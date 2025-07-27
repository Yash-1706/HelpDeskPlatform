package dao;

import db.DBConnection;
import model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    public void addFeedback(Feedback feedback) {
        String sql = "INSERT INTO FEEDBACK (ticket_id, customer_id, rating, comments, submitted_at) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, feedback.getTicketId());
            stmt.setInt(2, feedback.getCustomerId());
            stmt.setInt(3, feedback.getRating());
            stmt.setString(4, feedback.getComments());
            stmt.setTimestamp(5, feedback.getSubmittedAt());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Feedback submitted!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM FEEDBACK ORDER BY submitted_at DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                feedbacks.add(new Feedback(
                        rs.getInt("feedback_id"),
                        rs.getInt("ticket_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("rating"),
                        rs.getString("comments"),
                        rs.getTimestamp("submitted_at")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedbacks;
    }
}
