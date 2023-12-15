package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
     cucumber'da testBase class yerine Hooks tercih edilir

     Burada dikkat etmemiz gereken konu
     diger framework'lerde TestBase kullanimi class'dan belirlenebiliyordu
     biz Testbase kullanmak istersek extends yapiyorduk,
     istemezsek TestBase kullanmadan class'i calistirabiliyorduk

     AMMA Cucumber'da boyle tercih imkani yok
     Cunku Runner class'da features klasoru ile stepdefinitions package'i ilisiklendirildi
     yani stepdefinitions package altindaki
     @Before ve @After method'lari tum scenario'lar icin calisacaktir

     Bundan dolayi biz sadece
     Scenario FAILED oldugunda calisacak
     fotografi cekip, rapora ekleyecek bir method olusturacagiz
     */

    @After
    public void tearDown(Scenario scenario){


        if (scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshots");
            Driver.closeDriver();
        }

    }

}
