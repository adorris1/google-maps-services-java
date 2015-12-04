<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Center</title>

<head>
<link rel="stylesheet" type="text/css" href="header.css">
</head>

<body>
<div id="header"></div>

<div id="nav">
<a href="EmployeeHome.jsp" style="text-decoration:none"><font color="white" size = "4"><b>Home</b></font></a><br><br>
<a href="CustomerCenter.jsp" style="text-decoration:none"><font color="white" size = "4"><b>Customer Center</b></font></a><br><br>
<a href="PublicationCenter.jsp" style="text-decoration:none"><font color="white" size = "4"><b>Publications</b></font></a><br><br>
<a href="Printing.jsp" style="text-decoration:none"><font color="white" size = "4"><b>Printing</b></font></a><br><br>
<a href="Login.jsp" style="text-decoration:none"><font color="white" size = "4"><b>Log Out</b></font></a><br><br>
</div>

<div id="section">
<h2>Profile</h2>

<form action="EmpEditSrvlt" method="post">
	<table>
		<tr>
			<td>User Name: </td>
			<td>${uName}<input type="hidden" name="uName" value="${uName}"/></td>
		</tr>
		<tr>
			<td>Password: </td>
    		<td>${hidPass}<input type="hidden" name="pass" value="${pass}"/></td>
  		</tr>
  		<tr>
			<td>Password Recovery E-mail: </td>
    		<td>${email}<input type="hidden" name="email" value="${email}"/></td>
  		</tr>
  		<tr><td></td><td></td><td style="text-align: right"><input type="submit" value="Edit User Info" name = "edit"></td></tr>
	</table>
	<br>
	<table>
		<tr>
  			<td>Company Address: </td>
  			<td>${company}<input type="hidden" name="company" value="${company}"/></td>
  		</tr>
  		<tr>
  			<td></td>
  			<td>${address}<input type="hidden" name="address" value="${address}"/></td>
  		</tr>
  		<tr>
  			<td></td>
  			<td>${city}, ${state} ${zip}
  			<input type="hidden" name="city" value="${city}"/><input type="hidden" name="state" value="${state}"/><input type="hidden" name="zip" value="${zip}"/></td>
  		</tr>
  		<tr><td></td><td></td><td style="text-align: right"><input type="submit" value="Edit Address" name="edit"></td></tr>
	</table>
	<br>
	<table>
		<tr>
  			<td>Customer Service E-mail: </td>
  			<td>${csEmail}<input type="hidden" name="csEmail" value="${csEmail}"/></td>
  		</tr>
  		<tr>
  			<td>Customer Service Phone: </td>
  			<td>${csPhone}<input type="hidden" name="csPhone" value="${csPhone}"/></td>
  		</tr>
  		<tr><td></td><td></td><td style="text-align: right"><input type="submit" value="Edit Contact Info" name="edit"></td></tr>
	</table>
	<br>
	<table>
		<tr>
  			<td>File Path: </td>
  			<td>${path}<input type="hidden" name="path" value="${path}"/></td>
  		</tr>
  		<tr><td></td><td></td><td style="text-align: right"><input type="submit" value="Edit Path" name="edit"></td></tr>
	</table>
</form>
<br>

</div>

<div id="footer">
Copyright © Team One - CSC 481
</div>

</body>
</html>

