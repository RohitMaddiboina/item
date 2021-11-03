package com.ecommerce.item.dao;


import com.ecommerce.item.model.Item;
import com.ecommerce.item.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemDaoImpl implements ItemDao {

    @Autowired
    ItemRepo itemRepo;



    @Override
	public Item getItem(int itemID){
        return itemRepo.findById(itemID).get();
    }
    @Override
	public List<Item> getAllItems(String category,Pageable pageable){
    	List<Item> items = itemRepo.getCategoryItems(category, pageable);
    	if(!items.isEmpty()) {
    		
    		return items;
    	}
    	return new ArrayList<>();
    }
   
    @Override
	public List<Item> getCategoryItemsWithItemType(String category,String itemType,Pageable pageable){
        return itemRepo.getCategoryItemsWithItemType(category,itemType,pageable);
    }
   

    @Override
	public List<Item> getCategoryItemsWithItemTypePrice(String category,String itemType,float low,float high,Pageable pageable){
        return itemRepo.getCategoryItemsWithItemTypePrice(category,itemType,low,high,pageable);
    }
    @Override
	public List<Item> getCategoryItemsWithPrice(String category,float low,float high,Pageable pageable){
        return itemRepo.getCategoryItemsWithPrice(category,low,high,pageable);
    }
    @Override
	public List<String> getDistinctItemTypes(String category){
        return  itemRepo.getDistinctItemTypes(category);
    }

    @Override
	public List<Item> getItemsKeyword(String keyword){
        return itemRepo.getItemsWithKeyword(keyword);
    }
	@Override
	public Item updateItem(Item item) {
		return itemRepo.save(item);
	}
}
