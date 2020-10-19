<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="login-form col-6 offset-3 vh-100  d-flex align-items-center">
				<form class="w-100" method="POST" action="">
					<h1 class="text-center">Quiz App</h1>
					<div class="form-group">
  					  <label for="exampleInputEmail1">Имя</label>
  					  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name">
  					</div>
  					<div class="form-group">
  					  <label for="exampleInputEmail1">Фамилия</label>
  					  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="surname">
  					</div>
  					<div class="form-group">
  					  <label for="exampleInputEmail1">Email</label>
  					  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="email">
  					  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  					</div>
  					<div class="form-group">
  					  <label for="exampleInputPassword1">Пароль</label>
  					  <input type="password" class="form-control" id="exampleInputPassword1"  name="password">
  					</div>
  					<a href="login.html">Уже зарегстрированы? Войти</a>
  					<div class="d-flex justify-content-center mt-2">
  						<button type="submit" class="btn btn-primary">Зарегестрироваться</button>	
  					</div>
				</form>
			</div>	
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>