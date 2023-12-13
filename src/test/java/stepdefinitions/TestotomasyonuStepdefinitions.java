package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestotomasyonuStepdefinitions {
    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
    Sheet sayfa2;
    int actualStokMiktari;

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
    @Then("arama kutusuna phone yazip ENTER tusuna basar")
    public void arama_kutusuna_phone_yazip_enter_tusuna_basar() {
       testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
       Driver.closeDriver();
    }

    @And("arama sonucunda urun bulunabildigini test eder")
    public void aramaSonucundaUrunBulunabildiginiTestEder() {
        int sonucSayisi= testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(sonucSayisi>0);
    }

    @And("biraz bekler")
    public void birazBekler() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("arama kutusuna shoes yazip ENTER tusuna basar")
    public void aramaKutusunaShoesYazipENTERTusunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("shoes" + Keys.ENTER);
    }

    @Then("arama kutusuna nutella yazip ENTER tusuna basar")
    public void aramaKutusunaNutellaYazipENTERTusunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);
    }

    @And("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {
        int sonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertEquals(0,sonucSayisi);
    }

    @Then("arama kutusuna {string} yazip ENTER tusuna basar")
    public void aramaKutusunaYazipENTERTusunaBasar(String istenenUrun) {

        testOtomasyonuPage.aramaKutusu.sendKeys(istenenUrun + Keys.ENTER);
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String gidilecekUrl) {
        // gidilecekUrl : gitmek istedigimiz sayfanin configuration.properties'deki ismi

        Driver.getDriver().get(ConfigReader.getProperty(gidilecekUrl));

    }

    @Then("account butonuna basar")
    public void account_butonuna_basar() {
        testOtomasyonuPage.accountLinki.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String emailTuru) {
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty(emailTuru));
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String passwordTuru) {
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty(passwordTuru));
    }
    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testOtomasyonuPage.loginButonu.click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.logoutLinki.isDisplayed());
    }

    @And("sisteme giris yapamadigini test eder")
    public void sistemeGirisYapamadiginiTestEder() {
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
    }

    @When("email olarak listede verilen {string} girer")
    public void emailOlarakListedeVerilenGirer(String verilenEmail) {
        testOtomasyonuPage.emailKutusu.sendKeys(verilenEmail);
    }

    @And("password olarak listede verilen {string} girer")
    public void passwordOlarakListedeVerilenGirer(String verilenPassword) {
        testOtomasyonuPage.passwordKutusu.sendKeys(verilenPassword);
    }

    @Then("stok excelindeki {string} daki urunun stok miktarini bulur")
    public void stokExcelindekiDakiUrununStokMiktariniBulur(String satirNo) {
        // excel'de istenen satira gidip
        // satirdaki urun ismini aldik
        // ve aldigimiz urun ismini testotomasyonu.com'da aratip
        // actual stok sayisini kaydettik

        String dosyaYolu = "src/test/resources/stok.xlsx";
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = new XSSFWorkbook(fileInputStream) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sayfa2 = workbook.getSheet("Sayfa2");
        String satirdakiUrunIsmi = sayfa2.getRow(Integer.parseInt(satirNo)-1) .getCell(0).toString();

        testOtomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi+ Keys.ENTER);
        actualStokMiktari = testOtomasyonuPage.bulunanUrunElementleriList.size();
    }

    @And("stok miktarinin {string} da verilen stok miktarindan fazla oldugunu test eder")
    public void stokMiktarininDaVerilenStokMiktarindanFazlaOldugunuTestEder(String verilenSatir) {
        // yine istenen satira gidip
        // o satirda belirlenen min stok miktarini aldik
        // ve bir onceki adimda buldugumuz actualStokMiktari ile karsilastirip
        // testimizi yaptik

        String dosyaYolu = "src/test/resources/stok.xlsx";
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = new XSSFWorkbook(fileInputStream) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sayfa2 = workbook.getSheet("Sayfa2");

        String minStokMiktariStr = sayfa2
                                     .getRow(Integer.parseInt(verilenSatir)-1)
                                     .getCell(1).toString();
        System.out.println(minStokMiktariStr);
        int minStokMiktari = (int) Double.parseDouble(minStokMiktariStr);

        Assert.assertTrue(actualStokMiktari >= minStokMiktari);


    }
}
