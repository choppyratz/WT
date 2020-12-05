<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp">
  		<jsp:param name="user" value="${user}"/>
	</jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<div class="quiz-list pt-4">
					<c:forEach items="${quizes}" var="current">
    					<div class="card" style="width: 18rem;">
  							<img src="/quizApp/image/cat.jpg" class="card-img-top" alt="...">
  							<div class="card-body">
  								<h5 class="card-title">${current.name}</h5>
  								<p class="card-text">${current.description}</p>
  								<a href="quiz?id=${current.id}" class="btn btn-primary">Пройти тест</a>
  							</div>
						</div>
					</c:forEach>   
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<style>
		.quiz-list {
			display: grid;
			grid-template-columns: repeat(4, 1fr);
			grid-gap: 20px;
		}
	</style>
</body>
</html>