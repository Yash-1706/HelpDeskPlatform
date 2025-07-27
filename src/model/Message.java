package model;

import java.sql.Timestamp;

public class Message {
    public enum SenderType { AGENT, CUSTOMER }

    private int messageId;
    private int ticketId;
    private int senderId;
    private SenderType senderType;
    private String messageText;
    private Timestamp sentAt;

    public Message(int messageId, int ticketId, int senderId, SenderType senderType, String messageText, Timestamp sentAt) {
        this.messageId = messageId;
        this.ticketId = ticketId;
        this.senderId = senderId;
        this.senderType = senderType;
        this.messageText = messageText;
        this.sentAt = sentAt;
    }

    public int getMessageId() { return messageId; }
    public int getTicketId() { return ticketId; }
    public int getSenderId() { return senderId; }
    public SenderType getSenderType() { return senderType; }
    public String getMessageText() { return messageText; }
    public Timestamp getSentAt() { return sentAt; }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", ticketId=" + ticketId +
                ", senderId=" + senderId +
                ", senderType=" + senderType +
                ", messageText='" + messageText + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
