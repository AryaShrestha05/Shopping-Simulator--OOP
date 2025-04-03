import java.util.*;
import java.io.*;

/**
 * @author Arya Shrestha<br>
 * 
 * Prog 9<br>
 * 
 * Due Date and Time: 4/3/2025 before 9:00 AM<br>
 *  
 * Purpose: A program that implements a keyed list data structure to manage a shopping cart. 
 * Users can add, remove, search, and view items in sorted order. Each item has a name (as key), 
 * quantity, and unit price. The list maintains items in case-insensitive alphabetical order.<br> 
 * 
 * Input: Items are read from a file initially, then through user menu selections including:
 * - String for item name (case-insensitive)
 * - Integer for quantity
 * - Double for unit price<br>
 * 
 * Output: Provides menu-driven operations to:
 * - Display all items in sorted order
 * - Show total quantity of items
 * - Calculate total cost
 * - Check if list is empty/full
 * - Search for specific items<br>
 * 
 * Certification of Authenticity:<br>
 * I certify that this lab is entirely my own work.<br>
 */
public class ShoppingDemoShrestha {
	/**
	 * creates a static Scanner object named keyboard, which is used for reading user input from the console. 
	 */
	static Scanner keyboard = new Scanner(System.in);
    
    /**
     * Main method that drives the shopping cart program.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
    	
    	//Initializing variables and classes for the main method
        KeyedListShrestha shoppingList = new KeyedListShrestha();
        ItemShrestha itemInCart = null;
        int numItems = 0;
        int i = 0;
        double price = 0.0;
        int quantity = 0;
        String name = null;
        String fileName = null;
        int choice = -1;
        Scanner fileScanner = null;
        
        
      //Ask user for the input file name
	    System.out.println("Enter the input file name: ");
	    fileName = keyboard.next();

	    //Open and read from the file
	    File inputFile = new File(fileName);
	    
	    //try to open and use file if possible
	    try 
	    {
	    	//Create second scanner object to read from the file
	        fileScanner = new Scanner(inputFile);
	        
	        //Read first line of the file to see how many nums will follow 
	        numItems = fileScanner.nextInt(); 
	        
	        //Exception thrown if you try to read past line
	        for (i = 0; i < numItems; i++) {
	        	//Read item name
	            name = fileScanner.next(); 
	            //Read item quantity
	            quantity = fileScanner.nextInt(); 
	            //Read item price
	            price = fileScanner.nextDouble();

	            //Updating item reference
	            itemInCart = new ItemShrestha(name, quantity, price);
	            shoppingList.add(itemInCart);
	        
	        }//for
	        
	        //Close the file inside try
	        fileScanner.close();
	    }//try
        catch(FileNotFoundException e) {
            System.out.println("File not found. Starting with empty cart.");
        }//catch
   
        //Do loop to show the menu till user inputs 0 which quits
		do {
			System.out.println("\nMenu:");
	        System.out.println("1. Add an item to the list");
	        System.out.println("2. Delete an item from the list");
	        System.out.println("3. Print each item in the list");
	        System.out.println("4. Search for a user-specified item in the list");
	        System.out.println("5. Count the total number of items in the list");
	        System.out.println("6. Total the cost of the items in the list");
	        System.out.println("7. Determine whether the list is empty");
	        System.out.println("8. Determine whether the list is full");
	        System.out.println("9. Clear the list");
	        System.out.println("0. Quit");
	        System.out.print("Enter your choice: ");
	        choice = keyboard.nextInt();
	        
			//switch statement from the input given by the user
	        switch(choice) {
            case 1:
                addItem(shoppingList);
                break;
            case 2:
                removeItem(shoppingList);
                break;
            case 3:
            	shoppingList.print();
                break;
            case 4:
                searchItem(shoppingList);
                break;
            case 5:
                System.out.println("Your cart contains " + shoppingList.getCount() + " items.");
                break;
            case 6:
                System.out.printf("Total cost: $%.2f\n", shoppingList.calcTotal());
                break;
            case 7:
            	//Rather than having a separate method, I wrote the whole thing in one line with the conditional operator
                System.out.println("The list is " + (shoppingList.isEmpty() ? "empty" : "not empty"));
                break;
            case 8:
            	//Rather than having a separate method, I wrote the whole thing in one line with the conditional operator
                System.out.println("The list is " + (shoppingList.isFull() ? "full" : "not full"));
                break;
            case 9:
            	shoppingList.clear();
                System.out.println("The list has been cleared.");
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
	        
	        }//switch    
		}while(choice != 0); //Do-loop to loop until user inputs 0

	}//main
        
    /**
     * Adds an item to the shopping list after prompting user for item details
     * @param itemToAdd The KeyedListShrestha to which the item will be added
     */
    public static void addItem(KeyedListShrestha itemToAdd) {
        //Declare all variables at the start
        String name = " ";
        int quantity = 0;
        double price = 0.0;
        boolean addSuccess = false;
        ItemShrestha newItem = null;
        
        //Get user inputs
        System.out.println("Please provide information about the item to add.");
        System.out.print("Please enter the name: ");
        name = keyboard.next();
        
        System.out.print("Please enter the quantity: ");
        quantity = keyboard.nextInt();
        
        System.out.print("Please enter the unit price: $");
        price = keyboard.nextDouble();
        
        //Create and add new item
        newItem = new ItemShrestha(name, quantity, price);
        addSuccess = itemToAdd.add(newItem);
        
        //Displays result
        if (addSuccess)
            System.out.println(name + " has been added to the cart.");
        else
            System.out.println("Could not add item (either duplicate name or list is full).");
    }//addItem
    
    /**
     * Handles removing an item from the shopping list
     * @param removeThis The item to remove from the list
     */
    public static void removeItem(KeyedListShrestha removeThis) {
        //Declare variables
        String name = " ";
        boolean removalSuccess = false;
        
        //Get user input
        System.out.print("Please enter the name of the item to remove: ");
        name = keyboard.next();
        
        //Attempt removal and store result
        removalSuccess = removeThis.remove(name);
        
        //Display appropriate message
        if (removalSuccess)
            System.out.println(name + " has been removed from the cart.");
        else 
            System.out.println("Item not found in cart.");
        
    }//removeItem
    
    /**
     * Handles searching for an item in the shopping list
     * @param searchThis The item in the list to search 
     */
    public static void searchItem(KeyedListShrestha searchThis) {
        //Declare variables 
        String name = " ";
        ItemShrestha item = null;
        
        //Get user input
        System.out.print("Please enter the name of the item to search for: ");
        name = keyboard.next();  
        
        //Search for item
        item = searchThis.retrieve(name);
        
        //Display results
        if(item != null) {
            System.out.println("Item found:");
            System.out.println(item);
        }//if
        else System.out.println("Item not found in cart.");
        
    }//searchItem
    
}//ShoppingDemoShrestha