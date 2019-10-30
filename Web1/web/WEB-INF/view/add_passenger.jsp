<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World Adventures Airlines</title>
<link rel="stylesheet" href="resources/css/normalize.css" />
<link rel="stylesheet" href="resources/css/theme.css" />
</head>
<body>

	<div class="container">

		<div class="title">Add a passenger</div>

                <%
                    if(request.getAttribute("errors") != null) {
               
                %>
                
                <legend align="center">Errors</legend>
			<ul>

				<%
					if (request.getAttribute("firstName_error") != null) {
				%>
				<li class="error">First name error</li>
				<%
					}
				%>

				<%
					if (request.getAttribute("lastName_error") != null) {
				%>
				<li class="error">Last name error</li>
				<%
					}
				%>


				<%
					if (request.getAttribute("invalid_date_format_error") != null) {
				%>
				<li class="error">Date of birth invalid</li>
				<%
					}
				%>

			</ul>
                
                <%
                }
                %>
		<fieldset>

			<legend>Passenger details</legend>

			<form action="addPasenger" method="POST">

				<div class="inputField">
					<label for="first-name" class="inputLabel">First name: </label> <input
						name="first-name" type="text"></input>
				</div>

				<div class="inputField">
					<label for="last-name" class="inputLabel">Last name: </label> <input
						name="last-name" type="text"></input>
				</div>

				<div class="inputField">
					<label for="dob" class="inputLabel">Date of birth: </label> <input
						name="dob" type="text"></input>
				</div>

				<div class="inputField">
					<label for="first-name" class="inputLabel">Gender: </label> <select
						name="gender">
						<option value="Male">Male</option>
						<option valuie="Female">Female</option>
					</select>
				</div>
		</fieldset>

		<div class="inputField" id="submitField">
			<input type="submit" name="submit" value="Submit"/>
		</div>
		</form>




	</div>

</body>
</html>