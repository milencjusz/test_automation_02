import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Exercise01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        WebElement rightColumn = driver.findElement(By.id("checkbox-example"));

        for (int i = 1; i <= rightColumn.findElements(By.tagName("label")).size(); i++) {
            String path = "//*[@id='checkbox-example']/fieldset/label[" + i + "]";
            rightColumn.findElement(By.xpath(path + "/input")).click();
            String option = rightColumn.findElement(By.xpath(path)).getText();
            WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
            Select selectOptions = new Select(dropdown);
            selectOptions.selectByVisibleText(option);
            driver.findElement(By.name("enter-name")).sendKeys(option);
            driver.findElement(By.id("alertbtn")).click();
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();

            if (text.contains(option)) {
                System.out.println("Alert message success");
            } else {
                System.out.println("Something wrong with execution");
            }
            alert.accept();
            rightColumn.findElement(By.xpath(path + "/input")).click();

        }

    }
}
