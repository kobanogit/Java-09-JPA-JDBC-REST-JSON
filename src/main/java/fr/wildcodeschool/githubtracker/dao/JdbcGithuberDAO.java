package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.Resource;
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

    List<Githuber> githuberList;

    // Connection pool "myPool" :
    @Resource(lookup = "myPool")
    private DataSource dataSource;



    @Override
    public List<Githuber> getGithubers() {
        githuberList = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;

        try(Connection conn = dataSource.getConnection()){
            statement = conn.createStatement();
            String myQuery = "select * from githuber";
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
        }

        return githuberList;
    }



    @Override
    public void saveGithuber(Githuber githuber) {
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try(Connection conn = dataSource.getConnection()){
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
        }

    }

    @Override
    public void deleteGithuber(int id) {
        Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try(Connection conn = dataSource.getConnection()){
                statement = conn.createStatement();
                String query = "DELETE FROM githuber WHERE id = ?";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
