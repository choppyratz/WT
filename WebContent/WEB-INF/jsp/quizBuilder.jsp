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
		<div class="row">
			<div class="col-8 offset-2">
				<input type="text" class="w-100 mt-1 p-1 quizName" placeholder="quiz name">
				<input type="text" class="w-100 mt-2 p-1 quizDesc" placeholder="quiz description">
				<div class="questions">
					<div class="questions_body">
						<div class="question p-2 mt-3 oneAns" id="que1" style="border: 1px solid black">
							<div class="question_head">
								<input type="text" class="w-100 mt-2 p-1" placeholder="question name">
							</div>
							<div class="question_body">
								<div class="variants">
									<div class="variant w-100" style="position: relative;">
										<input type="radio" name="que1">
										<label contenteditable="true">variant</label>
										<div class="delete-btn text-center" style="line-height: 15px;cursor: pointer; position: absolute; right: 0;top: 5px; color: white; width: 20px; height: 20px; background-color: red; border-radius: 50%">x</div>
									</div>
								</div>
								<div class="v-panel d-flex">
									<button class="btn btn-primary mr-2 addVariant">Добавить вариант</button>
									<button class="btn btn-danger deleteQue">Удалить вопрос</button>
								</div>
							</div>
						</div>
						<div class="question p-2 mt-3 manyAns" id="que2" style="border: 1px solid black">
							<div class="question_head">
								<input type="text" class="w-100 mt-2 p-1" placeholder="question name">
							</div>
							<div class="question_body">
								<div class="variants">
									<div class="variant w-100" style="position: relative;">
										<input type="checkbox" id="scales" name="que2">
										<label contenteditable="true">variant</label>
										<div class="delete-btn text-center" style="line-height: 15px;cursor: pointer; position: absolute; right: 0;top: 5px; color: white; width: 20px; height: 20px; background-color: red; border-radius: 50%">x</div>
									</div>
								</div>
								<div class="v-panel d-flex">
									<button class="btn btn-primary mr-2 addVariant">Добавить вариант</button>
									<button class="btn btn-danger deleteQue">Удалить Вопрос</button>
								</div>
							</div>
						</div>
					</div>
					<button class="btn btn-primary mt-1 addQueOne">Добавить вопрос с одним вариантом ответа</button>
					<button class="btn btn-primary mt-2 addQueMany">Добавить вопрос с несколькими вариантами ответов</button><br>
					<button class="btn btn-primary mt-2 addQuiz">Добавить Тест</button>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<script>
		let generatedObject = [];
		let quizName = "";
		let quizDescription = "";
		let QuestionsCount = 3;
		$('body').on('click', ".delete-btn", function() {
			console.log("ok");
			$(this).parent().remove();
		});
		
		$('body').on('click', ".addVariant", function() {
			let elem = $(this).parent().parent().parent();
			let queId = elem.attr('id');
			let queVariants = $(this).parent().parent().find('.variants');
			if (elem.hasClass("oneAns")) {
				console.log("one");
				queVariants.append('<div class="variant w-100" style="position: relative;">'+
						'<input type="radio" name="' + queId + '">' + 
						'<label contenteditable="true"> variant</label>'+
						'<div class="delete-btn text-center" style="line-height: 15px;cursor: pointer; position: absolute; right: 0;top: 5px; color: white; width: 20px; height: 20px; background-color: red; border-radius: 50%">x</div>' + 
					'</div>');
			}else if (elem.hasClass("manyAns")) {
				console.log("manyAns");
				queVariants.append('<div class="variant" style="position: relative;">' + 
						'<input type="checkbox" id="scales" name="' + queId + '">' + 
						'<label contenteditable="true">ans</label><br>' +
						'<div class="delete-btn text-center" style="line-height: 15px;cursor: pointer; position: absolute; right: 0;top: 5px; color: white; width: 20px; height: 20px; background-color: red; border-radius: 50%">x</div>' + 

					'</div>');
			}
		});
		
		$("body").on('click',".deleteQue", function() {
			$(this).parent().parent().parent().remove();
		});
		
		$(".addQueOne").on('click', function() {
			$(".questions_body").append('<div class="question p-2 mt-3 oneAns" id="que' + QuestionsCount + '" style="border: 1px solid black">'+
					'<div class="question_head">'+
					'<input type="text" class="w-100 mt-2 p-1" placeholder="question name">'+
				'</div>'+
				'<div class="question_body">'+
					'<div class="variants">'+
						'<div class="variant w-100" style="position: relative;">'+
							'<input type="radio" name="que' + QuestionsCount + '">'+
							'<label contenteditable="true">variant</label>'+
							'<div class="delete-btn text-center" style="line-height: 15px;cursor: pointer; position: absolute; right: 0;top: 5px; color: white; width: 20px; height: 20px; background-color: red; border-radius: 50%">x</div>'+
						'</div>'+
					'</div>'+
					'<div class="v-panel d-flex">'+
						'<button class="btn btn-primary mr-2 addVariant">Добавить вариант</button>'+
						'<button class="btn btn-danger deleteQue">Удалить вопрос</button>'+
					'</div>'+
				'</div>'+
			'</div>');
		});
		
		$(".addQueMany").on('click', function() {
			$(".questions_body").append('<div class="question p-2 mt-3 manyAns" id="que' + QuestionsCount + '" style="border: 1px solid black">'+
					'<div class="question_head">'+
					'<input type="text" class="w-100 mt-2 p-1" placeholder="question name">'+
				'</div>'+
				'<div class="question_body">'+
					'<div class="variants">'+
						'<div class="variant w-100" style="position: relative;">'+
							'<input type="checkbox" id="scales" name="que' + QuestionsCount + '">'+
							'<label contenteditable="true">variant</label>'+
							'<div class="delete-btn text-center" style="line-height: 15px;cursor: pointer; position: absolute; right: 0;top: 5px; color: white; width: 20px; height: 20px; background-color: red; border-radius: 50%">x</div>'+
						'</div>'+
					'</div>'+
					'<div class="v-panel d-flex">'+
						'<button class="btn btn-primary mr-2 addVariant">Добавить вариант</button>'+
						'<button class="btn btn-danger deleteQue">Удалить Вопрос</button>'+
					'</div>'+
				'</div>'+
			'</div>');
		});
		
		$(".addQuiz").on('click', function(){
			quizName = $(".quizName").val();
			quizDescription = $(".quizDesc").val();
			let questions = [];
			let trueAns = "";
			
			$(".question").each(function() {
				let question = {};
				question['name'] = $(this).find(".question_head").find("input").val();
				if ($(this).hasClass("oneAns")) {
					question['isOneAnswer'] = true;
				}else if ($(this).hasClass("manyAns")) {
					question['isOneAnswer'] = false;
				}
				
				let variants = [];
				$(this).find(".question_body").find(".variants").find(".variant").each(function(){
					variants.push($(this).find("label").text());
					if (question['isOneAnswer'] && $(this).find("input").is(":checked") == true) {
						trueAns += $(this).index() + ",";
					}else if (!question['isOneAnswer'] && $(this).find("input").prop("checked") == true) {
						trueAns += $(this).index() + ",";
					}
				});
				trueAns = trueAns.slice(0, -1);
				trueAns += ';';
				question['variants'] = variants;
				
				questions.push(question);
			});
			trueAns = trueAns.slice(0, -1);
			
			$.ajax({
				method: 'POST',
				url: window.location.href,
				data: 'name=' + quizName + 
					  '&description=' +  quizDescription +
					  '&quizBody=' + JSON.stringify(questions) + 
					  '&trueAns=' + trueAns,
				success: function(data) {
					alert("тест добавлен!");
				}
			});
		});
	</script>
</body>
</html>