package dao;

import db.DBConnection;
import model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    // Add a new message to a ticket
    public void addMessage(Message message) {
        String sql = "INSERT INTO MESSAGE (ticket_id, sender_id, sender_type, message_text, sent_at) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, message.getTicketId());
            stmt.setInt(2, message.getSenderId());
            stmt.setString(3, message.getSenderType().name());
            stmt.setString(4, message.getMessageText());
            stmt.setTimestamp(5, message.getSentAt());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Message added to ticket.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all messages in a ticket
    public List<Message> getMessagesByTicketId(int ticketId) {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM MESSAGE WHERE ticket_id = ? ORDER BY sent_at ASC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticketId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Message message = new Message(
                        rs.getInt("message_id"),
                        rs.getInt("ticket_id"),
                        rs.getInt("sender_id"),
                        Message.SenderType.valueOf(rs.getString("sender_type")),
                        rs.getString("message_text"),
                        rs.getTimestamp("sent_at")
                );
                messages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }
}
