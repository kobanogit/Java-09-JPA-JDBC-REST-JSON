package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.InDatabase;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService {

    @Inject
    @InDatabase
    private GithuberDAO githuberDao;

    @Inject
    private GithubUtils gu;

    /*@Inject
    public GithubersService(@InMemory GithuberDAO githuberDao){
        this.githuberDao = githuberDao;
    }*/


    /*public List<Githuber> getAllGithubers(){
        return githuberDao.getGithubers();
    }*/

    public List<Githuber> getGithubers(){
        return githuberDao.getGithubers();
    }

    public Githuber getGithuber(String login){
        Githuber githuberFound = new Githuber();
        for(Githuber githuber: this.githuberDao.getGithubers()){
            if(githuber.getName().equals(login))
                githuberFound =  githuber;
        }
        return githuberFound;
    }

    public void track(String login){
        // Si githuber absent de la BDD
        // Ajout dans la BDD
        // renvoi de la liste complète dans tous les cas
        List<Githuber> githuberList = this.getGithubers();
        boolean githuberExistsInBdd = false;
        for (Githuber githuber : githuberList){
            githuberExistsInBdd = (githuber.getLogin() == login) ? true: false;
        }
        if (!githuberExistsInBdd){
            // Création objet Githuber si existant sur repo distant
            Githuber newGithuber = gu.parseGithuber(login);
            // Enregistrement en BDD
            githuberDao.saveGithuber(newGithuber);
        }

    }
}
