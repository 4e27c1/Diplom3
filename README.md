# Diplom_3

Для запуска тестов в яндекс браузере на локальной машине используется команда:  
mvn -Dwebdriver.chrome.driver=src/main/resources/chromedriver.exe -Dwebdriver.yandex.driver=src/main/resources/chromedriver114.exe -Dwebdriver.yandex.binary="C:\Program Files\Yandex\YandexBrowser\Application\browser.exe" -Dbrowser=yandex test

Для запуска тестов в яндекс браузере на другой машине нужно в этой команде прописать свои пути к исполняемому файлу яндекс браузера.  
Драйвера вынесены в ресурсы.   
Версия драйвера для хрома - 116  
Версия драйвера для яндекса  - 114  

