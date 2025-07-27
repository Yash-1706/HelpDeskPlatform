# HelpDeskPlatform

HelpDeskPlatform is a Java-based application designed to manage customer support operations efficiently. It provides a structured way to handle tickets, agents, customers, feedback, and escalations, making it suitable for organizations looking to streamline their help desk processes.

## Features

- **Ticket Management:** Create, update, and track support tickets.
- **Agent Management:** Assign agents to tickets, track agent metrics, and manage agent categories.
- **Customer Management:** Store and manage customer information and their ticket history.
- **Feedback System:** Collect and analyze feedback from customers.
- **Escalation Handling:** Escalate tickets based on SLA or other criteria.
- **Database Integration:** Uses a relational database (schema provided in `resources/schema.sql`).

## Project Structure

```
HelpDeskPlatform.iml
resources/
    schema.sql           # Database schema
src/
    Main.java           # Main entry point
    app/
        Main.java       # Application logic
    dao/                # Data Access Objects
        CustomerDAO.java
        FeedbackDAO.java
        MessageDAO.java
        TicketDAO.java
    db/
        DBConnection.java # Database connection logic
    META-INF/
        MANIFEST.MF     # Manifest file for packaging
    model/              # Data models
        Agent.java
        AgentCategory.java
        AgentMetrics.java
        Category.java
        Customer.java
        Escalation.java
        Feedback.java
        Message.java
        SLA.java
        Ticket.java
        TicketHistory.java
```

## Getting Started

### Prerequisites

- Java 8 or higher
- A relational database (e.g., MySQL, PostgreSQL)
- Maven or your preferred Java build tool

### Setup

1. **Clone the repository:**
   ```
   git clone https://github.com/Yash-1706/HelpDeskPlatform.git
   ```
2. **Configure the database:**
   - Create a database using the schema in `resources/schema.sql`.
   - Update database connection details in `src/db/DBConnection.java` as needed.
3. **Build the project:**
   - Using your IDE or with Maven/Gradle.
4. **Run the application:**
   - Run `src/Main.java` or `src/app/Main.java` as the main class.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please contact the repository owner or open an issue on GitHub.
