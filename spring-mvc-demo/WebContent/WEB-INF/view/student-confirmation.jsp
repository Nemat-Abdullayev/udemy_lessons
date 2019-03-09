<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Student confirmation</title>
</head>


<body>


</body>

The student is confirmed:${student.firstName} ${student.lastName}
<br>
<br> Country:${student.country}
<br>
<br> Favorite Language:
<ul>
	<c:forEach var="test" items="${student.favoriteLanguage}">
		<li>${test}</li>

	</c:forEach>
</ul>
<br>
<br> Operation Systems:
<ul>
	<c:forEach var="temp" items="${student.operationSystems}">
		<li>${temp}</li>

	</c:forEach>
</ul>


</html>