package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;



@Controller 
public class DummiesController {
	
	@Autowired
	ReviewDao reviewDao;

	@RequestMapping(path="/allReviews", method=RequestMethod.GET)
	public String showAllReviews(ModelMap modelHolder) {
		List<Review> reviews= reviewDao.getAllReviews();
		modelHolder.put("allReviews", reviews);
		
		
		return "allReviews";
	}
	@RequestMapping(path="/newReview", method=RequestMethod.GET)
	public String newReviewInput(ModelMap modelHolder) {
		if(! modelHolder.containsAttribute("review")){
			modelHolder.put("review", new Review());
		}
		
		return "newReview";
	}
	@RequestMapping(path="/newReview", method=RequestMethod.POST)
	public String newReviewInputSubmission(@Valid @ModelAttribute Review newReview, BindingResult result, RedirectAttributes flash)  {
		
		flash.addFlashAttribute("review", newReview);
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "review", result);
			return "redirect:/newReview";
		}
		newReview.setDateSubmitted(LocalDateTime.now());
		reviewDao.save(newReview);
		return "redirect:/allReviews";
	}
	

}
	

