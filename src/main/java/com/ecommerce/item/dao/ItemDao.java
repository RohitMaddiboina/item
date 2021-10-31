package com.ecommerce.item.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ecommerce.item.model.Item;

public interface ItemDao {

	Item getItem(int itemID);

	List<Item> getAllItems(String category, Pageable pageable);

	List<Item> getCategoryItemsWithItemType(String category, String itemType, Pageable pageable);

	List<Item> getCategoryItemsWithItemTypePrice(String category, String itemType, float low, float high,
			Pageable pageable);

	List<Item> getCategoryItemsWithPrice(String category, float low, float high, Pageable pageable);

	List<String> getDistinctItemTypes(String category);

	List<Item> getItemsKeyword(String keyword);

}