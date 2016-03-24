<%--
  Created by IntelliJ IDEA.
  Author: Emile
  Date: 3/20/2016
  Time: 10:06 PM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Travel Experts Home</title>
      <link rel="stylesheet" type="text/css" href="Css/reset.css" >
      <script type="text/javascript" src="JavaScript/JQuery/jquery-2.2.2.js"></script>
      <style>
          /*#d13f31 --possible validation color*/
          .container{
              height:88%;
              width:100%;
              display: flex;
              flex-wrap: wrap;
          }
          #logoDiv{
              display: flex;
              flex-direction: row;
              background-color: #FFF5C3;
              height: 20%;
              width: 100%;
          }
          #packageDiv{
              background: url("Images/Island.jpg");
              background-position: center;
              background-size: cover;
              height: 100%;
              width:100%;
          }
          #packageDiv h1{
              padding-left: 22%;
              padding-top: 12%;
              font-size: 400%;
              font-weight: bold;
              font-family: "Levenim MT";
              color: #1A202C;
              opacity: .6;
          }
          #loginDiv{
              background-color: #FFF5C3;
              height:80%;
              width:100%;
          }
          #loginDiv h4{
              font-family: "Levenim MT";
              margin-left: 10%;
              position: relative;
              top: 10%;
          }
          .left-content{
              margin: 0;
              padding: 0;
              width:15%;
              min-width: 150px;
          }
          .right-content{
              margin: 0;
              padding: 0;
              width:85%;
          }
          #footer{
              height: 12%;
              width:100%;
              background-color: #FFF5C3;
          }
          #logo{
              margin-top: 15%;
              margin-left: 23%;
              width:50%;
              height: 100%;
          }
          /*#slogan{
              padding-left: 10%;
              width: 70%;
              height: 100%;
          }*/
          #slogan h1{
              padding-top:40%;
          }
          #inputs{
              position: relative;
              top: 80px;
          }
          .txtInput{
              padding:2%;
              background-color: #72B095;
              width: 100%;
              border: none;

          }
          .txtInput:hover {

              padding: 5%;
              background-color: #4CC3D9;
              border-color: #d13f31;
          }
          #inputs div{
              height:2%;
          }
          #inputs button{
              border: none;
              border-radius: 0%;
              width:100%;
              font-family: "Levenim MT";
              text-align: left;
              background-color: #FFC65D;
          }
          #inputs button:hover{
              padding: 4.5%;
              background-color: #d13f31;
          }
      </style>
  </head>
  <body>
    <div class="container">
      <div class="left-content">
        <div id="logoDiv">
          <div id="logo"><%--<img src="Images/Compass.png"/>--%></div>
          <div id="slogan"><%--<h1>Where Travel is Travel</h1>--%></div>
        </div>
          <div id="loginDiv">
              <h4>Login to View Bookings</h4>
              <form>
                  <div id="inputs">
                      <input type="text" class="txtInput" id="txtUsername" name="username" placeholder="User Name" />
                        <div></div>
                      <input type="password" class="txtInput" id="txtPassword" name="password" placeholder="Password" />
                        <div></div>
                      <button>Login</button>
                        <div></div>
                      <button>Register</button>
                  </div>
              </form>
          </div>
      </div>
        <div class="right-content">
          <div id="packageDiv">
              <h1>Welcome to Travel Experts</h1>
              <button>New Image</button>
          </div>
        </div>
    </div>

    <div id="footer">
    </div>
  <script>
      var images = new Array();
      images.push("Images/cruise.jpg");
      images.push("Images/Island.jpg");
      images.push("Images/europe.jpg");
      var index = 0;
      $(document).ready(function(){
          $('#packageDiv button').click(function(){

              $('#packageDiv').css({"background": "url("+images[index]+")",
                                    "background-position": "center",
                                    "background-size":"cover"});
              if(index == images.length-1) {
                  index = 0;
              }
              else{
                  index++;
              }
          });
      });
  </script>
  </body>
</html>
