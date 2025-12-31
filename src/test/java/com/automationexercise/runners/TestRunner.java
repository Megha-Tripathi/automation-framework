package com.automationexercise.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/features", 
		glue = {
				"com.automationexercise.stepdefinitions",
				"com.automationexercise.hooks"
		},
		tags = "@smoke",
		plugin = {"pretty","html:target/cucumber-reports.html"},
		monochrome = true
		)


public class TestRunner {


}
