package com.ecommerce.item.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

//@CrossOrigin
public interface ItemController {

	@GetMapping("/getItem/{itemId}")
	Item getItem(@PathVariable("itemId") int itemId);

	@GetMapping("/getItems/{category}/{index}")
	Page<Item> getAllItemsInCategory(@PathVariable("category") String category,@PathVariable("index")int index);

	@GetMapping("/getItemsKeyword/{keyword}/{index}")
	Page<Item> getItemsKeyword(@PathVariable("keyword") String keyword,@PathVariable("index")int index);

	@PostMapping("/getItems/{category}/{index}")
	Page<Item> getAllItemsInCategoryWithitemType(@PathVariable("category") String category,
			@RequestBody List<String> itemTypes,@PathVariable("index")int index);

	@PostMapping("/getItems/{category}/{low}/{high}/{index}")
	Page<Item> getAllCategoryAndItemTypeAndPriceBetween(@PathVariable("category") String category,
			@RequestBody List<String> itemTypes, @PathVariable("low") int low, @PathVariable("high") int high,
			@PathVariable("index")int index);

	@GetMapping("/getItemType/{navItem}/{category}/{index}")
	List<String> hello(String navItem, String category,
			@PathVariable("index")int index);

	@PutMapping("/addQuantity/{itemId}/{quantity}")
	Item addQuantityToItems(@PathVariable("itemId") int itemId,@PathVariable("quantity") int quantity);

	@PutMapping("/removeQuantity/{itemId}/{quantity}")
	Item removeQuantityFromItem(@PathVariable("itemId") int itemId,@PathVariable("quantity") int quantity);

}