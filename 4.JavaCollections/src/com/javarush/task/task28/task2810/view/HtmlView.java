/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    Controller contr;
    //final String filePath = "D:\\JavaRush_new\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task28\\task2810\\view\\vacancies.html";
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        try{
            updateFile(getUpdatedFileContent(vacancies));
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some exception");
        }


    }

    @Override
    public void setController(Controller controller) {
        this.contr = controller;
    }

    public void userCitySelectEmulationMethod(){
        contr.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {

        Document document = null;
        try {
            document = getDocument();

            Element templateOriginal = document.getElementsByClass("template").first();
            Element copyTemplate = templateOriginal.clone();
            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            document.select("tr[class=vacancy]").remove().not("tr[class=vacancy template]");

            for (Vacancy vacancy : vacancies) {
                Element localClone = copyTemplate.clone();
                localClone.getElementsByClass("city").first().text(vacancy.getCity());
                localClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                localClone.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link =localClone.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateOriginal.before(localClone.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    private void updateFile(String content) {

        try {
            FileWriter fileWriter = new FileWriter(new File(filePath));
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected Document getDocument()  throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

}
