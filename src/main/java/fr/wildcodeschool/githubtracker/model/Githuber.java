package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Githuber {
    private String name, email, login, avatarUrl, url, bio, location;
    private int id, github_id;


    public Githuber() {
    }

    @JsonCreator
    public Githuber(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("login") String login,
            @JsonProperty("avatar_url") String avatarUrl,
            @JsonProperty("url") String url,
            @JsonProperty("bio") String bio,
            @JsonProperty("location") String location,
            @JsonProperty("id") int id,
            @JsonProperty("github_id") int github_id) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.url = url;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.location = location;
        this.id = id;
        this.github_id = github_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGithub_id() { return github_id; }

    public void setGithub_id(int github_id) { this.github_id = github_id; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getBio() { return bio; }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
