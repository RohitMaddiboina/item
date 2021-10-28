package com.ecommerce.item;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ItemApplicationTests {


 @Autowired
MockMvc mockmvc;
@Test
void getItem() throws Exception
{
mockmvc.perform( get("/getItem/10") )
.andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}

@Test
void getAllItems() throws Exception
{
mockmvc.perform( get("/getItems/top wear") )
.andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}


@Test
void getItemsKeyword() throws Exception
{
mockmvc.perform( get("/getItemsKeyword/polo") )
.andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}

@Test
void getAllItemWithItemType() throws Exception
{
List<String> list=new ArrayList<>();
list.add("T shirts");
list.add("jeans");
ObjectMapper mapper=new ObjectMapper();
String jsonData=mapper.writeValueAsString(list);
mockmvc.perform( post("/getItems/top wear")
.content(jsonData)
.contentType("application/json") )
.andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}

@Test
void Negative_getAllItemWithItemType() throws Exception
{
List<String> list=new ArrayList<>();
ObjectMapper mapper=new ObjectMapper();
String jsonData=mapper.writeValueAsString(list);
mockmvc.perform( post("/getItems/top wear")
.content(jsonData)
.contentType("application/json") )
.andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}

@Test
void getAllItemWithItemTypeAndPrice() throws Exception
{
List<String> list=new ArrayList<>();
list.add("T shirts");
ObjectMapper mapper=new ObjectMapper();

String jsonData=mapper.writeValueAsString(list);
mockmvc.perform( post("/getItems/top wear/500/5000")
.content(jsonData)
.contentType("application/json") ) .andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}
@Test
void Negative_getAllItemWithItemTypeAndPrice() throws Exception
{
List<String> list=new ArrayList<>();
ObjectMapper mapper=new ObjectMapper();
String jsonData=mapper.writeValueAsString(list);
mockmvc.perform( post("/getItems/top wear/500/1500")
.content(jsonData)
.contentType("application/json") ) .andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}

@Test
void getDistinctItemType() throws Exception
{
mockmvc.perform( get("/getItemType/men/top wear") )
.andExpect( status().isOk() )
.andExpect( jsonPath("$").exists() );
}

}