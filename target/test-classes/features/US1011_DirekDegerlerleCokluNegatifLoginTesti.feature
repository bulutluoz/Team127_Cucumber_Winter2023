Feature: US1011 scenario'da verilen yanlis bilgilerle negatif login testi

  @P2
  Scenario Outline: TC17 liste olarak verilen yanlis kullanici bilgileri ile giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email olarak listede verilen "<verilenEmail>" girer
    And password olarak listede verilen "<verilenPassword>" girer
    Then signIn butonuna basar
    And sisteme giris yapamadigini test eder
    And 1 saniye bekler
    Then sayfayi kapatir

    Examples:
      |verilenEmail    |verilenPassword    |
      |esra@fmail.com  |1234555            |
      |gamze@gmail.com |mesela123          |
      |zehra@zmail.com |asdf4321           |
      |ayca@amail.com  |6543241tre65       |
      |gulnur@gmail.com|123ert678          |
