package Assigment.Payment_Form;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.paymentPage;
import net.bytebuddy.ByteBuddy;
import resources.base_config;

public class ACH_Payment_TC extends base_config {

	String url;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ACH_Payment_TC.class.getName());
	paymentPage cp;

	@BeforeTest()
	public void start() throws IOException {
		log.info("TestCase is Starting");

		driver = initalizerDriver();
		log.info("Driver is instiallized");
		this.url = prop.getProperty("url");

	}

	@Test(dataProvider = "getData")
	public void ACH_TestCase(String firstName, String lastName, String email, String company, String description,
			String amt, String PaymentScheduleType, String PaymentScheduleFreq, String NameOfCheckHolder,
			String Acc_type, String Acc_Use, String Routing_Number, String Acc_Number, String Confiorm_Acc_Num)
			throws IOException, InterruptedException {

		driver.get(url);
		log.info(" Navigating to URL");
		cp = new paymentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement visibleText;
		visibleText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h5[@data-testid='payment-form-header-title']")));
		visibleText.getText();

		cp.getFirstName().sendKeys(firstName);
		cp.getLastName().sendKeys(lastName);
		cp.getEmail().sendKeys(email);
		cp.getCompany().sendKeys(company);
		cp.getDescription().sendKeys(description);
		cp.getPaymentAmount().sendKeys(amt);
		cp.getPaymentScheduleTypeSelect().click();
		if (PaymentScheduleType.equals("Recurring Payment")) {
			cp.getRecurringPayment().click();
			cp.getPaymentScheduleFrequencySelect().click();
			if (PaymentScheduleFreq.equals("Monthly")) {
				cp.getMonthly().click();
			}

		} else {
			cp.getOneTimePayment().click();
		}
		Thread.sleep(1000);

		cp.getBankAccount().click();
		cp.getPaymentCheckName().sendKeys(NameOfCheckHolder);
		if (Acc_type.equals("Saving")) {
			cp.getPaymentCheckAccountType().click();
			cp.getSavings().click();
		}
		
		if (Acc_Use.equals("Business")) {
			cp.getPaymentCheckBusinessPersonal().click();
			cp.getBusiness().click();
		}

		
		cp.getPaymentCheckRoutingNumber().sendKeys(Routing_Number);
		String Bankname = cp.getPaymentCheckAccountType().getText();
		//Assert.assertEquals(Bankname, "BANK OF AMERICA, NA");

		cp.getPaymentCheckAccountNumber().sendKeys(Acc_Number);
		cp.getPaymentCheckAccountNumberConfirmation().sendKeys(Confiorm_Acc_Num);
		
		cp.getTerms().click();
		cp.getSubmit().click();

		WebElement conf_text;
		conf_text = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@data-testid='confirmation-number']")));
		String conf_number = conf_text.getText();

		System.out.println(conf_number);

		String verify_payment_schedule = driver
				.findElement(By.xpath("//h6[@data-testid='payment-schedule-description']")).getText().replace("-", " ")
				.toUpperCase();
		System.out.println(verify_payment_schedule);

//		Assert.assertEquals(verify_payment_schedule, PaymentScheduleType.toUpperCase());

		String verify_amt = driver.findElement(By.xpath("//h6[@data-testid='payment-amount']")).getText()
				.replace("$", " ").trim();
		System.out.println(verify_amt);
		Assert.assertEquals(verify_amt, amt);

		String conf_email = driver.findElement(By.xpath("//div[@data-testid='conf-email-copy']/strong")).getText();
		System.out.println(conf_email);
		Assert.assertEquals(conf_email, email);

		Thread.sleep(1000);

	}

	@DataProvider()
	public Object[][] getData() {

		Object[][] data = new Object[][] {
				{ "Test", "QA", "testingQA@gmail.com", "Test Company", "Test Descripition", "12,000.00",
						"One Time Payment", "", "Test QA", "Checking", "Personal", "072000805", "5112000100000003",
						"5112000100000003" },
				{ "Test1", "QA", "testingQA1@gmail.com", "Test Company", "Test Descripition", "18,000.00",
						"Recurring Payment", "Monthly", "Test1 QA", "Savings", "Business", "072000805",
						"5112000100000003", "5112000100000003" },
				{ "Test2", "QA", "testingQA2@gmail.com", "Test Company", "Test Descripition", "15,000.00",
						"Recurring Payment", "Weekly", "Test1 QA", "Checking", "Personal", "072000805",
						"5112000100000003", "5112000100000003" },

		};

		return data;

	}

	@AfterTest()
	public void close() {

		driver.close();
		log.info("Succesfully close browser");

	}

}
