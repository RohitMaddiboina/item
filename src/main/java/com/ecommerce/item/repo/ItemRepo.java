package com.ecommerce.item.repo;


import com.ecommerce.item.model.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,Integer> {
	
	public static final String DISTINCT_ITEMTYPES = "select distinct itemType from Item where category=:category";
	public static final String CATEGORY_ITEMS = "from Item where category=:category order by price";
	public static final String CATEGORY_ITEMS_WITH_ITEMTYPES = "from Item where category=:category and itemType=:itemType order by price";
	public static final String CATEGORY_ITEMS_WITH_PRICE = "from Item where category=:category and price between :low and :high order by price";
	public static final String CATEGORY_ITEMS_WITH_ITEMTYPES_AND_PRICE = "from Item where category=:category and itemType=:itemType and price between :low and :high order by price";
	public static final String GET_ITEMS_WITH_KEYWORD = "select * from item where concat(brand,' ' ,item_name,' ',item_type,'',item_name,' ',brand,' ',item_type) like :keyword";

	
    @Query(value = DISTINCT_ITEMTYPES)
    List<String> getDistinctItemTypes(@Param("category") String category);

    @Query(value = CATEGORY_ITEMS)
    List<Item> getCategoryItems(@Param("category") String category,Pageable pageable);
    
    
    @Query(value = CATEGORY_ITEMS_WITH_ITEMTYPES)
    List<Item> getCategoryItemsWithItemType(@Param("category") String category,@Param("itemType") String itemType,Pageable pageable);
    
    
    
    
    
    @Query(value = CATEGORY_ITEMS_WITH_PRICE)
    List<Item> getCategoryItemsWithPrice(@Param("category") String category,@Param("low") float low,
                                @Param("high") float high,Pageable pageable);

    @Query(value = CATEGORY_ITEMS_WITH_ITEMTYPES_AND_PRICE)
    List<Item> getCategoryItemsWithItemTypePrice(@Param("category") String category,@Param("itemType") String itemType,@Param("low") float low,
                                         @Param("high") float high,Pageable pageable);
    

    @Query(value = GET_ITEMS_WITH_KEYWORD,nativeQuery = true)
    List<Item> getItemsWithKeyword(@Param("keyword") String keyword);
   
}
