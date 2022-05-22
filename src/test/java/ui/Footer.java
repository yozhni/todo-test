package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Footer extends WebComponent {

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "All")
    public WebElement filterAll;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Active")
    public WebElement filterActive;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Completed")
    public WebElement filterCompleted;
    @FindBy(how = How.CSS, using = "span.todo-count")
    WebElement todoCount;
    @FindBy(how = How.CSS, using = "button.clear-completed")
    WebElement clearCompleted;

    Footer(RemoteWebElement wrapper) {
        super(wrapper);
    }

    public WebElement getFilterByString(String string) {
        if (string.toLowerCase().equals("all")) {
            return filterAll;
        } else if (string.toLowerCase().equals("active")) {
            return filterActive;
        } else if (string.toLowerCase().equals("completed")) {
            return filterCompleted;
        } else return null;
    }

    public WebElement getClearCompleted() {
        return this.clearCompleted;
    }

    public WebElement getTodoCount() {
        return this.todoCount;
    }

    public Integer getToDoCountNumber() {
        return Integer.parseInt(todoCount.getText().toString().split(" ")[0]);
    }


}
