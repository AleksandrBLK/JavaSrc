package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> motherParents = new ArrayList<>();
        ArrayList<Human> fatherParents = new ArrayList<>();

        Human granfather = new Human("Grandfather", true, 95, motherParents);
        Human granfather2 = new Human("Grandfather2", true, 85, fatherParents);
        Human granmother = new Human("Grandmother1", false, 70, motherParents);
        Human granmother2 = new Human("Grandmother2", false, 75, fatherParents);

        ArrayList<Human> parents = new ArrayList<>();
        Human mother = new Human("Mother", false, 50, parents);
        Human father = new Human("Father", true, 60, parents);
        motherParents.add(mother);
        fatherParents.add(father);

        Human douter = new Human("Douter", false, 25, new ArrayList<>());
        Human douter2 = new Human("Douter2", false, 25, new ArrayList<>());
        Human sun = new Human("sun", true, 25, new ArrayList<>());
        parents.add(douter);
        parents.add(douter2);
        parents.add(sun);


        System.out.println(granfather);
        System.out.println(granmother);
        System.out.println(granfather2);
        System.out.println(granmother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(douter);
        System.out.println(douter2);
        System.out.println(sun);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;


        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
