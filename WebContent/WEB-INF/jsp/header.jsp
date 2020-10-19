<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  	<a class="navbar-brand" href="#">Quiz App</a>
  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
  	  <span class="navbar-toggler-icon"></span>
  	</button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
	  		<li class="nav-item active">
	  	 		<a class="nav-link" href="">Главная <span class="sr-only">(current)</span></a>
	  	 	</li>
	  	 	<li class="nav-item">
	  	 		<a class="nav-link" href="#">Викторины</a>
	  	 	</li>
	  	 	<li class="nav-item">
	  	 		<a class="nav-link" href="/statistics">Статистика</a>
	  	 	</li>
	  	 </ul>
	  	 <ul class="navbar-nav">
	  	 	<c:if test="${not empty user}">
    			<li><a class="nav-link" href="login.html"><c:out value="${user.email}" /></a></li>
			</c:if>
			<c:if test="${empty user}">
    			<li><a class="nav-link" href="login.html">Войти</a></li>
			</c:if>
	  	  </ul>
  	</div>
</nav>