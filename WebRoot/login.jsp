<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
     <h1>登陆页面</h1>
     <%
           String msg="";
          //判断request域中是否有错误信息
          if(request.getAttribute("msg")!=null)
          { 
            msg=(String)request.getAttribute("msg");
          }
     
           
     
     
     
      %>
     <h3><%=msg    %>   </h3>
  <form action="/signup/loginservlet"  method="post">
     <table>
        <tr>
            <td>用户名</td>
            <td>  <input type="text"  name="username"  />  </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>  <input type="password"  name="password"  />  </td>

        </tr>
        <tr>
            <td  colspan="2"  >  <input  type="submit"  value="登录"  /> </td>
        </tr>
     
     </table>
     </form>
  </body>
</html>
