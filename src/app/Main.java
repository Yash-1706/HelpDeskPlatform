package app;

import db.DBConnection;
import dao.CustomerDAO;
import model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ✅ Step 1: Test DB connection
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connected to MySQL successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
            return;
        }

        // ✅ Step 2: Initialize DAO
        CustomerDAO customerDAO = new CustomerDAO();

        // ✅ Step 3: Add a new customer
        Customer newCustomer = new Customer(
                0, // ID is auto-generated
                "Yash Gaikwad",
                "9999988888",
                "yash@example.com",
                new Timestamp(System.currentTimeMillis())
        );
        customerDAO.addCustomer(newCustomer);

        // ✅ Step 4: Fetch and print all customers
        List<Customer> customers = customerDAO.getAllCustomers();
        System.out.println("\n📋 List of customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
