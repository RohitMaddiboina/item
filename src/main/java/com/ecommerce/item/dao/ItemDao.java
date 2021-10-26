package com.ecommerce.item.dao;


import com.ecommerce.item.model.Item;
import com.ecommerce.item.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ItemDao {

    @Autowired
    ItemRepo itemRepo;



    public Item getItem(int itemID){
        return itemRepo.findById(itemID).get();
    }
    public List<Item> getAllItems(String category){
        return itemRepo.getCategoryItems(category);
    }

    public List<Item> getCategoryItemsWithItemType(String category,String itemType){
        return itemRepo.getCategoryItemsWithItemType(category,itemType);
    }

    public List<Item> getCategoryItemsWithItemTypePrice(String category,String itemType,float low,float high){
        return itemRepo.getCategoryItemsWithItemTypePrice(category,itemType,low,high);
    }
    public List<Item> getCategoryItemsWithPrice(String category,float low,float high){
        return itemRepo.getCategoryItemsWithPrice(category,low,high);
    }
    public List<String> getDistinctItemTypes(String category){
        return  itemRepo.getDistinctItemTypes(category);
    }

    public List<Item> getItemsKeyword(String keyword){
        return itemRepo.getItemsWithKeyword(keyword);
    }
}
