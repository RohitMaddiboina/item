package com.ecommerce.item.repo;


import com.ecommerce.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,Integer> {

    @Query(value = "select distinct itemType from Item where category=:category")
    List<String> getDistinctItemTypes(@Param("category") String category);

    @Query(value = "from Item where category=:category order by price")
    List<Item> getCategoryItems(@Param("category") String category);

    @Query(value = "from Item where category=:category and price between :low and :high order by price")
    List<Item> getCategoryItemsWithPrice(@Param("category") String category,@Param("low") float low,
                                @Param("high") float high);

    @Query(value = "from Item where category=:category and itemType=:itemType order by price")
    List<Item> getCategoryItemsWithItemType(@Param("category") String category,@Param("itemType") String itemType);

    @Query(value="from Item where category=:category and itemType=:itemType and price between :low and :high order by price")
    List<Item> getCategoryItemsWithItemTypePrice(@Param("category") String category,@Param("itemType") String itemType,@Param("low") float low,
                                         @Param("high") float high);

    @Query(value = "select * from item where concat(brand,' ' ,item_name,' ',item_type,'',item_name,' ',brand,' ',item_type) like :keyword",nativeQuery = true)
    List<Item> getItemsWithKeyword(@Param("keyword") String keyword);
   
}
