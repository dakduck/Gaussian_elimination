package com.company;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Gauss {
    Slau s;
    int how;
    int[] k;
    // матрица СЛАУ
    double[][] n;

    public Gauss(Slau s, int how) {
        this.s = s;
        this.how = how;
        k = new int[s.mas.length];
        for (int i = 0; i < s.mas.length; i++) {
            k[i] = i;
        }
        this.n = new double[this.s.mas.length][this.s.mas[0].length];
        for (int i = 0; i < this.n.length; i++) {
            for (int j = 0; j < this.n[0].length; j++) {
                n[i][j] = this.s.mas[i][j];
            }
        }
    }

    void start() {
        if (this.how == 1) {
            lineGaussF();
            lineGaussB();
            answer();
        }
    }

    // прямой ход метода Гаусса с выбором по строке
    void lineGaussF() {
        System.out.println(" ***  Прямой ход: ");
        int max;
        Slau sn;
        for (int i = 0; i < this.s.mas.length - 1; i++) {
            max = maxInLine(i);
            changeK(max, i);
            n = changeMas(max, i);
            sn = new Slau(this.n.length, n);
            sn.printSlau(k);
            n = solve(i);
            sn = new Slau(this.s.mas.length, n);
            System.out.println("step " + i);
            sn.printSlau(k);
            for (int j = 0; j < k.length; j++) {
                System.out.print(k[j] + " ");
            }
            System.out.println();
        }
    }

    // обратный ход метода Гаусса с выбором по строке
    void lineGaussB() {
        System.out.println(" ***  Обратный ход: ");
        for (int i = n.length - 1; i > 0; i--) {
            if (n[i][i] != 1) {
                n[i][n.length] = n[i][n.length] / n[i][i];
                n[i][i] = 1;
            }
            int j = i;
            for (int l = i - 1; l >= 0; l--) {
                n[l][n.length] = n[l][n.length] - n[l][j] * n[i][n.length];
                n[l][j] = 0;
            }
        }
        n[0][n.length] = n[0][n.length] / n[0][0];
        n[0][0] = 1;

        Slau sn = new Slau(n.length, n);
        sn.printSlau(k);
    }

    // выбор макс в строке
    int maxInLine(int line) {
        double max = 0;
        int j = 0;
        for (int i = 0; i < n.length; i++) {
            if (max <= Math.abs(n[line][i])) {
                max = Math.abs(n[line][i]);
                j = i;
            }
        }
        int answ = j;
        return answ;
    }

    // изменение порядка коэфф.
    void changeK(int max, int line) {
        int save = this.k[line];
        this.k[line] = max;
        this.k[max] = save;
    }

    // изменение матрицы (столбцов местами)
    double[][] changeMas(int max, int line) {
        double[][] answ = new double[this.s.mas.length][this.s.mas[0].length];
        for (int i = 0; i < this.s.mas.length; i++) {
            for (int j = 0; j < this.s.mas[0].length; j++) {
                answ[i][j] = this.n[i][j];
            }
        }
        // меняем местами два столбца - с инд line и max
        for (int i = 0; i < this.n.length; i++) {
            answ[i][line] = answ[i][max];
            answ[i][max] = this.n[i][line];
        }
        return answ;
    }

    // переход к диагон. матрице
    double[][] solve(int line) {
        double m;
        for (int i = line + 1; i < n.length; i++) {
            m = (-1) * n[i][line] / n[line][line];
            for (int j = line; j < n[0].length; j++) {
                n[i][j] = n[i][j] + n[line][j] * m;
            }
        }
        return n;
    }

    void answer() {
        System.out.println(" ***  Answer: ");
        for (int i = 0; i < n.length; i++) {
            if (n[i][i] == 1) {
                System.out.print("x" + k[i] + " = " + n[i][n.length] + "; ");
            }
        }
    }

}
