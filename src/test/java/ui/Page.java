package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;


public class Page {

    public Header header;
    public Footer footer;
    public TodoList todoList;
    private By headerLocator = By.cssSelector("header.header");
    private By footerLocator = By.cssSelector("footer.footer");
    private By bodyLocator = By.cssSelector("section.main");

    public Page(WebDriver driver) {
        header = new Header((RemoteWebElement) headerLocator.findElement(driver));
        footer = new Footer((RemoteWebElement) footerLocator.findElement(driver));
        todoList = new TodoList((RemoteWebElement) bodyLocator.findElement(driver));
    }


}
