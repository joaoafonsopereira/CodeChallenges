import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    private static final String PRIME_LIST_URL = "https://en.wikipedia.org/wiki/List_of_prime_numbers";
    private static final String PRIME_LIST_FILE = "list-of-primes";

    private static void downloadPrimesList() throws Exception {
        Document doc = Jsoup.connect(PRIME_LIST_URL).get();
        Element table = doc.select(".wikitable").get(0);
        Elements rows = table.select("tr");

        int numEntries = (rows.size() - 1) * rows.get(1).select("td").size();
        List<Integer> primes = new ArrayList<>(numEntries);

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it
            Element row = rows.get(i);
            Elements cols = row.select("td");
            for (Element col : cols)
                primes.add(Integer.parseInt(col.text()));
        }

        FileOutputStream fos = new FileOutputStream(PRIME_LIST_FILE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(primes);
        oos.close();
        fos.close();
    }

    public static List<Integer> getPrimesList() {
        List<Integer> primes = new ArrayList<>();
        try {
            File plist = new File(PRIME_LIST_FILE);
            if(!plist.isFile())
                downloadPrimesList();

            FileInputStream fis = new FileInputStream(plist);
            ObjectInputStream ois = new ObjectInputStream(fis);

            primes = (ArrayList<Integer>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return primes;
    }

}
