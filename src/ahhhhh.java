
import java.util.LinkedList;
import java.util.Scanner;

public class ahhhhh {
    private LinkedList<String> contacts;

    public ahhhhh() {
        contacts = new LinkedList<>();
    }

    public void insertContact(String contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void searchContact(String name) {
        boolean found = false;
        for (String contact : contacts) {
            if (contact.contains(name)) {
                System.out.println("Found: " + contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            System.out.println("Contacts:");
            for (String contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(String name) {
        boolean removed = contacts.removeIf(contact -> contact.contains(name));
        if (removed) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void updateContact(String oldName, String newContact) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).contains(oldName)) {
                contacts.set(i, newContact);
                System.out.println("Contact updated successfully!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ahhhhh phonebook = new ahhhhh();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter contact (Name - Phone): ");
                    String contact = scanner.nextLine();
                    phonebook.insertContact(contact);
                    break;
                case "2":
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    phonebook.searchContact(nameToSearch);
                    break;
                case "3":
                    phonebook.displayContacts();
                    break;
                case "4":
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    phonebook.deleteContact(nameToDelete);
                    break;
                case "5":
                    System.out.print("Enter name to update: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new contact (Name - Phone): ");
                    String newContact = scanner.nextLine();
                    phonebook.updateContact(nameToUpdate, newContact);
                    break;
                case "6":
                    System.out.println("Exiting phonebook...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!choice.equals("6"));

        scanner.close();
    }
}