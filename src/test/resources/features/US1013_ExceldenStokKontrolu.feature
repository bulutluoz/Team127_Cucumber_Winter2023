Feature:


  Scenario:TC19 verilen stok excelinde verilen min.stok degerlerine gore liste olusturulabilir

    Given kullanici "toUrl" anasayfaya gider
    Then stok excelindeki tum urunleri artip, min stok miktarinda urun olanlari listeler
    And sayfayi kapatir