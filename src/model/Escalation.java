package model;

import java.sql.Timestamp;

public class Escalation {
    private int escalationId;
    private int ticketId;
    private Timestamp escalatedOn;
    private String reason;

    public int getEscalationId() { return escalationId; }
    public void setEscalationId(int escalationId) { this.escalationId = escalationId; }

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public Timestamp getEscalatedOn() { return escalatedOn; }
    public void setEscalatedOn(Timestamp escalatedOn) { this.escalatedOn = escalatedOn; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
