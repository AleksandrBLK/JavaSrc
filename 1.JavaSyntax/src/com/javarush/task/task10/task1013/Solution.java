package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String profession;
        private int skillLevel;
        private int age;
        private String closePeople;
        private String country;

        public Human(String name, String closePeople) {
            this.name = name;
            this.closePeople = closePeople;
        }

        public Human(String name, String profession, int skillLevel, int age, String country) {
            this.name = name;
            this.profession = profession;
            this.skillLevel = skillLevel;
            this.age = age;
            this.country = country;
        }

        public Human(String name, String profession, int skillLevel, int age) {
            this.name = name;
            this.profession = profession;
            this.skillLevel = skillLevel;
            this.age = age;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }

        public Human(String name, String profession, int skillLevel, int age, String closePeople, String country) {
            this.name = name;
            this.profession = profession;
            this.skillLevel = skillLevel;
            this.age = age;
            this.closePeople = closePeople;
            this.country = country;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String profession, int age, String closePeople, String country) {
            this.name = name;
            this.profession = profession;
            this.age = age;
            this.closePeople = closePeople;
            this.country = country;
        }

        public Human(String profession, int skillLevel, int age, String closePeople, String country) {
            this.profession = profession;
            this.skillLevel = skillLevel;
            this.age = age;
            this.closePeople = closePeople;
            this.country = country;
        }

        public Human(int age, String closePeople, String country) {
            this.age = age;
            this.closePeople = closePeople;
            this.country = country;
        }
    }
}
