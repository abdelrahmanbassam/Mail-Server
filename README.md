# Mail Server

### Project Overview

This project is a web-based email program that mimics the functionality of a simplified Gmail-like application. It allows users to manage their emails, contacts, and attachments in a streamlined and user-friendly interface. Designed with simplicity and efficiency in mind, the system is built using design patterns that ensure maintainability, flexibility, and scalability.

---
https://github.com/user-attachments/assets/fb27f0c7-9abe-4020-b407-9a8a2f362869

### Main Features

### 1. **Mail Management**:

- **Inbox**:
    - Contains two modes: Default and Priority. Default mode sorts emails from newest to oldest by default. In Priority mode, emails are sorted by their priority (supports four priority levels).
- **Trash**: Automatically deletes emails that are older than 30 days.
- **Sent Folder**: Shows all sent emails.
- **Drafts**: Saves emails as drafts before sending.
- **User-Defined Folders**:
    - Users can add, rename, and delete their own folders.
- **Email Filtering**:
    - Emails can be filtered by subject or sender and automatically directed to specific folders.
- **Email Sorting and Searching**:
    - Sort emails based on attributes such as Date, Sender, Receivers, Importance, Subject, Body, Attachments, etc.
    - Search emails based on various criteria.

### 2. **Attachments**:

- Add or delete attachments from emails.
- Support for viewing attachments.
- Attachments can be of any file type, and an email can contain multiple attachments.

### 3. **Contact Management**:

- Add, edit, and delete contacts.
- Manage contacts with one or more email addresses.
- Search and sort contacts by name or email.

### 4. **Verification System**:

To make the experience more realistic and secure, the system has a basic verification process during signup:

- **Email Validation**: Ensures users cannot sign up with an invalid email (missing '@' or other invalid formats).
- **Password Strength Check**: A minimum of 6 characters is required to ensure security.
- **Existing User Check**: If a user tries to sign up with an email that already exists in the system, they will be prompted to sign in instead.

These verification steps are aimed at providing a real-world experience similar to well-known email services.

---

### Additional Functionalities

- **Multiple Receivers**:
    - When sending an email to multiple receivers, a queue data structure is used to handle this operation efficiently.
- **Pagination**:
    - Emails are retrieved and displayed using pagination to handle large numbers of emails.
    - Navigation buttons allow moving forward or backward between pages of emails.
- **Bulk Email Operations**:
    - Select multiple emails at once for bulk actions like moving or deleting.
- **User Interface**:
    - The application includes a refresh button that allows users to check for new emails.
    - The UI is designed with simplicity and clarity in mind, providing a clean and intuitive navigation experience between folders and actions like composing, filtering, and searching emails.

---

### Design Patterns Applied

- **Builder Pattern**: Simplifies the creation of emails by providing a flexible way to build email objects, particularly useful when dealing with multiple parameters like sender, receiver, and attachments.
- **Prototype Pattern**: Used for creating copies of an email when sending to multiple recipients.
- **Singleton Pattern**: Ensures that only one instance of the `SystemManager` exists throughout the application, ensuring consistency when handling user sessions.
- **Filter Pattern**: Allows for filtering emails based on criteria such as subject or sender, making it easy to organize large volumes of emails.
- **Strategy Pattern**: Implemented for sorting emails based on different strategies (e.g., sorting by date, priority, etc.).

### JSON Schema and Data Handling

- The project uses JSON to store email metadata, ensuring efficient storage and retrieval.
- CRUD operations are implemented using appropriate HTTP requests (e.g., POST for creating, DELETE for deleting).

### How to Use

1. **Sign Up/Sign In**:
    - **Sign Up**: Users can register using a valid email and a strong password (at least 6 characters). The system checks for valid email formatting (e.g., must include '@').
    - **Sign In**: Returning users can log in to access their inbox, drafts, and other folders.
    - **Existing User Check**: If a user tries to sign up with an email already registered, they will be prompted to log in instead.
2. **Compose Email**: Use the compose option to write an email, attach files, and send it to one or multiple recipients.
3. **Manage Folders**: Create custom folders, filter emails, and move emails to different folders.
4. **Manage Contacts**: Add new contacts, search for existing ones, or edit and delete contact details.

### Testing

- Unit testing and mocking are applied to ensure the functionality of the backend services.
- The application is designed to avoid crashes, even when encountering malicious input, ensuring robust error handling.

### UML Diagram
![UML class (1)_page-0001 (1)](https://github.com/user-attachments/assets/63dc8fb9-3d76-40c4-b25e-e78716918967)

### Implementation Notes

- Follows a client-server approach with all business logic on the server side and the user interface handled on the client side.
- The application is designed with **clean code** principles, ensuring that the code is easy to maintain, scalable, and robust against potential issues.

### Prerequisites

- **Backend**: Built with **Java Spring Boot**, the backend server should be run first and will automatically operate on port **8081**.
- **Frontend**: Developed using **Vue.js**, the frontend can be started after the backend by using the following command:
    
    ```bash
    bash
    Copy code
    npm run serve
    ```
    
    This will launch the frontend server on port **8080**.
    
- **Access**: Open your browser and visit **localhost:8080** to use the mail application.

### How to Run the Application

1. **Run the Backend**:
    - Open a terminal and navigate to the backend directory.
    - Use the command to start the backend server (default port **8081**).
2. **Run the Frontend**:
    - Open a new terminal and navigate to the frontend directory.
    - Run `npm run serve` to start the frontend server (port **8080**).
3. **Access the Mail Server**:
    - Open a web browser and go to **localhost:8080**.

---
