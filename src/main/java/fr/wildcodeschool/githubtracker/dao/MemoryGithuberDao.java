package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Named("MemoryGithuberDao")
public class MemoryGithuberDao implements GithuberDAO{

    Map<String, Githuber> githuberLoginMap;

    @Override
    public List<Githuber> getGithubers() {
        List<Githuber> githubersList = new ArrayList<>();
        List<String> githubersToFindByLogin = new ArrayList();
        githubersToFindByLogin.add("kobanogit");
        for(String githuberLogin : githubersToFindByLogin){
            githubersList.add(parseGithuber(githuberLogin));
        }
        return null;
    }

    @PostConstruct
    @Override
    public void saveGithuber(Githuber githuber) {
        // Appelle les 5 githubers de Dumb
        // Ajout à la map
    }

    public Githuber parseGithuber(String login){
        Githuber githubUser = new Githuber();
        if(login.getClass().equals(String.class)
//                && StringUtils.isNotBlank(login)
                && login != null){
            String url = "https://api.github.com/users/" + login;
            ObjectMapper mapper = new ObjectMapper();
            try {
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                InputStream stream = new URL(url).openStream();
                githubUser = mapper.readValue(stream, Githuber.class);
                System.out.println("githubuser : " + githubUser);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return githubUser;
    }

}
