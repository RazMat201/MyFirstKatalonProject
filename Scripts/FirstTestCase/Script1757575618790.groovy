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

WebUI.openBrowser(GlobalVariable.BaseURL)

WebUI.click(findTestObject('FirstTestCase/ActualData/Elements'))

WebUI.click(findTestObject('FirstTestCase/ActualData/TextBox'))

WebUI.sendKeys(findTestObject('FirstTestCase/ActualData/UserName'), 'Razan')

WebUI.sendKeys(findTestObject('FirstTestCase/ActualData/Email'), 'Razan@2001.com')

WebUI.sendKeys(findTestObject('FirstTestCase/ActualData/CurrentAddress'), 'Amman')

WebUI.sendKeys(findTestObject('FirstTestCase/ActualData/PermenentAddress'), 'Amman')

WebUI.click(findTestObject('FirstTestCase/ActualData/SubmitButton'))

// Data verification
// Actual Data:
String UserName = WebUI.getAttribute(findTestObject('FirstTestCase/ActualData/UserName'), 'value')

String Email = WebUI.getAttribute(findTestObject('FirstTestCase/ActualData/Email'), 'value')

String CurrentAddress = WebUI.getAttribute(findTestObject('FirstTestCase/ActualData/CurrentAddress'), 'value')

String PermenentAddress = WebUI.getAttribute(findTestObject('FirstTestCase/ActualData/PermenentAddress'), 'value')
//******

WebUI.getText(findTestObject('FirstTestCase/ExpectedData/NameData'))

WebUI.getText(findTestObject('FirstTestCase/ExpectedData/PermenentAddressData'))

WebUI.getText(findTestObject('FirstTestCase/ExpectedData/Emaildata'))

WebUI.getText(findTestObject('FirstTestCase/ExpectedData/CurrentAddressData'))
// Data After Submition
String UserNameData = WebUI.getText(findTestObject('FirstTestCase/ExpectedData/NameData'))
String EmailData = WebUI.getText(findTestObject('FirstTestCase/ExpectedData/Emaildata'))
String CurrentAddressData = WebUI.getText(findTestObject('FirstTestCase/ExpectedData/CurrentAddressData'))
String PermenentAddressData = WebUI.getText(findTestObject('FirstTestCase/ExpectedData/PermenentAddressData'))
// splitted :
String UserNameSplit = UserNameData.split(":")[1].trim()
String EmailSplit = EmailData.split(":")[1]
String CurrentSplit = CurrentAddressData.split(":")[1]
String PermenentSplit = PermenentAddressData.split(":")[1]

WebUI.verifyEqual(UserName, UserNameSplit)
WebUI.verifyEqual(Email, EmailSplit)
WebUI.verifyEqual(CurrentAddress, CurrentSplit)
WebUI.verifyEqual(PermenentAddress, PermenentSplit)



