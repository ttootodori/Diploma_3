# UI Tests (Selenium + API)

## Description
UI automation with data preparation via API.  
Shows how to combine API and UI in E2E testing.

## Tech Stack
- Java
- JUnit 4
- Selenium WebDriver
- Rest Assured (data preparation)
- Allure (reporting)

## What was done
**Total: 9 UI tests**

**Constructor (3 tests)**  
- Validating constructor buttons

**Login (4 tests)**  
- Positive and negative scenarios

**User Creation (2 tests)**  
- User created via API  
- Validated via UI  
- Cleaned up via API

## Architecture
- **Page Object** — page interaction
- **Client** — API client for test data
- **Steps** — reusable steps

## How to run
```bash
mvn clean test
```
Allure report
```bash
mvn allure:serve
```

# UI автотесты (Selenium + API)

## Описание
UI-автотесты с подготовкой данных через API.  
Показывает, как совмещать API и UI в E2E-тестировании.

## Стек
- Java
- JUnit 4
- Selenium WebDriver
- Rest Assured (подготовка данных)
- Allure (отчёты)

## Что сделано
**Всего: 9 UI-тестов**

**Конструктор (3 теста)**  
- Проверка работы кнопок конструктора

**Логин (4 теста)**  
- Позитивные и негативные сценарии

**Создание пользователя (2 теста)**  
- Пользователь создаётся через API  
- Проверяется через UI  
- Удаляется через API

## Архитектура
- **Page Object** — работа со страницами
- **Client** — API-клиент для подготовки данных
- **Steps** — переиспользуемые шаги

## Как запустить
```bash
mvn clean test
```
## Allure отчёт 
```bash
mvn allure:serve
```
