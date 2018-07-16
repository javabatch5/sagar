<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	.wrapper {
    text-align: center;
}

.button {
    position: absolute;
 }
</style>
<script type="text/javascript">
	function deleteStudent(uname) {
		alert("delete trigger for : " + uname);
		document.forms[0].action = "${pageContext.request.contextPath}/deleteStudent?uname="
				+ uname;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
	function editStudent(uname) {

		alert("edit trigger for : " + uname);
		document.forms[0].action = "${pageContext.request.contextPath}/editStudent?uname="
				+ uname;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="grey">


	<form action="deleteall">
		<table border="3" align="center">
			<tr style="color: red">
				<th>name</th>
				<th>uname</th>
				<th>mnumber</th>
			</tr>
			<core:forEach var="student" items="${stdList}">
				<tr syle="color: white">
					<td><core:out value="${student.name}" /></td>
					<td><core:out value="${student.uname}" /></td>
					<td><core:out value="${student.mnumber}" /></td>
					<td><input type="button" value="Edit"
						onclick="editStudent('${student.uname}')" /></td>
					<!-- <td><input type="text" /></td> -->
					<td><input type="button" value="Delete"
						onclick="deleteStudent('${student.uname}')" /></td>
				<td><input type="checkbox" name="deletemultiple" value="${student.uname}"></td>
				</tr>
			</core:forEach>

		</table>
		<div class="wrapper">
	<input type="submit" class="button" value="deleteselected" align="center">
	</div>
	</form>
</body>
</html>