package com.company;

public class Slau {
    int k;
    double[][] mas;
    int[] koeff;

    public Slau(int k, double[][] mas) {
        this.k = k;
        this.mas = mas;
        this.koeff = new int[k];
        for (int i = 0; i < koeff.length; i++) {
            koeff[i] = i;
        }
    }

    void printSlau (int[] koeff) {
        int k = 0;
        for (int i = 0; i < this.mas.length; i++) {
            for (int j = 0; j <  this.mas.length; j++) {
                if (j == this.mas.length-1) {
                    System.out.print(this.mas[i][j] + "x" + koeff[j] + " = " + this.mas[i][this.mas.length]);
                } else System.out.print(this.mas[i][j] + "x" + koeff[j] + " + ");
            k++;
            }
            k=0;
            System.out.println();
        }
    }


}
