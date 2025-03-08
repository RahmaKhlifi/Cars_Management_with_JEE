# Cars Management with JEE

A web application for managing car inventory using Java Enterprise Edition (JEE) technologies. This project demonstrates CRUD operations, user authentication, and dynamic UI rendering with JSP and Servlets.


## Features

- **User Authentication**: Secure login/logout functionality.
- **Car Management**: 
  - Add new cars with details (model, brand, year, color, price, etc.).
  - Update existing car information.
  - Delete cars from the inventory.
  - View all cars in a responsive table.
- **Search & Filter**: Search cars by model, brand, or other attributes.
- **Pagination**: Navigate through car listings with paginated results.
- **Responsive UI**: Built with Bootstrap for a mobile-friendly experience.

## Technologies Used

- **Backend**: Java EE (Servlets, JSP, JDBC)
- **Database**: MySQL
- **Frontend**: HTML, CSS, JavaScript, Bootstrap
- **Server**: Apache Tomcat
- **Build Tool**: Maven (optional)

## Installation

### 1. Clone the Repository:
```bash
git clone https://github.com/RahmaKhlifi/Cars_Management_with_JEE.git
```

### 2. Import the Project:
Open Eclipse/IntelliJ and import as a Maven or Dynamic Web Project.

### 3. Database Setup:
- Install MySQL and create a database named `car_management`.
- Run the SQL script located in `src/main/resources/database.sql` to create tables and sample data.

### 4. Configure Database Connection:
Update the database credentials in `src/main/java/utils/DBUtil.java` (or in `context.xml` for JNDI).

### 5. Deploy on Tomcat:
- Configure Apache Tomcat in your IDE.
- Deploy the project and start the server.

### 6. Access the Application:
Visit `http://localhost:8080/Cars_Management_with_JEE/login.jsp`.

## Usage

### Login:
Use the credentials (default: `admin/admin`) or register a new user if applicable.

### Dashboard:
- View all cars in a paginated table.
- Use the search bar to filter results.

### Add a New Car:
Click **"Add Car"** and fill in the form.

### Edit/Delete Cars:
Click the **"Edit"** or **"Delete"** buttons in the car table.

### Logout:
Click the **"Logout"** link to end the session.

## API Endpoints

| Endpoint        | Method | Description                  |
|----------------|--------|------------------------------|
| `/login`       | POST   | Authenticate user            |
| `/logout`      | GET    | Invalidate session           |
| `/cars`        | GET    | Retrieve all cars (paginated)|
| `/cars`        | POST   | Add a new car                |
| `/cars/delete` | POST   | Delete a car by ID           |
| `/cars/update` | POST   | Update a car by ID           |

## Contributing

Contributions are welcome! Follow these steps:

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your message"
   ```
4. Push to the branch:
   ```bash
   git push origin feature/your-feature
   ```
5. Submit a pull request.

Please report bugs or suggest enhancements via GitHub Issues.

## License

This project is licensed under the MIT License. See `LICENSE` for details.

## Contact

**Author:** Rahma Khlifi  
**GitHub:** [RahmaKhlifi](https://github.com/RahmaKhlifi)  
**Email:** rahma.khlifi08@gmail.com <!-- Add your email if desired -->
