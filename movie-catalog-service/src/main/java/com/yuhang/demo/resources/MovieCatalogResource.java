package com.yuhang.demo.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuhang.demo.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping("/{uId}")	
	// YH: @PathVariable is to obtain some placeholder from the URI (Spring calls it an URI Template),
	// i.e., the user input URI component "uId" is passed to the local variable "userId".	
	public List<CatalogItem> getCatalog(@PathVariable("uId") String userId){
		
		// My first time to see creating a single element list.
		return Collections.singletonList(new CatalogItem("Transformers3","Test", 89));
	}

}
