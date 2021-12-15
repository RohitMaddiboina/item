package com.ecommerce.item.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.item.model.Item;

public interface ItemDao {

	Item getItem(int itemID);

	Page<Item> getAllItems(String category, Pageable pageable);

	Page<Item> getCategoryItemsWithItemType(String category, List<String> itemType, Pageable pageable);

	Page<Item> getCategoryItemsWithItemTypePrice(String category, List<String> itemType, float low, float high,
			Pageable pageable);

	Page<Item> getCategoryItemsWithPrice(String category, float low, float high, Pageable pageable);

	List<String> getDistinctItemTypes(String category);

	Page<Item> getItemsKeyword(String keyword,Pageable pageable);

	Item updateItem(Item item);

}