package com.ecommerce.item.service;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    public Item getItem(int itemID){
        return itemDao.getItem(itemID);
    }

    public List<Item> getAllItems(String category){
        return itemDao.getAllItems(category);
    }

    public List<Item> getCategoryItemsWithItemType(String category,List<String> itemTypes){
        List<Item> items = new ArrayList<>();
        if (!itemTypes.isEmpty()){

            for(String itemType : itemTypes){
                items.addAll(itemDao.getCategoryItemsWithItemType(category,itemType));

            }
            return items;
        }else{
            return this.getAllItems(category);
        }
    }

    public List<Item> getCategoryItemsWithItemTypePrice( String category, List<String> itemTypes,  float low,float high){
        List<Item> items = new ArrayList<>();
        if (!itemTypes.isEmpty()){

            for(String itemType : itemTypes){
                items.addAll(itemDao.getCategoryItemsWithItemTypePrice(category,itemType,low,high));

            }
            return items;
        }else{
            return itemDao.getCategoryItemsWithPrice(category,low,high);
        }
    }

    public List<String> getDistinctItemType(String category){
        return  itemDao.getDistinctItemTypes(category);
    }

    public List<Item> getItemsKeyWord(String keyword){
    	String keywordModified = "%"+keyword.replace(' ', '%')+"%";
        return itemDao.getItemsKeyword(keywordModified);
    }
}
