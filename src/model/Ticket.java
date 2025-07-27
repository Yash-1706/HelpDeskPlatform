package model;

import java.sql.Timestamp;

public class Ticket {
    private int ticketId;
    private int customerId;
    private int categoryId;
    private int agentId;
    private Priority priority;
    private String title;
    private String description;
    private Status status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp assignedAt;
    private Timestamp resolvedAt;
    private Timestamp closedAt;

    public enum Priority {
        low, medium, high, urgent
    }

    public enum Status {
        open, in_progress, resolved, closed
    }

    public Ticket(int ticketId, int customerId, int categoryId, int agentId,
                  Priority priority, String title, String description, Status status,
                  Timestamp createdAt, Timestamp updatedAt, Timestamp assignedAt,
                  Timestamp resolvedAt, Timestamp closedAt) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.categoryId = categoryId;
        this.agentId = agentId;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.assignedAt = assignedAt;
        this.resolvedAt = resolvedAt;
        this.closedAt = closedAt;
    }

    // Getters and setters for all fields

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    public Timestamp getAssignedAt() { return assignedAt; }
    public void setAssignedAt(Timestamp assignedAt) { this.assignedAt = assignedAt; }

    public Timestamp getResolvedAt() { return resolvedAt; }
    public void setResolvedAt(Timestamp resolvedAt) { this.resolvedAt = resolvedAt; }

    public Timestamp getClosedAt() { return closedAt; }
    public void setClosedAt(Timestamp closedAt) { this.closedAt = closedAt; }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", customerId=" + customerId +
                ", categoryId=" + categoryId +
                ", agentId=" + agentId +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", assignedAt=" + assignedAt +
                ", resolvedAt=" + resolvedAt +
                ", closedAt=" + closedAt +
                '}';
    }
}
