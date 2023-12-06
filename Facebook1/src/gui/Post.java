package gui;

import javax.swing.*;
import gui.posting.CommentGui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Post extends JFrame {

    public Post(String userID, String ID) {

        String postId = ID;
        setTitle("Post");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ResultSet post = getPost(postId);

        // Panel creation
        JPanel panel = new JPanel(new BorderLayout());

        try {
            // ResultSet에서 데이터 읽기
            if (post.next()) {
                String post_id = post.getString("post_ID");
                String author = post.getString("author_ID");
                String body_text = post.getString("body_text");
                String date = post.getString("post_date");

                // Create a panel for post details
                JPanel detailsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                detailsPanel.add(new JLabel("Author: " + author));
                detailsPanel.add(new JLabel("Date: " + date));

                // Create a JTextArea for post content
                JTextArea contentTextArea = new JTextArea(body_text);
                contentTextArea.setWrapStyleWord(true);
                contentTextArea.setLineWrap(true);
                contentTextArea.setOpaque(false);
                contentTextArea.setEditable(false);
                contentTextArea.setFocusable(false);

                // Create a scroll pane for content
                JScrollPane contentScrollPane = new JScrollPane(contentTextArea);
                contentScrollPane.setPreferredSize(new Dimension(500, 200));

                // Create a panel for buttons
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                // "Comments" button
                JButton commentButton = new JButton("Comments");
                commentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Open the CommentGui window
                        SwingUtilities.invokeLater(() -> {
                            CommentGui commentGui = new CommentGui(userID, postId);
                            commentGui.setVisible(true);
                        });
                    }
                });

                // "Likes" button
                JButton likesButton = new JButton("Likes");
                likesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Open the LikesWindow
                        SwingUtilities.invokeLater(() -> new LikesWindow(userID, postId));
                    }
                });

                // "Like" button
                JButton likeButton = new JButton("Like");
                likeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle post liking functionality
                        SwingUtilities.invokeLater(() -> new LikePost(userID, postId));
                    }
                });

                buttonPanel.add(commentButton);
                buttonPanel.add(likesButton);
                buttonPanel.add(likeButton);

                // Add components to the main panel
                panel.add(detailsPanel, BorderLayout.NORTH);
                panel.add(contentScrollPane, BorderLayout.CENTER);
                panel.add(buttonPanel, BorderLayout.SOUTH);
            }

            // Add the main panel to the frame
            add(panel);

            // Frame visibility
            setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getPost(String ID) {
        // JDBC connection information
        String jdbcUrl = "jdbc:mysql://localhost:3306/facebook";
        String username = "root";
        String password = "sophia0115";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Execute SQL query
            String query = "SELECT * FROM post WHERE post_ID = '" + ID + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Return the ResultSet
            return resultSet;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Return null in case of an error
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Post("66661", "99995");
        });
    }
}
