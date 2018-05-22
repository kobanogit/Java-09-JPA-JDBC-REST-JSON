package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
@InMemory
public class MemoryGithuberDao implements GithuberDAO{

    private static List <Githuber> githubers = new ArrayList<>();

    @Override
    public List<Githuber> getGithubers() {
        return githubers;
    }

    @PostConstruct
    @Override
    public void saveGithuber(Githuber githuber) {
        if(githuber.getLogin() != null) {
            githubers.add(githuber);
        }
    }
}
