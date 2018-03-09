package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null, new File("D:\\JavaRush_new\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Aleksandr");
            user.setLastName("Bilyk");
            user.setBirthDate(new Date(1987 - 1900, 8 - 1, 7));
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);


            User user1 = new User();
            user1.setFirstName("Petya");
            user1.setLastName("Pupkin");
            user1.setBirthDate(new Date(1981 - 1900, 7 - 1, 1));
            user1.setMale(false);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            javaRush.save(outputStream);

            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) {
                System.out.println("Yes");
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            if (!(users.size() == 0)) {
                for (User i : users) {
                    writer.println(i.getFirstName());
                    writer.println(i.getLastName());
                    writer.println(i.getBirthDate().getTime());
                    writer.println(i.isMale());
                    writer.println(i.getCountry().getDisplayedName());
                    writer.flush();
                }
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int userSize = Integer.parseInt(reader.readLine());
            if (userSize > 0) {
                for (int i = 0; i < userSize; i++) {
                    User user = new User();
                    users.add(user);
                    String firstName = reader.readLine();
                    user.setFirstName(firstName);
                    String lastName = reader.readLine();
                    user.setLastName(lastName);
                    Date date = new Date(Long.parseLong(reader.readLine()));
                    user.setBirthDate(date);
                    boolean isMale = Boolean.parseBoolean(reader.readLine());
                    user.setMale(isMale);
                    String country = reader.readLine();
                    if (country.equals(User.Country.RUSSIA.getDisplayedName())) {
                        User.Country country1 = User.Country.RUSSIA;
                        user.setCountry(country1);
                    }
                    if (country.equals(User.Country.UKRAINE.getDisplayedName())) {
                        User.Country country1 = User.Country.UKRAINE;
                        user.setCountry(country1);
                    }
                    if (country.equals(User.Country.OTHER.getDisplayedName())) {
                        User.Country country1 = User.Country.OTHER;
                        user.setCountry(country1);
                    }


                }

            }

            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
