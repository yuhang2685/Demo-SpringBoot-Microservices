package com.yuhang.demo.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.yuhang.demo.models.CatalogItem;
import com.yuhang.demo.models.Movie;
import com.yuhang.demo.models.Rating;

/**
 * 
 * @author yuhang
 *
 * First, we construct 3 independent microservices (which are Spring Boot REST Applications) with hard-coded data.
 * 
 * Next, we enable them to call each other programmatically through REST APIs using REST client library.
 * Note Spring Boot has one REST client (to call REST APIs) already in your classpath - RestTemplate.
 * We will show how it calls an external microservice API.
 * 
 */


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	// To avoid the problem that a RestTemplate is created every time when this service is called,
	// we create a method returning a RestTemplate and denoted by @Bean.
	@Autowired
	private RestTemplate restTemplate;
	
	// The movie catalog service accepts user id and returns a list of catalog items.
	// There is no such catalog items available, we have to construct it through other services.
	@RequestMapping("/{uId}")	
	// YH: @PathVariable is to obtain some placeholder from the URI (Spring calls it an URI Template),
	// i.e., the user input URI component "uId" is passed to the local variable "userId".	
	public List<CatalogItem> getCatalog(@PathVariable("uId") String userId){
				
		// A new way to create a single element list:
		// return Collections.singletonList(new CatalogItem("Transformers3","description", 89));
	
		// WebClient is replacing RestTemplate.
		// We need the dependency webflux
		WebClient.Builder webClientBuilder = WebClient.builder();
		
		// Starting from hard coded list of rating objects, later we will use the input uid to get user rated movies.
		List<Rating> ratings = Arrays.asList(
				new Rating("S101", 86),
				new Rating("T445", 55)
		);
		
		// Then we use each movie ID obtained from rating object to call movie info service to obtain the movie name, 
		// and use piece data to construct a CatalogItem.
		//
		// Could use for-loop to result each item and put them together in list to return.		
		return ratings.stream()
				      .map(rating -> 
				      		// We start from a hard coded mapping from a rating to an item:
				           	//   rating -> new CatalogItem("Transformers3","description", 89)
				           	// Then we use RestTemplate to goto the hard coded REST service URI 
				      		//   and gets back a Movie object used to construct a CatalogItem.
				    	  	{
				    	  		//Movie mv = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getmId(), Movie.class);
				    	  		Movie mv = webClientBuilder.build().get()
							    	  			.uri("http://localhost:8082/movies/" + rating.getmId())
							    	  			.retrieve()
							    	  			.bodyToMono(Movie.class)
							    	  			.block(); // blocking until get data back - asynchronous becomes synchronous
				    	  		return new CatalogItem(mv.getMname(), "description", rating.getMrating());
				    	  	}
				          )
		              .collect(Collectors.toList());
		
		
	}

}
