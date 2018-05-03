package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Githuber {
//    @JsonProperty("name")
    private String name;

//    @JsonProperty("email")
    private String email;

//    @JsonProperty("login")
    private String login;

//    @JsonProperty("avatarUrl")
    private String avatarUrl;

//    @JsonProperty("id")
    int id;

    public Githuber() {
    }

    @JsonCreator
    public Githuber(@JsonProperty("name") String name, @JsonProperty("email") String email,
                    @JsonProperty("login") String login, @JsonProperty("avatarUrl") String avatarUrl,
                    @JsonProperty("id") int id) {
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
