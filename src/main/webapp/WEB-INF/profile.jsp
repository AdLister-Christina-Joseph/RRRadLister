<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
<form method="post" action="/profile/edit">

<!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content text-bg-dark p-3">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit your profile</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="FormControlInput1" class="form-label">Username</label>
                        <textarea name="new-username" type="text" class="form-control" id="FormControlInput1">${sessionScope.user.username}</textarea>
                    </div>
                    <div class="mb-3">
                        <label for="FormControlInput2" class="form-label">Email</label>
                        <textarea name="new-email" type="email" class="form-control" id="FormControlInput2">${sessionScope.user.email}</textarea>
                    </div>
                    <div class="mb-3">
                        <label for="FormControlInput3" class="form-label">New Password</label>
                        <textarea name="new-password" type="password" class="form-control" id="FormControlInput3" placeholder="Enter New Password"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="FormControlInput4" class="form-label">Confirm Password</label>
                        <textarea name="confirm-new-password" type="password" class="form-control" id="FormControlInput4" placeholder="Confirm New Password"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-success" data-bs-dismiss="modal">Save</button>
                </div>
            </div>
        </div>
        <div class="container w-75" <%=session.getAttribute("error")%>>
            <div class="alert alert-danger" role="alert">
                <%=session.getAttribute("errorMsg")%>
            </div>
        </div>
    </div>
</form>
<br>
    <div class="card mx-auto bg-dark">
        <div class="card-header">
            <h1>Welcome, ${sessionScope.user.username}!
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-bounding-box" viewBox="0 0 16 16">
                    <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"/>
                    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                </svg>
                </button>
            </h1>
            <h2>Here are all your ads:</h2>
        </div>
        <ul class="list-group list-group-flush bg-dark">
            <c:forEach var="adsByUser" items="${adsByUser}">
                <li class="list-group-item bg-dark" style="text-align:left;">
                    <p><a href="/ads/edit?id=${adsByUser.id}"><i class="fa-solid fa-pencil"></i></a> <a
                            href="/delete?id=${adsByUser.id}"><i class="fa-solid fa-circle-xmark"></i></a></p>
                    <h2><i class="fa-solid fa-recycle"></i> ${adsByUser.title}</h2>
                    <p style="text-align:left;">${adsByUser.description}</p>
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
