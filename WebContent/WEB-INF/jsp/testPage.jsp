<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row p-4 mt-5">
			<div class="quiz-name col-6 offset-1" style="background: #343A40;color:white;">
				<h3>Lorem ipsum, dolor, sit amet consectetur adipisicing elit. Exercitationem consectetur ipsam animi praesentium maxime magnam at vel voluptate ad iste.</h3>
				<p class="pt-2">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Expedita optio perferendis, earum, repellendus dolorum praesentium voluptatibus quod cum facere, tenetur, ipsa vel aliquid accusamus nisi iste. Quam, fuga, veniam possimus quod veritatis blanditiis necessitatibus. Assumenda, repellendus natus ut maiores quibusdam odio alias, quia, officia voluptatibus exercitationem, eveniet. Sunt, molestias, natus.</p>
			</div>
			<div class="quiz-info col-4" style="border-right: 2px dashed #343A40;border-top: 2px dashed #343A40; border-bottom: 2px dashed #343A40;">
				<p class="m-0 pt-2">Количество вопросов</p>
				<h4>6</h4>
			</div>
		</div>
		<div class="row p-3">
			<div class="col-10 offset-1">
				<div class="question pt-2">
					<div class="question-head">
						<h4>Вопрос 1</h4>
					</div>
					<div class="question-body">
						<div class="form-check pt-1">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
  							<label class="form-check-label" for="exampleRadios2">
    							Second default radio
  							</label>
						</div>
						<div class="form-check pt-1">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
  							<label class="form-check-label" for="exampleRadios2">
    							Second default radio
  							</label>
						</div>
					</div>	
				</div>
				<div class="question pt-4">
					<div class="question-head">
						<h4>Вопрос 2</h4>
					</div>
					<div class="question-body">
						<div class="form-check pt-1">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
  							<label class="form-check-label" for="exampleRadios2">
    							Second default radio
  							</label>
						</div>
						<div class="form-check pt-1">
  							<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
  							<label class="form-check-label" for="exampleRadios2">
    							Second default radio
  							</label>
						</div>
					</div>	
				</div>
				<div class="question pt-4">
					<div class="question-head">
						<h4>Вопрос 3</h4>
					</div>
					<div class="question-body">
						<div class="form-check pt-1">
  							<input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
  							<label class="form-check-label" for="defaultCheck1">
    							Default checkbox
  							</label>
						</div>
						<div class="form-check pt-1">
  							<input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
  							<label class="form-check-label" for="defaultCheck1">
    							Default checkbox
  							</label>
						</div>
					</div>	
				</div>
				<div class="btn-panel pt-4">
					<button type="button" class="btn btn-dark">Проверить</button>
				</div>		
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>