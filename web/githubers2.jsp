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
            <ul class="list-group">
                <c:forEach items="${githubUsers}" var="githuber" >
                    <li class="list-group-item"> login : ${githuber.login} </li>
                </c:forEach>
            </ul>


            <div class="container">
                <div class="row no-collapse-1">
                    <section class="4u"> <a href="#" class="image featured"><img src="Phase%20Shift%20by%20TEMPLATED_fichiers/pic01.jpg" alt=""></a>
                        <div class="box">
                            <p>Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue rutrum  wisi maecenas ligula.</p>
                            <a href="#" class="button">Read More</a> </div>
                    </section>
                </div>
            </div>


        </div>
    </div>
</div><%--fluid-container--%>


</body>
</html>
