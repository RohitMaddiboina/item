package com.ecommerce.item.dao;


import com.ecommerce.item.model.Item;
import com.ecommerce.item.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemDao {

    @Autowired
    ItemRepo itemRepo;



    public Item getItem(int itemID){
        return itemRepo.findById(itemID).get();
    }
    public List<Item> getAllItems(String category,Pageable pageable){
    	List<Item> items = itemRepo.getCategoryItems(category, pageable);
    	if(!items.isEmpty()) {
    		
    		return items;
    	}
    	return new ArrayList<>();
    }
   
    public List<Item> getCategoryItemsWithItemType(String category,String itemType,Pageable pageable){
        return itemRepo.getCategoryItemsWithItemType(category,itemType,pageable);
    }
   

    public List<Item> getCategoryItemsWithItemTypePrice(String category,String itemType,float low,float high,Pageable pageable){
        return itemRepo.getCategoryItemsWithItemTypePrice(category,itemType,low,high,pageable);
    }
    public List<Item> getCategoryItemsWithPrice(String category,float low,float high,Pageable pageable){
        return itemRepo.getCategoryItemsWithPrice(category,low,high,pageable);
    }
    public List<String> getDistinctItemTypes(String category){
        return  itemRepo.getDistinctItemTypes(category);
    }

    public List<Item> getItemsKeyword(String keyword){
        return itemRepo.getItemsWithKeyword(keyword);
    }
}
