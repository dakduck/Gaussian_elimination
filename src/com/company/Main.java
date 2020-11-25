package com.company;

import java.util.*;

public class Main {
    /*
    2
    1 2 3 -1
    11 12
     */
    /*
    3
    2 10 -3 -3 -24 5 1 3 -5
    38 -86 27
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = in.nextInt();
        System.out.println("Enter coefficients: ");
        double[][] mas = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = in.nextDouble();
            }
        }
        System.out.println("Enter b: ");
        for (int i = 0; i < n; i++) {
                mas[i][n] = in.nextDouble();
        }
        Slau s = new Slau(n, mas);
        s.printSlau(s.koeff);
        System.out.println("Start: ");
        Gauss g = new Gauss(s, 1);
        g.start();
    }
}
