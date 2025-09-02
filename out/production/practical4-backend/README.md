# Practical 4 - Full-Stack Application

**Course:** IX608001 Intermediate Application Development Concepts  
**Institution:** Otago Polytechnic Auckland International Campus  
**Student:** [Your Name Here]  
**Due Date:** Tuesday 2nd September 8:30am

## Project Overview

This is a full-stack web application built with Spring Boot (backend) and React (frontend) that manages Products and Attendants with complete CRUD operations.

## Technologies Used

### Backend
- **Framework:** Spring Boot 3.1.0
- **Database:** H2 In-Memory Database
- **ORM:** JPA/Hibernate
- **Build Tool:** Maven
- **Java Version:** 17

### Frontend
- **Framework:** React 18.2.0
- **Routing:** React Router DOM
- **HTTP Client:** Axios
- **Styling:** CSS3

## Features

✅ **Product Management**
- Add new products with name, price, category, stock, and description
- View all products in a table format
- Update existing product information
- Delete products with confirmation

✅ **Attendant Management**
- Add new attendants with name, address, mobile, email, and comments
- View all attendants in a table format
- Update existing attendant information
- Delete attendants with confirmation

✅ **Additional Features**
- Responsive design that works on desktop and mobile
- Real-time data updates
- Form validation and error handling
- Success/error message notifications
- Sample data preloaded for testing

## Project Structure

```
practical4-project/
├── backend/                          # Spring Boot Backend
│   ├── src/main/java/com/otago/practical4backend/
│   │   ├── Practical4BackendApplication.java
│   │   ├── config/DataLoader.java
│   │   ├── controller/
│   │   │   ├── ProductController.java
│   │   │   └── AttendantController.java
│   │   ├── model/
│   │   │   ├── Product.java
│   │   │   └── Attendant.java
│   │   ├── repository/
│   │   │   ├── ProductRepository.java
│   │   │   └── AttendantRepository.java
│   │   └── service/
│   │       ├── ProductService.java
│   │       └── AttendantService.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── frontend/                         # React Frontend
│   ├── public/
│   │   └── index.html
│   ├── src/
│   │   ├── components/
│   │   │   ├── HomePage.js
│   │   │   ├── ProductPage.js
│   │   │   └── AttendantPage.js
│   │   ├── services/
│   │   │   └── apiService.js
│   │   ├── App.js
│   │   ├── App.css
│   │   ├── index.js
│   │   └── index.css
│   └── package.json
└── README.md
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Node.js 16+ and npm
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Backend Setup (Spring Boot)

1. **Create Spring Boot Project:**
   - Go to https://start.spring.io/
   - Choose: Maven, Java 17, Spring Boot 3.1.0
   - Add dependencies: Spring Web, Spring Data JPA, H2 Database
   - Download and extract

2. **Project Configuration:**
   ```bash
   cd practical4-backend
   ```

3. **Copy the provided files:**
   - Copy all Java files to their respective packages
   - Copy `application.properties` to `src/main/resources/`
   - Copy `pom.xml` to root directory

4. **Build and Run:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Verify Backend:**
   - Backend runs on: http://localhost:8080/practical4-backend
   - H2 Console: http://localhost:8080/practical4-backend/h2-console
   - API Endpoints:
     - GET http://localhost:8080/practical4-backend/api/products
     - GET http://localhost:8080/practical4-backend/api/attendants

### Frontend Setup (React)

1. **Create React App:**
   ```bash
   npx create-react-app practical4-frontend
   cd practical4-frontend
   ```

2. **Install Dependencies:**
   ```bash
   npm install react-router-dom axios
   ```

3. **Copy provided files:**
   - Replace `src/App.js`, `src/App.css`, `src/index.js`, `src/index.css`
   - Copy all component files to `src/components/`
   - Copy `src/services/apiService.js`
   - Replace `public/index.html`
   - Replace `package.json`

4. **Create Directory Structure:**
   ```bash
   mkdir src/components
   mkdir src/services
   ```

5. **Start Development Server:**
   ```bash
   npm start
   ```

6. **Verify Frontend:**
   - Frontend runs on: http://localhost:3000
   - Should display the home page with navigation

### Running Both Applications

1. **Start Backend first:**
   ```bash
   cd practical4-backend
   mvn spring-boot:run
   ```

2. **Start Frontend in a new terminal:**
   ```bash
   cd practical4-frontend
   npm start
   ```

3. **Access the Application:**
   - Open browser to http://localhost:3000
   - Navigate between Home, Products, and Attendants pages
   - Test CRUD operations on both entities

## API Endpoints

### Product Endpoints
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### Attendant Endpoints
- `GET /api/attendants` - Get all attendants
- `GET /api/attendants/{id}` - Get attendant by ID
- `POST /api/attendants` - Create new attendant
- `PUT /api/attendants/{id}` - Update attendant
- `DELETE /api/attendants/{id}` - Delete attendant

## Sample Data

The application automatically loads sample data on startup:

### Products
1. Dell XPS 13 Laptop - $1299.99 (Electronics)
2. Breville Espresso Machine - $299.50 (Appliances)
3. Java Programming Guide - $45.99 (Books)

### Attendants
1. John Smith - Queen Street, Auckland
2. Sarah Johnson - Ponsonby Road, Auckland
3. Michael Brown - K Road, Auckland

## Building for Production

### Backend WAR File
```bash
cd practical4-backend
mvn clean package
# WAR file will be in target/practical4-backend-0.0.1-SNAPSHOT.war
```

### Frontend Build
```bash
cd practical4-frontend
npm run build
# Build files will be in build/ directory
```

## Troubleshooting

### Common Issues

1. **CORS Errors:**
   - Ensure `@CrossOrigin(origins = "*")` is present in controllers
   - Check that frontend is calling the correct backend URL

2. **Database Connection:**
   - H2 console credentials: username=`sa`, password=`password`
   - JDBC URL: `jdbc:h2:mem:testdb`

3. **Port Conflicts:**
   - Backend: Change port in `application.properties`: `server.port=8081`
   - Frontend: Set PORT environment variable: `PORT=3001 npm start`

4. **API Connection Issues:**
   - Verify backend is running on port 8080
   - Check `apiService.js` base URL matches backend
   - Ensure no firewall blocking the ports

## Testing the Application

### Manual Testing Steps

1. **Test Product Management:**
   - Navigate to Products page
   - Add a new product with all fields
   - Edit an existing product
   - Delete a product (with confirmation)
   - Verify data persistence

2. **Test Attendant Management:**
   - Navigate to Attendants page
   - Add a new attendant
   - Edit attendant information
   - Delete an attendant (with confirmation)
   - Test email validation

3. **Test Navigation:**
   - Click between Home, Products, and Attendants
   - Verify responsive design on mobile
   - Test form validation and error messages

## Screenshots Required

Include screenshots of:
1. **Home Page** - Welcome page with navigation
2. **Products Page** - Product list and form
3. **Attendants Page** - Attendant list and form
4. **Add Product** - Form with new product data
5. **Edit Product** - Form in edit mode
6. **H2 Console** - Database tables with sample data
7. **API Response** - Browser/Postman showing API response

## Submission Requirements

### Files to Submit

1. **ZIP file containing:**
   ```
   practical4-project.zip
   ├── practical4-backend/          # Complete backend source
   │   ├── src/
   │   ├── target/
   │   │   └── practical4-backend-0.0.1-SNAPSHOT.war
   │   ├── pom.xml
   │   └── README-backend.md
   ├── practical4-frontend/         # Complete frontend source
   │   ├── src/
   │   ├── build/                   # Production build
   │   ├── package.json
   │   └── README-frontend.md
   └── README.md                    # Main documentation
   ```

2. **Documentation PDF/Word file:**
   - Project overview and architecture
   - Screenshots with explanations
   - Setup and running instructions
   - Testing results
   - Challenges faced and solutions

### Deployment WAR File

The WAR file can be deployed to:
- Apache Tomcat 10+
- Any Java servlet container
- Spring Boot embedded Tomcat (default)

## Design Patterns Used

1. **MVC (Model-View-Controller):**
   - Models: Product.java, Attendant.java
   - Views: React components
   - Controllers: ProductController.java, AttendantController.java

2. **Repository Pattern:**
   - ProductRepository, AttendantRepository
   - Abstracts data access layer

3. **Service Layer Pattern:**
   - ProductService, AttendantService
   - Business logic separation

4. **RESTful API Design:**
   - Standard HTTP methods (GET, POST, PUT, DELETE)
   - Resource-based URLs
   - JSON data exchange

## Learning Outcomes Achieved

✅ **Learning Outcome 1:** Apply design patterns and programming principles using software development best practices
- Implemented MVC, Repository, and Service patterns
- Used proper separation of concerns
- Applied SOLID principles

✅ **Learning Outcome 2:** Design and implement full-stack applications using industry relevant programming languages
- Created RESTful backend with Spring Boot (Java)
- Built interactive frontend with React (JavaScript)
- Integrated frontend and backend with HTTP APIs

## Future Enhancements

Possible improvements:
- User authentication and authorization
- Data validation with Bean Validation
- Pagination for large datasets
- Search and filtering functionality
- File upload for product images
- Export data to CSV/Excel
- Unit and integration tests
- Docker containerization
- PostgreSQL/MySQL database
- Deployment to cloud platforms

## Contact Information

**Student:** [Your Name]  
**Email:** [your.email@student.op.ac.nz]  
**Lecturer:** Tariq Khan  
**Course:** IX608001 Intermediate Application Development Concepts

---

*This project demonstrates full-stack development skills with modern Java and React technologies, implementing industry-standard patterns and practices for building scalable web applications.*
