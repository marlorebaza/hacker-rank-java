package com.marlo.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class MyBigDecimal {
	
	public static void main(String[] args) {
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String[]s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();
      	for (int i = 0; i < (s.length - 3); i++) {
      		int equalValueIndex = -1;
      		for (int j = (i + 1); j < s.length - 2; j++) {
      			int comparison = new BigDecimal(s[i]).compareTo(new BigDecimal(s[j]));
      			if (comparison < 0) {
      				String temp = s[i];
      				s[i] = s[j];
      				if (equalValueIndex == -1) {
          				s[j] = temp;
      				} else {
          				s[j] = s[equalValueIndex];
          				s[equalValueIndex] = temp;
      				}
      			} else if (comparison == 0) {
      				equalValueIndex = j;
      			}
      		}
      	}
      	//Output
        for(int i=0;i<n;i++) {
            System.out.println(s[i]);
        }
	}

}
