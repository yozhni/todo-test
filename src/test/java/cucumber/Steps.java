package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ui.Page;
import ui.TodoItem;
import ui.TodoStatus;


import java.util.ArrayList;
import java.util.List;


public class Steps {

    Page page = (Page) TestState.data.get("page");
    WebDriver driver = (WebDriver) TestState.data.get("driver");

    @Given("I'm on todo app page")
    public void i_m_on_todo_app_page() {
    }

    @Given("todo list is empty")
    public void todo_list_is_empty() {
        List<TodoItem> list = page.todoList.getTodoItems();
        if (list.size() > 0) {
            for (TodoItem item : list) {
                item.delete();
            }
        }
    }

    @Then("all todos in the list are {string}")
    public void allTodosInTheListAre(String status) {
        List<TodoItem> list = page.todoList.getTodoItems();
        Assert.assertTrue(list.stream().filter(x->x.getStatus().equals(TodoStatus.Active)).toArray().length==0);
    }

    @Then("todo {string} is {string}")
    public void todo_has_status(String label, String status) {
        TodoItem item = page.todoList.findByLabel(label);
        Assert.assertEquals(item.getStatus(), returnStatusByString(status));

    }

    @Given("todo {string} is in the list")
    public void todo_exists(String label) {
        List<TodoItem> list = page.todoList.getTodoItems();
        Assert.assertTrue(list.stream().filter(x -> x.getLabel().equals(label)).toArray().length > 0);
    }

    @Given("todo {string} is not in the list")
    public void there_is_no_todo_in_the_list(String label) {
        List<TodoItem> list = page.todoList.getTodoItems();
        Assert.assertFalse(list.stream().filter(x -> x.getLabel().equals(label)).toArray().length > 0);
    }

    @When("I add todo {string}")
    public void i_add_todo(String label) {
        page.header.add(label);


    }

    @When("I update todo {string} to {string}")
    public void i_update_todo_to(String currentLabel, String newLabel) {
        TodoItem item = page.todoList.findByLabel(currentLabel);
        try {
            item.update(newLabel);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("update of todo item is unsuccessful: " + e);
        }
    }

    @When("I delete todo {string}")
    public void i_delete_todo(String label) {
        TodoItem item = page.todoList.findByLabel(label);
        item.delete();
    }

    @When("I complete todo {string}")
    public void iCompeteTodo(String label) {
        TodoItem item = page.todoList.findByLabel(label);
        item.markItem();
    }

    @When("I mark all as completed")
    public void iMarkAllAsComplete() {
        page.header.clickCompleteAll();
    }


    @And("I set filter to {string}")
    public void filterIsSetTo(String filter) {
        page.footer.getFilterByString(filter).click();
    }

    @And("I refresh page")
    public void iRefreshPage() {
        new Actions(driver).sendKeys(Keys.F5).perform();

    }

    @Then("there are {int} todos are displayed")
    public void thereAreTodosAreDisplayed(int number) {
        List<TodoItem> list = page.todoList.getTodoItems();
        Assert.assertEquals(list.size(),number);
    }


    @And("filter remains {string}")
    public void filterRemainsTo(String filter) {
        Assert.assertTrue(page.footer.getFilterByString(filter).getAttribute("class").equals("selected"));
    }


    public TodoStatus returnStatusByString(String status) {
        return status.toLowerCase().equals("completed") ? TodoStatus.Completed : TodoStatus.Active;
    }
}
