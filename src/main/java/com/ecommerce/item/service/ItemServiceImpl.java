package com.ecommerce.item.service;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDaoImpl;
	private static final int ITEM_CAPACITY = 10;

	@Override
	public Item getItem(int itemID) {
		return itemDaoImpl.getItem(itemID);
	}

	// This gets the list of list of items when user submits the category
	@Override
	public Page<Item> getAllItems(String category,int index) {

		return itemDaoImpl.getAllItems(category, PageRequest.of(index, ITEM_CAPACITY,Sort.by("price")));
	}

	// This gets the list of list of items when user wants particular item type from
	// category
	@Override
	public Page<Item> getCategoryItemsWithItemType(String category, List<String> itemTypes
			,int index) {
		if (itemTypes.isEmpty()) {
			return getAllItems(category,index);
		}
		return itemDaoImpl.getCategoryItemsWithItemType(category, itemTypes, PageRequest.of(index, ITEM_CAPACITY,Sort.by("price")));
	}

	// This gets a list of list of items of a category based on price range set by
	// user
	@Override
	public Page<Item> getCategoryItemsWithPrice(String category, float low, float high
			,int index) {
		return itemDaoImpl.getCategoryItemsWithPrice(category, low, high, PageRequest.of(index, ITEM_CAPACITY,Sort.by("price")));

	}

	// This gets the List of List of items from a category of a itemType within the
	// price range
	@Override
	public Page<Item> getCategoryItemsWithItemTypePrice(String category, List<String> itemTypes, float low,
			float high,int index) {

		if (itemTypes.isEmpty()) {
			return getCategoryItemsWithPrice(category, low, high,index);
		}

		return itemDaoImpl.getCategoryItemsWithItemTypePrice(category, itemTypes, low, high, PageRequest.of(index, ITEM_CAPACITY,Sort.by("price")));

	}

	// Gets all the itemsTypes present in the category
	@Override
	public List<String> getDistinctItemType(String category) {
		return itemDaoImpl.getDistinctItemTypes(category);
	}

	// Gets List Of items list based on the keyword given by users
	@Override
	public Page<Item> getItemsKeyWord(String keyword,int index) {
		String keywordModified = "%" + keyword.replace(' ', '%') + "%";
		return itemDaoImpl.getItemsKeyword(keywordModified,PageRequest.of(index, ITEM_CAPACITY,Sort.by("price")));
	
	}

	@Override
	public Item addQuantityToItems(int itemId, int quantity) {
		Item item = itemDaoImpl.getItem(itemId);
		item.setQuanitity(item.getQuanitity() + quantity);
		return itemDaoImpl.updateItem(item);
	}

	@Override
	public Item removeQuantityFromItem(int itemId, int quantity) {
		Item item = itemDaoImpl.getItem(itemId);
		item.setQuanitity(item.getQuanitity() - quantity);
		return itemDaoImpl.updateItem(item);
	}
}
