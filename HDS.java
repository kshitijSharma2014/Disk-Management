/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hds;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kshitij
 */
public class HDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a[] = new int[100];
        int h;   //loc of head
        int count; //counting head movements
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("enter number of location\t");
        n = s.nextInt();
        System.out.println("enter elements of disk queue\n");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (a[j] > a[k]) {
                    int dummy = a[j];
                    a[j] = a[k];
                    a[k] = dummy;
                }
            }
        }
        for (int p = 0; p < n; p++) {
            System.out.println("array" + a[p]);
        }
        System.out.println("enter position of head\t");
        h = s.nextInt();
        int temp = h;
        int left_dist = 0;
        int right_dist = 0;
        int position = 0;

        for (int i = 0; i < n; ++i) {
            if (a[i] >= h) {
                position = i;
//                System.out.println("position : " + position);
                break;
            }
        }
//        System.out.println("after for loop position : " + position);
        left_dist = h - a[0];
        right_dist = a[n - 1] - h;
        count = 0;
        if (left_dist < right_dist) {
            for (int i = position - 1; i >= 0; --i) {
                count = count + temp - a[i];
                temp = a[i];
//                System.out.println("left 1 position : " + position);
            }
            count = count + position - a[1];
            for (int i = position + 1; i < n; ++i) {
                count = count + a[i] - a[i - 1];
//                System.out.println("left 2position : " + position);
            }
        } else {
            for (int i = position; i < n; ++i) {
                count = count + a[i] - h;
                h = a[i];
//                System.out.println("position : " + position + "head : " + h);
            }
//            System.out.println("position : " + position);
//            System.out.println("1)count : " + count);
//            System.out.println(" a[n-1] : " + a[n - 1]);
//            System.out.println("a[position - 1] : " + a[position - 1]);
            count = count + a[n - 1] - a[position - 1];
//            System.out.println("2)count : " + count + " a[n-1] : " + a[n - 1] + " a[position - 1] : " + a[position - 1]);
            for (int i = position - 1; i >= 1; --i) {
                count = count + a[i] - a[i - 1];
            }
        }
        System.out.println("count" + count);
    }
}
