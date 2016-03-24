<%--
  Created by IntelliJ IDEA.
  User: 433080
  Date: 3/18/2016
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="../Css/view.css" media="all">
  <script type="text/javascript" src="../JavaScript/view.js"></script>

</head>
<body id="main_body" >

<img id="top" src="../Images/top.png" alt="">
<div id="form_container">

  <h1><a>Login</a></h1>
  <form id="form_1114665" class="appnitro"  method="post" action="/Login">
    <div class="form_description">
      <h2>Login</h2>
      <p>Welcome to Travel Experts</p>
    </div>
    <ul >
      <li id="li_1" >
        <label class="description" for="element_1">Username </label>
        <div>
          <input id="element_1" name="txtUsername" class="element text medium" type="text" maxlength="255" value=""/>
        </div><p class="guidelines" id="guide_1">Enter your Username</p>
      </li>
      <li id="li_2" >
      <label class="description" for="element_2">Password </label>
      <div>
        <input id="element_2" name="txtPassword" class="element text medium" type="text" maxlength="255" value=""/>
      </div><p class="guidelines" id="guide_2"><small>Please Enter your Password</small></p>
      </li>
      <li class="buttons">
        <input type="hidden" name="form_id" value="1114665" />
        <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
      </li>
    </ul>
  </form>
</div>
<img id="bottom" src="../Images/bottom.png" alt="">
</body>
</html>
