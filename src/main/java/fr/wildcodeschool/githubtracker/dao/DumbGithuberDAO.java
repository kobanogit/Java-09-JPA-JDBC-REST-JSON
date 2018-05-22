package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Dependent
public class DumbGithuberDAO implements GithuberDAO {

    @Override
    public List<Githuber> getGithubers() {
        List<Githuber> githubers = new ArrayList<Githuber>();
        /*githubers.add(new Githuber("Githuber1", "email1@wcs.fr", "login1", "avatarUrl1", 1, 1));
        githubers.add(new Githuber("Githuber2", "email2@wcs.fr", "login2", "avatarUrl2", 2, 2));
        githubers.add(new Githuber("Githuber3", "email3@wcs.fr", "login3", "avatarUrl1", 3, 3));
        githubers.add(new Githuber("Githuber4", "email4@wcs.fr", "login4", "avatarUrl4", 1, 4));
        githubers.add(new Githuber("Githuber5", "email5@wcs.fr", "login5", "avatarUrl5", 1, 5));*/

        // make the list unmodifiable
        List<Githuber> immutableGithubersList = Collections.unmodifiableList(githubers);

        return immutableGithubersList;
    }

    @Override
    public void saveGithuber(Githuber githuber) throws UnsupportedOperationException{

    }
}
