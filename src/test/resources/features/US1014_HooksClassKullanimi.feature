Feature: US1014 Scenario failed oldugunda fotograf cekilmeli

  @wip
  Scenario: TC20 kullanici testotomasyonu sayfasinda Nutella bulabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "nutella" yazip ENTER tusuna basar
    And arama sonucunda urun bulunamadigini test eder
    And sayfayi kapatir

