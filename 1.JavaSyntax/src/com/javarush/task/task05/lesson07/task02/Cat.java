package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String cat = null;
    private int weightStandart = 4;
    private String nameStandart = null;
    private String adressStandart = null;
    private int ageStandart = 8;

    public void initialize(String name)
    {
        this.cat = name;
    }


    public void initialize(String name, int weight, int age)
    {
        this.cat = name + weight + age;

    }

    public void initialize(String name, int age)
    {
        this.cat = name + age + weightStandart;
    }

    public void initialize (int weight, String color){
        this.cat = weight + color + nameStandart + adressStandart + ageStandart;
    }

    public void initialize (int weight, String color, String adress){
        this.cat = weight + color + adress + nameStandart + ageStandart;
    }


}
