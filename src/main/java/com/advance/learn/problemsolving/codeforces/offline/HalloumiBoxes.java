package com.advance.learn.problemsolving.codeforces.offline;

import java.util.Scanner;

public class HalloumiBoxes {
    public static void main(String[] args) {
        try (var sc = new Scanner(System.in)) {
            for (int t = sc.nextInt(); t-- > 0;) {
                int n=sc.nextInt(), k=sc.nextInt();
                int[] a=new int[n];
                for(int i=0;i<n;i++)
                    a[i]=sc.nextInt();

                if(k==1){
                    boolean sorted=true;
                    for(int i=1;i<n;i++)
                        if(a[i]<a[i-1]){
                            sorted=false;
                            break;
                        }
                    System.out.println(sorted?"YES":"NO");
                }else
                    System.out.println("YES");
            }
        }
    }
}