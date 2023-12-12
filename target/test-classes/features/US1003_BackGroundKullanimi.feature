

Feature: US1003 Kullanici bastaki ortak adimlari tek sefer yazabilmeli

  Background: baslangictaki ortak adimlar buraya yazilabilir
    Given kullanici "toUrl" anasayfaya gider


  Scenario: TC06 Kullanici java arattiginda sonuc bulamamali

    Then arama kutusuna "java" yazip ENTER tusuna basar
    And arama sonucunda urun bulunamadigini test eder
    And 3 saniye bekler
    Then sayfayi kapatir

  Scenario: TC07 Kullanici samsung arattiginda sonuc bulamamali

    Then arama kutusuna "cucumber" yazip ENTER tusuna basar
    And arama sonucunda urun bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir