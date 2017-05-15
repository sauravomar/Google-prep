package com.prep.arrays;



/*
 * Question: Given an array where two neighboring elements are adjacent (in absolute difference 1), can you write an algorithm to search an element in the array and return its position? If the element appears multiple times, please return the first occurrence.
For example, if given the array {4, 5, 6, 5, 6, 7, 8, 9, 10, 9} and an element 9, the element appears twice in the array, and the first occurrence is at position 7.
 * 
 */
public class SearchInAdajacentNumbers {
	
	private int search(int arr[], int searchNum){
		
		int start = 0;
		int end = arr.length;
		
		if(end == 0){
			System.err.println("Empty Array");
			return -1;
		}
		
		
		while(start <= end-1){
			
			if(arr[start] == searchNum){
				return start;
			}else{
				int diff = Math.abs(arr[start] - searchNum);
				start  = start + diff;
			}
		}
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {4, 5, 6, 5, 6, 7, 8, 9, 10, 9};
		int pos =  new SearchInAdajacentNumbers().search(arr, 14);
		
		System.out.println( pos == -1 ? "Not found " : "Found at Position -> " + pos );
	}

}
