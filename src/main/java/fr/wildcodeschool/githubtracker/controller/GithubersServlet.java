package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})
public class GithubersServlet extends javax.servlet.http.HttpServlet {

    private @Inject GithubersService githuberService;

    /*public GithubersServlet(GithubersService githubersService){
//        githuberDAO = new DumbGithuberDAO();
//        githuberService = new GithubersService(githuberDAO);
        this.githuberService = githubersService;
    }*/

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

//        List<Githuber> githuberDAOList = githuberDAO.getGithubers();

        List<Githuber> gitList = githuberService.getAllGithubers();
        request.setAttribute("githubers", gitList);
        System.out.println("gitlist : " + gitList);
        this.getServletContext().getRequestDispatcher("/githubers.jsp").forward(request, response);

    }
}
