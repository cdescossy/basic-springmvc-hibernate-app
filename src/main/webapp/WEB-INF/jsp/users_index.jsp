<%@ include file="include/header.jsp" %>

<div class="page-header">
  <h1>Users <small>> List User</small>
  </h1>
</div>

<%@ include file="include/flash.jsp" %>

<div class="row">
  <div class="span2">Username</div>
  <div class="span2">Firstname</div>
  <div class="span2">Lastname</div>
  <div class="span4">Actions</div>
</div>
<c:if test="${empty users}">
  <div class="row">
    <div class="span4">No results found!</div>
  </div>
</c:if>
<c:forEach var="current" items="${users}">
  <div class="row">
    <div class="span2">${current.username}</div>
    <div class="span2">${current.firstname}</div>
    <div class="span2">${current.lastname}</div>
    <div class="span4">
      <a href="users/${current.username}"><i class="icon-eye-open"></i></a>
      <a href="users/edit/${current.username}"><i class="icon-pencil"></i></a>
      <a href="users/delete/${current.username}"><i class="icon-trash"></i></a>
    </div>
  </div>
</c:forEach>

<%@ include file="include/footer.jsp" %>
