Hi! 

By using this project you can compare 2 different topics' percentual ratio 
of the past 90 days in New York, USA. It is comparing "Selenium WebDriver" 
and "Javascript WebDriverIO" using Chrome by default. In order to compare different topics
you can chance the firstTopic and secondTopic value in Configuration.properties file.


This project is written in Java and built using Maven. All dependencies are in pom.xml file.
It is a Page Object Model Cucumber BDD framework that uses Selenium WebDriver and Junit.

For each page, there is corresponding class inside pages package for storing related web elements and methods.

Inside runners package there are 2 runner class that for starting the test you should run CucumberRunner class.
If there is failed test then it will be saved inside rerun.txt file. You can rerun the rest from the failedTestRuner class.
It creates json and html reports that you can find it inside target folder.

In stepDefinitions package steps are implemented and Assertions are made inside GoogleTrendsStepDef class 
Before the scenario SetUpAndTearDown class runs. It has Before and After methods. In case a step fails it takes screenshot.

Inside utilities package there is BrowserUtils class that has useful methods.
ConfigurationReader class reads the data from configuration.properties file where we store important data such as browser and url.
It has topic names that you can change to search and compare different terms.
DriverFactory class has Singleton Design Pattern. You can see available browsers inside this class.

resources folder that stores .feature file which when you run the test it will read the steps that is written in Gherkin language.


That's all you need to know.
Enjoy your testing!!