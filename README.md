# 🚀 IAC Community Ambassadors Onboarding Process

A Java project to automate the onboarding of community ambassadors, generate UTM tracking links, send welcome emails, and display ambassador performance dashboards. Built as part of the **GPI 2025 Internship Program** by **Cloud Counselage Pvt. Ltd.**
It is also Approach Full Stack Java Developement.

---

## 📌 Table of Contents

- [About the Project](#about-the-project)
- [Problem Statement](#problem-statement)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Architecture](#project-architecture)
- [Project Flow](#project-flow)
- [Project Flow Diagram](#project-flow-diagram)
- [Backend Modules](#backend-modules)
- [Frontend Modules](#frontend-modules)
- [Database Design](#database-design)
- [Tools Used](#tools-used)
- [Project Screenshots](#project-screenshots)
- [Challenges Faced](#challenges-faced)
- [How to Run Locally](#how-to-run-locally)
- [Project Status](#project-status)
- [Watch the Demo Video](#watch-the-demo-video)
- [License](#license)


---

## 📖 About the Project

The **IAC Community Ambassadors Onboarding Process** project is designed to streamline the ambassador onboarding workflow.  
Once ambassadors submit a form, they receive a **custom UTM tracking link** via email. Their performance is tracked using the link, and data is visualized through a **dashboard**.  
The project follows a full SDLC lifecycle including documentation, planning, development, testing, and reporting.

---

## 🎯 Problem Statement

Automate Onboarding ambassadors and tracking their contributions is time-consuming and inefficient.  
This project solves the problem by:

- Automating registration and UTM link generation
- Sending welcome emails instantly
- Tracking performance through each ambassador’s unique UTM
- Visualizing all data through a dashboard for admins

---

## ✅ Features

- REST API for registration and data fetch
- UTM link generation and email integration
- Login secured with Spring Security
- Dashboard for performance tracking
- Oracle DB integration with JPA
- Full project documentation (SRS, WBS, RAID log, etc.)

---

## 🛠️ Tech Stack

**Backend:**
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Maven
- Oracle 19c

**Frontend:**
- HTML
- CSS
- JavaScript

**Other:**
- Git & GitHub
- Gmail SMTP (for email notifications)
- Eclipse IDE

---

## 🧱 Project Architecture

- Frontend (HTML/CSS/JS) | REST API Calls | Spring Boot Application | Service Layer (UTM generation, Email, Business Logic) | Spring Data JPA | Oracle 19c Database

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

## 🖼️ Project Flow Diagram

![CA Flow Diagram](https://github.com/GugulRaj2001/IAC-Community-Ambassador-Onboarding-Process/blob/8fb7331eb9ee61de8eb677dd429503fc33dfef82/CA%20Project%20Flow%20Diagram.png)

---

## 🔁 Backend Modules

- `CommunityAmbassadorController.java` – handles HTTP endpoints
- `AmbassadorService.java` – business logic
- `AmbassadorRepository.java` – database operations
- `PerformanceService.java` – calculates and fetches signup data
- `EmailService.java` – Gmail SMTP integration
- `SecurityConfig.java` – Spring Security configuration

---

## 🎨 Frontend Modules

- `register.html` – ambassador form
- `dashboard.html` – signup tracking display
- `style.css` – responsive design styling
- `script.js` – AJAX & dynamic content rendering

---

## 🧩 Database Design

**Table: COMMUNITY_AMBASSADORS**
- `id` (Primary Key)
- `name`
- `email`
- `utm_link`
- `signups`
- `college_or_university`
- `address`
- `phone`

---

## 🧪 Tools Used

| Purpose              | Tool/Technology    |
|----------------------|--------------------|
| IDE                  | Eclipse IDE       |
| Version Control      | Git + GitHub        |
| Database             | Oracle 19c          |
| Email Notifications  | Gmail SMTP          |
| API Testing          | Postman + unittest  |
| Project Documents    | MS Word, Excel      |

---

## 🖼️ Project Screenshots

> *(Out put of Project and project Screenshorts)*

**Ambassador Login Form**

![Log-in Form](https://github.com/GugulRaj2001/IAC-Community-Ambassador-Onboarding-Process/blob/8fb7331eb9ee61de8eb677dd429503fc33dfef82/CA%20Login%20page.png)

**Ambassador Registration Form**

![Registration Form](https://github.com/GugulRaj2001/IAC-Community-Ambassador-Onboarding-Process/blob/8fb7331eb9ee61de8eb677dd429503fc33dfef82/CA%20Registertion%20Form.png)

**Performance Dashboard**

![Dashboard](https://github.com/GugulRaj2001/IAC-Community-Ambassador-Onboarding-Process/blob/8fb7331eb9ee61de8eb677dd429503fc33dfef82/CA%20dashboard.png)


**If you want More Clarity about 5th point go to this file:**

- 📌[View IAC Technical Summary](Project%20Documents/IAC%20Technical%20Summary.docx)

- 📌[Download IAC Technical Summary](https://github.com/GugulRaj2001/IAC-Community-Ambassador-Onboarding-Process/raw/main/Project%20Documents/IAC%20Technical%20Summary.docx)

---

## ⚠️ Challenges Faced

- **Oracle DB Setup:** Took time to configure and connect Spring Boot with Oracle.
- **Email SMTP:** Gmail SMTP required app password and multiple test cases.
- **UTM Logic:** Generating and linking unique UTM tracking was tricky.
- **Frontend-Backend Sync:** Ensuring form inputs and responses were properly mapped.
- **Deployment:** Environment-related errors during deployment attempts.

---

## 🖥️ How to Run Locally

1. Clone the repository  
   ```bash
   git clone https://github.com/GugulRaj2001/IAC-Community-Ambassador-Onboarding-Process.git
   cd IACCommunityAmbassadorOnboardingProcess

2. Set up Oracle DB and update credentials in application.properties

3. Generate Gmail App Password and update EmailService accordingly

4. Build and run the Spring Boot app

   - 📌 mvn spring-boot:run

5. Open **register.html** and **dashboard.html** from your browser to interact with UI.

---

## 📌 Project Status

- ✅ Completed

- 📦 Final deliverables submitted

- 📄 All documentation prepared

- 🚀 Ready for deployment

---

## 📃 License
- This project is for academic and internship learning purposes only. Not for commercial use.

---

## Watch the Demo Video ▶️
- Google Drive link : [(https://drive.google.com/file/d/1ryGsOM-176kfxamsQODi0Ycw6t-HjIXJ/view?usp=drive_link)](https://drive.google.com/file/d/1ryGsOM-176kfxamsQODi0Ycw6t-HjIXJ/view?usp=drive_link)
- Youtube link : [https://youtu.be/Fl_dOi07GPE](https://youtu.be/Fl_dOi07GPE)

## 💼 Developed By
- Guguloth Rajkumar

- Graduate in Civil Engineering | Full Stack Java Developer

- Cloud Counselage Pvt. Ltd. | GPI 2025 Intern

- Hyderabad, Telangana

- 📧 rajkumar173927@gmail.com | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rajkumar-guguloth/) | 📞 +91-9390494309




