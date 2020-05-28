package pageobjects;

import framework.base.BasePage;
import framework.driver.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HowLongSleepProblemPage extends BasePage {

    public HowLongSleepProblemPage(WebDriverUtil webDriverUtil, String host) {
        super(webDriverUtil, host, "#2/2");
    }


    public void selectDropdownOptionByValue(String value) {
        WebElement testDropDown = getWebDriverUtil().findElement(By.className("sl-select"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByValue(value);
    }

    public String getSelectedOptionText() {
        WebElement testDropDown = getWebDriverUtil().findElement(By.className("sl-select"));
        Select dropdown = new Select(testDropDown);
        WebElement element = dropdown.getFirstSelectedOption();
        if(element != null) {
            return element.getText();
        }

        return "";
    }

}
