package com.yuhang.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhang.demo.models.Rating;
import com.yuhang.demo.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

		// Movie Rating Service accepts a movie ID and returns a movie rating object. 
	    @RequestMapping("/{mId}")
	    public Rating getRating(@PathVariable("mId") String movieId) {
	        
	    	// Hard coded rating for every request.
	    	return new Rating(movieId, 88);
	    }
	    
	    // Movie Rating Service accepts a user ID and returns a list of movie rating objects. 
	    @RequestMapping("/users/{uId}")
	    // UserRating is a wrapper class for the list of movie rating objects (as a field in the wrapper class).
	    public UserRating getRatings(@PathVariable("uId") String userId) {
	    	
	    	// Hard coded rating list for every request.
	    	List<Rating> ratings = Arrays.asList(
					new Rating("S101", 86),
					new Rating("T445", 55)
			);
	    	UserRating userRating = new UserRating();
	    	userRating.setUserRatings(ratings);
	    	return userRating;
	    }
}
