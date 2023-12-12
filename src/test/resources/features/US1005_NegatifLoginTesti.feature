Feature: US1005 Kullanici yanlis bilgilerle giris yapamaz


  Scenario: TC09 Kullanici gecerliEmail ve gecersizPassword ile giris yapamamali

    Given kullanici testotomasyonu anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecersizPassword" girer
    Then signIn butonuna basar
    And sisteme giris yapamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir


  Scenario: TC10 Kullanici gecersizEmail ve gecerliPassword ile giris yapamamali

    Given kullanici testotomasyonu anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecersizEmail" girer
    And password olarak "toGecerliPassword" girer
    Then signIn butonuna basar
    And sisteme giris yapamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir


  Scenario: TC11 Kullanici gecersizEmail ve gecersizPassword ile giris yapamamali

    Given kullanici testotomasyonu anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecersizEmail" girer
    And password olarak "toGecersizPassword" girer
    Then signIn butonuna basar
    And sisteme giris yapamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir