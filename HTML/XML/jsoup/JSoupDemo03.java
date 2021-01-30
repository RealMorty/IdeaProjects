package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JSoupDemo03 {
    public static void main(String[] args) throws IOException {
        String path = JSoupDemo03.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements student = document.getElementsByTag("student");
        System.out.println(student);
        System.out.println("----------------------------");

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("----------------------------");

        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);
        System.out.println("----------------------------");

        Element zhangsan = document.getElementById("zhangsan");
        System.out.println(zhangsan);
        System.out.println("----------------------------");

    }
}
