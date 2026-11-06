package Swagtestpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import Swagbasepkg.Swagbase;

public class Swaglogintest extends Swagbase {
	

	@Test(priority = 1)

	public void login() throws Exception {
    //Object extent;
	test = extent.createTest("Loginverification");
    obj.loginmthd("standard_user", "secret_sauce");
    Thread.sleep(2000);
	}


	@Test(priority = 2)

	public void valdiation() {

	    test = extent.createTest("Loginvalidation");
	    String expurl = "https://www.saucedemo.com/";
        String acturl = obj.urlmthd();
        Assert.assertEquals(expurl, acturl);

	}


	@Test(priority=3)

	public void swagtitleverification() {

	    test = extent.createTest("swagtitleverification");
	    String Exp = "Swaglabs";
	    String actual = obj.titlemthd();
	    System.out.println(actual);

	}

}
