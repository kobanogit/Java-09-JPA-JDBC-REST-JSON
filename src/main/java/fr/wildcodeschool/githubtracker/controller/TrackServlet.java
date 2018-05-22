package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "TrackServlet", urlPatterns = {"/track"})
public class TrackServlet extends javax.servlet.http.HttpServlet {

    @Inject
    private GithubUtils gu;

    @Inject
    private GithubersService githubersService;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String login = request.getParameter("login");

        Githuber newGithuber = gu.parseGithuber(login);
        if(newGithuber.getLogin() == null){
            request.setAttribute("info", "Githuber login \" " + login + " \" doesn't exist.");
            this.getServletContext().getRequestDispatcher("/loginSearch.jsp").forward(request, response);
        }else{
            githubersService.track(login);
            response.sendRedirect("./githubers");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/loginSearch.jsp").forward(request, response);
    }
}
