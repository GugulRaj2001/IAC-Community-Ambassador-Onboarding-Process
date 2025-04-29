# 🌐 IAC Community Ambassador Onboarding System

A full-stack web application built with **Spring Boot**, **Oracle DB**, and **Vanilla JavaScript** for managing the onboarding and performance tracking of community ambassadors through a registration form and a performance dashboard.

---

## 📌 Features

- 📝 Registration form for new Community Ambassadors (name, email, phone, address, college)
- 🔗 Auto-generated UTM link for each registered ambassador
- 📊 Dashboard to track ambassador performance (signups via UTM link)
- 📬 Email confirmation after successful registration
- ✅ RESTful APIs for frontend-backend communication
- 🔐 Spring Security configured with form login and basic auth
- ☁️ CORS support for local frontend access
- 📁 Oracle Database Integration with JPA

---

## 📂 Tech Stack

| Layer        | Technology                   |
|--------------|------------------------------|
| Frontend     | HTML, CSS, JavaScript        |
| Backend      | Spring Boot (Java 17)        |
| Database     | Oracle 17c                   |
| Security     | Spring Security              |
| Build Tool   | Maven                        |
| Email        | Spring Boot Mail             |
| Hosting/Run  | Spring Tool Suite (STS IDE)  |

---

## 🚀 Project Flow

1. **User Registration**
   - Form data sent to `POST /api/cas/register`
   - UTM link generated and stored in Oracle DB
   - Email sent to user

2. **Dashboard**
   - On page load, fetches data from `GET /api/cas/performance`
   - Renders all ambassador records with clickable UTM links

3. **Spring Security**
   - Allows public access to registration and dashboard pages
   - Protects internal API routes

4. **Database**
   - Table: `Community_Ambassadors`
   - Fields: name, email, phone, utmLink, signups, address, college

---

# 🖼️ Project Flow Diagram


