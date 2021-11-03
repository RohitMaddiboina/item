package com.ecommerce.item.service;

import java.util.List;

import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

public interface ItemService {

	Item getItem(int itemID);

	//This gets the list of list of items when user submits the category
	ListOfItemsList getAllItems(String category);

	//This gets the list of list of items when user wants particular item type from category
	ListOfItemsList getCategoryItemsWithItemType(String category, List<String> itemTypes);

	//This gets a list of list of items of a category based on price range set by user
	ListOfItemsList getCategoryItemsWithPrice(String category, float low, float high);

	//This gets the List of List of items from a category of a itemType within the price range
	ListOfItemsList getCategoryItemsWithItemTypePrice(String category, List<String> itemTypes, float low, float high);

	//Gets all the itemsTypes present in the category
	List<String> getDistinctItemType(String category);

	//Gets List Of items list based on the keyword given by users
	ListOfItemsList getItemsKeyWord(String keyword);

	Item addQuantityToItems(int itemId, int quantity);

	Item removeQuantityFromItem(int itemId, int quantity);

}