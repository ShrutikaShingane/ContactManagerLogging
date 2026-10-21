# Contact Manager GUI with File-Based Logging

## 1. Project Overview

The Contact Manager is a Java desktop application developed using Eclipse IDE and Java Swing. It allows users to add, edit, view, and delete contact details through a graphical user interface.

This project demonstrates file-based logging using Java's built-in `java.util.logging` package. Every successful contact addition, edit, and deletion is recorded in `contacts.log` with a timestamp.

## 2. Objectives

- Develop a simple Contact Manager GUI.
- Implement Create, Read, Update, and Delete (CRUD) operations.
- Configure file-based logging using `FileHandler`.
- Record application events with timestamps.
- Use `INFO` for normal operations and `SEVERE` for errors.
- Verify log file updates after user actions.

## 3. Technologies Used

- **Programming Language:** Java
- **IDE:** Eclipse IDE
- **GUI:** Java Swing
- **Logging:** `java.util.logging`
- **File Handling:** `FileHandler`
- **Version Control:** Git and GitHub

No external libraries are required.

## 4. Project Structure

```text
ContactManagerLogging/
├── src/
│   └── contactmanager/
│       ├── Contact.java
│       ├── ContactLogger.java
│       ├── ContactManagerGUI.java
│       └── Main.java
├── contacts.log
└── README.md
```

The `contacts.log` file is generated automatically when the application runs and initializes its logger. It may not exist in a fresh checkout until the application is launched.

## 5. Features

### Contact Management
- Add a contact with name, phone number, and email.
- Select and edit an existing contact.
- Delete a selected contact after confirmation.
- Clear the input fields.
- Validate required fields and contact selection.

### File-Based Logging
- Store log entries in `contacts.log`.
- Include timestamps and log levels.
- Append new entries without intentionally overwriting previous logs.
- Record application startup and successful CRUD operations.
- Record exceptions using the `SEVERE` log level.

## 6. How to Run the Project

1. Install a compatible JDK and Eclipse IDE.
2. Open Eclipse and select your workspace.
3. Select **File → New → Java Project**.
4. Name the project `ContactManagerLogging`.
5. Create the package `contactmanager` inside `src`.
6. Create the four Java classes listed in the project structure.
7. Paste the corresponding source code into each class.
8. Save all files.
9. Open `Main.java`.
10. Right-click and select **Run As → Java Application**.

The Contact Manager GUI should open.

## 7. How to Verify Logs

1. Run the application.
2. Add a contact.
3. Edit the contact.
4. Delete the contact.
5. Refresh the project in Eclipse.
6. Open `contacts.log` in a text editor.
7. Verify that the actions have corresponding log entries and timestamps.

Normal operations should use the `INFO` level. Exceptions should be recorded using `SEVERE`.

## 8. Testing

The following manual tests can be performed:

| Test Case | Expected Result |
|---|---|
| Add a valid contact | Contact appears in the list and an INFO log is created |
| Edit a selected contact | Updated details appear and an INFO log is created |
| Delete a selected contact | Contact is removed and an INFO log is created |
| Submit empty required fields | Validation message is displayed |
| Edit or delete without selecting a contact | Selection message is displayed |
| An application exception occurs | A SEVERE log entry is recorded |

## 9. Important Notes

- Contact records are stored in application memory and are not permanently saved in a database.
- The `contacts.log` file stores operation logs, not a complete contact database.
- The log file is created in the application's working directory.
- The log file may contain personal contact details in its messages. Do not commit real or sensitive contact information to a public repository.

## 10. Future Enhancements

- Store contacts permanently in a file or database.
- Add phone number and email format validation.
- Add contact search functionality.
- Add a dedicated log viewer.
- Improve GUI styling and usability.

## 11. Author

**Project:** Contact Manager GUI with File-Based Logging  
**Language:** Java  
**IDE:** Eclipse IDE  
**Task:** Day 16

## 12. License

This project is intended for educational and learning purposes.
