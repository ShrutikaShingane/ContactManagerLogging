
package contactmanager;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class ContactManagerGUI extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private DefaultListModel<Contact> contactModel;
    private JList<Contact> contactList;

    public ContactManagerGUI() {
        setTitle("Contact Manager");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);

        contactModel = new DefaultListModel<>();
        contactList = new JList<>(contactModel);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        JButton addButton = new JButton("Add Contact");
        JButton editButton = new JButton("Edit Contact");
        JButton deleteButton = new JButton("Delete Contact");
        JButton clearButton = new JButton("Clear Fields");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        setLayout(new BorderLayout(10, 10));
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(contactList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addContact());
        editButton.addActionListener(e -> editContact());
        deleteButton.addActionListener(e -> deleteContact());
        clearButton.addActionListener(e -> clearFields());

        contactList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Contact contact = contactList.getSelectedValue();

                if (contact != null) {
                    nameField.setText(contact.getName());
                    phoneField.setText(contact.getPhone());
                    emailField.setText(contact.getEmail());
                }
            }
        });

        ContactLogger.info("Contact Manager application started");
    }

    private boolean validateFields() {
        if (nameField.getText().trim().isEmpty()
                || phoneField.getText().trim().isEmpty()
                || emailField.getText().trim().isEmpty()) {

            ContactLogger.info(
                    "Validation failed: required field is empty");

            JOptionPane.showMessageDialog(this,
                    "Please enter name, phone and email.");

            return false;
        }

        return true;
    }

    private void addContact() {
        try {
            if (!validateFields()) {
                return;
            }

            Contact contact = new Contact(
                    nameField.getText().trim(),
                    phoneField.getText().trim(),
                    emailField.getText().trim()
            );

            contactModel.addElement(contact);

            ContactLogger.info(
                    "CONTACT ADDED: " + contact.getName());

            clearFields();

        } catch (Exception e) {
            ContactLogger.error("Error adding contact", e);
            JOptionPane.showMessageDialog(this,
                    "Unable to add contact.");
        }
    }

    private void editContact() {
        try {
            int index = contactList.getSelectedIndex();

            if (index == -1) {
                JOptionPane.showMessageDialog(this,
                        "Please select a contact to edit.");
                return;
            }

            if (!validateFields()) {
                return;
            }

            Contact contact = contactModel.getElementAt(index);
            String oldName = contact.getName();

            contact.setName(nameField.getText().trim());
            contact.setPhone(phoneField.getText().trim());
            contact.setEmail(emailField.getText().trim());

            contactModel.setElementAt(contact, index);

            ContactLogger.info(
                    "CONTACT EDITED: " + oldName
                    + " -> " + contact.getName());

            clearFields();

        } catch (Exception e) {
            ContactLogger.error("Error editing contact", e);
            JOptionPane.showMessageDialog(this,
                    "Unable to edit contact.");
        }
    }

    private void deleteContact() {
        try {
            int index = contactList.getSelectedIndex();

            if (index == -1) {
                JOptionPane.showMessageDialog(this,
                        "Please select a contact to delete.");
                return;
            }

            Contact contact = contactModel.getElementAt(index);

            int choice = JOptionPane.showConfirmDialog(this,
                    "Delete " + contact.getName() + "?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                contactModel.removeElementAt(index);

                ContactLogger.info(
                        "CONTACT DELETED: " + contact.getName());

                clearFields();
            }

        } catch (Exception e) {
            ContactLogger.error("Error deleting contact", e);
            JOptionPane.showMessageDialog(this,
                    "Unable to delete contact.");
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        contactList.clearSelection();
    }
}
