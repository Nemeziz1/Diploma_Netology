### Инструкция подключения БД и включения SUT
1. C помощью команды `git clone` осуществить клонирование репозитория по ссылке `https://github.com/Nemeziz1/Diploma_Netology.git`.
2. Открыть склонированный проект в Intellij IDEA.
3. Для запуска контейнеров ввести в терминале Intellij IDEA команду `docker-compose up -d`.
4. Запустить SUT командой:
- `java -Dspring.datasource-mysql.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar` - на БД mysql.
- `java -Dspring.datasource-postgresql.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar` - на БД postgresql.

Запуск успешен при наличии в логах сообщений `Tomcat started on port(s): 8080 (http) with context path ''` и `Started ShopApplication in ... seconds (JVM running for ...)`

5. Войти в браузер `Google Chrome` и ввести ссылку `http://localhost:8080`.
6. При необходимости отключения SUT, находясь в терминале Intellij IDEA, нажать клавиши `CTRL+C`.
7. При необходимости отключения контейнеров ввести в терминале Intellij IDEA команду `docker-compose down`.