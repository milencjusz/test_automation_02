import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowHandlingAssignment {
    public static void main(String[] args) throws InterruptedException {
        // Initialize a new instance of WebDriver as EdgeDriver
        WebDriver driver = new EdgeDriver();
        // Navigate to the specified URL
        driver.get("http://qaclickacademy.com/practice.php");
        // Locate an element in the web page with the specified ID and assign it to a WebElement variable
        WebElement rightColumn = driver.findElement(By.id("checkbox-example"));
        // Loop to iterate through all the label elements in the rightColumn section of the web page
        for (int i = 1; i <= rightColumn.findElements(By.tagName("label")).size(); i++) {
            // Construct a String variable path with the XPath expression to locate the current label element
            String path = "//*[@id='checkbox-example']/fieldset/label[" + i + "]";
            // Click on the input element inside the current label element
            rightColumn.findElement(By.xpath(path + "/input")).click();
            // Get the text of the current label element and assign it to a String variable
            String option = rightColumn.findElement(By.xpath(path)).getText();
            // Locate an element in the web page with the specified ID and assign it to a WebElement variable
            WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
            // Instantiate a new Select object with the dropdown WebElement variable
            Select selectOptions = new Select(dropdown);
            // Select the option with the specified visible text in the dropdown list
            selectOptions.selectByVisibleText(option);
            // Find the input element with the name attribute "enter-name" and enter the value of the option variable
            driver.findElement(By.name("enter-name")).sendKeys(option);
            // Find the element with the specified ID and click on it
            driver.findElement(By.id("alertbtn")).click();
            // Switch to the alert pop-up window and get its text
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            // Check if the text of the alert contains the value of the option variable and print the corresponding message
            if (text.contains(option)) {
                System.out.println("Alert message success");
            } else {
                System.out.println("Something wrong with execution");
            }
            // Accept the alert
            alert.accept();
            // Click on the input element inside the current label element to uncheck it
            rightColumn.findElement(By.xpath(path + "/input")).click();

        }

    }
}
