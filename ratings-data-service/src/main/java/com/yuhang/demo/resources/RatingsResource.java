package com.yuhang.demo.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhang.demo.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	    @RequestMapping("/{mId}")
	    public Rating getRating(@PathVariable("mId") String movieId) {
	        return new Rating(movieId, 88);
	    }
}
