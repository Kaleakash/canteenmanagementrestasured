package com.hexaware.ftp97.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class MenuRestTest {

	@Test
	public void testMenuList() throws AssertionError, URISyntaxException {
	Menu[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/menu")).getBody().as(Menu[].class);
	System.out.println(res.length);
	System.out.println(res[0].getFoodId());
		for (Menu m: res) {
		switch (m.getFoodId()) {
		case 101:
			assertEquals(new Menu(101).getFoodId(), m.getFoodId());
					break;
		case 102:
			assertEquals(new Menu(102).getFoodId(), m.getFoodId());
					break;				
		case 103:
			assertEquals(new Menu(103).getFoodId(), m.getFoodId());
					break;				
		case 104:
			assertEquals(new Menu(104).getFoodId(), m.getFoodId());
					break;				
		case 105:
			assertEquals(new Menu(105).getFoodId(), m.getFoodId());
					break;			
		default:
			fail("Unknown menu with id:" + m);	
			}
		}
	}

	@Test
	public void testMenuById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/menu/1010")).then().assertThat().statusCode(404);
	}
	
}
