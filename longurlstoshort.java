import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class URLShortener {
    private Map<String, String> urlMap;
    private MessageDigest digest;

    public URLShortener() {
        this.urlMap = new HashMap<>();
        try {
            this.digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String shortenURL(String longURL) {
        String shortURL = generateShortURL(longURL);
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        return urlMap.getOrDefault(shortURL, "URL not found");
    }

    private String generateShortURL(String longURL) {
        byte[] hash = digest.digest(longURL.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().substring(0, 8); // Adjust length as needed
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String longURL = "https://www.example.com";

        String shortURL = shortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);

        String expandedURL = shortener.expandURL(shortURL);
        System.out.println("Expanded URL: " + expandedURL);
    }
}
