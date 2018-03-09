/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int number = 0;

        while (true)
        {
            Document document = null;

            try {
                document = getDocument(searchString, number++);

            }
            catch (IOException e) {}

            Elements elements = document.body().getElementsByClass("job");
            if (!elements.isEmpty()) {
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setUrl("https://moikrug.ru" + element.select("a[class=job_icon]").attr("href"));
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "count").text());
                    vacancies.add(vacancy);

                }
            }
            else {
                return vacancies;
            }
        }
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36")
                .referrer("https://www.google.com/")
                .get();
    }
}
