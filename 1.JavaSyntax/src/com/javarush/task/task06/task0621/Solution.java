package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat grandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat grandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, grandFather, false);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, grandMother, true);

        String sunName = reader.readLine();
        Cat catSun = new Cat(sunName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);


        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSun);
        System.out.println(catDaughter);

    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parent1;
        private boolean sex;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }

        Cat(String name, Cat parent, boolean sex) {
            this.name = name;
            this.parent = parent;
            this.sex = sex;
        }

        Cat(String name, Cat parent, Cat parent1) {
            this.name = name;
            this.parent = parent;
            this.parent1 = parent1;
        }


        @Override
        public String toString() {
            if (parent == null)
                return "Cat name is " + name + ", no mother, no father";
            if (parent1 == null && sex == false)
                return "Cat name is " + name + ", no mother, father is " + parent.name;
            if (parent1 == null && sex == true)
                return "Cat name is " + name + ", mother is " + parent.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + parent.name + ", father is " + parent1.name;
        }
    }

}
