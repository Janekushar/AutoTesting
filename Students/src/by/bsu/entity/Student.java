package by.bsu.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    Scanner sc=new Scanner(System.in);
    private int[] marks;
    private int id;

    Student (int amount, int id) {
        marks=new int[amount];
        this.id=id;
        for (int i=0;i<amount;i++)
            setMarks(i);
    }

    private void setMarks (int i) {
        marks[i]=(int)(Math.random()*10)+1;
    }

    private void setMark (int i) {
        int a;
        try {
            a=sc.nextInt();
            if (0 <= a && a <= 10) {
                marks[i] = a;
            } else {
                setMark(i);
            }
        } catch (InputMismatchException e){
            setMark(i);
        }
    }

    public double getAverage () {
        double avMark=0;
        for (int m: marks)
           avMark+=m;
        return avMark/marks.length;
    }

    public int getMark(int n){
        return marks[n];
    }
}
