package ui;

import etc.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebComponent {

    protected WebElement wrappedElement;
    protected WebDriverWait wait;
    protected WebDriver wrappedDriver;

    WebComponent(RemoteWebElement wrapper) {
        this.wrappedDriver = wrapper.getWrappedDriver();
        PageFactory.initElements(wrapper, this);
        this.wrappedElement = wrapper;
        this.wait = new WebDriverWait(this.wrappedDriver, Config.DefaultTimeout);
    }
}
