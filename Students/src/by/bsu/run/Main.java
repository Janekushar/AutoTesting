package by.bsu.run;

import by.bsu.entity.Group;

public class Main {

    public static void main(String[] args) {
        Group group=new Group(3,3);
        System.out.println(group.getAverageS(0));
        System.out.println(group.getAverageG());
    }
}
