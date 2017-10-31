package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.calculator.ShippingCalculator;
import com.techelevator.calculator.TaxCalculator;
import com.techelevator.model.Order;
import com.techelevator.model.OrderDAO;
import com.techelevator.model.OrderItem;
import com.techelevator.model.OrderItemDAO;
import com.techelevator.model.Product;
import com.techelevator.model.ProductDAO;
import com.techelevator.model.ShoppingCart;
import com.techelevator.model.ShoppingCartItem;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;
import com.techelevator.model.viewmodel.ConfirmationViewModel;

@Controller
@SessionAttributes({"shoppingCart", "email"})
public class StoreController {

    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private UserDAO userDAO;

    @Autowired
    public StoreController(ProductDAO oroductDAO, OrderDAO orderDAO, OrderItemDAO orderItemDAO, UserDAO userDAO) {
        this.productDAO = oroductDAO;
        this.orderDAO = orderDAO;
        this.orderItemDAO = orderItemDAO;
        this.userDAO = userDAO;
    }

	@RequestMapping(path="/store")
    public String getStore(ModelMap model) {
		model.addAttribute("products", productDAO.getProducts());
        return "store/getStore";
    }

	@RequestMapping(path="/store/detail/{sku}")
    public String listProductsl(@PathVariable String sku, ModelMap model) {
        Product product = productDAO.getProduct(sku);
//        if (model == null)
//        {
//            return new HttpNotFoundResult();
//        }
        model.addAttribute(product);
        return "store/detail";
    }

	@RequestMapping(path="/store/addToCart", method=RequestMethod.POST)
    public String addToCart(@RequestParam String sku, @RequestParam int quantity, ModelMap model) {
        Product product = productDAO.getProduct(sku);
//        if (product == null || quantity < 1)
//        {
//            return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
//        }
        ShoppingCart cart = getActiveShoppingCart(model);
        cart.addToCart(product, quantity);
        return "redirect:/store/viewCart";
    }

	@RequestMapping(path="/store/updateCart", method=RequestMethod.POST)
	public String updateCart(@RequestParam String sku, @RequestParam int quantity, ModelMap model) {
        // Update the quantity of an item in the cart
        ShoppingCart cart = getActiveShoppingCart(model);
        if (quantity <= 0) {
            List<ShoppingCartItem> sciList = cart.getItems();
            for (int i = sciList.size() -1; i >= 0; i--) {
				if (sciList.get(i).getProduct().getSku().equals(sku)) {
					sciList.remove(i);
					break;
				}
            }
        }
        else {
            List<ShoppingCartItem> sciList = cart.getItems();
            for (int i = 0; i < sciList.size(); i++) {
				if (sciList.get(i).getProduct().getSku().equals(sku)) {
					sciList.get(i).setQuantity(quantity);
					break;
				}
            }
        }
        return "redirect:/store/viewCart";
    }

	@RequestMapping(path="/store/checkout")
    public String checkout(ModelMap model) {
        // If the user has not logged in yet, make them log in
        if(model.get("email") == null) {
            return "redirect:/user/login";
        }

        ShoppingCart cart = getActiveShoppingCart(model);

        //If they don't have any items, redirect them to ViewCart
        if (cart.getItems().size() == 0) {
            return "redirect:/store/viewCart";
        }

        //Create an Order Model that sums up the item totals and weights
        Order order = new Order();
        order.setSubTotal(cart.getSubTotal());
        double weight = 0;
        for(ShoppingCartItem sci : cart.getItems() ) {
        	weight += sci.getWeight();
        }
        order.setWeight(weight);

        //Set the shipping rates to use for the model
        order.setShippingRates(ShippingCalculator.getShippingRates(order.getWeight()));
        model.addAttribute("order", order);
        return "store/checkout";
    }

	@RequestMapping(path = "/store/checkout", method = RequestMethod.POST)
	public String checkout(HttpSession session, Order order, ModelMap model) {
		// Get their active shopping cart
		ShoppingCart cart = getActiveShoppingCart(model);
		order.setSubTotal(cart.getSubTotal());
		double weight = 0;
		for (ShoppingCartItem sci : cart.getItems()) {
			weight += sci.getWeight();
		}
		order.setWeight(weight);

		// if (!ModelState.IsValid)
		// {
		// order.ShippingRates =
		// ShippingCalculator.GetShippingRates(order.Weight);
		// return View("Checkout", order);
		// }

		// Update the order with fields from the customer's checkout
		order.setTax(cart.getSubTotal().multipliedBy(TaxCalculator.getTaxRate(order.getBillingPostalCode())));
		order.setShipping(ShippingCalculator.getShippingRates(order.getWeight()).get(order.getShippingType()));
		User user = userDAO.getUser(model.get("email").toString());
		order.setUserID(user.getID());

		// Create a transaction to save these in the database
		// We want to make sure that the order is saved, along with each order
		// item
		// using (TransactionScope tran = new TransactionScope()) {
		// //Save the Order
		orderDAO.saveOrder(order);

		// Convert each "ShopingCartItem" to an "OrderItem" and give it the new
		// order id
		List<OrderItem> orderItems = new ArrayList<>();
		for (ShoppingCartItem sci : cart.getItems()) {
			OrderItem oi = new OrderItem();
			oi.setPrice(sci.getPrice());
			oi.setProductID(sci.getProduct().getId());
			oi.setQuantity(sci.getQuantity());
			oi.setOrderID(order.getId());
			orderItems.add(oi);
		}

		// Save the Order Items
		orderItemDAO.saveOrderItems(orderItems);

		// Empty the shopping cart
		cart.empty();
		//
		// //Save the transaction
		// tran.Complete();
		// }
		return "redirect:/store/confirm/" + order.getId();
	}

	@RequestMapping(path = "/store/confirm/{orderID}")
	public String confirm(@PathVariable Long orderID, ModelMap model) {
		// Build the view model and use the order, order items, and product
		// purchased to populate it
		ConfirmationViewModel confirmationViewModel = new ConfirmationViewModel();
		confirmationViewModel.setOrder(orderDAO.getOrder(orderID));
		confirmationViewModel.setOrderItems(orderItemDAO.getOrderItems(orderID));
		List<Product> products = new ArrayList<>();
		for (OrderItem oi : confirmationViewModel.getOrderItems()) {
			products.add(productDAO.getProductByID(oi.getProductID()));
		}
		confirmationViewModel.setProducts(products);
		model.addAttribute("confirmationViewModel", confirmationViewModel);
		return "/store/confirm";
	}

	@RequestMapping(path="/store/viewCart")
    public String viewCart(ModelMap model) {
        return "/store/viewCart";
    }

    private ShoppingCart getActiveShoppingCart(ModelMap model) {
        if (model.get("shoppingCart") == null) {
            model.addAttribute("shoppingCart", new ShoppingCart());
        }
        return (ShoppingCart)model.get("shoppingCart");
    }

}
