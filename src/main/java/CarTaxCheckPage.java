import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarTaxCheckPage {

    WebDriver driver;

    public CarTaxCheckPage(){
        System.setProperty("webdriver.chrome.driver", "./src/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.get("https://cartaxcheck.co.uk/");
    }

    public void closeDriver(){
        driver.quit();
    }

    public CarDetails checkCarDetailsMatching(String carString) {
        //String carString = "DN09HRM";
        driver.get("https://cartaxcheck.co.uk/");
        WebElement strRegistration = driver.findElement(By.id("vrm-input"));
        WebElement btnFreeCarCheck = driver.findElement(By.className("jsx-3655351943"));

        strRegistration.sendKeys(carString);
        //strRegistration.click();
        strRegistration.submit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement table = driver.findElements(By.className("jsx-3315683148")).get(1);
        List<WebElement> dls = table.findElements(By.className("jsx-3583247658"));

        CarDetails carDetails = new CarDetails();

        for(WebElement webElement : dls) {
            String text = webElement.findElement(By.tagName("dt")).getText();
            String value = webElement.findElement(By.tagName("dd")).getText();

            if(text.equals("Registration"))
                carDetails.registrationNumber = value;
            if(text.equals("Make"))
                carDetails.make = value;
            if(text.equals("Model"))
                carDetails.model = value;
            if(text.equals("Colour"))
                carDetails.colour = value;
            if(text.equals("Year"))
                carDetails.year = value;
        }

        //System.out.println(carDetails);

        return carDetails;
    }
}
