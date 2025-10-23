# 🚀 GroupChat

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Frontend: React](https://img.shields.io/badge/Frontend-React-blue?logo=react)](https://reactjs.org/)
[![Backend: Spring Boot](https://img.shields.io/badge/Backend-SpringBoot-brightgreen?logo=spring)](https://spring.io/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue?logo=mysql)](https://www.mysql.com/)

**GroupChat** is a modern, real-time full-stack chat application for instant group messaging. It is built with **Spring Boot (Java)** for a robust backend and **React.js** for a dynamic frontend.

---

## ✨ Features

- **Real-time Messaging:** Messages instantly broadcasted to all users via **WebSockets**  
- **Authentication:** Secure registration and login for users  
- **Responsive Design:** Works perfectly on desktop, tablet, and mobile  
- **Clean Architecture:** Modular backend and frontend structure for easy maintenance  
- **Quick Setup:** Run locally in minutes  

---

## 💻 Tech Stack

### Frontend
- React.js  
- HTML, CSS, JavaScript  

### Backend
- Java, Spring Boot  
- WebSocket for real-time communication  
- MySQL database for storing users and messages  

### Tools
- Git & GitHub  
- Maven (backend dependencies)  
- Node.js & npm (frontend dependencies)  

---

## 🚀 Installation & Run (All-in-One)

```bash
# Backend
cd backend
mvn clean install
mvn spring-boot:run
# Make sure your MySQL database is running and configured in application.properties

# Frontend
cd ../frontend
npm install
npm start
# The app will run at http://localhost:3000
````

---

## 📖 Usage

1. Open the app at [http://localhost:3000](http://localhost:3000)
2. Register a new account or log in with existing credentials
3. Start chatting! Messages are instantly sent and received via WebSockets

---

## 📂 Project Structure

```
ChatApp/
├── backend/   # Spring Boot backend, REST API, WebSocket server
└── frontend/  # React frontend, UI components, WebSocket client
```

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/AmazingFeature`
3. Commit your changes: `git commit -m 'Add AmazingFeature'`
4. Push to your branch: `git push origin feature/AmazingFeature`
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## ✉️ Contact

**Dayanand Raut**

* Email: [dayanand333@gmail.com](mailto:dayanand333@gmail.com)
* GitHub: [https://github.com/RautDayanand](https://github.com/RautDayanand)

---

Made with ❤️ and ☕


