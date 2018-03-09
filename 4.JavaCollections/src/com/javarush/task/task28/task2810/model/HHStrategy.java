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
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";

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

                Elements elements = document.body().getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (!elements.isEmpty()) {
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                        vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                        vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                        vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                        vacancy.setSiteName("hh.ua");
                        vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
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
                .referrer("https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
                .get();
    }
}