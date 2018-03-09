package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human aleksandr = new Human("Александр", true, 29 );
        Human pavel = new Human("Павел", true, 36);
        Human vasiliy = new Human("Василий", false, 61);
        Human elena = new Human("Елена", false, 61);


        Human aleksandr1 = new Human("Александр", true, 29, aleksandr, elena);
        Human pavel1 = new Human("Павел", false, 36, pavel, elena);
        Human vasiliy1 = new Human("Василий", true, 61, vasiliy, elena);
        Human elena1 = new Human("Елена", false, 61, aleksandr, elena);
        Human elena2 = new Human("Елена", false, 61, vasiliy, elena);


        System.out.println(aleksandr.toString());
        System.out.println(pavel.toString());
        System.out.println(vasiliy.toString());
        System.out.println(elena.toString());
        System.out.println(aleksandr1.toString());
        System.out.println(pavel1.toString());
        System.out.println(vasiliy1.toString());
        System.out.println(elena1.toString());
        System.out.println(elena2.toString());



    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















