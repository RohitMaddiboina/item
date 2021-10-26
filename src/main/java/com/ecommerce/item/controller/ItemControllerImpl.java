package com.ecommerce.item.controller;



import com.ecommerce.item.model.Item;
import com.ecommerce.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemControllerImpl implements ItemController {
    @Autowired
    ItemService itemService;

    @Override
	public Item getItem(@PathVariable("itemId") int itemId){
        return itemService.getItem(itemId);
    }

    @Override
    public List<Item> getAllItems(@PathVariable("category") String category){
        return itemService.getAllItems(category);
    }
    
    @Override
    public List<Item> getItemsKeyword(@PathVariable("keyword") String keyword){
        return itemService.getItemsKeyWord(keyword);
    }
    
    @Override
    public List<Item> getAllItemWithItemType(@PathVariable("category") String category,@RequestBody List<String> itemTypes){

                return itemService.getCategoryItemsWithItemType(category, itemTypes);
    }
    
    @Override
    public List<Item> getAllItemWithItemTypeAndPrice(@PathVariable("category") String category,@RequestBody List<String> itemTypes,
                                                     @PathVariable("low") float low,@PathVariable("high") float high){

        return itemService.getCategoryItemsWithItemTypePrice(category, itemTypes, low, high);
    }
    
    @Override
    public List<String> hello(@PathVariable("navItem") String navItem,@PathVariable("category") String category){
        return itemService.getDistinctItemType(category);
    }


}
