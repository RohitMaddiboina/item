package com.ecommerce.item.service;

import com.ecommerce.item.dao.ItemDao;
import com.ecommerce.item.model.Item;
import com.ecommerce.item.model.ListOfItemsList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public ListOfItemsList getAllItems(String category){
    	List<Item> itemsList = itemDao.getAllItems(category,null);
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
    	int noPages = itemsList.size()/6;
    	int remPage = noPages%6;
    	List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	for(int i=0;i<noPages;i++)
    	{
    		listOfItemsList0.add( itemsList.subList(6*i, 6*i+6));
    	}
    	if(remPage>0)
    	{
    	listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
    	}
//    	
//    	if(remPage>0) {
//    		noPages=noPages+1;
//    	}
//    	if(noPages>0){
//    		for(int i=0;i<noPages;i++) {
//    			
//    			listOfItemsList0.add(itemDao.getAllItems(category,PageRequest.of(i, 6)));
//    		}
//    	}
    	listOfItemsList1.setList(listOfItemsList0);
    	return listOfItemsList1;
    }

    public ListOfItemsList getCategoryItemsWithItemType(String category,List<String> itemTypes){
        List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
        if (!itemTypes.isEmpty()){

            for(String itemType : itemTypes){
               
                List<Item> itemsList =  itemDao.getCategoryItemsWithItemType(category,itemType,null);

            	int noPages = itemsList.size()/6;
            	int remPage = itemsList.size()%6;
            	for(int i=0;i<noPages;i++)
            	{	
            		listOfItemsList0.add( itemsList.subList(6*i, 6*i+6));
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
    public ListOfItemsList getCategoryItemsWithPrice(String category, float low,float high) {
    	List<Item> itemsList = itemDao.getCategoryItemsWithPrice(category,low,high,null);
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
    	
    	int noPages = itemsList.size()/6;
    	int remPage = itemsList.size()%6;
    	List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	for(int i=0;i<noPages;i++)
    	{	
    		listOfItemsList0.add( itemsList.subList(6*i, 6*i+6));
    	}
    	if(remPage>0)
    	{
    		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
    		
    	}
    	listOfItemsList1.setList(listOfItemsList0);
        return listOfItemsList1;
    }

    public ListOfItemsList getCategoryItemsWithItemTypePrice( String category, List<String> itemTypes,  float low,float high){
        List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
        if (!itemTypes.isEmpty()){
        	
            for(String itemType : itemTypes){
            	 List<Item> itemsList =  itemDao.getCategoryItemsWithItemTypePrice(category,itemType,low,high,null);
                 
            	 int noPages = itemsList.size()/6;
             	int remPage = itemsList.size()%6;
             	for(int i=0;i<noPages;i++)
             	{	
             		listOfItemsList0.add( itemsList.subList(6*i, 6*i+6));
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

    public List<String> getDistinctItemType(String category){
        return  itemDao.getDistinctItemTypes(category);
    }

    public ListOfItemsList getItemsKeyWord(String keyword){
    	String keywordModified = "%"+keyword.replace(' ', '%')+"%";
    	List<Item> itemsList = itemDao.getItemsKeyword(keywordModified);
    	ListOfItemsList listOfItemsList1 = new ListOfItemsList();
    	
    	int noPages = itemsList.size()/6;
    	int remPage = itemsList.size()%6;
    	List<List<Item>> listOfItemsList0 = new ArrayList<>();
    	for(int i=0;i<noPages;i++)
    	{	
    		listOfItemsList0.add( itemsList.subList(6*i, 6*i+6));
    	}
    	if(remPage>0)
    	{
    		listOfItemsList0.add(itemsList.subList(itemsList.size()-remPage, itemsList.size()));
    		
    	}
    	listOfItemsList1.setList(listOfItemsList0);
        return listOfItemsList1;
    }
}
