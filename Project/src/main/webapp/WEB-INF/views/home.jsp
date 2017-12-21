<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>
<title>자이네스</title>

<!-- Test  -->
<script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(document).ready(function(){
    $("#val").click(function(){
    $.ajax({
        type: "post",
        url: 'ajax_call.jsp',
        success : function test(a){ $("#callback").html(a); },
         error : function error(){alert("error");} 
        });
    });
});
</script>
<!-- TE  -->
</head>
<body>
	<h1>Xiness</h1>
	<!-- Test  -->
	<input type="button" id="val" value="개발팀 팀원 ">
	<div id="callback"></div>
<!-- ST  -->

	<div>
		<input type="button" value="개발팀 모든정보"
			onClick="location.href='DevelopmentTeam.do'">
	</div>
	
</body>
</html>

	<!--  <li class="">
  <a href="DevelopmentTeam.do">개발팀</a>
 </li> -->