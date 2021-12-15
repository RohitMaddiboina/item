package com.ecommerce.item.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

public interface ItemService {

	Item getItem(int itemID);

	//This gets the list of list of items when user submits the category
	Page<Item> getAllItems(String category,int index);

	//This gets the list of list of items when user wants particular item type from category
	Page<Item> getCategoryItemsWithItemType(String category, List<String> itemTypes,int index);

	//This gets a list of list of items of a category based on price range set by user
	Page<Item> getCategoryItemsWithPrice(String category, float low, float high,int index);

	//This gets the List of List of items from a category of a itemType within the price range
	Page<Item> getCategoryItemsWithItemTypePrice(String category, List<String> itemTypes, float low, float high,
			int index);

	//Gets all the itemsTypes present in the category
	List<String> getDistinctItemType(String category);

	//Gets List Of items list based on the keyword given by users
	Page<Item> getItemsKeyWord(String keyword,int index);

	Item addQuantityToItems(int itemId, int quantity);

	Item removeQuantityFromItem(int itemId, int quantity);

}