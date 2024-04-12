/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05190000073final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sinem
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        //Dosyanın okunması
        DoublyLinkedList list = new DoublyLinkedList();  //Object list is created
        int choice = 0;
        // Main menu
        try {
            
            while (choice != 7) {
                System.out.println();
                System.out.println("Choose from the following:");
                System.out.println("1) ADD FROM FILE - Add customers from the customer.txt");
                System.out.println("2) ADD - Add new customer");
                System.out.println("3) SEARCH - Search customers to see if customer exists, then display.");
                System.out.println("4) DELETE - Search customers by keyword and delete if it exists.");
                System.out.println("5) DISPLAY A to Z - List all customers in alphabetical order (A -> Z).");
                System.out.println("6) DISPLAY Z to A - List all customers in reverse alphabetical order (Z -> A).");
                System.out.println("7) QUIT");

                Scanner scan = new Scanner(System.in);
                choice = Integer.parseInt(scan.next());  //to prevent InputMissMatchException
                Scanner fileIn = null; // Initializes fileIn to an empty object

                switch (choice) {

                    case 1:  //reading text
                        try {
                        fileIn = new Scanner(new FileInputStream("customer.txt"));
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                        System.exit(0);
                    }
                    while (fileIn.hasNextLine()) {

                        String line = fileIn.nextLine();
                        String[] eachCustomer = line.split(",");  //BURADAB İSİM VE SOYİSİM AYIRMAYI SİLDİN
                        ArrayList<String> phoneList = new ArrayList<String>();  //customers phone number count may be plural
                        for (int i = 2; i < eachCustomer.length; i++) {
                            phoneList.add(eachCustomer[i]);

                        }
                        CustomerInfo customer = new CustomerInfo(eachCustomer[0], eachCustomer[1], phoneList); 

                        list.insertSorted(customer);
                    }
                    System.out.println("The customers has been read from the text and saved to the list.");
                    break;
                    case 2:  //add
                        scan.nextLine();  //it does not scanning the keyboard for the next scan without this
                        System.out.println("Please enter the new customer's name-surname, address, phone numbers in this order by using \",\"  ");
                        String line = scan.nextLine();
                        String[] eachCustomer = line.split(",");
                        ArrayList<String> phoneList2 = new ArrayList<String>();
                        for (int i = 2; i < eachCustomer.length; i++) {
                            phoneList2.add(eachCustomer[i]);
                        }
                        CustomerInfo customer = new CustomerInfo(eachCustomer[0], eachCustomer[1], phoneList2);
                        System.out.println(customer);
                        list.insertSorted(customer);
                        System.out.println("The customer is added to the list.");
                        break;
                    case 3: //search
                        scan.nextLine();
                        System.out.println("Please enter customer's name and surname that you want to search and print");
                        String nameSurname1 = scan.nextLine();
                        System.out.println(nameSurname1);
                        list.displayMatch(nameSurname1);
                        break;
                    case 4:
                        scan.nextLine();
                        System.out.println("Please enter customer's name and surname that you want to delete");
                        String nameSurname2 = scan.nextLine(); //?
                        list.deleteMatch(nameSurname2);
                        break;
                    case 5:
                        System.out.println("List is sorted by last-name (from A to Z as) printed below.");
                        list.displayAllSorted();
                        break;
                    case 6:
                        System.out.println("List is sorted by last-name (from Z to A) as printed below.");
                        list.displayAllReverse();
                        break;
                    case 7:
                        fileIn.close();
                        break;

                }
            }  //end of while
        } catch(NumberFormatException e) {   //these are the exceptions that can occur.
            System.out.println("YOU HAVE ENTERED A INAPPROPRIATE ANSWER. PLEASE ANSWER CORRECTLY BY INSTRUCTIONS!");
            System.exit(0);
        } catch(NegativeArraySizeException e) {
            System.out.println("YOU HAVE WROTE A MISSING ENTRY. PLEASE ANSWER CORRECTLY BY INSTRUCTIONS!");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("something went wrong...");
            System.exit(0);     
            } 
        }
}

