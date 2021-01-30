package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JSoupDemo02 {
    public static void main(String[] args) throws IOException {
        String path = JSoupDemo02.class.getClassLoader().getResource("student.xml").getPath();
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);
        URL url = new URL("https://www.bilibili.com/");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);

        /*String str = "<!--?xml version=\"1.0\" encoding=\"UTF-8\" ?-->\n" +
                "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  <students> \n" +
                "   <student number=\"heima_0001\"> \n" +
                "    <name>\n" +
                "     zhangsan\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     28\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     female\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "   <student number=\"heima_0002\"> \n" +
                "    <name>\n" +
                "     Morty\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     45\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     male\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "  </students> \n" +
                "  <!--<!DOCTYPE students [\n" +
                "\n" +
                "\t\t<!ELEMENT students (student+) >\n" +
                "\t\t<!ELEMENT student (name,age,sex)>\n" +
                "\t\t<!ELEMENT name (#PCDATA)>\n" +
                "\t\t<!ELEMENT age (#PCDATA)>\n" +
                "\t\t<!ELEMENT sex (#PCDATA)>\n" +
                "\t\t<!ATTLIST student number ID #REQUIRED>\n" +
                "\n" +
                "\n" +
                "\t\t]>--> \n" +
                "  <!--<students>--> \n" +
                "  <!--\t<student number=\"s001\">--> \n" +
                "  <!--\t\t<name>zhangsan</name>--> \n" +
                "  <!--\t\t<age>abc</age>--> \n" +
                "  <!--\t\t<sex>hehe</sex>--> \n" +
                "  <!--\t</student>--> \n" +
                "  <!--\t<student number=\"s002\">--> \n" +
                "  <!--\t\t<name>lisi</name>--> \n" +
                "  <!--\t\t<age>24</age>--> \n" +
                "  <!--\t\t<sex>female</sex>--> \n" +
                "  <!--\t</student>--> \n" +
                "  <!--</students>-->\n" +
                " </body>\n" +
                "</html>\n";
        Document parse = Jsoup.parse(str);
        System.out.println(parse);*/
    }
}
