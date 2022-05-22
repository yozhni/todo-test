package ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TodoItem extends WebComponent {


    @FindBy(how = How.CSS, using = "label")
    private WebElement labelElement;

    @FindBy(how = How.CSS, using = "input.edit")
    private WebElement inputElement;


    @FindBy(how = How.CSS, using = "button.destroy")
    private WebElement deleteButton;

    @FindBy(how = How.CSS, using = "input.toggle")
    private WebElement checkBox;

    TodoItem(RemoteWebElement wrapper) {
        super(wrapper);
    }


    public String getLabel() {
        return labelElement.getText();
    }

    public TodoStatus getStatus() {
        return wrappedElement.getAttribute("class").toLowerCase().contains("completed") ? TodoStatus.Completed : TodoStatus.Active;
    }


    public void delete() {
        new Actions(wrappedDriver).moveToElement(wrappedElement).perform();
        deleteButton.click();
        wait.until(x -> {
            try {
                return !wrappedElement.isDisplayed();
            } catch (Exception ex) {
                return true;
            }
        });
    }

    public TodoItem update(String newLabel) throws InterruptedException {

        new Actions(wrappedDriver).doubleClick(wrappedElement).perform();
        wait.until(x -> wrappedElement.getAttribute("class").contains("editing"));
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.COMMAND + "a");
        inputElement.sendKeys(Keys.BACK_SPACE);
        inputElement.sendKeys(newLabel + Keys.ENTER);
        return this;
    }

    public TodoItem markItem() {
        new Actions(wrappedDriver).moveToElement(wrappedElement).perform();
        checkBox.click();
        return this;
    }


}
