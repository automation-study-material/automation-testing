package org.collection;

import java.util.ArrayList;
import java.util.List;

public class Sorting_Array {
	public static void bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
    	ArrayList <Integer> list=new ArrayList <Integer>();
    	list.add(10);list.add(20);list.add(30);list.add(5);
    	list.add(8);list.add(11);list.add(22);list.add(25);
    	System.out.println(list);
    	bubbleSort(list);
    	System.out.println(list);
    }

	

	
}
