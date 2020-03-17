<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!-- controller 안에서의 매개변수 이름과 view에서 설정하는 name값이 일치해야 매칭이 된다.  -->

<hr>
<!-- get방식으로 URL뒤에 파라미터 이름과 값을 보낸다.(가존 보내던 방식) -->
<!-- 아래처럼 보내면 ''도 같이 보내진다. -->
	get방식 일반<a href="./get1?id='abc'&pass='111'">./get1?id='abc'&pass='111'</a>
<hr>
<!-- 
controller 쪽에서 "/get2/{id}/{pass}" 이렇게 설정을 했는데 중괄호 안에 있는 것이 
parameter이름이다. 이것에 맞게 URL에 /하고 값을 넣어주면 해당 이름으로 값이 넘어간다. 
-->
	get방식 스프링 타입<a href="./get2/abc/111">./get2/abc/111</a>
<hr>
<!-- controller에서 매개변수로 설정한 값과 input태그의 이름이 일치해야 한다. -->
<!-- 해당 URL로 보낼 때 각 파라메터 이름을 인식해서 model에 값을 넣고  해당 경로로 이동한다. -->
	post방식 일반
	<form action="./post1" method="post">
		이름: <input type="text" name="name" value="나영"><br>
		학번: <input type="text" name="studentid" value="209901"><br>
		국어: <input type="text" name="kor" value="90"><br>
		영어: <input type="text" name="eng" value="100"><br>
		수학: <input type="text" name="mat" value="80"><br>
		<input type="submit" value="post1">	
	</form>
<hr>
<!-- 
controller에서 해당 클래스 객체 이름으로 값을 보낸다. 여기서도 파라메터의 이름값이 틀리면 안되는데 
클래스 객체 ExamRIO안에 있는 변수를 참고하는 것이 아니라 getter, setter메소드에서 get, set제거하고 난 뒤의
이름을 참고하는 것 같다.(getter, setter메소드의  이름들을 바꿔주니 name값 바꿔도 값이 날라간다 .)
-->
	post방식 묶어 처리
	<form action="./post2" method="post">
		이름: <input type="text" name="name" value="나영"><br>
		학번: <input type="text" name="studentid" value="209901"><br>
		국어: <input type="text" name="kor" value="90"><br>
		영어: <input type="text" name="eng" value="100"><br>
		수학: <input type="text" name="mat" value="80"><br>
		<input type="submit" value="post2">	
	</form>
</body>
</html>
