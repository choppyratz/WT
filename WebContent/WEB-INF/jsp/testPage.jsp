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
		<c:if test="${isPassed == false}">
			<div class="row p-4 mt-5">
				<div class="quiz-name col-6 offset-1" style="background: #343A40;color:white;">
					<h3><c:out value="${quiz.name}" /></h3>
					<p class="pt-2"><c:out value="${quiz.description}" /></p>
				</div>
				<div class="quiz-info col-4" style="border-right: 2px dashed #343A40;border-top: 2px dashed #343A40; border-bottom: 2px dashed #343A40;">
					<p class="m-0 pt-2">Количество вопросов</p>
					<h4></h4>
				</div>
			</div>
			<div class="row p-3">
				<div class="col-10 offset-1">
					<div class="questions">
						
					</div>
					<div class="quizResult">
						<h3 class="text-center"></h3>
					</div>
					<div class="btn-panel pt-4">
						<form action="" method="POST">
							<button type="button" class="btn btn-dark">Проверить</button>
						</form>
					</div>		
				</div>
			</div>
		</c:if>
		<c:if test="${isPassed == true}">
			<h3 class="text-center pt-5">Вы уже прошли данный тест</h3>
			<h3 class="result pt-3 text-center"></h3>
		</c:if>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<script>
		<c:if test="${isPassed == true}">
			let passedResult = "<c:out value="${stat.trueVariants}" />"
			let passedResultArr = passedResult.split(";");
			let trueCount = 0;
			passedResultArr.forEach(item => {
				if (item == '1') {
					trueCount++;
				}
			});
			$(".result").text(trueCount + " из " + passedResultArr.length);
		</c:if>
		let testBody = "<c:out value="${quiz.testBody}" />";
		let quizResult = [];
		let testHTML = "";
		testBody = JSON.parse(convert(testBody));
		
		$(".quiz-info h4").text(testBody.length);
		
		let questionNum = 1;
		testBody.forEach(question => {
			if (question.isOneAnswer) {
				testHTML += "<div class=\"question oneAns pt-4\"><div class=\"question-head\"><h4 class=\"queHead" + questionNum + "\">";
			}else {
				testHTML += "<div class=\"question manyAns pt-4\"><div class=\"question-head\"><h4 class=\"queHead" + questionNum + "\">";
			}
			testHTML += question.name;
			testHTML += "</h4></div><div class=\"question-body\">";
			let variantNum = 1;
			question.variants.forEach(variant => {
				testHTML += "<div class=\"form-check pt-1 \">";
				if (question.isOneAnswer) {
					testHTML += "<input class=\"form-check-input\" type=\"radio\" name=\"exampleRadios" + questionNum + "\" id=\"exampleRadios" + variantNum + "\" value=\"option2\">";
				}else {
					testHTML += "<input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"defaultCheck1\">";
				}
				testHTML += "<label class=\"form-check-label\" for=\"defaultCheck1\">";
				testHTML += variant;
				
				testHTML += "</label></div>";
				variantNum++;
			});
			testHTML += "</div></div>";
			questionNum++;
		});

		$(".questions").append(testHTML);
		
		$(".btn-dark").on('click', function() {
			let i = 0;
			$(".question").each(function() {
				let answerResult = [];
				let isOneAns = false;
				if ($(this).hasClass("oneAns")) {
					isOneAns = true;
				}
				$(this).find(".question-body").find(".form-check").each(function(){
					if (isOneAns) {
						if ($(this).find("input").is(":checked")) {
							answerResult.push($(this).index());
						}
					}else {
						if ($(this).find("input").prop('checked')) {
							answerResult.push($(this).index());
						}
					}
				});
				i++;
				quizResult.push(answerResult);
			});
			console.log(quizResult);
			console.log(serialize(quizResult));
			
			let trueCount = 0;
			$.ajax({
				method: 'POST',
				url: window.location.href,
				data: 'answers=' + serialize(quizResult),
				success: function(data) {
					let arr = data.split(";");
					let i = 1;
					arr.forEach(item => {
						if (item == 1) {
							$(".queHead" + i).css("color", "green");
							trueCount++;
						}else {
							$(".queHead" + i).css("color", "red");
						}
						i++;
					});
					$(".quizResult>h3").text(trueCount + " из " + testBody.length);
				}
			});
		});
		
		function serialize(arr) {
			let result = "";
			for (let i = 0; i < arr.length; i++) {
				for (let j = 0; j < arr[i].length; j++) {
					result += arr[i][j];
					if (j != arr[i].length - 1){
						result += ',';
					}
				}
				if (i != arr.length - 1){
					result += ';';
				}
			}
			return result;
		}
		
		function convert(str)
		{
		 	str = str.replace(/&amp;/g, "&");
		 	str = str.replace(/&gt;/g, ">");
		 	str = str.replace(/&lt;/g, "<");
		 	str = str.replace(/&quot;/g, "\"");
		 	str = str.replace(/&#039;/g, "'");
		 	str = str.replace(/&#034;/g, '"');
		 	return str;
		}
	</script>
</body>
</html>