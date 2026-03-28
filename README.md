# Spring Boot JWT Authentication

## Features
- Login with username/password
- JWT token generation
- Stateless authentication
- Protected APIs

## Tech Stack
- Spring Boot
- Spring Security
- JWT (jjwt)
- MySQL DB

## How to Run

1. Clone project
2. Run application
3. Use Postman

## API Endpoints

### Login
POST /auth/login

{
  "username": "user",
  "password": "password"
}

### Protected API
GET /api/test

Header:
Authorization: Bearer <TOKEN>

## Flow
1. User logs in
2. JWT generated
3. Client sends token
4. Filter validates token
5. Access granted
