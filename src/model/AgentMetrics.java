package model;

import java.sql.Timestamp;

public class AgentMetrics {
    private int agentId;
    private int totalTicketsResolved;
    private double resolutionRate;
    private int avgHandlingTime;
    private Timestamp lastUpdated;

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public int getTotalTicketsResolved() { return totalTicketsResolved; }
    public void setTotalTicketsResolved(int totalTicketsResolved) { this.totalTicketsResolved = totalTicketsResolved; }

    public double getResolutionRate() { return resolutionRate; }
    public void setResolutionRate(double resolutionRate) { this.resolutionRate = resolutionRate; }

    public int getAvgHandlingTime() { return avgHandlingTime; }
    public void setAvgHandlingTime(int avgHandlingTime) { this.avgHandlingTime = avgHandlingTime; }

    public Timestamp getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Timestamp lastUpdated) { this.lastUpdated = lastUpdated; }
}
