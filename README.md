# SkillBridge — Student Talent & Freelancing Marketplace

A polished MVP starter with:
- React + Vite frontend (demo mode works immediately with browser localStorage)
- Java 21 + Spring Boot REST API
- H2 development database and MySQL-ready configuration
- SQL schema, Dockerfiles, and setup instructions

## Quick start (frontend demo)
Requirements: Node.js 20+ and npm.

```bash
cd frontend
npm install
npm run dev
```
Open the local URL printed by Vite. The demo includes seeded users/services and supports browsing, search, category filters, sign-in demo, creating a service, and placing an order. Demo data is stored in localStorage.

Demo login:
- Student: `kajal@skillbridge.demo` / `demo123`
- Client: `client@skillbridge.demo` / `demo123`
- Admin: `admin@skillbridge.demo` / `demo123`

These are demo-only credentials. Do not use them in production.

## Run the Java backend
Requirements: JDK 21 and Maven 3.9+.

```bash
cd backend
mvn spring-boot:run
```
API base: `http://localhost:8080/api`
Health: `http://localhost:8080/api/health`
H2 console (development): `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:mem:skillbridge`, user `sa`, blank password.

The backend is a functional API starter with service and order endpoints. It uses H2 for easy local startup. MySQL settings are provided in `application-mysql.properties`; set `SPRING_PROFILES_ACTIVE=mysql` and configure environment variables before using it.

## Build frontend
```bash
cd frontend
npm run build
```

## Docker
Backend:
```bash
cd backend
docker build -t skillbridge-api .
docker run -p 8080:8080 skillbridge-api
```
Frontend:
```bash
cd frontend
docker build -t skillbridge-web .
docker run -p 8081:80 skillbridge-web
```

## Important project notes
- This is a college-project MVP, not a production payment platform.
- Checkout is a simulated demo flow. No real money is charged.
- Demo authentication uses localStorage on the frontend. Replace it with secure backend authentication (Spring Security, password hashing, JWT/session handling) before real deployment.
- Add authorization, validation, rate limiting, file upload scanning, audit logging, HTTPS, secrets management, backups, and payment gateway sandbox integration before production.
- Never commit real passwords, API keys, or payment credentials.
