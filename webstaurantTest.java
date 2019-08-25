package webstaurant.testcases;

import org.testng.annotations.Test;

import webstaurantstore.base.Testbase;
import webstaurantstore.pages.Homepage;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;

public class webstaurantTest extends Testbase {
	 Homepage hp=null;
	
  public webstaurantTest() throws IOException {
		super();
		
	}
@Test
  public void searchaddtocarttest() {
  }
  @BeforeClass
  public void beforeClass() throws IOException, InterruptedException, AWTException {
	  initwebdriver();
	  	  hp=new Homepage();
	  	hp.verifyHomePageTitle();
	  hp.getwebstauranttitle();
	  hp.searchbutton();
	  hp.addtocart();
  }

  @AfterClass
  //11.Close Chrome
  public void afterClass() {
	 	  driver.close();
  }

}
