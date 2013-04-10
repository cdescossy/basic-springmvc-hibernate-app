<%@ include file="include/header.jsp" %>

<div class="page-header">
  <h1>Users <small>> Get User</small></h1>
</div>

<%@ include file="include/flash.jsp" %>

<div class="row">
  <div class="span2">Username</div>
  <div class="span2">${user.username}</div>
</div>
<div class="row">
  <div class="span2">Firstname</div>
  <div class="span2">${user.firstname}</div>
</div>
<div class="row">
  <div class="span2">Lastname</div>
  <div class="span2">${user.lastname}</div>
</div>

<%@ include file="include/footer.jsp" %>
