<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
name:<input type="text" name="name" value="${editview.name}"></br>
uname:<input type="text" name="uname" value="${editview.uname}" readonly="readonly"></br>
pwrd:<input type="text" name="pwrd" value="${editview.pwrd}"></br>
mobilenmber:<input type="text" name="mnumber" value="${editview.mnumber}"><br>
<input type="submit" value="update">
</form>

</body>
</html>