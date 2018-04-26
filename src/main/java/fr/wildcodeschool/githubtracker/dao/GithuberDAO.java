package fr.wildcodeschool.githubtracker.dao;
//package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.util.List;

public interface GithuberDAO {
    List<Githuber> getGithubers();
}