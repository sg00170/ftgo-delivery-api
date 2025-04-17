# 🚚 Delivery API Server Tutorial

Spring Boot 기반의 간단한 음식배달 API 서버입니다.  
JWT(Json Web Token)를 이용한 로그인 기능과 인증된 사용자 정보 조회 기능이 포함되어 있습니다.

---

## 🔧 기술 스택

- Java 17
- Spring Boot 3.4.x
- Spring Security
- JWT (JJWT)
- MySQL 8.x
- Liquibase
- Maven

---

## ✨ 주요 기능

- 회원가입 (`/api/v1/auth/sign-up`)
- 로그인 및 JWT 발급 (`/api/v1/auth/sign-in`)
- 로그인한 사용자 정보 조회 (`/api/v1/users/me`)
- 비밀번호 암호화 (BCrypt)
- JWT 기반 인증/인가
- Liquibase 기반 DB 마이그레이션

---

## 📁 프로젝트 구조