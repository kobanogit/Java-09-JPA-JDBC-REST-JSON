package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@ApplicationScoped // ??
public class GithubUtils {

    @Inject private ObjectMapper om;

    public Githuber parseGithuber(String login){
        Githuber githubUser = new Githuber();
        if(login.getClass().equals(String.class) && login != null){
            String url = "https://api.github.com/users/" + login;
            try {
                om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                InputStream stream = new URL(url).openStream();
                githubUser = om.readValue(stream, Githuber.class);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            githubUser = null;
        }
        return githubUser;
    }
}
