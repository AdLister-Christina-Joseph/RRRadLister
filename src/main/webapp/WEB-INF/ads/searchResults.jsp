<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Please Log In" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Search Results:</h1>
    <c:forEach var="adResults" items="${adResults}">
        <div class="col-md-6">
            <h2>${adResults.title}</h2>
            <p>${adResults.description}</p>
<%--            <p>${adResults.userId}</p>--%>
        </div>
    </c:forEach>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
