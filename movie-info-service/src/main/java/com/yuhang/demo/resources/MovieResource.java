package com.yuhang.demo.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhang.demo.models.Movie;



@RestController
@RequestMapping("/movies")
public class MovieResource {

		// The movie info service accepts a movie ID and returns a movie name object
	    @RequestMapping("/{mId}")
	    // Frequently we see ID are numbers mixed with chars...
	    public Movie getMovieInfo(@PathVariable("mId") String movieId) {
	        return new Movie(movieId, "Movie Name");

	    }
}
