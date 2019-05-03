import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("https://yobit.net/ru/") .get();

        Elements trElements = doc.getElementsByAttributeValue("c2n", "BTC");

        trElements.forEach(trElement -> {
            Element tdElement = trElement.child(0);
            String name = tdElement.child(0).text();

            articleList.add(new Article(name));
        });

        articleList.forEach(System.out::println);
        }
    }
class Article {
    private String name;

    public Article(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                '}';
    }
}
