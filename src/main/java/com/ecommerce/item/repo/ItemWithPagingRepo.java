package com.ecommerce.item.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.item.model.Item;

public interface ItemWithPagingRepo  extends JpaRepository<Item,Integer> {

	public static final String GET_ITEMS_WITH_KEYWORD = "select * from item where concat(brand,' ' ,item_name,' ',item_type,'',item_name,' ',brand,' ',item_type) like :keyword";
	
	Page<Item> findByCategory(String category,Pageable pageable);
	
    
	Page<Item> findByCategoryAndItemTypeIn(String category, List<String> itemType,Pageable pageable);
	
	Page<Item> findByCategoryAndItemTypeInAndPriceBetween(String category,List<String> itemType,float low,
            float high,Pageable pageable);
	
	
	Page<Item> findByCategoryAndPriceBetween(String category,float low,float high,Pageable pageable);
		 
	
	@Query(value = GET_ITEMS_WITH_KEYWORD,nativeQuery = true)
    Page<Item> getItemsWithKeyword(@Param("keyword") String keyword,Pageable pageable);

}
