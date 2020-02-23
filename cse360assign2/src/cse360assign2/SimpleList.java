package cse360assign2;
/**
 * This java file contains the code for the program SimpleList.
 * This program has the methods to add, delete, count, and 
 * search specific elements in the array list.
 * @author Moses Kang
 * @classID 392
 * @Assignment 2
 */

public class SimpleList 
{
	private int list[];
	private int count;

	/**
	 * This is the constructor of SimpleList object.
	 * The private array list is initialized with 10 empty spaces
	 * and private int count is initialized to 0. 
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * This method is to add an integer "add" to the front of 
	 * the array "list".
	 * This method also deletes the last element if there
	 * are already 10 elements in the array.
	 * @param add the integer to add to the list
	 */
	public void add(int add) {
		if(count == 10) {
			list[9] = 0;
			count = count - 1;
		}
		
		//for loop to move every element to the right.
		if(count > 0) {
			for(int index = count; index > 0; index--) {
				list[index] = list[index - 1];	
			}
		}

		count++;
		list[0] = add;	
	}
	
	/**
	 * This method is used to remove an integer from the 
	 * array. 
	 * This method will delete duplicates of any integer entered.
	 * @param remove the integer(s) to remove from list
	 */
	public void remove(int remove) {
		//boolean "found" is used to indicate whether or not the
		//integer was found.
		boolean found = false;
		for(int index = 0; index < count; index++) {
			if(list[index] == remove) {
				found = true;
			}
			
			if(found) {
				//this for loop is to shift all elements after the
				//remove integer to the left.
				for(int track = index; track < count - 1; track++) {
					list[track] = list[track + 1];
					index--;
				}
				count = count - 1;
			}
			found = false;
		}
	}
	
	/**
	 * this method is used to return the current number of 
	 * elements in the array
	 * @return count the current count value
	 */
	public int count() {
		return count; 
	}
	
	/**
	 * this method combines every element in the list to form
	 * a string.
	 * @return string the string of list elements
	 */
	public String toString() {
		String string = "";
		if(count != 0) {
			//this for loop is to add every element to the array
			//"list" and add a space after.
			for(int index = 0; index < count; index++) {
				string = string + list[index];
			
				if(index < count - 1) {
					string = string + " ";
				}
			}
		}
		return string;
	}
	
	/**
	 * This method is used to search for an integer entered
	 * by the user. This method also returns -1 if the number
	 * doesn't exist in the array. 
	 * @param search the integer to search on the list
	 * @return position the position of the integer
	 */
	public int search(int search) {
		int position = -1;
		int tempCount = count;
		for(int index = 0; index < tempCount; index++) {
			if(list[index] == search) {
				position = index;
				index = tempCount; //this statement ends the for loop
				//without break.
			}
		}
		return position;
	}
}

