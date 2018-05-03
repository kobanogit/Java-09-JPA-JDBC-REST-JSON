package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class GithubersService {
    private GithuberDAO githuberDao;

    @Inject
    public GithubersService(@Named("MemoryGithuberDao") GithuberDAO githuberDao){
        this.githuberDao = githuberDao;
    }

    public List<Githuber> getAllGithubers(){
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
        // TODO
    }
}
