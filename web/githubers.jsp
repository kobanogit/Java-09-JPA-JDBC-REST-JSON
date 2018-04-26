<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.wildcodeschool.githubtracker.model.Githuber" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--JSTL Library --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:directive.include file="header.jsp" />
<div class="fluid-container">
    <header class="row">
        <div class="col-lg-12">
            <h1>Githubers list</h1>
        </div>
    </header>
    <div  class="row">
        <div class="col-lg-12">
            <h2>JSTL Version : </h2>
            <ul class="list-group">
                <c:forEach items="${githubers}" var="githuber" >
                    <li class="list-group-item"> ${githuber.name} </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div><%--fluid-container--%>


</body>
</html>
