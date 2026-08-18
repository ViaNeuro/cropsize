# Корпоративный web-портал

Монорепозиторий содержит backend на Java 17 + Spring Boot, PostgreSQL и frontend на React. Портал предназначен для эксплуатации во внутренней локальной сети предприятия.

## Архитектура

- `backend/` — REST API Spring Boot: новости, подразделения, сотрудники, документы.
- `frontend/` — React/Vite SPA, потребляет REST API.
- `docker-compose.yml` — локальный запуск PostgreSQL, backend и frontend.

## REST API

Базовый путь: `http://localhost:8080/api`.

- `GET /health` — проверка доступности.
- `GET|POST /departments` — подразделения.
- `GET /employees?q=...`, `POST /employees` — справочник сотрудников.
- `GET|POST /announcements` — корпоративные новости.
- `GET /documents?category=...`, `POST /documents` — документы.

## Запуск через Docker Compose

```bash
docker compose up --build
```

После запуска:

- Frontend: http://localhost:5173
- Backend API: http://localhost:8080/api
- PostgreSQL: `localhost:5432`, база `corporate_portal`, пользователь `portal`, пароль `portal`.

## Локальный запуск для разработки

Backend:

```bash
cd backend
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/corporate_portal \
SPRING_DATASOURCE_USERNAME=portal \
SPRING_DATASOURCE_PASSWORD=portal \
mvn spring-boot:run
```

Frontend:

```bash
cd frontend
npm install
VITE_API_BASE_URL=http://localhost:8080/api npm run dev
```

## Тесты и сборка

```bash
mvn test
cd frontend && npm install && npm test && npm run build
```
