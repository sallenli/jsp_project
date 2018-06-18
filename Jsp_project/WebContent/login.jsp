<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆系统后台</title>
<script type="text/javascript">
function change(obj)
{
	obj.src="checkcodeServlet?"+new Date().getTime()}
	function regist()
	{
		window.location.href="adduser.jsp";
	}
</script>

</head>
<body>
	<form action="loginServlet" method="post">
		<table align="center" style="border: 1px, solid;">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
			<td>密码:</td>
			<td><input type="password" name="password"/></td>
			</tr>
			<tr>
			<td>
			验证码:
			</td>
			<td>
			<input type="text" name="checkcode" />
			<img src="checkcodeServlet" onclick="change(this)"/>
			</td>
			</tr>
			<tr>
			<td>
			<input type="submit" value="登陆"/>
			<input type="button" value="注册" onclick="regist()"/>
			</td>
			
			</tr>
		</table>
	</form>

</body>
</html>