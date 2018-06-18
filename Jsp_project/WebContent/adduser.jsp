<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户页面</title>
</head>
<body>
 <form action="addUserServlet" method="post" align="center">
 
        <div class="form-group">
            <label for="userName">用户名：</label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名"  />
        </div>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="hobby">爱好：</label>
            <input type="checkbox" name="hobby"  class="form-control" id="hobby" value="音乐" />音乐
            <input type="checkbox" name="hobby"  class="form-control" id="hobby" value="游戏"/>游戏
            <input type="checkbox" name="hobby"  class="form-control" id="hobby" value="旅游"/>旅游
            <input type="checkbox" name="hobby"  class="form-control" id="hobby" value="爬山"/>爬山
             
          
        </div>

       

        
       <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" id="password" class="form-control" name="userPassword" />
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</body>
</html>