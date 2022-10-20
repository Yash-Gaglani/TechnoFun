package com.operative.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Second_Solution {
    
    public static int solution(List<Integer> managersTime, int numberOfStudents) {
        
        long numberOfManagersWhoCanTakeInterview = getNumberOfManagersWhoCanTakeInterview(managersTime);
        int totalTimeTakenForInterview = 0;
        while(numberOfStudents > 0 && numberOfManagersWhoCanTakeInterview > 0) {
            if(numberOfStudents > numberOfManagersWhoCanTakeInterview) {
                updateManagersTimeAfterOneRoundOfInterview(managersTime, numberOfManagersWhoCanTakeInterview);
                numberOfStudents -= numberOfManagersWhoCanTakeInterview;
            } else {
                updateManagersTimeAfterOneRoundOfInterview(managersTime, numberOfStudents);
                numberOfStudents = 0;
            }
            totalTimeTakenForInterview += 5;
            numberOfManagersWhoCanTakeInterview = getNumberOfManagersWhoCanTakeInterview(managersTime);
        }
        
        if(numberOfStudents > 0 && numberOfManagersWhoCanTakeInterview == 0) {
            System.out.println(String.format("Interview with the given data is not possible as %d student/s will still be remaining for the interview", numberOfStudents));
            return -1;
        }
        
        if(numberOfStudents == 0) {
            int managerNumber = 1;
            for (Integer managerTime : managersTime) {
                System.out.println(String.format("Manager %d has %d minute/s left", managerNumber, managerTime));
                managerNumber += 1;
            }
        }
        
        return totalTimeTakenForInterview;
        
    }
    
    public static long getNumberOfManagersWhoCanTakeInterview(List<Integer> managersTime) {
        return managersTime.stream()
                .filter(managerTime -> managerTime >= 5)
                .count();
    }
    
    public static List<Integer> updateManagersTimeAfterOneRoundOfInterview(List<Integer> managersTime, long numberOfManagersWhoHadTakenInterview) {
        
        ListIterator<Integer> li = managersTime.listIterator();
        while(numberOfManagersWhoHadTakenInterview > 0) {
            Integer managerTime = li.next();
            if(managerTime >= 5 && numberOfManagersWhoHadTakenInterview > 0) {
                li.set(managerTime - 5);
                numberOfManagersWhoHadTakenInterview--;
                if(numberOfManagersWhoHadTakenInterview == 0) break;
            }
        }
        
        return managersTime;
        
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(11);al.add(12);al.add(9);al.add(15); //al.add(13);al.add(12);
        System.out.println(String.format("The Least Time For the interview is %d", solution(al,5)));
    }
    
}
