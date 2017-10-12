package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@RequestMapping("/productList")
	public String showProductList(ModelMap modelHolder) {
		modelHolder.put("products", getProducts());
		return "productList";
	}
	
	@RequestMapping("/productTiles")
	public String showProductTiles(ModelMap modelHolder) {
		modelHolder.put("products", getProducts());
		return "productTiles";
	}
	
	@RequestMapping("/productTable")
	public String showProductTable(ModelMap modelHolder) {
		modelHolder.put("products", getProducts());
		return "productTable";
	}
	
	@RequestMapping("/productDetail")
	public String showProductDetail(@RequestParam String productId, ModelMap modelHolder) {
		for(Product p : getProducts()) {
			if(p.getProductId().equals(productId)) {
				modelHolder.put("product", p);
			}
		}
		return "productDetail";
	}
	
	private List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product().setAverageRating(4.4).setImageName("toy-balls.jpg").setTopSeller(true).setManufacturer("Safe Kidz Toys").setName("Stackable Balls").setPrice(24.99).setProductId("SKU-1234").setRemainingStock(5).setWeightInLbs(2.0).setDescription("The safest stackable balls for a baby. GIFT Ready, reduce teething injury, and sharpen your child's mind!"));
		products.add(new Product().setAverageRating(3.4).setImageName("toy-car.jpg").setTopSeller(false).setManufacturer("Safe Kidz Toys").setName("Push and Pull Car").setPrice(8.99).setProductId("SKU-2345").setRemainingStock(5).setWeightInLbs(2.0).setDescription("Buckle up, because the Green Toys Race Car is ready to roll. Built in the USA from 100% recycled materials."));
		products.add(new Product().setAverageRating(1.2).setImageName("toy-gym.jpg").setTopSeller(false).setManufacturer("Crossfit Kids").setName("Kid Gym").setPrice(89.99).setProductId("SKU-5678").setRemainingStock(19).setWeightInLbs(25.0).setDescription("Promotes safe, playful fitness participation and so much fun! Now your kids can join in the fun of overhead squats, cleans, & all those lifts you love to do."));
		products.add(new Product().setAverageRating(4.1).setImageName("toy-horse.jpg").setTopSeller(false).setManufacturer("Amazing Toys").setName("Rocking Horse").setPrice(34.99).setProductId("SKU-3333").setRemainingStock(2).setWeightInLbs(13.0).setDescription("One of Little Tikes' classic items is back! Perfect for small indoor areas!"));
		products.add(new Product().setAverageRating(5.0).setImageName("toy-snail.jpg").setTopSeller(true).setManufacturer("Slow Toys").setName("Drag-a-long Snail").setPrice(8.99).setProductId("SKU-4567").setRemainingStock(15).setWeightInLbs(2.3).setDescription("Perfect tagalong companion for little ones as they gain confidence in learning and exploring"));
		products.add(new Product().setAverageRating(4.7).setImageName("toy-tricycle.jpg").setTopSeller(true).setManufacturer("Safe Kidz Toys").setName("My First Trike").setPrice(24.99).setProductId("SKU-5566").setRemainingStock(11).setWeightInLbs(17.0).setDescription("This Tricycle won Parents Choice Classic Award, Parents Guide to Children's Media Award, The National parenting Centers Seal of Approval. A controlled turning radius and low center of gravity make this tricycle easy for little ones to ride. The sturdy steel design and rubber tires make this tricycle durable."));
        return products;
	}
}
