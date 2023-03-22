<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="<%= session.getAttribute("title") %>">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text" ><%= session.getAttribute("description") %></textarea>
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <select name="category" id="category">
                    <option value="Help Wanted">Help Wanted</option>
                    <option value="FREE">FREE</option>
                    <option value="Furniture">Furniture</option>
                    <option value="Appliances">Appliances</option>
                    <option value="Cars">Cars</option>
                    <option value="Bikes">Bikes</option>
                    <option value="Books">Books</option>
                    <option value="Electronics">Electronics</option>
                    <option value="Household">Household</option>
                    <option value="Jewelery">Jewelery</option>
                    <option value="Camping">Camping</option>
                    <option value="Tools">Tools</option>
                    <option value="Tools">General/Misc</option>
                </select>
            </div>





            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>



    <div class = "container w-75" <%=session.getAttribute("error")%>>

        <div class="alert alert-danger" role="alert">
            <%=session.getAttribute("errorMsg")%>
        </div>
    </div>

    <%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
