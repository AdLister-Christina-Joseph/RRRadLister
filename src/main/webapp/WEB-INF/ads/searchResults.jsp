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
<br>
<br>
<div class="card mx-auto bg-dark">
    <div class="card-header">
        <h2>Search Results:</h2>
    </div>
    <ul class="list-group list-group-flush bg-dark">

        <c:forEach var="adResults" items="${adResults}">
            <li class="list-group-item bg-dark">

                <a href="/individualAd?id=${adResults.id}"><h6><i class="fa-solid fa-recycle"></i>  ${adResults.title}</h6></a>
            </li>
        </c:forEach>

    </ul>
</div>

<br>
<br>
<br>
<br>
<br>
<br>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
