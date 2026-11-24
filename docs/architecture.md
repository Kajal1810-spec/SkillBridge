# Architecture

React/Vite client -> REST/JSON -> Spring Boot API -> Spring Data JPA -> H2 (dev) / MySQL (configured).

The included frontend demo currently uses localStorage so it can be demonstrated before the API is connected. The backend independently exposes `/api/services`, `/api/orders`, and `/api/health`.

Production hardening required: authentication/authorization, password hashing, CORS allowlist, payment gateway integration, object storage for portfolio uploads, observability, backups, HTTPS and secrets manager.
