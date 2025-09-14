import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling


WebUI.callTestCase(findTestCase('SecondTestCase/BaseTestCase'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.sendKeys(findTestObject('SecondTestCase/Name'), 'Razan')
WebUI.sendKeys(findTestObject('SecondTestCase/LastName'), 'Matalgah')
WebUI.sendKeys(findTestObject('SecondTestCase/Email'), 'Razan2001.com')
WebUI.click(findTestObject('SecondTestCase/FemaleButton', ['value': 'Female']))
WebUI.sendKeys(findTestObject('SecondTestCase/Number'), '1234567890')
WebUI.click(findTestObject('SecondTestCase/SubmitButton'))


String EmailData = WebUI.getAttribute(findTestObject('SecondTestCase/Email'), 'value')

String redColor = "rgb(220,53,69)"
String color = WebUI.getCSSValue(findTestObject('SecondTestCase/Email'), 'border-color').replaceAll(/\s+/, '')

if (color == redColor) {
	assert true : "border is red"
}
else {
	assert false : "border is not red, there's a bug"
}
