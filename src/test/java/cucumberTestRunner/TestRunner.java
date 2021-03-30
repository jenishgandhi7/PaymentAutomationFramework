package cucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="cucumberStepDefine")
public class TestRunner extends AbstractTestNGCucumberTests  {

}
