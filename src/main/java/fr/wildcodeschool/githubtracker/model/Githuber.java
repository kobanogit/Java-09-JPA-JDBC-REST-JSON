package fr.wildcodeschool.githubtracker.model;

public class Githuber {
    private String name, email, login, avatarUrl;
    int id;

    public Githuber() {
    }

    public Githuber(String name, String email, String login, String avatarUrl, int id) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.id = id;
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
}
