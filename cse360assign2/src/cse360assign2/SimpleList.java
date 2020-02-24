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
	 * If the list is filled up, the list expands by 50%.
	 * @param add the integer to add to the list
	 */
	public void add(int add) {
		if(count == list.length) {
			int increase = count / 2;
			int[] newArray = new int[list.length + increase];
			System.arraycopy(list, 0, newArray, 0, list.length);
			list = newArray;
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
	 * If the resulting list has more than 25% empty spaces,
	 * then the list is reduced. 
	 * @param remove the integer(s) to remove from list
	 */
	public void remove(int remove) {
		//boolean "found" is used to indicate whether or not the
		//integer was found.
		int currentTracker = (int) (list.length * 0.75);
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
		
		if(count <= currentTracker && count > 1) {
			int[] newArray = new int[(int)(list.length * 0.75)];
			System.arraycopy(list, 0, newArray, 0, newArray.length);
			list = newArray;
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
	
	/**
	 * This method is used to append a number to the
	 * list. This means that an entered integer
	 * will be added at the end of the list. 
	 * @param appendNum is the number to be appended
	 */
	public void append(int appendNum) {
		if(count == list.length) {
			int increase = count / 2;
			int[] newArray = new int[list.length + increase];
			System.arraycopy(list, 0, newArray, 0, list.length);
			list = newArray;
		}
		
		list[count] = appendNum;
		count++;
	}
	
	/**
	 * This method is used to return the 
	 * first element of the list.
	 * @return the first element of the list.
	 * @return -1 if there are no elements in the list.
	 */
	public int first() {
		if(count == 0) {
			return -1;
		}
		
		return list[0];
	}
	
	/**
	 * This method returns the last element of the array.
	 * @return the last element of the current list
	 * @return -1 if there are no elements in the list
	 */
	public int last() {
		int last = 0;
		if(count == 0) {
			return -1;
		}
		return list[count - 1];
	}
	/**
	 * this method returns the size of the current list.
	 * @return list.length the number of elements in the list.
	 */
	public int size() {
		return list.length;
	}
	
	//things to do for tomorrow: fix the delete method. it's not working rn.
	
}