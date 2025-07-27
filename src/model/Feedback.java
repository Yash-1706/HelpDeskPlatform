package model;

import java.sql.Timestamp;

public class Feedback {
    private int feedbackId;
    private int ticketId;
    private int customerId;
    private int rating; // out of 5
    private String comments;
    private Timestamp submittedAt;

    public Feedback(int feedbackId, int ticketId, int customerId, int rating, String comments, Timestamp submittedAt) {
        this.feedbackId = feedbackId;
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.rating = rating;
        this.comments = comments;
        this.submittedAt = submittedAt;
    }

    public int getFeedbackId() { return feedbackId; }
    public int getTicketId() { return ticketId; }
    public int getCustomerId() { return customerId; }
    public int getRating() { return rating; }
    public String getComments() { return comments; }
    public Timestamp getSubmittedAt() { return submittedAt; }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", ticketId=" + ticketId +
                ", customerId=" + customerId +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", submittedAt=" + submittedAt +
                '}';
    }
}
