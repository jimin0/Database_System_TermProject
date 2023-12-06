package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class PostEditor {

    private String loggedInUserID; // Replace with the actual logged-in user ID

    public PostEditor(String loggedInUserID) {
        this.loggedInUserID = loggedInUserID;
    }

    public void savePostToDatabase(String postText) {
        String url = "jdbc:mysql://localhost:3306/facebook";
        String username = "root";
        String password = "sophia0115";
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO post (post_ID, post_date, body_text, author_ID) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Generate a random UUID for post_ID
                String postID = UUID.randomUUID().toString();
                // Current time stamp for post_date
                Timestamp postDate = new Timestamp(System.currentTimeMillis());
               
                preparedStatement.setString(1, postID);
                preparedStatement.setTimestamp(2, postDate);
                preparedStatement.setString(3, postText);
                preparedStatement.setString(4, loggedInUserID);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Post successfully uploaded.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred during post upload.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error.");
        }
    }
}
