<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit an Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Edit an Ad</h1>
    <form action="/ads/edit?id=${ad.id}" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
        </div>
        <input type="submit" class="btn btn-block btn-success">
    </form>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>