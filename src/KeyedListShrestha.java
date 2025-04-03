/**
 * @author Arya Shrestha<br>
 * 
 * Prog 9 <br>
 * 
 * Due Date and Time: 4/3/2025 before 9:00 AM <br>
 *  
 * The list has a fixed capacity (default 10 items) and prevents duplicate entries.
 * All name comparisons are case-insensitive. Items are automatically maintained
 * in sorted order, with new items inserted in their proper position.
 * 
 * Purpose:
 * - Add items with automatic sorting
 * - Remove items by name
 * - Search for items by name
 * - Calculate total quantity and cost
 * - Check list status (empty/full)
 * - Display all items in order
 * 
 * Certification of Authenticity: <br>
 * I certify that this lab is entirely my own work. <br>
 * 
 */
public class KeyedListShrestha {
	
	/**
	 * The array that stores the items in this keyed list.
	 * The list maintains items in case-insensitive alphabetical order by name.
	 */
	private ItemShrestha[] myList;
	
	/**
	 * The current number of items stored in the list.
	 * This value ranges from 0 to myCapacity.
	 */
	private int mySize;
	
	/**
	 * The maximum number of items this list can hold.
	 * The default capacity is 10 when constructed.
	 */
	private int myCapacity;

	/**
     * Constructs an empty KeyedListShrestha with default capacity of 10.
     */
	public KeyedListShrestha() {
		myCapacity = 10;
		myList = new ItemShrestha[myCapacity];
		mySize = 0;
	
	}//Null constructor KeyedListShrestha
	
	/**
     * Returns the current number of items in the list.
     * @return the size of the list
     */
	public int getSize() {
		return mySize;
	}//getSize
	
	 /**
     * Removes all items from the list, resetting it to empty state.
     */
    public void clear() {
        myList = new ItemShrestha[myCapacity];
        mySize = 0;
    }//clear
	
    /**
     * Searches for an item with the specified key value.
     * @param keyValue the name of the item to search for
     * @return index of the item if found, -1 otherwise
     */
	private int findIndex(String keyValue) {

		boolean found = false;
		int i = 0;
		int location = -1;
		
		while((i < mySize)&& (!found)) {
			if(myList[i].getName().equalsIgnoreCase(keyValue)) {
				found = true;
				location = i;		
			}//if
			else i++;
		}//while
		return location;
	}//findIndex
	
	/**
     * Adds a new item to the list in its proper sorted position.
     * @param product the item to add
     * @return true if item was added successfully, false if list is full or item already exists
     */
	public boolean add(ItemShrestha product) {
		
		int i = 0;
		boolean answer = false;
		int insertPos = 0;
		boolean positionFound = false;
		
		if((!isFull()) && (findIndex(product.getName())== -1)) {
			 while ((insertPos < mySize) && (!positionFound)) {
	                if (myList[insertPos].getName().compareToIgnoreCase(product.getName()) >= 0) {
	                    positionFound = true;
	                }//if 
	                else insertPos++;
	                
			 }//while
		
			for (i = mySize; i > insertPos; i--) {
	            myList[i] = myList[i-1];
	        }//for
	        
	        myList[insertPos] = product;
	        mySize++;
	        answer = true;
		}//if
		return answer;
	}//add
	
	/**
     * Removes an item with the specified key value from the list.
     * @param keyValue the name of the item to remove
     * @return true if item was found and removed, false otherwise
     */
	public boolean remove(String keyValue) {
		
        boolean success = false;
        int index = findIndex(keyValue);
        int i = 0;
        
        if (index != -1) {
            for (i = index; i < mySize - 1; i++) {
                myList[i] = myList[i+1];
            }//for
            
            mySize--;
            success = true;
        }//if
        return success;
    }//remove
	
	/**
     * Retrieves an item with the specified key value.
     * @param keyValue the name of the item to retrieve
     * @return the item if found, null otherwise
     */
	public ItemShrestha retrieve(String keyValue) {
		int i = 0;
		boolean found = false;
		ItemShrestha result = null;
		
		while((!found)&&(i<mySize)) {
			if(myList[i].getName().equalsIgnoreCase(keyValue)){
				found = true;
				result = myList[i];				
			}//if
			else i++;
		}//while
		return result;
	}//retrieve
	
	/**
     * Checks if the list is full.
     * @return true if list has reached capacity, false otherwise
     */
	public boolean isFull() {
		boolean flag = false;
		
		if(mySize == myCapacity)
			flag = true;
		return flag;
	}//isFull
	
	/**
     * Checks if the list is empty.
     * @return true if list contains no items, false otherwise
     */
	public boolean isEmpty() {
		boolean flag = false;
		
		if(mySize == 0)
			flag = true;
		return flag;
	}//isEmpty
	
	/**
     * Prints all items in the list to standard output.
     */
	public void print() {
		int i = 0;
		
		if (isEmpty()) {
            System.out.println("The list is empty.");
        }//if
		else {
            System.out.println("Items in your cart:");
            for (i = 0; i < mySize; i++) {
                System.out.println(myList[i]);
            }//for
        }//else
    }//print
	
	/**
     * Calculates the total quantity of all items in the list.
     * @return sum of quantities of all items
     */
	public int getCount() {
		int i = 0;
		int toPurchase = 0;
		
		if(isEmpty()) {
			System.out.println("The cart is empty. No quantity");
		}//if
		else {
			for(i=0; i < mySize; i++) {
				toPurchase += myList[i].getQuantity();
			}//for
		}//else
		
		return toPurchase;
	}//getCount
	
	
	/**
     * Calculates the total cost of all items in the list.
     * @return sum of (price * quantity) for all items
     */
	public double calcTotal() {
		double totalSum = 0.0;
		int i = 0;
		
		if(isEmpty()) {
			System.out.println("Your cart is empty.");
		}//if
		else {
			for(i = 0; i < mySize; i++) {
				totalSum += (myList[i].getPrice()) * (myList[i].getQuantity());
			}//for
		}//else
		return totalSum;
	}//calcTotal

}//KeyedListShrestha

