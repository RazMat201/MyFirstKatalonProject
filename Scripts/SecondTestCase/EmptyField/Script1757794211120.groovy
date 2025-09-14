import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
WebUI.callTestCase(findTestCase('SecondTestCase/BaseTestCase'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.sendKeys(findTestObject('SecondTestCase/Name'), 'Razan')
WebUI.sendKeys(findTestObject('SecondTestCase/LastName'), 'Matalgah')
WebUI.sendKeys(findTestObject('SecondTestCase/Email'), 'Razan@2001.com')
WebUI.click(findTestObject('SecondTestCase/FemaleButton', ['value': 'Female']))

WebUI.sendKeys(findTestObject('SecondTestCase/Number'), '')

WebUI.click(findTestObject('SecondTestCase/SubmitButton'))


String redColor = "rgb(220,53,69)"
String color = WebUI.getCSSValue(findTestObject('SecondTestCase/Number'), 'border-color').replaceAll(/\s+/, '')

if (color == redColor) {
	assert true : "border is red"
}
else {
	assert false : "border is not red, there's a bug"
}





