package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.GithubUser.GithubUser;
//import fr.wildcodeschool.githubtracker.RandomUserBean.RandomUser;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.stream.Stream;

public class DaoGithuber {

    public DaoGithuber(){
//        run();
    }

    public static void main(String[] args) {
        DaoGithuber daoGithuber = new DaoGithuber();
//        daoGithuber.run();
//        daoGithuber.getGithubUserFromLogin("kobanogit");
        GithubUser githubUser = daoGithuber.getGithubUserFromLogin("kobanogit");
        System.out.println(githubUser);
    }

    /*public GithubUser getGithubUserRandom(){
        GithubUser githubUser = new GithubUser();
        return githubUser;
    }*/

    public GithubUser getGithubUserFromLogin(String login){
        GithubUser githubUser = new GithubUser();

        if(login.getClass().equals(String.class)
                && StringUtils.isNotBlank(login)
                && login != null){

            String url = "https://api.github.com/users/" + login;
            githubUser = get(url);

        }

        return githubUser;
    }

//    public GithubUser getGithubUserFromId(int id){
//        GithubUser githubUser = new GithubUser();
//        return githubUser;
//    }

    private GithubUser get(String url){
        ObjectMapper mapper = new ObjectMapper();

//        String url = url;
        GithubUser githubUser = new GithubUser();


        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


            // Convert JSON string from file to Object
            InputStream stream = new URL(url).openStream();
            githubUser = mapper.readValue(stream, GithubUser.class);
//            System.out.println(githubUser);



            // Convert JSON string to Object
//            String jsonInString = "{" +
//                    "\"login\": \"kobanogit\",\n" +
//                    "  \"id\": 19733351,\n" +
//                    "  \"avatar_url\": \"https://avatars3.githubusercontent.com/u/19733351?v=4\"}";
//            githubUser = mapper.readValue(jsonInString, GithubUser.class);
//            System.out.println(githubUser);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return githubUser;
    }

    /*private RandomUser run() {
        ObjectMapper mapper = new ObjectMapper();

        String url = "https://randomuser.me/api/";
        RandomUser randomUser = new RandomUser();

//        String url = "https://randomuser.me/api/";
//        GithubUser githubUser = new GithubUser();

        try {
            ObjectMapper mapperInit = new ObjectMapper();
            mapperInit.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            // https://randomuser.me/api/

            // Convert JSON string from file to Object

            // RandomUser API
            randomUser = mapper.readValue(new URL(url).openStream(), RandomUser.class);
            System.out.println(randomUser);

            // Github API
//            githubUser = mapper.readValue(new URL(url).openStream(), GithubUser.class);
//            System.out.println(githubUser);



            // Convert JSON string to Object
//            String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
//            Staff staff1 = mapper.readValue(jsonInString, Staff.class);
//            System.out.println(staff1);

            //Pretty print
//            String githuberContainer = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(githuberContainer);
//            System.out.println(githuberContainer);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomUser;
    }*/

}
