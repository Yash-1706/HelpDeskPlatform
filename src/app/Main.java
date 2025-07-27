package app;

import db.DBConnection;
import dao.CustomerDAO;
import dao.TicketDAO;
import dao.MessageDAO;
import dao.FeedbackDAO;

import model.Customer;
import model.Ticket;
import model.Message;
import model.Feedback;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ✅ Step 1: Test DB connection
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connected to MySQL successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
            return;
        }

        // ✅ Step 2: Initialize DAOs
        CustomerDAO customerDAO = new CustomerDAO();
        TicketDAO ticketDAO = new TicketDAO();
        MessageDAO messageDAO = new MessageDAO();
        FeedbackDAO feedbackDAO = new FeedbackDAO();

        // ✅ Step 3: Get all customers
        List<Customer> customers = customerDAO.getAllCustomers();
        System.out.println("\n📋 List of customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }

        // ✅ Step 4: Avoid duplicate ticket
        String targetTitle = "App crashes on login";
        int customerId = 1; // 👈 If dynamic, extract based on name/email
        List<Ticket> existingTickets = ticketDAO.getAllTickets();
        Ticket matchedTicket = null;

        for (Ticket t : existingTickets) {
            if (t.getCustomerId() == customerId && t.getTitle().equalsIgnoreCase(targetTitle)) {
                matchedTicket = t;
                break;
            }
        }

        if (matchedTicket == null) {
            Ticket newTicket = new Ticket(
                    0,
                    customerId,
                    1, // category_id
                    1, // agent_id
                    Ticket.Priority.high,
                    targetTitle,
                    "User reports the app crashes immediately after login.",
                    Ticket.Status.open,
                    new Timestamp(System.currentTimeMillis()),
                    null, null, null, null
            );
            ticketDAO.createTicket(newTicket);
            System.out.println("✅ Ticket created successfully.");

            // Re-fetch the latest ticket
            existingTickets = ticketDAO.getAllTickets();
            matchedTicket = existingTickets.get(existingTickets.size() - 1);
        } else {
            System.out.println("ℹ️ Ticket already exists. Skipping creation.");
        }

        // ✅ Step 5: Display all tickets
        System.out.println("\n🎫 List of tickets:");
        for (Ticket t : existingTickets) {
            System.out.println(t);
        }

        // ✅ Step 6: Add messages if none exist
        int ticketId = matchedTicket.getTicketId();
        List<Message> existingMessages = messageDAO.getMessagesByTicketId(ticketId);

        if (existingMessages.isEmpty()) {
            Message msg1 = new Message(
                    0,
                    ticketId,
                    customerId,
                    Message.SenderType.CUSTOMER,
                    "Hello, I’m facing an issue with login.",
                    new Timestamp(System.currentTimeMillis())
            );
            messageDAO.addMessage(msg1);
            System.out.println("✅ Message from customer added to ticket.");

            Message msg2 = new Message(
                    0,
                    ticketId,
                    1, // agent_id
                    Message.SenderType.AGENT,
                    "Hi Yash, we’re looking into it!",
                    new Timestamp(System.currentTimeMillis())
            );
            messageDAO.addMessage(msg2);
            System.out.println("✅ Message from agent added to ticket.");
        } else {
            System.out.println("ℹ️ Messages already exist for this ticket. Skipping message creation.");
        }

        // ✅ Step 7: Show all messages in this ticket
        System.out.println("\n📨 Messages in ticket #" + ticketId + ":");
        List<Message> msgs = messageDAO.getMessagesByTicketId(ticketId);
        for (Message m : msgs) {
            System.out.println("[" + m.getSentAt() + "] " + m.getSenderType() + " (" + m.getSenderId() + "): " + m.getMessageText());
        }

        // ✅ Step 8: Submit feedback if not already submitted for this ticket
        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        boolean feedbackExists = feedbackList.stream().anyMatch(f -> f.getTicketId() == ticketId);

        if (!feedbackExists) {
            Feedback fb = new Feedback(
                    0,
                    ticketId,
                    customerId,
                    5,
                    "Excellent support. Fixed quickly!",
                    new Timestamp(System.currentTimeMillis())
            );
            feedbackDAO.addFeedback(fb);
            System.out.println("✅ Feedback submitted for ticket #" + ticketId);
        } else {
            System.out.println("ℹ️ Feedback already exists for this ticket. Skipping submission.");
        }

        // ✅ Step 9: Display all feedback
        System.out.println("\n🗣 All Feedback:");
        for (Feedback f : feedbackDAO.getAllFeedback()) {
            System.out.println(f);
        }
    }
}
