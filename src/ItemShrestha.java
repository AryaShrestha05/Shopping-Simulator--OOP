import java.text.*;

/**
 * @author Arya Shrestha<br>
 * 
 * Prog 9<br>
 * 
 * Due Date and Time: 4/3/2025 before 9:00 AM <br>
 * 
 * Represents an individual shopping item with name, quantity and price.
 * Provides methods to access and modify item properties and format output.<br>
 * 
 * Certification of Authenticity:<br>
 * I certify that this class is entirely my own work.<br>
 */
public class ItemShrestha {
	
	/**
     * The name of the item (serves as key in KeyedList)
     */
	private String myName;
	
	/**
     * The quantity of this item to purchase
     */
	private int myQuantity;
	
	/**
     * The unit price of this item
     */
	private double myPrice;
	
	/**
     * Decimal formatter for consistent price display
     */
	static DecimalFormat moneyStyle = new DecimalFormat ("0.00");
	
	/**
	 * Constructs a new ItemShrestha with default values.
	 * The name is set to empty string, quantity to 0, and price to 0.0.
	 */
	public ItemShrestha() 
	{
		myName = " ";
		myQuantity = 0;
		myPrice = 0.0;
	}//Null constructor
	
	/**
	 * Constructs a new full ItemShrestha with specified values.
	 * 
	 * @param newName the name of the item
	 * @param newQuantity the quantity of the item
	 * @param newPrice the price per unit of the item
	 */
	public ItemShrestha(String newName, int newQuantity, double newPrice) {
        myName = newName;
        myQuantity = newQuantity;
        myPrice = newPrice;
	}//Full Constructor
	
	/**
	 * Returns the name of the item.
	 * 
	 * @return the current item's name
	 */
	public String getName() {
		return myName;
	}//getName
	    
	/**
	 * Returns the quantity of the item.
	 * 
	 * @return the current item's quantity
	 */
	public int getQuantity() {
		return myQuantity;
	}//getQuantity
	    
	/**
	 * Returns the price of the item.
	 * 
	 * @return the current item's price per unit
	 */
	public double getPrice() {
		return myPrice;
	}//getPrice
	    
	/**
	 * Sets the name of the item.
	 * 
	 * @param newName the new name to set for the item
	 */
	public void setName(String newName) {
		myName = newName;
	}//setName
	    
	/**
	 * Sets the quantity of the item.
	 * 
	 * @param newQuantity the new quantity to set for the item
	 */
	public void setQuantity(int newQuantity) {
		myQuantity = newQuantity;
	}//setQuantity
	    
	/**
	 * Sets the price of the item.
	 * 
	 * @param newPrice the new price to set for the item
	 */
	public void setPrice(double newPrice) {
		myPrice = newPrice;
	}//setPrice
	    
	/**
	 * Returns a string representation of the item.
	 * The format is: "name, quantity: x, price: $y.yy each"
	 * 
	 * @return a formatted string representing the item
	 */	
	public String toString() {
		String ans = "Name: " + myName + "\n";
		ans += "Quantity: " + myQuantity + "\n";
		ans += "Price: $" + moneyStyle.format(myPrice) + "\n";
		return ans;
	}//toString
	

}//ItemShrestha