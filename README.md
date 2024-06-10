# ArabamCom Mobil app Proje

Bu projede, Appium, Android Studio ve App Inspector'ı kullanarak Arabam.com mobil uygulamasında örnek otomasyon testleri kurup çalıştırdım. TestNG kullanarak yazdığım bu projede iki ana test senaryosu bulunmaktadır:

Arabam.com APK'sini Sanal Cihaza Yükleme: Bu test, Arabam.com uygulamasının sanal cihaza başarıyla yüklenip kurulduğunu ve sonraki testler için sağlam bir temel sağlandığını gösterir ve onaylar.

Arabam.com Araç seçimi ve Filtreleme: Bu test, Arabam.com uygulamasında çeşitli kullanıcı işlemlerinin otomasyonunu göstermektedir:

Arabam.com uygulamasını açılır.
Ana sayfada "Araba" olarak araç tipi seçilir.
"Audi" modeli seçilir.
Seçeneklerde "Tümü"ne tıklanır.
Filtre seçeneğine tıklanır ve  Fiyat düşükten yükseğe sıralanır.
En ucuz aracın 200.000 Türk Lirası üzerinde olup olmadığını doğrulanır.
