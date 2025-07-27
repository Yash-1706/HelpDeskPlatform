CREATE DATABASE IF NOT EXISTS helpdesk;
USE helpdesk;

CREATE TABLE CUSTOMER (
                          customer_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          phone_number VARCHAR(20),
                          email VARCHAR(255) UNIQUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE AGENT (
                       agent_id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255),
                       email VARCHAR(255) UNIQUE,
                       is_available BOOLEAN DEFAULT TRUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE CATEGORY (
                          category_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100),
                          description TEXT
);
