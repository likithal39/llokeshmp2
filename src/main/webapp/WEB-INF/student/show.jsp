<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="/WEB-INF/templates/header.jspf" %>

<c:if test="${not empty messages}">
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <ul>
            <c:forEach items="${messages}" var="msg">
                <li>
                    <strong>Warning!</strong><c:out value="${msg.key} has an error of ${msg.value}"/>
                </li>
            </c:forEach>
        </ul>
    </div>
</c:if>


<table class="table">
    <thead>
        <tr>
            <th>student ID</th>
            <th>First Name</th>
            <th>Last Name </th>
            <th>Address   </th>

        </tr>
    </thead>
    <tbody>
    <body bgcolor="#E6E6FA">
        <c:forEach items="${requestScope.stud}" var="row">
        <tr>
            <c:url value="${request.contextPath}/student/edit" var="editStudentURL">
                <c:param name="studentID" value="${row.studentID}"/>
            </c:url>

            <c:url value="${request.contextPath}/student/delete" var="delStudentURL">
                <c:param name="studentID" value="${row.studentID}"/>
            </c:url>

            <td><a href="${editStudentURL}">${row.studentID}</a></td>    
            <td><c:out value="${row.firstName}"/></td>
            <td><c:out value="${row.lastName}"/></td>
            <td><c:out value="${row.address}"/></td>

            <td><a href="${delStudentURL}">Delete</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>
<h5><a href="<c:url value="/index.jsp"/>">Home page</a></h5>
<%@include file="/WEB-INF/templates/footer.jspf" %>
