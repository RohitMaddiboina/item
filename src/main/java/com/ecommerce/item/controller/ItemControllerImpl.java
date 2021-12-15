package com.ecommerce.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;
import com.ecommerce.item.repo.ItemRepo;
import com.ecommerce.item.repo.ItemWithPagingRepo;
import com.ecommerce.item.service.ItemService;
import com.ecommerce.item.service.ItemServiceImpl;

@RestController
public class ItemControllerImpl implements ItemController {

	@Autowired
	ItemService itemServiceImpl;
	@Autowired
	ItemWithPagingRepo itemWithPagingRepo;

	@Override
	public Page<Item> getAllItemsInCategory(String category,int index) {

		Page<Item> page = itemServiceImpl.getAllItems(category,index);
		return  page;
	}

	@Override
	public Page<Item> getAllItemsInCategoryWithitemType( String category,
			 List<String> itemTypes,int index) {
		return itemServiceImpl.getCategoryItemsWithItemType(category, itemTypes,index);
	}


	  //Dummy.
    @Override
    public List<String> hello(@PathVariable("navItem") String navItem,@PathVariable("category") String category
    		,int index){
        return itemServiceImpl.getDistinctItemType(category);
    }
	
	@Override
	public Item addQuantityToItems(int itemId, int quantity) {
		return itemServiceImpl.addQuantityToItems(itemId, quantity);
	}
	
	@Override
	public Item removeQuantityFromItem(int itemId, int quantity) {
		return itemServiceImpl.removeQuantityFromItem(itemId, quantity);
	}

	@Override
	public Item getItem(int itemId) {
		// TODO Auto-generated method stub
		return itemServiceImpl.getItem(itemId);
	}

	@Override
	public Page<Item> getItemsKeyword(String keyword,int index) {
		// TODO Auto-generated method stub
		return itemServiceImpl.getItemsKeyWord(keyword,index);
	}

	@Override
	public Page<Item> getAllCategoryAndItemTypeAndPriceBetween(String category, List<String> itemTypes, int low,
			int high,int index) {
		// TODO Auto-generated method stub
		return itemServiceImpl.getCategoryItemsWithItemTypePrice(category, itemTypes, low, high,index);
	}

}
