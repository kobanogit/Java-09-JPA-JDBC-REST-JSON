package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDao;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})
public class GithubersServlet extends javax.servlet.http.HttpServlet {

//    private @Inject GithubersService githuberService;
    private @Inject MemoryGithuberDao memoryGithuberDao;

    /*public GithubersServlet(GithubersService githubersService){
//        githuberDAO = new DumbGithuberDAO();
//        githuberService = new GithubersService(githuberDAO);
        this.githuberService = githubersService;
    }*/

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

//        List<Githuber> githuberDAOList = githuberDAO.getGithubers();

        // Initialisation avec 5 githubers
        if(memoryGithuberDao.getGithubers().isEmpty()) {
            memoryGithuberDao.saveGithuber(memoryGithuberDao.parseGithuber("kevwil"));
            memoryGithuberDao.saveGithuber(memoryGithuberDao.parseGithuber("anotherjesse"));
            memoryGithuberDao.saveGithuber(memoryGithuberDao.parseGithuber("ezmobius"));
            memoryGithuberDao.saveGithuber(memoryGithuberDao.parseGithuber("wayneeseguin"));
            memoryGithuberDao.saveGithuber(memoryGithuberDao.parseGithuber("KirinDave"));
        }

        List<Githuber> gitList = memoryGithuberDao.getGithubers();
        request.setAttribute("githubers", gitList);
        this.getServletContext().getRequestDispatcher("/githubers.jsp").forward(request, response);

    }
}
