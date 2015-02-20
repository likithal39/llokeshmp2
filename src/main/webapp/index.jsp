

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Student Portal</title>
    <h1>Welcome to student portal</h1>
    <h2>select the below options</h2>
    <body>
        <body bgcolor="#90EE90">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    
        <c:if test="${not empty requestScope.messages}">
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <ul>
                    <c:forEach items="${requestScope.messages}" var="msg">
                        <li>
                            <strong><c:out value="${msg.key}: ${msg.value}"/></strong>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <c:if test="${not empty requestScope.violations}">
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <ul>
                    <c:forEach items="${requestScope.violations}" var="violation">
                        <li>
                            <strong><c:out value="${violation.message}"/></strong>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <ul>
            <li><a href="${pageContext.request.contextPath}/student/">Display all Students</a></li>
            <li><a href="${pageContext.request.contextPath}/student/new">Add New Student</a></li>
         
        </ul>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    </body>
</html>
<%@include file="/WEB-INF/footer.jspf" %>