package model;

import java.sql.Timestamp;

public class Feedback {
    private int feedbackId;
    private int ticketId;
    private int customerId;
    private int agentId;
    private int rating;
    private String comments;
    private Timestamp submittedAt;

    public int getFeedbackId() { return feedbackId; }
    public void setFeedbackId(int feedbackId) { this.feedbackId = feedbackId; }

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public Timestamp getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(Timestamp submittedAt) { this.submittedAt = submittedAt; }
}
