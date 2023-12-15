Feature: US1002 Kullanici parametre ile verdigi urunu aratabilmeli
  @P2
  Scenario: TC04 Kullanici java arattiginda sonuc bulamamali

    Given kullanici testotomasyonu anasayfaya gider
    Then arama kutusuna "java" yazip ENTER tusuna basar
    And arama sonucunda urun bulunamadigini test eder
    And 3 saniye bekler
    Then sayfayi kapatir
  @P1
  Scenario: TC05 Kullanici samsung arattiginda sonuc bulamamali

    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "cucumber" yazip ENTER tusuna basar
    And arama sonucunda urun bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir

