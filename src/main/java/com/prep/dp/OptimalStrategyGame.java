package com.prep.dp;

import java.util.ArrayList;
import java.util.List;

public class OptimalStrategyGame {

	
	public int game(List<Integer>list, int sum) {
		
		if(list.isEmpty()) return 0;
		
		int leftSum = 0;
		int rightSum = 0;
		
		if(list.size() == 1) {
			return sum + list.get(0);
		}else if(list.size() == 2) {
			leftSum = sum + list.get(0);
			rightSum = sum + list.get(1);
		}else{
			int newSum = sum + list.get(0);
			leftSum = game(list.subList(1, list.size() -1), newSum);
			
			newSum = sum + list.get(list.size() -1);
		    rightSum = game(list.subList(1, list.size() -1), newSum);
		}

		if(leftSum > rightSum) return leftSum;
		else return rightSum;
	}
	public static void main(String[] args) {
		List<Integer>list = new ArrayList<>();
		list.add(8);
		list.add(15);
		list.add(3);
		list.add(7);

		System.out.println(new OptimalStrategyGame().game(list, 0));
	}
}
