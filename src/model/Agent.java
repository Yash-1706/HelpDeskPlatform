package model;

import java.sql.Timestamp;

public class Agent {
    private int agentId;
    private String name;
    private String email;
    private boolean isAvailable;
    private Timestamp createdAt;

    public Agent(int agentId, String name, String email, boolean isAvailable, Timestamp createdAt) {
        this.agentId = agentId;
        this.name = name;
        this.email = email;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
    }

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isAvailable=" + isAvailable +
                ", createdAt=" + createdAt +
                '}';
    }
}
