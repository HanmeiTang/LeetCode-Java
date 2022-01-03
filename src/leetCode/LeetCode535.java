package leetCode;
import java.util.*;
public class LeetCode535 {
}

class Codec {

    Random rand = new Random();
    int URL_LEN = 6;
    double RATE = 0.3; // increase URL_LEN by 1 if RATE achieved

    Map<String, String> getLong = new HashMap<>();
    Map<String, String> getShort = new HashMap<>();

    String head = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        longUrl = longUrl.replaceAll("http[s]*://", "");

        if (getShort.containsKey(longUrl)) {
            return head + getShort.get(longUrl);
        }

        String shortUrl = randStr();
        getLong.put(shortUrl, longUrl);
        getShort.put(longUrl, shortUrl);

        return head + getShort.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replaceAll("http[s]*://", "");
        return getLong.get(shortUrl);
    }

    private String randStr() {
        checkSpace();

        char[] arr = new char[URL_LEN];
        for (int i = 0; i < URL_LEN; i++) {
            arr[i] = getChar(rand.nextInt(62));
        }

        String shortUrl = new String(arr);
        while (getLong.containsKey(shortUrl)) {
            shortUrl = randStr();
        }

        return shortUrl;
    }


    // 0 - 61
    private char getChar(int count) {
        count %= 62;

        if (count <= 9) return (char) ('0' + count);
        else if (count <= 35) return (char) ('a' + count);
        else return (char) ('A' + count);
    }

    private void checkSpace() {
        long limit = (long) (Math.pow(62, URL_LEN) * RATE);
        if ((long) getLong.size() > limit) URL_LEN++;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));


/*

1. long url
    1. check exists or not
    2. generate a new shortUrl
2. short url
    look up

Map<s, l>
Map<l, s>
s -> 6 char long
l -> anything
*/