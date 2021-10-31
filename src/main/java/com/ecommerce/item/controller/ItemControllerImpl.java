package com.ecommerce.item.controller;



import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;
import com.ecommerce.item.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemControllerImpl implements ItemController {
    @Autowired
    ItemService itemServiceImpl;

    //Gets an Item by ItemId 
    @Override
	public Item getItem(@PathVariable("itemId") int itemId){
        return itemServiceImpl.getItem(itemId);
    }

//    Gets list of items list when user submits the category
    @Override
    public ListOfItemsList getAllItems(@PathVariable("category") String category){
    	
        return itemServiceImpl.getAllItems(category);
    }
    
    //Gets list of items list when user searches for a product
    @Override
    public ListOfItemsList getItemsKeyword(@PathVariable("keyword") String keyword){
        return itemServiceImpl.getItemsKeyWord(keyword);
    }
    
  //Gets list of items list when user submits itemTypes his interested in.
    @Override
    public ListOfItemsList getAllItemWithItemType(@PathVariable("category") String category,@RequestBody List<String> itemTypes){
    			
                return itemServiceImpl.getCategoryItemsWithItemType(category, itemTypes);
    }
    
    //Gets list of items list when user submits itemTypes he is interested in and also price range.
    @Override
    public ListOfItemsList getAllItemWithItemTypeAndPrice(@PathVariable("category") String category,@RequestBody List<String> itemTypes,
                                                     @PathVariable("low") float low,@PathVariable("high") float high){

        return itemServiceImpl.getCategoryItemsWithItemTypePrice(category, itemTypes, low, high);
    }
    
    //Dummy.
    @Override
    public List<String> hello(@PathVariable("navItem") String navItem,@PathVariable("category") String category){
        return itemServiceImpl.getDistinctItemType(category);
    }


}
