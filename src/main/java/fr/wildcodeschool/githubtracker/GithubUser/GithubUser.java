package fr.wildcodeschool.githubtracker.GithubUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.wildcodeschool.githubtracker.RandomUserBean.Info;
import fr.wildcodeschool.githubtracker.RandomUserBean.Results;

import java.util.List;

//@JsonIgnoreProperties({"gravatar_id"})
public class GithubUser {

    private String login;

    public String getLogin() { return this.login; }

    public void setLogin(String login) { this.login = login; }

    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String avatar_url;

    public String getavatar_url() { return this.avatar_url; }

    public void setavatar_url(String avatar_url) { this.avatar_url = avatar_url; }

    private String gravatar_id;

    public String getGravatar_id() { return this.gravatar_id; }

    public void setGravatar_id(String gravatar_id) { this.gravatar_id = gravatar_id; }

    private String url;

    public String getUrl() { return this.url; }

    public void setUrl(String url) { this.url = url; }

    private String html_url;

    public String getHtml_url() { return this.html_url; }

    public void setHtml_url(String html_url) { this.html_url = html_url; }

    private String followers_url;

    public String getFollowers_url() { return this.followers_url; }

    public void setFollowers_url(String followers_url) { this.followers_url = followers_url; }

    private String following_url;

    public String getFollowing_url() { return this.following_url; }

    public void setFollowing_url(String following_url) { this.following_url = following_url; }

    private String gists_url;

    public String getGists_url() { return this.gists_url; }

    public void setGists_url(String gists_url) { this.gists_url = gists_url; }

    private String starred_url;

    public String getStarred_url() { return this.starred_url; }

    public void setStarred_url(String starred_url) { this.starred_url = starred_url; }

    private String subscriptions_url;

    public String getSubscriptions_url() { return this.subscriptions_url; }

    public void setSubscriptions_url(String subscriptions_url) { this.subscriptions_url = subscriptions_url; }

    private String organizations_url;

    public String getOrganizations_url() { return this.organizations_url; }

    public void setOrganizations_url(String organizations_url) { this.organizations_url = organizations_url; }

    private String repos_url;

    public String getRepos_url() { return this.repos_url; }

    public void setRepos_url(String repos_url) { this.repos_url = repos_url; }

    private String events_url;

    public String getEvents_url() { return this.events_url; }

    public void setEvents_url(String events_url) { this.events_url = events_url; }

    private String received_events_url;

    public String getReceived_events_url() { return this.received_events_url; }

    public void setReceived_events_url(String received_events_url) { this.received_events_url = received_events_url; }

    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private boolean site_admin;

    public boolean getSite_admin() { return this.site_admin; }

    public void setSite_admin(boolean site_admin) { this.site_admin = site_admin; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String company;

    public String getCompany() { return this.company; }

    public void setCompany(String company) { this.company = company; }

    private String blog;

    public String getBlog() { return this.blog; }

    public void setBlog(String blog) { this.blog = blog; }

    private String location;

    public String getLocation() { return this.location; }

    public void setLocation(String location) { this.location = location; }

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private String hireable;

    public String getHireable() { return this.hireable; }

    public void setHireable(String hireable) { this.hireable = hireable; }

    private String bio;

    public String getBio() { return this.bio; }

    public void setBio(String bio) { this.bio = bio; }

    private int public_repos;

    public int getPublic_repos() { return this.public_repos; }

    public void setPublic_repos(int public_repos) { this.public_repos = public_repos; }

    private int public_gists;

    public int getPublic_gists() { return this.public_gists; }

    public void setPublic_gists(int public_gists) { this.public_gists = public_gists; }

    private int followers;

    public int getFollowers() { return this.followers; }

    public void setFollowers(int followers) { this.followers = followers; }

    private int following;

    public int getFollowing() { return this.following; }

    public void setFollowing(int following) { this.following = following; }

    private String created_at;

    public String getCreated_at() { return this.created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    private String updated_at;

    public String getUpdated_at() { return this.updated_at; }

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }

}
