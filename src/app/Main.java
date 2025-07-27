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

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        CustomerDAO customerDAO = new CustomerDAO();
        TicketDAO ticketDAO = new TicketDAO();
        MessageDAO messageDAO = new MessageDAO();
        FeedbackDAO feedbackDAO = new FeedbackDAO();

        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer c : customers) {
            System.out.println(c);
        }

        String targetTitle = "App crashes on login";
        int customerId = 1;
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
                    1,
                    1,
                    Ticket.Priority.high,
                    targetTitle,
                    "User reports the app crashes immediately after login.",
                    Ticket.Status.open,
                    new Timestamp(System.currentTimeMillis()),
                    null, null, null, null
            );
            ticketDAO.createTicket(newTicket);
            existingTickets = ticketDAO.getAllTickets();
            matchedTicket = existingTickets.get(existingTickets.size() - 1);
        }

        for (Ticket t : existingTickets) {
            System.out.println(t);
        }

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

            Message msg2 = new Message(
                    0,
                    ticketId,
                    1,
                    Message.SenderType.AGENT,
                    "Hi Yash, we’re looking into it!",
                    new Timestamp(System.currentTimeMillis())
            );
            messageDAO.addMessage(msg2);
        }

        List<Message> msgs = messageDAO.getMessagesByTicketId(ticketId);
        for (Message m : msgs) {
            System.out.println("[" + m.getSentAt() + "] " + m.getSenderType() + " (" + m.getSenderId() + "): " + m.getMessageText());
        }

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
        }

        List<Feedback> allFeedback = feedbackDAO.getAllFeedback();
        for (Feedback f : allFeedback) {
            System.out.println(f);
        }
    }
}
