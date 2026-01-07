# Electricity Billing System (Java + JDBC)

## 📌 Description
A Java-based Electricity Billing System that calculates electricity charges based on units consumed and stores billing details in a MySQL database using JDBC.

## 🛠️ Technologies Used
- Java
- JDBC
- MySQL
- Scanner (for user input)

## ✨ Features
- Calculates bill based on unit slabs
- Stores consumer details and bill amount in database
- Uses PreparedStatement for secure DB operations

## 📊 Billing Logic
- Up to 100 units → ₹1.5/unit  
- 101–300 units → ₹2.5/unit  
- Above 300 units → ₹4.0/unit  

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
