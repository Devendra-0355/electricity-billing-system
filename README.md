 # Electricity Billing System (Java + JDBC)

## 📌 Project Overview
This project is a Java-based Electricity Billing System that calculates electricity charges based on units consumed and stores the billing details in a MySQL database using JDBC.

## 🛠️ Technologies Used
- Java  
- JDBC  
- MySQL  
- Git & GitHub  

## ✨ Features
- Calculates electricity bill using slab-wise logic  
- Accepts consumer details (ID, name, units)  
- Stores bill data securely in MySQL database  
- Uses `PreparedStatement` to prevent SQL injection  

## ⚙️ Billing Logic
- Up to 100 units → ₹1.5 per unit  
- 101–300 units → ₹2.5 per unit  
- Above 300 units → ₹4.0 per unit  

## 🗄️ Database Setup
```sql
CREATE DATABASE electricity_db;
USE electricity_db;

CREATE TABLE bills (
    consumer_id INT,
    consumer_name VARCHAR(50),
    units INT,
    amount DOUBLE
);

