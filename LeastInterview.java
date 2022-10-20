package com.operative.activity;


public class LeastInterview {

	// A solution with efficient complexity O(students/managers) in the worst case scenario. 
	// @Author : Yash G. and Sarthak S.
	
	public static int Solution(int managers , int students) {
		int count = 0;
		if(managers > students)			// Boundary Condition: if there are more managers than number of student
			return 5;				
		
		if(10 * ((managers * (managers+1))/2)< students * 5) {   // Boundary Condition: If there is not enough time for all students
			return -1;
		}
		
		while(managers > 0 && students > 0) { //Logic to decrease students based on manager
			count+=5; //Since every interview takes 5 minutes
			students -= managers; //In every iteration no of student reduced is equal to no of managers
			if(count % 2 ==0) 
				managers -=1; //Since on every even iteration managers will be reduced as one manager will get his time exhausted
			// example 10,20,30
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(Solution(3,11)); // Border Case
		System.out.println(Solution(2, 7)); // Border Case
		System.out.println(Solution(6, 4)); // 
	}
}
