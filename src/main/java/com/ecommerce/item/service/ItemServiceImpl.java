package com.ecommerce.item.service;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDaoImpl;
    private static final int ITEM_CAPACITY = 10;
    @Override
	public Item getItem(int itemID){
        return itemDaoImpl.getItem(itemID);
    }

    //This gets the list of list of items when user submits the category
    @Override
	public ListOfItemsList getAllItems(String category){
		
    	List<Item> itemsList = itemDaoImpl.getAllItems(category,null);
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
    	int noPages = itemsList.size()/ITEM_CAPACITY;
    	int remPage = itemsList.size()%ITEM_CAPACITY;
    	List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	for(int i=0;i<noPages;i++)
    	{
    		listOfItemsList0.add( itemsList.subList(ITEM_CAPACITY*i, ITEM_CAPACITY*i+ITEM_CAPACITY));
    	}
    	if(remPage>0)
    	{
    		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
    	}

    	listOfItemsList1.setList(listOfItemsList0);
    	return listOfItemsList1;
    }

    //This gets the list of list of items when user wants particular item type from category
    @Override
	public ListOfItemsList getCategoryItemsWithItemType(String category,List<String> itemTypes){
        List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
        if (!itemTypes.isEmpty()){

            for(String itemType : itemTypes){
               
                List<Item> itemsList =  itemDaoImpl.getCategoryItemsWithItemType(category,itemType,null);

            	int noPages = itemsList.size()/ITEM_CAPACITY;
            	int remPage = itemsList.size()%ITEM_CAPACITY;
            	for(int i=0;i<noPages;i++)
            	{	
            		listOfItemsList0.add( itemsList.subList(ITEM_CAPACITY*i, ITEM_CAPACITY*i+ITEM_CAPACITY));
            	}
            	if(remPage>0)
            	{
            		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
            		
            	}
            	
            }
            listOfItemsList1.setList(listOfItemsList0);
            return listOfItemsList1;
        }
           
        else{
            return getAllItems(category);
        }
    }
    
    //This gets a list of list of items of a category based on price range set by user
    @Override
	public ListOfItemsList getCategoryItemsWithPrice(String category, float low,float high) {
    	List<Item> itemsList = itemDaoImpl.getCategoryItemsWithPrice(category,low,high,null);
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
    	
    	int noPages = itemsList.size()/ITEM_CAPACITY;
    	int remPage = itemsList.size()%ITEM_CAPACITY;
    	List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	for(int i=0;i<noPages;i++)
    	{	
    		listOfItemsList0.add( itemsList.subList(ITEM_CAPACITY*i, ITEM_CAPACITY*i+ITEM_CAPACITY));
    	}
    	if(remPage>0)
    	{
    		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
    		
    	}
    	listOfItemsList1.setList(listOfItemsList0);
        return listOfItemsList1;
    }

    //This gets the List of List of items from a category of a itemType within the price range
    @Override
	public ListOfItemsList getCategoryItemsWithItemTypePrice( String category, List<String> itemTypes,  float low,float high){
        List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
        if (!itemTypes.isEmpty()){
        	
            for(String itemType : itemTypes){
            	 List<Item> itemsList =  itemDaoImpl.getCategoryItemsWithItemTypePrice(category,itemType,low,high,null);
                 
            	 int noPages = itemsList.size()/ITEM_CAPACITY;
             	int remPage = itemsList.size()%ITEM_CAPACITY;
             	for(int i=0;i<noPages;i++)
             	{	
             		listOfItemsList0.add( itemsList.subList(ITEM_CAPACITY*i, ITEM_CAPACITY*i+ITEM_CAPACITY));
             	}
             	if(remPage>0)
             	{
             		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
             		
             	}
          
            }
            listOfItemsList1.setList(listOfItemsList0);
            return listOfItemsList1;
        }else{
            return this.getCategoryItemsWithPrice(category,low,high);
        }
    }

    //Gets all the itemsTypes present in the category
    @Override
	public List<String> getDistinctItemType(String category){
        return  itemDaoImpl.getDistinctItemTypes(category);
    }

    //Gets List Of items list based on the keyword given by users
    @Override
	public ListOfItemsList getItemsKeyWord(String keyword){
    	String keywordModified = "%"+keyword.replace(' ', '%')+"%";
    	List<Item> itemsList = itemDaoImpl.getItemsKeyword(keywordModified);
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
    	
    	int noPages = itemsList.size()/ITEM_CAPACITY;
    	int remPage = itemsList.size()%ITEM_CAPACITY;
    	List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	for(int i=0;i<noPages;i++)
    	{	
    		listOfItemsList0.add( itemsList.subList(ITEM_CAPACITY*i, ITEM_CAPACITY*i+ITEM_CAPACITY));
    	}
    	if(remPage>0)
    	{
    		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
    		
    	}
    	listOfItemsList1.setList(listOfItemsList0);
        return listOfItemsList1;
    }
}
