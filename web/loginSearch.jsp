<%--
  Created by IntelliJ IDEA.
  User: wilder
  Date: 06/05/18
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>LoginSearch</title>
</head>
<body>--%>

<%--JSTL Library --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:directive.include file="header.jsp" />
    <div class="container">
        <div  class="row">
            <div class="col-lg-12">
                <form action="track" method="post">
                    <c:if test="${!empty info}">
                        <div class="alert alert-danger" role="alert">
                                ${info}
                        </div>
                    </c:if>

                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" id="login" name="login" aria-describedby="loginHelp">
                        <small id="loginHelp" class="form-text text-muted">Enter the
                            <a href="https://api.github.com/users" target=""_blank">login</a> to search for.</small>
                    </div>

                    <button type="submit" class="btn btn-primary">Add</button>
                    <%--login : <input type="text" name="login" id="login">--%>
                    <%--<input type="submit" value="Submit">--%>
                    <%--<p>${info}</p>--%>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
