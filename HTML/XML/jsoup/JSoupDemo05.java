package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JSoupDemo05 {
    public static void main(String[] args) throws IOException {
        String path = JSoupDemo05.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements name = document.select("name");
        System.out.println(name);

        Elements zhangsan = document.select("#zhangsan");
        System.out.println(zhangsan);
        System.out.println("--------------************--------------");

        Elements student = document.select("student[number='heima_0001']");
        System.out.println(student);
        System.out.println("--------------************--------------");

        Elements student2 = document.select("student[number='heima_0001'] > age");
        System.out.println(student2);
    }
}
