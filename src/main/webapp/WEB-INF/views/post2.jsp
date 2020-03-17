<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	post2
</h1>
<hr>
<!-- el(expression languige)태그를 통해서 넘겨준 값을 받아옴 -->
<!-- 클래스 형을 받아왔기 때문에 그 안에서 값을 호출해야 하는데 getter메소드만 가능한 것이아니라 -->
<!-- 그냥 변수를 넣어도 가능하다 .-->
이름 : ${exam.name}<br>
학번 : ${exam.studentid}<br>
국어 : ${exam.kor}<br>
영어 : ${exam.eng}<br>
수학 : ${exam.mat}<br>
</body>
</html>