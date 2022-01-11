package SetupClass.StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import java.lang.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;

import SetupClass.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Coupon extends SetupClass {
	
	WebDriverWait wait = new WebDriverWait(driver,60);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@Given("^user is already on Website Home Page cc$")
	public void user_is_already_on_Website_Home_Page_cc() throws Throwable {
		//driver.get(AppURL);
		driver.get("https://www.slidegeeks.com/");
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}
		Thread.sleep(3000);
	    driver.get("https://www.slidegeeks.com/subscriptions");
		Thread.sleep(4000);
		//Thread.sleep(3000);
		 WebElement Join_now = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Monthly")));
		Thread.sleep(3000);
		Join_now.click();
		Thread.sleep(5000);
		
		WebElement create_account = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pg-account-action > div > div:nth-child(1) > div > div > div.btn-wrapper.create_accbtn > a")));
		Thread.sleep(3000);
		create_account.click();
		Thread.sleep(2000);
		//driver.get("https://www.slidegeeks.com/register");
		Thread.sleep(3000);
		
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jform_name1")));
		 Thread.sleep(3000);
		 name.sendKeys("Automated Program");
		 Thread.sleep(3000);
	   
	
		// Generate Random Email Address
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	    
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		Thread.sleep(2000);
		
		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jform_email1")));
		 Thread.sleep(3000);
		 new_email.sendKeys(full_email);
		 Thread.sleep(3000);
		
	
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jform_password1")));
		 Thread.sleep(3000);
		password.sendKeys("Geeks@123");
		 Thread.sleep(3000);
		 
		 WebElement confirm_passwoed = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jform_password2")));
		 Thread.sleep(3000);
		confirm_passwoed.sendKeys("Geeks@123");
		 Thread.sleep(3000);
	    
	
		WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captchtext")));
		 Thread.sleep(3000);
		captcha.sendKeys("Y3Tt6bfwI");
		 Thread.sleep(3000);
	    

		WebElement register_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		 Thread.sleep(3000);
		register_btn.click();
		 Thread.sleep(5000);
	}
	
    
    @Then("^user is redirected to pricing page and choose the plan to pay cc$")
	public void user_is_redirected_to_pricing_page_and_choose_the_plan_to_pay_cc() throws Throwable {
		// choose a plan
		driver.get("https://www.slidegeeks.com/subscriptions");
		Thread.sleep(3000);
		 WebElement Subscribe_btn  =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[3]/span/form/span/button"));
		js.executeScript("arguments[0].scrollIntoView();",Subscribe_btn);
			Thread.sleep(2000);
		    Subscribe_btn.click();
			Thread.sleep(6000);

	}

	@Then("^user is redirected checkout page cc$")
	public void user_is_redirected_checkout_page_cc() throws Throwable {
		Thread.sleep(6000);
    //WebElement Continue =  driver.findElement(By.xpath("//*[@id='pg-checkout-shipping-info']/div[1]/div/div/div/div[2]/button"));
	//js.executeScript("arguments[0].scrollIntoView();",Continue);
		//Thread.sleep(1000);
		//Continue.click();
	}

	@Then("^user proceed to pay with paypal pp cc$")
	public void user_proceed_to_pay_with_paypal_pp_cc() throws Throwable {
	
		Thread.sleep(1400);
		
		    try
		{
			WebElement cp_btn  = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]"));
			Thread.sleep(2000);
		    cp_btn.click();
		    Thread.sleep(3000);
		}
		catch (NoSuchElementException popup) {
			// TODO: handle exception
		}
		
		Thread.sleep(3000);
		//Apply coupon

		WebElement Coupon= driver.findElement(By.cssSelector("#discount-checkbox"));
		Thread.sleep(3000);
		Coupon.click();
		Thread.sleep(3000);
		 WebElement Add_Coupon= driver.findElement(By.cssSelector("#checkbox-input"));
		Thread.sleep(3000);
		Add_Coupon.sendKeys("5OFF");
		Thread.sleep(3000);
		Thread.sleep(3000);
		 WebElement Apply_Coupon= driver.findElement(By.cssSelector("#applyPromoCode"));
		Thread.sleep(3000);
		Apply_Coupon.click();
		Thread.sleep(3000);
    
		//Remove Coupon
		 WebElement Remove_Coupon= driver.findElement(By.cssSelector("#removePromoCode"));
		Thread.sleep(3000);
		Remove_Coupon.click();
		Thread.sleep(3000);
    
    //Aplly Coupon Again
		WebElement Coupon1= driver.findElement(By.cssSelector("#discount-checkbox"));
		Thread.sleep(3000);
		Coupon1.click();
		Thread.sleep(3000);
		 WebElement Add_Coupon1= driver.findElement(By.cssSelector("#checkbox-input"));
		Thread.sleep(3000);
		Add_Coupon1.sendKeys("5OFF");
		Thread.sleep(3000);
		Thread.sleep(3000);
		 WebElement Apply_Coupon1= driver.findElement(By.cssSelector("#applyPromoCode"));
		Thread.sleep(3000);
		Apply_Coupon1.click();
		Thread.sleep(3000);
    
		WebElement Value_after_coupon= driver.findElement(By.cssSelector("body > div.afterBody.checkout-wrapper.main-wrapper.no-left-menu > div.main_wrapper > div > div.checkout-inner-wrapper > div.checkout-box-wrapper.checkout-order > div > div > table > tbody > tr:nth-child(4) > td:nth-child(2) > strong > em"));
		
	      String expected = "47.49";
              String actual = Value_after_coupon.getText();
              System.out.println(actual);
		
              Assert.assertTrue("Price does not matched", actual.contentEquals("47.49"));
		
              if(expected.equals(actual)){
              System.out.println("Coupon applied Successfully");
              }
           else {
            System.out.println("Coupon Error");
        }
		
		
		Thread.sleep(1000);
		   try {
			
		 WebElement place_order_btn  =  driver.findElement(By.cssSelector("body > div.afterBody.checkout-wrapper.main-wrapper.no-left-menu > div.main_wrapper > div > div.checkout-inner-wrapper > div.checkout-box-wrapper.checkout-order > div > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > button.btn.primary-btn.pg-button.pg-checkout-continue"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			//js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
		    place_order_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^paypal popup appears and user navigates back to my account pp cc$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_pp_cc() throws Throwable {
	         
		// page title
		  String pp_page_title=driver.getTitle();
			Thread.sleep(3000);
		    System.out.println("Title of the Page is --> "+pp_page_title);
		
		Thread.sleep(2000);
				  driver.get("https://www.slidegeeks.com/component/pago/checkout");
				 // driver.switchTo().window(currentWindow);
			 
	}


	@Then("^user Signout account PP cc$")
	public void user_Signout_account_PP_cc() throws Throwable {
		Thread.sleep(3000);
	    driver.get("https://www.slidegeeks.com/component/pago/checkout");
		Thread.sleep(2000);
		
		 //  driver.get("https://www.slidegeeks.com/component/pago/checkout");
		//Thread.sleep(2000);
	WebElement Account = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/nav/div/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]/a"));
		Thread.sleep(3000);
		Account.click();
                 Thread.sleep(3000);
	WebElement Delete_Account = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[2]/div/ul/li[6]/a"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",Delete_Account);	
		Thread.sleep(3000);
		Delete_Account.click();
                 Thread.sleep(3000);
	WebElement Delete_Account_reason = driver.findElement(By.cssSelector("#only-free-download-product"));
		Thread.sleep(3000);
		Delete_Account_reason.click();
                 Thread.sleep(3000);
	WebElement Delete_Profile = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/button[1]"));
		Thread.sleep(3000);
		Delete_Profile.click();
                 Thread.sleep(3000);
	WebElement No_Delete = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/button[2]"));
		Thread.sleep(3000);
		No_Delete.click();
                 Thread.sleep(7000);
		
		
	}


	
}
