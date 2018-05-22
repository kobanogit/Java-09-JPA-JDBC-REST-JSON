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

        // make the list unmodifiable
        List<Githuber> immutableGithubersList = Collections.unmodifiableList(githubers);

        return immutableGithubersList;
    }

    @Override
    public void saveGithuber(Githuber githuber) throws UnsupportedOperationException{}

    @Override
    public void deleteGithuber(int id) {}
}
