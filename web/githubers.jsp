<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.wildcodeschool.githubtracker.model.Githuber" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--JSTL Library --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:directive.include file="header.jsp" />
    <div class="container">
        <header class="row">
            <div class="col-lg-12">
                <h1>Githubers list</h1>
            </div>
        </header>
        <div  class="row">
            <div class="col-lg-12">
                <ul class="list-group">
                    <c:forEach items="${githubers}" var="githuber" >
                        <li class="list-group-item">
                            <a href="https://github.com/${githuber.login}" target="_blank">
                                <img src="${githuber.avatarUrl}" alt="avatar" style="max-width:30px;">
                            </a>
                            <a href="https://github.com/${githuber.login}">${githuber.name}</a>
                            <form action="untrack" method="post" style="float:right;">
                                <input type="hidden" class="form-control" id="id" name="id"
                                       aria-describedby="loginHelp" value="${githuber.id}">
                                <button type="submit" class="btn btn-danger">
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            </form>
                            <div style="clear:both;"></div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>


</body>
</html>
