<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit an Ad"/>
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Edit an Ad</h1>
    <form action="/ads/edit?id=${ad.id}" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text"
                   value="<%= session.getAttribute("title") %>">
        </div>
        <%--<div class="form-group">
            <label for="location">Location</label>
            <input id="location" name="location" class="form-control" type="text"
                   value="<%= session.getAttribute("location") %>">
        </div>--%>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control"
                      type="text"><%= session.getAttribute("description") %></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-success" style="margin-top: 10px">
    </form>
</div>

<div class="container w-75" <%=session.getAttribute("error")%>>
    <div class="alert alert-danger" role="alert">
        <%=session.getAttribute("errorMsg")%>
    </div>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>