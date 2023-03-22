<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <br>

    <div class="card mx-auto bg-dark">
        <div class="card-header">
            <h3>All current ads:</h3>
        </div>
        <ul class="list-group list-group-flush bg-dark">

            <c:forEach var="ad" items="${ads}">
                <li class="list-group-item bg-dark">
                    <a href="/individualAd?id=${ad.id}"><h6><i class="fa-solid fa-recycle"></i>  ${ad.title}</h6></a>
            </li>
            </c:forEach>

        </ul>
    </div>



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
