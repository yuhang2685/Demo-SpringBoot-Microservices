package com.yuhang.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yuhang.demo.models.Movie;
import com.yuhang.demo.models.MovieSummary;



@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	// @Value: find the variable in application.properties for the field below.
	@Value("${api.key}")
    private String apiKey;
	
    @Autowired
    private RestTemplate restTemplate;
	
	// The movie info service accepts a movie ID and returns a movie name object	
	@RequestMapping("/{mId}")
    // Frequently we see ID are numbers mixed with chars...
    public Movie getMovieInfo(@PathVariable("mId") String movieId) {
	        
    	// Hard coded movie name for every request.
    	//return new Movie(movieId, "Movie Name");
		
		// Only pick the MovieSummary fields from so many fields supplied by the hard coded external API. 
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        // Then use the obtained data to construct a Movie object.
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    }
}
