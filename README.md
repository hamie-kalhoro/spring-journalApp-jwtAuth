**🗂️ Spring Journal App + JWT Auth**
<br>
  Spring Journal App is a minimalistic and secure journal management backend built using Spring Boot.
  It features JWT-based stateless authentication and Spring Security for role-based authorization.
  Ideal for building secure RESTful services and learning clean architecture with Spring.

---

**🚀 Features**
<br>
  🔐 JWT Auth — Secbrure login & role-based access with Spring Security
  
  📓 Journal CRUD — Create, view, edit & delete your journal entries
  
  🌐 RESTful API — Lightweight and stateless endpoints
  
  🐳 Docker Support — Container-ready deployment

---

**🏗️ Tech Stack**
<br>
  ☕ Spring Boot 3
  
  🔒 Spring Security + JWT
  
  🛢️ H2 / PostgreSQL (flexible setup)
  
  🧪 JUnit & Mockito (testing support)
  
  🐳 Docker (for containerization)

---

**🔐 Auth Flow**
<br>
  👤 User logs in with credentials
  
  🪙 JWT token is returned
  
  🔐 All secure endpoints require Authorization: Bearer <token>
  
  🔄 Stateless, token-based access — no sessions stored on server

---

**🧭 API Overview**
<br>
  Method	Endpoint	Description
  POST	/auth/login	🔐 Login + Get JWT
  POST	/auth/register	🧾 Register User
  GET	/api/journals	📓 Get all journals
  POST	/api/journals	➕ Create journal entry
  PUT	/api/journals/{id}	✏️ Edit journal entry
  DELETE	/api/journals/{id}	❌ Delete journal entry

---

**🛠️ Getting Started**
<br>
  ✅ Clone + Build
  bash
  Copy
  Edit
  git clone https://github.com/hamie-kalhoro/spring-journalApp-jwtAuth.git
  cd spring-journalApp-jwtAuth
  mvn clean install
  mvn spring-boot:run
  🔗 Visit: http://localhost:8080

---

**🐳 Run with Docker**
<br>
  bash
  Copy
  Edit
  docker build -t spring-journal-app .
  docker run -p 8080:8080 spring-journal-app

---

**📁 Structure Highlights**
<br>
  AuthController, JwtService → 🔐 Handles authentication and token issuance
  
  JournalController, JournalService → 📓 Business logic for journals
  
  SecurityConfig → 🛡️ Sets up Spring Security and filters
  
  JWTFilter, TokenUtil → 🪙 Handles token validation and parsing

---

**📜 License**
<br>
  MIT License — free to use and contribute 🤝
  PRs and forks are always welcome!
