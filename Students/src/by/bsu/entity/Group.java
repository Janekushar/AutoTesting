package by.bsu.entity;

import java.util.ArrayList;

public class Group {
    private ArrayList<Student> students=new ArrayList<>();
    private int amountSt, amountMrk;

    public Group (int amountSt, int amountMrk) {
        this.amountSt=amountSt;
        this.amountMrk=amountMrk;
        for(int i=0; i<amountSt;i++) {
            students.add(new Student(amountMrk,i));
        }
    }

    public double getAverageG(){
        double av=0;
        for (Student st: students) {
            av+=st.getAverage();
        }
        return av/students.size();
    }

    public double getAverageS(int number) {
        return students.get(number).getAverage();
    }

    @Override
    public String toString() {
        String st="";
        for (int i=0;i<students.size();i++){
            st+="\nStudent "+String.valueOf(i)+"\n\tMarks: ";
            for(int j=0;j<amountMrk;j++){
                st+=String.valueOf(students.get(i).getMark(j))+" ";
            }
        }
        return st;
    }
}
