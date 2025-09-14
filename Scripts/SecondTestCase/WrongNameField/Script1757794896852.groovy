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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.callTestCase(findTestCase('SecondTestCase/BaseTestCase'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SecondTestCase/Name'), '12345')
WebUI.sendKeys(findTestObject('SecondTestCase/LastName'), 'Matalgah')
WebUI.sendKeys(findTestObject('SecondTestCase/Email'), 'Razan@2001.com')
WebUI.sendKeys(findTestObject('SecondTestCase/Number'), '1234567890')
WebUI.click(findTestObject('SecondTestCase/SubmitButton'))

String expectedColor = "rgb(220, 53, 69)" 

String borderColor = WebUI.getCSSValue(findTestObject('SecondTestCase/Name'), 'border-color').trim()
if (borderColor == expectedColor) {
	println("Test Passed, name field shows red border for invalid input")
} else {
	assert true : "name field did not show red border for numbers as a name input"
}