<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

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

<c:choose>
    <c:when test="${not empty requestScope.stud}">
        <h1>${requestScope.stud.studentID}</h1>

        <form role="form" method="post" action="${pageContext.request.contextPath}/student/edit">
           
        </c:when>
        <c:otherwise>
            <form role="form" method="post" action="${pageContext.request.contextPath}/student/new">

            </c:otherwise>
               
        </c:choose>
                <body>
                    
        <body bgcolor="#E6E6FA">
         <div class="row">
            <div class="large-4 columns">
                <label>Student ID
                    <input type="text" placeholder="student ID" id="studentId" name="studentID" value="${stud.studentID}" />
                </label>
            </div>
            <div class="large-4 columns">
                <label>First Name
                    <input type="text" placeholder="First Name" id="firstName" name="firstName" value="${stud.firstName}"/>
                </label>
            </div>
            <div class="large-4 columns">
                <label>Last Name
                    <input type="text" placeholder="Last Name" id="lastName" name="lastName" value="${stud.lastName}"/>
                </label>
            </div>
        </div>
        
               
        <div class="row">
            <div class="large-12 columns">
                <label>Address
                    <textarea id="address" name="address" placeholder="address" value="${stud.address}"></textarea>
                </label>
            </div>
        </div>

        <c:if test="${requestScope.readonly ne 'readonly'}">
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Save</button>
                </div>
            </div>
        </c:if>
    </form>
        </body>
    <%@include file="/WEB-INF/footer.jspf" %>