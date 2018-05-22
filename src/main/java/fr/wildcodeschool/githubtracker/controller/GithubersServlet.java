package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})
public class GithubersServlet extends javax.servlet.http.HttpServlet {

    @Inject
    @InMemory
    private GithuberDAO memoryGithuberDao;

    @Inject
    private GithubUtils gu;

    @Inject
    private GithubersService githubersService;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // Initialisation avec 5 githubers
        if(githubersService.getAllGithubers().isEmpty()) {
            memoryGithuberDao.saveGithuber(gu.parseGithuber("TomBtz"));
            memoryGithuberDao.saveGithuber(gu.parseGithuber("sebaurel"));
            memoryGithuberDao.saveGithuber(gu.parseGithuber("JulTorres"));
            memoryGithuberDao.saveGithuber(gu.parseGithuber("loloof64"));
            memoryGithuberDao.saveGithuber(gu.parseGithuber("xpdemon"));
            memoryGithuberDao.saveGithuber(gu.parseGithuber("devart"));
            memoryGithuberDao.saveGithuber(gu.parseGithuber("kobanogit"));
        }

        List<Githuber> gitList = githubersService.getAllGithubers();

        request.setAttribute("githubers", gitList);
        this.getServletContext().getRequestDispatcher("/githubers.jsp").forward(request, response);

    }
}
