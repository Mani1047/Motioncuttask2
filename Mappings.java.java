import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class URLShortener {
    private static final String HASH_ALGORITHM = "SHA-256";

    public static String shortenURL(String longURL) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = digest.digest(longURL.getBytes(StandardCharsets.UTF_8));

            // Use Base64 encoding to represent the hash as a shorter string
            return Base64.getUrlEncoder().encodeToString(hashBytes).substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Example usage
        String longURL = "https://www.example.com";
        String shortURL = shortenURL(longURL);
        System.out.println("Long URL: " + longURL);
        System.out.println("Shortened URL: " + shortURL);
    }
}
