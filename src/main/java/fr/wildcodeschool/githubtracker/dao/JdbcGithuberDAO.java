package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@InDatabase
public class JdbcGithuberDAO implements GithuberDAO{

//    @Inject
//    ConnectionProducer connectionProducer;

    List<Githuber> githuberList = new ArrayList<>();

    /*private Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/githubtracker?user=newuser&password=password");
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }*/

    public static final String URL = "jdbc:mysql://localhost:3306/githubtracker";
    public static final String USER = "newuser";
    public static final String PASS = "password";



    /*public static Connection getConnection(){
    // Version de base
        try {
            Class<?> driverClass = null;
            driverClass = Class.forName("com.mysql.jdbc.Driver");

            Driver driverInstance = (Driver) driverClass.newInstance();
//DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public Connection getConnection(){
        Connection connection = null;
        try{
            DataSource ds = (DataSource) new InitialContext().lookup("myPool");
            connection = ds.getConnection();

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }



    @Override
    public List<Githuber> getGithubers() {
        Statement statement = null;
        ResultSet rs = null;

        try{
            Connection conn = getConnection();
            try {
                statement = conn.createStatement();
                String myQuery = "select * from githuber";
//                String myQuery = "INSERT INTO githuber (github_id, name, login, url, email, bio, location, avatar_url) VALUES (583231, 'The Octocat', 'octocat', 'https://api.github.com/users/octocat', 'null', 'null', 'San Francisco', 'https://avatars3.githubusercontent.com/u/583231?v=4')";
                rs = statement.executeQuery(myQuery);
                while (rs.next()) {
                    githuberList.add(new Githuber(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("login"),
                            rs.getString("avatar_url"),
                            rs.getString("url"),
                            rs.getString("bio"),
                            rs.getString("location"),
                            rs.getInt("id"),
                            rs.getInt("github_id")
                    ));
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) {};
                try { if (statement != null) statement.close(); } catch (Exception e) {};
                try { if (conn != null) conn.close(); } catch (Exception e) {};
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return githuberList;
    }



    @Override
    public void saveGithuber(Githuber githuber) {
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try{
            Connection conn = getConnection();
            try {
                statement = conn.createStatement();
                String query = "INSERT INTO githuber (github_id, name, login, url, email, bio, location, avatar_url) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, githuber.getGithub_id());
                preparedStatement.setString(2, githuber.getName());
                preparedStatement.setString(3, githuber.getLogin());
                preparedStatement.setString(4, githuber.getUrl());
                preparedStatement.setString(5, githuber.getEmail());
                preparedStatement.setString(6, githuber.getBio());
                preparedStatement.setString(7, githuber.getLocation());
                preparedStatement.setString(8, githuber.getAvatarUrl());
                preparedStatement.executeUpdate();
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) {};
                try { if (statement != null) statement.close(); } catch (Exception e) {};
                try { if (conn != null) conn.close(); } catch (Exception e) {};
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGithuber(int id) {
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try{
            Connection conn = getConnection();
            try {
                statement = conn.createStatement();
                String query = "DELETE FROM githuber WHERE id = ?";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) {};
                try { if (statement != null) statement.close(); } catch (Exception e) {};
                try { if (conn != null) conn.close(); } catch (Exception e) {};
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
