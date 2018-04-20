package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GithubersServlet", urlPatterns = {"/githubers"})
public class GithubersServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        List<Githuber> githubers = new ArrayList<Githuber>();
        githubers.add(new Githuber("Githuber1", "email1@wcs.fr", "login1", "avatarUrl1", 1));
        githubers.add(new Githuber("Githuber2", "email2@wcs.fr", "login2", "avatarUrl2", 2));
        githubers.add(new Githuber("Githuber3", "email3@wcs.fr", "login3", "avatarUrl1", 3));
        githubers.add(new Githuber("Githuber4", "email4@wcs.fr", "login4", "avatarUrl4", 1));
        githubers.add(new Githuber("Githuber5", "email5@wcs.fr", "login5", "avatarUrl5", 1));

        request.setAttribute("githubers", githubers);

        this.getServletContext().getRequestDispatcher("/githubers.jsp").forward(request, response);
    }
}
