package com.ecommerce.item.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

@CrossOrigin
public interface ItemController {

	@GetMapping("/getItem/{itemId}")
	Item getItem(int itemId);

	@GetMapping("/getItems/{category}")
	ListOfItemsList getAllItems(String category);

	@GetMapping("/getItemsKeyword/{keyword}")
	ListOfItemsList getItemsKeyword(String keyword);

	@PostMapping("/getItems/{category}")
	ListOfItemsList getAllItemWithItemType(String category, List<String> itemTypes);

	@PostMapping("/getItems/{category}/{low}/{high}")
	ListOfItemsList getAllItemWithItemTypeAndPrice(String category, List<String> itemTypes, float low, float high);

	@GetMapping("/getItemType/{navItem}/{category}")
	List<String> hello(String navItem, String category);

	@PutMapping("/addQuantity/{itemId}/{quantity}")
	Item addQuantityToItems(int itemId, int quantity);
	
	@PutMapping("/removeQuantity/{itemId}/{quantity}")
	Item removeQuantityFromItem(int itemId, int quantity);

}