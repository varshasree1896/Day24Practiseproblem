package com.blz.day24;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;


public class Addressbook {
    private static ArrayList<Contacts> list = new ArrayList<Contacts>();



    /**
     * Call method to check entry in contact by searching state
     */
    private void searchPersonByState() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter state to check entry in Contacts: ");
        String state = sc.nextLine();
        Stream<Contacts> check = list.stream().filter(i -> i.getState().equals(state));
        check.forEach(str -> System.out.println(str.toString()));
    }

    /**
     * Call method to check entry in contact by searching city
     */
    private void searchPersonByCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter city to check entry in Contacts: ");
        String city = sc.nextLine();
        Stream<Contacts> check = list.stream().filter(i -> i.getCity().equals(city));
        check.forEach(str -> System.out.println(str.toString()));
    }


    /**
     * Call method to check duplicate entry
     */
    private void checkDuplicateEntry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname to Check duplicate entry Contact: ");
        String name = sc.nextLine();
        Stream<Contacts> check = list.stream().filter(i -> i.getFirstName().equals(name));
        check.forEach(str -> System.out.println(str.toString()));
    }

    /**
     * Call method to delete contact by searching firstname in contact list
     */
    private void deleteContact() throws ConcurrentModificationException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname to Delete Contact: ");
        String name = sc.nextLine();
        try {
            for (Contacts search : list) {
                if (name.equalsIgnoreCase(search.getFirstName())) {
                    System.out.println("Entered name found in the Address Book, deleting contact");
                    list.remove(search);
                } else {
                    System.out.println("Entered name not found in the Address Book");
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception is "+e.toString());
        }
    }

    /**
     * Call method to edit the contact by searching firstname
     */
    private void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname to edit contact: ");
        String name = sc.nextLine();
        for (Contacts search : list) {
            if (name.equalsIgnoreCase(search.getFirstName())) {
                System.out.println("Entered name found in the Contacts");
                System.out.println("Enter the updated first name");
                String firstName = sc.next();
                search.setFirstName(firstName);
                System.out.println("Enter the updated last name");
                String lastName = sc.next();
                search.setLastName(lastName);
                System.out.println("Enter the updated address");
                String address = sc.next();
                search.setAddress(address);
                System.out.println("Enter the updated city");
                String city = sc.next();
                search.setCity(city);
                System.out.println("Enter the updated state");
                String state = sc.next();
                search.setState(state);
                System.out.println("Enter the updated zipcode");
                int zip = sc.nextInt();
                search.setZip(zip);
                System.out.println("Enter the updated phoneNumber");
                long phoneNumber = sc.nextInt();
                search.setPhoneNumber(phoneNumber);
                System.out.println("Enter the updated emailID");
                String email = sc.next();
                search.setEmail(email);
                search.toString();
            } else {
                System.out.println("Entered name not found in the AddressBook");
            }
        }
    }
    /*
     * Call method to add contacts in ArrayList
     * Create object and add details in it and put it in that list
     */

    public void AddContactsDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("First Name = ");
        String firstName = sc.nextLine();
        System.out.println("Last Name = ");
        String lastName = sc.nextLine();
        System.out.println("Address = ");
        String address = sc.nextLine();
        System.out.println("City = ");
        String city = sc.nextLine();
        System.out.println("State = ");
        String state = sc.nextLine();
        System.out.println("Zip Code = ");
        int zip = sc.nextInt();
        System.out.println("Phone Number = ");
        long phoneNumber = sc.nextLong();
        System.out.println("Email = ");
        String email = sc.nextLine();
        Contacts person = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
        list.add(person);
        person.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Addressbook> addressBooks = new HashMap<>();
        Addressbook book1 = new Addressbook();
        Addressbook book2 = new Addressbook();
        Addressbook book3 = new Addressbook();
        addressBooks.put("AddressBook1", book1);
        addressBooks.put("AddressBook2", book2);
        addressBooks.put("AddressBook3", book3);
        System.out.println("Choose Address Book");
        System.out.println("1. Addressbook 1");
        System.out.println("2. Addressbook 2");
        System.out.println("3. Addressbook 3");
        int chooseAddressBook = sc.nextInt();
        System.out.println("Choose What to do in this Address Book");
        while (chooseAddressBook >= 1) {
            System.out.println(" ");
            System.out.println("1. Add Contacts");
            System.out.println("2. Edit Contacts");
            System.out.println("3. Delete Contacts");
            System.out.println("4. check duplicate entry");
            System.out.println("5. Search entry by city");
            System.out.println("6. Search entry by state");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            switch (chooseAddressBook) {
                case 1:
                    if (choice == 1) {
                        book1.AddContactsDetails();
                    } else if (choice == 2) {
                        book1.editContact();
                    } else if (choice == 3) {
                        book1.deleteContact();
                    } else if (choice == 4) {
                        book1.checkDuplicateEntry();
                    }
                    else if (choice == 5) {
                        book1.searchPersonByCity();
                    } else if (choice == 6) {
                book1.searchPersonByState();
                break;
                case 2:
                    if (choice == 1) {
                        book2.AddContactsDetails();
                    } else if (choice == 2) {
                        book2.editContact();
                    } else if (choice == 3) {
                        book2.deleteContact();
                    } else if (choice == 4) {
                        book2.checkDuplicateEntry();
                    }  else if (choice == 6) {
                        book2.searchPersonByState();
                    }
                    break;
                case 3:
                    if (choice == 1) {
                        book3.AddContactsDetails();
                    } else if (choice == 2) {
                        book3.editContact();
                    } else if (choice == 3) {
                        book3.deleteContact();
                    } else if (choice == 4) {
                        book3.checkDuplicateEntry();
                    } else if (choice == 5) {
                book3.searchPersonByCity();
                    } else if (choice == 6) {
                        book3.searchPersonByState();
                        break;
                    default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("1. Addressbook 1");
            System.out.println("2. Addressbook 2");
            System.out.println("3. Addressbook 3");
            System.out.println("0. Exit");
            chooseAddressBook = sc.nextInt();
        }
        System.out.println("The Program End");
    }
}
