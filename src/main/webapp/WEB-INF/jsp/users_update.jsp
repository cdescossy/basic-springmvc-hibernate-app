<%@ include file="include/header.jsp" %>

<div class="page-header">
  <h1>User <small>> Update User</small></h1>
</div>

<%@ include file="include/flash.jsp" %>

<form:form modelAttribute="user" action="users/update" method="post">
  <%@ include file="include/users_form.jsp" %>

  <fieldset>
    <button type="submit" class="btn">Update User</button>
  </fieldset>
</form:form>

<%@ include file="include/footer.jsp" %>
