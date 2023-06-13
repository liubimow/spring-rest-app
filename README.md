# Spring App
Простое Spring приложение на Kotlin, принимает JSON объект POST запросом и сохраняет в бд. Используется Kafka, PostgreSQL и Docker Compose

**Как запустить проект:**<summary>
Убедись, что у тебя установлены и настроены Kafka, PostgreSQL и Docker Compose. Для начала нужно запустить необходимые контейнеры из основного каталога командой `docker-compose up`.
Настроить файл application.yml (postgresql). Можно запускать:  `./gradlew bootRun`</summary>

**Endpoint**

endpoint для отправки POST-запроса в формате JSON: `/main/new`

*Пример запроса в формате JSON:*

```
{
    "name": "Andy",
    "message": "Hello"
}
```
