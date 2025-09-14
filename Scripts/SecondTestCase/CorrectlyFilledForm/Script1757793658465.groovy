import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling




WebUI.callTestCase(findTestCase('SecondTestCase/BaseTestCase'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SecondTestCase/Name'), 'Razan')
WebUI.sendKeys(findTestObject('SecondTestCase/LastName'), 'Matalgah')
WebUI.sendKeys(findTestObject('SecondTestCase/Email'), 'Razan@2001.com')
WebUI.click(findTestObject('SecondTestCase/FemaleButton', ['value': 'Female']))
WebUI.sendKeys(findTestObject('SecondTestCase/Number'), '1234567890')
WebUI.click(findTestObject('SecondTestCase/SubmitButton'))

WebDriver driver = DriverFactory.getWebDriver()

String fullName = WebUI.getAttribute(findTestObject('SecondTestCase/Name'), 'value') + " " +
                  WebUI.getAttribute(findTestObject('SecondTestCase/LastName'), 'value')

WebElement FemaleRadioButton = driver.findElement(By.id("gender-radio-2"))
String genderValue = FemaleRadioButton.getAttribute("value")


List<String> actualData = [
    fullName,
    WebUI.getAttribute(findTestObject('SecondTestCase/Email'), 'value'),
    genderValue,
    WebUI.getAttribute(findTestObject('SecondTestCase/Number'), 'value')
]

List<WebElement> rows = driver.findElements(By.xpath("//div[@class='modal-body']//tr"))
List<String> tableSecondColumn = []

for (int i = 0; i < rows.size(); i++) {
    List<WebElement> cells = rows[i].findElements(By.tagName("td"))
    if (cells.size() >= 2) {
        tableSecondColumn.add(cells[1].getText().trim())
    }
}

for (int j = 0; j < actualData.size(); j++) {
    WebUI.verifyEqual(actualData[j], tableSecondColumn[j])
}
