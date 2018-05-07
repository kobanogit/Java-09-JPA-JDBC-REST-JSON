package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Named("MemoryGithuberDao")
public class MemoryGithuberDao implements GithuberDAO{

    private static List <Githuber> githubers = new ArrayList<>();

    @Inject
    private ObjectMapper om;

    @Override
    public List<Githuber> getGithubers() {
//        List<Githuber> githubersList = new ArrayList<>();

//        List<Githuber> list = new ArrayList<Githuber>(githuberLoginMap.values());

//        System.out.println(list);
//        List<String> githubersToFindByLogin = new ArrayList();
//        githubersToFindByLogin.add("kevwil");
//        githubersToFindByLogin.add("anotherjesse");
//        githubersToFindByLogin.add("fanvsfan");
//        githubersToFindByLogin.add("railsjitsu");
//        githubersToFindByLogin.add("KirinDave");

//        for(Githuber githuber : list){
//            githubersList.add(parseGithuber(githuberLogin));
//        }

        return githubers;
    }

    @PostConstruct
    @Override
    public void saveGithuber(Githuber githuber) {
        if(githuber.getLogin() != null) {
//            githuberLoginMap.put(githuber.getName(), githuber);
            githubers.add(githuber);
//            System.out.println(Arrays.toString(githuberLoginMap.entrySet().toArray()));

        }
    }

    public Githuber parseGithuber(String login){
        Githuber githubUser = new Githuber();
        if(login.getClass().equals(String.class) && login != null){
            String url = "https://api.github.com/users/" + login;
            try {
                om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                InputStream stream = new URL(url).openStream();
                githubUser = om.readValue(stream, Githuber.class);
//                System.out.println(githubUser.getLogin());
//                if (githubUser.getName() == null) githubUser = null;
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
