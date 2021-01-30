package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JSoupDemo04 {
    public static void main(String[] args) throws IOException {
        String path = JSoupDemo04.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements names = document.getElementsByTag("name");
        System.out.println(names);
        System.out.println("---------------------------------------------");

        Element element_student = document.getElementsByTag("student").get(0);
        Elements element_name = element_student.getElementsByTag("name");
        System.out.println(element_name.size());

        String number = element_student.attr("number");
        System.out.println(number);

        String text = element_name.text();
        String html = element_name.html();
        System.out.println(text);
        System.out.println(html);

    }
}
