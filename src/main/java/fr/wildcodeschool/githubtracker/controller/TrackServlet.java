package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TrackServlet", urlPatterns = {"/track"})
public class TrackServlet extends javax.servlet.http.HttpServlet {

//    private @Inject GithubersService githuberService;
//    private @Inject MemoryGithuberDao memoryGithuberDao;
    @Inject
    @InMemory
    private GithuberDAO memoryGithuberDao;

    @Inject
    private GithubUtils gu;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String login = request.getParameter("login");

        System.out.println(login);
//        Githuber newGithuber = memoryGithuberDao.parseGithuber(login);
        Githuber newGithuber = gu.parseGithuber(login);
        System.out.println(newGithuber.getLogin());
        if(newGithuber.getLogin() == null){
            request.setAttribute("info", "Githuber login \" " + login + " \" doesn't exist.");
            this.getServletContext().getRequestDispatcher("/loginSearch.jsp").forward(request, response);
        }else{
            memoryGithuberDao.saveGithuber(newGithuber);
            response.sendRedirect("/githubers");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

//        memoryGithuberDao.saveGithuber(memoryGithuberDao.parseGithuber("kevwil"));
//        List<Githuber> gitList = memoryGithuberDao.getGithubers();
//        request.setAttribute("githubers", memoryGithuberDao.getGithubers());
//        System.out.println("githubers : " + gitList);
        this.getServletContext().getRequestDispatcher("/loginSearch.jsp").forward(request, response);

    }
}
