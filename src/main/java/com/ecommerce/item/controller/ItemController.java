package com.ecommerce.item.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.ecommerce.item.model.Item;

public interface ItemController {

	@GetMapping("/getItem/{itemId}")
	Item getItem(int itemId);

	@GetMapping("/getItems/{category}")
	List<Item> getAllItems(String category);

	@GetMapping("/getItemsKeyword/{keyword}")
	List<Item> getItemsKeyword(String keyword);

	@PostMapping("/getItems/{category}")
	List<Item> getAllItemWithItemType(String category, List<String> itemTypes);

	@PostMapping("/getItems/{category}/{low}/{high}")
	List<Item> getAllItemWithItemTypeAndPrice(String category, List<String> itemTypes, float low, float high);

	@GetMapping("/getItemType/{navItem}/{category}")
	List<String> hello(String navItem, String category);

}