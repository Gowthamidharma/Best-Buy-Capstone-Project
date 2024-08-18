Project Focus - Automating Best Buy web application 
		
		Technologies used:
		
		Java - Programming Language
		
		Selenium Webdriver - Selenium WebDriver is used as core component which provides a programming interface for driving the web browsers.
		
		Maven - Maven is a build automation tool used primarily for Java projects. 
		It automates the source code compilation and dependency management, assembles binary codes into packages, and executes test scripts.
		
		TestNG - TestNG is a testing framework for Java that helps in automating tests for your software applications.
		It allows you to write and organize test cases, execute them efficiently, and generate detailed test reports.
		TestNG supports various testing scenarios like unit testing, integration testing, and end-to-end testing.
		
		POM architecture - Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements.
		It helps reduce code duplication and improves test case maintenance. 
		In Page Object Model, consider each web page of an application as a class file.
		
		Eclipse - Eclipse is an IDE, it provides integrated development environment to write specific logics to develop/automate webpage and
		through eclipse we can write selenium scripts to automate webpage and can do several things in this tool like debugging your coding,
		framework implements.
		
		Test Driven Development(TDD) - TDD, which stands for test-driven development, is a software development methodology. TDD consists of using tests to drive the development of the application, leading to simple, iterative implementation with high test coverage from the beginning.
		
		GitHub - GitHub is a cloud-based platform where we can store, share, and work together with others to write code. Storing our code in a "repository" on 
		GitHub allows us to showcase or share your work. Track and manage changes to your code over time. Let others review your code, and make suggestions to improve it.
		
		Jenkins - Jenkins is an open source automation server. It helps automate the parts of software development related to building, testing, and deploying, facilitating continuous integration, and continuous delivery.
		
		Log4j - Log4j, is possible to store the flow details of our automation in a file or database.Log4j is worked for large as well as small projects.
		In log4j, we use log statements rather than SOPL statements in the code to know the condition of a project while it is executing.
		
		Extent Report - Extent Reports is library useful for test automation. It can be easily integrated with major testing frameworks like JUnit, NUnit, TestNG, etc. 
		These reports are HTML documents that depict results as pie charts.
		
		Structure of project:
		
		Packages : 
		    Base : It contains a class with all the base specification for the project.
		           It contains Extent Report in @BeforeSuite. 
		    Pages: It contains classes for indiviual pages and abstract methods. 
		    Test : It contains test methods, interface and @Test where the order of execution begins. 
		    Utilies: It contains static methods , which can be accessed throughout the application. 
		              It contains Listener class , which gives detailed segregated test report descriprtion.
		
		Resource: 
		    PropertyFile : It contains all the required Static data for the project.
		    Excel : It contains all the required Dynamic data for the project.
		
		Screenshot: 
		    It contains the relavent screenshot of testcases
		ExtentReport: 
		    It contains HTML ExtentReport to support the TestCases 
		
		Project Closure Report and Support Document Attached along with Git Hub Link: 
		1. Testng Execution Result
		2. Maven Execution Result
		3. Jenkins Integrated Result
		
		Plans that were Excluded:
		
		1. Headless Browser Testing due to system compatability issue. (failed to start new session exception)
		2. Parallel Execution was not possible due to platform downtime.
		
		
