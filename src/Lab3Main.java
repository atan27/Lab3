import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Lab3Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String text) {
        Scanner sc = new Scanner(text);
        int count = 0;
        while (sc.hasNext()) {
            sc.next();
            count ++;
        }
        return count;
    }

    public static int countOneWord(final String txt, String word) {
        Scanner s = new Scanner(txt);
        int c = 0;
        while (s.hasNext()) {
            String w = s.next();
            if (w.equalsIgnoreCase(word)) {
                c += 1;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("Run");
        String text1 = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String text2 = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String text3 = urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        System.out.println(wordCount(text1));
        System.out.println(wordCount(text2));
        System.out.println(wordCount(text3));
        System.out.println(countOneWord(text1, "prince"));
    }
}
