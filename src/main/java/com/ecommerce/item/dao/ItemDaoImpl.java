package com.ecommerce.item.dao;


import com.ecommerce.item.model.Item;
import com.ecommerce.item.repo.ItemRepo;
import com.ecommerce.item.repo.ItemWithPagingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemDaoImpl implements ItemDao {

	@Autowired
	ItemWithPagingRepo itemWithPagingRepo;
	
	@Autowired
	ItemRepo itemRepo;




	@Override
	public Item getItem(int itemID){
        return itemWithPagingRepo.findById(itemID).get();
    }
  
	@Override
	public Page<Item> getAllItems(String category,Pageable pageable){
    	return itemWithPagingRepo.findByCategory(category, pageable);
    	
    }
   
 	@Override
	public Page<Item> getCategoryItemsWithItemType(String category,List<String> itemType,Pageable pageable){
        return itemWithPagingRepo.findByCategoryAndItemTypeIn(category,itemType,pageable);
    }
   

    
	@Override
	public Page<Item> getCategoryItemsWithItemTypePrice(String category,List<String> itemType,float low,float high,Pageable pageable){
        return itemWithPagingRepo.findByCategoryAndItemTypeInAndPriceBetween(category,itemType,low,high,pageable);
    }
   
	@Override
	public Page<Item> getCategoryItemsWithPrice(String category,float low,float high,Pageable pageable){
        return itemWithPagingRepo.findByCategoryAndPriceBetween(category,low,high,pageable);
    }
   
	@Override
	public List<String> getDistinctItemTypes(String category){
        return  itemRepo.getDistinctItemTypes(category);
    }

   
	@Override
	public Page<Item> getItemsKeyword(String keyword,Pageable pageable){
        return itemWithPagingRepo.getItemsWithKeyword(keyword,pageable);
    }
	
	@Override
	public Item updateItem(Item item) {
		return itemRepo.save(item);
	}
}
