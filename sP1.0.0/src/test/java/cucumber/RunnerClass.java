package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/cucumber",glue = "src/test/java/onlineShop/LoginPages",
monochrome = true,plugin ={"html:target/cucumber.html"})
public class RunnerClass extends AbstractTestNGCucumberTests{

}
