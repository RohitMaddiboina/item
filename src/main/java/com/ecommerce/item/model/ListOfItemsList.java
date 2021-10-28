package com.ecommerce.item.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListOfItemsList {

	private List<List<Item>> list;
}
