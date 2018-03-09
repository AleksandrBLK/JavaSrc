package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg zerg = new Zerg();
        zerg.name = "zerg";
        Zerg kolya = new Zerg();
        kolya.name = "kolya";
        Zerg sasha = new Zerg();
        sasha.name = "sasha";
        Zerg vitya = new Zerg();
        vitya.name = "vitya";
        Zerg yura = new Zerg();
        yura.name = "yura";
        Zerg petya = new Zerg();
        petya.name = "petya";
        Zerg vitalya = new Zerg ();
        vitalya.name = "vitalya";
        Zerg pasha = new Zerg();
        pasha.name = "pasha";
        Zerg andrey = new Zerg();
        andrey.name = "andrey";
        Zerg jenya = new Zerg();
        jenya.name = "jenya";

        Protos anya = new Protos();
        anya.name = "anya";
        Protos vika = new Protos();
        vika.name = "vika";
        Protos olya = new Protos();
        olya.name = "olya";
        Protos oksana = new Protos();
        oksana.name = "oksana";
        Protos katya = new Protos();
        katya.name = "katya";

        Terran max = new Terran();
        max.name = "max";
        Terran aleksandr = new Terran();
        aleksandr.name = "aleksandr";
        Terran viktor = new Terran();
        viktor.name = "viktor";
        Terran mihail = new Terran();
        mihail.name = "mihail";
        Terran evgeniya = new Terran();
        evgeniya.name = "evgeniya";
        Terran viktoriya = new Terran();
        viktoriya.name = "viktoriya";
        Terran ekaterina = new Terran();
        ekaterina.name = "ekaterina";
        Terran lilu = new Terran();
        lilu.name = "lilu";
        Terran bridget = new Terran();
        bridget.name = "bridget";
        Terran emilia = new Terran();
        emilia.name = "emilia";
        Terran dragon = new Terran();
        dragon.name = "dragon";
        Terran maxmax = new Terran();
        maxmax.name = "maxmax";


    }

    public static class Zerg
    {
        public String name;


    }

    public static class Protos
    {
        public String name;


    }

    public static class Terran
    {
        public String name;


    }
}