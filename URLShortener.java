import javax.swing.*;
import java.awt.event.*;

public class URLShortener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("URL Shortener");
        JPanel panel = new JPanel();
        JTextField longURLField = new JTextField(20);
        JButton shortenButton = new JButton("Shorten");
        JLabel resultLabel = new JLabel("Shortened URL will appear here.");

        shortenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String longURL = longURLField.getText();
                // Logic to shorten the URL
                String shortenedURL = shortenURL(longURL);
                resultLabel.setText("Shortened URL: " + shortenedURL);
            }
        });

        panel.add(new JLabel("Enter Long URL:"));
        panel.add(longURLField);
        panel.add(shortenButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method to simulate URL shortening (Replace this with actual URL shortening logic)
    public static String shortenURL(String longURL) {
        // Simulated shortening logic
        return "http://short.url/" + Math.abs(longURL.hashCode() % 10000);
    }
}
