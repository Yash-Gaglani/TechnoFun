package com.operative.activity;

public class LeastInterview {

	public static int Solution(int managers , int students) {
		int count = 0;
		if(managers > students)			// Boundary Condition: if there are more managers than number of student
			return 5;				
		
		if(10 * ((managers * (managers+1))/2)< students * 5) {   // Boundary Condition: If there is not enough time for all students
			return -1;
		}
		
		for(int i = 0 ; managers > 0 && students > 0 ; i++) { // Logic of removing students based on number of managers
			count+=5;
			students -= managers;
			if(count % 2 ==0)
				managers -=1;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(Solution(3,11)); // Border Case
		System.out.println(Solution(2, 7)); // Border Case
	}
}
