package runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/features"},glue={"sfdc.steps"},plugin={"pretty",
		"html:target/cucumber-reports.html" ,"json:target/cucumber.json"},tags="@sanity or @regression",dryRun=false)

@RunWith(Cucumber.class)
public class sfdcSanityRunner {
	
}
