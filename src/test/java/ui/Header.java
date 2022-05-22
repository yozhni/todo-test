package ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Header extends WebComponent {

    @FindBy(how = How.CSS, using = "input")
    public WebElement input;

    @FindBy(how = How.XPATH, using = "//section/label")
    public WebElement toggleAll;

    Header(RemoteWebElement wrapper) {
        super(wrapper);
    }

    public void add(String label) {
        input.sendKeys(label + Keys.ENTER);
    }

    public void clickCompleteAll()
    {
        toggleAll.click();
    }


}
