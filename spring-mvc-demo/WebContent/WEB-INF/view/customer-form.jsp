<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Customer Registration Form</title>
<style>
.error {
	color: red
}
#save{background-color:green
}
</style>

</head>


<body>
	<i><b>Fill out the form.Asterisk (*) means required.</b> </i>
	<br><br>
	<form:form action="processForm" modelAttribute="customer">
First name: <form:input path="firstName" />
		<br>
		<br>
Last name(*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br><br>
FreeSpaces: <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error" />
        <br><br>
Postal Code: <form:input path="postalCode"/> 
        <form:errors path="postalCode" cssClass="error" />       
		<br><br>
Startup Code: <form:input path="startupCode"/> 
        <form:errors path="startupCode" cssClass="error" />       
		<br><br>
		<input type="submit" value="Save" id="save"/>
		


	</form:form>

</body>
<br><br>
<footer>
 <small>&copy; Copyright 2019, Nemat Abdullayev</small>
</footer>




</html>