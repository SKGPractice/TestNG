package test;

import java.io.PrintStream;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;
import genericfunction.GetConfig;



public class LoginTest {
	
	
  @Test (testName = "Login Test")
  public void loginTest() {
  }
  
  
  @BeforeMethod
  public void beforeMethod(Method method) throws Exception{
	  
	  System.out.println(GetConfig.getTestFilePath());
	  System.out.println(GetConfig.getTestFileName());
	  System.out.println(method.getName());
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
