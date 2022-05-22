package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TodoList extends WebComponent {

    private final By itemsLocator = By.cssSelector("li.todo");

    TodoList(RemoteWebElement wrapper) {
        super(wrapper);
    }


    public List<TodoItem> getTodoItems() {
        List<WebElement> items = itemsLocator.findElements(wrappedElement);
        return items.stream().map(x -> new TodoItem((RemoteWebElement) x)).collect(Collectors.toList());
    }

    public TodoItem findByLabel(String label) {

        return wait.until(x -> this.getTodoItems().stream().filter(i -> i.getLabel().equals(label)).findFirst().orElse(null));
    }
}