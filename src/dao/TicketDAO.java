package dao;

import db.DBConnection;
import model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    // Create a new ticket
    public void createTicket(Ticket ticket) {
        String sql = "INSERT INTO TICKET (customer_id, category_id, agent_id, priority, title, description, status, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticket.getCustomerId());
            stmt.setInt(2, ticket.getCategoryId());
            stmt.setInt(3, ticket.getAgentId());
            stmt.setString(4, ticket.getPriority().name());
            stmt.setString(5, ticket.getTitle());
            stmt.setString(6, ticket.getDescription());
            stmt.setString(7, ticket.getStatus().name());
            stmt.setTimestamp(8, ticket.getCreatedAt());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Ticket created successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM TICKET";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ticket ticket = new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("category_id"),
                        rs.getInt("agent_id"),
                        Ticket.Priority.valueOf(rs.getString("priority")),
                        rs.getString("title"),
                        rs.getString("description"),
                        Ticket.Status.valueOf(rs.getString("status")),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getTimestamp("assigned_at"),
                        rs.getTimestamp("resolved_at"),
                        rs.getTimestamp("closed_at")
                );
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }
}
