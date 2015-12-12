<html>
<head>
<meta charset="utf-8">
<title>Shopping is Fun Login Page</title>
<style type="text/css">
body {
background-color: #f4f4f4;
background-image: url("Shopping+cart1.jpg");
color: #5a5656;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
font-size: 16px;
line-height: 1.5em;
}
a { text-decoration: none; }
h1 { font-size: 1em; }
h1, p {
margin-bottom: 10px;
}
strong {
font-weight: bold;
}
.uppercase { text-transform: uppercase; }

/* ---------- LOGIN ---------- */
#login {
margin: 50px auto;
width: 300px;
}
form fieldset input[type="text"], input[type="password"] {
background-color: #e5e5e5;
border: none;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
color: #5a5656;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
font-size: 14px;
height: 50px;
outline: none;
padding: 0px 10px;
width: 280px;
-webkit-appearance:none;
}
form fieldset input[type="submit"] {
background-color: #008dde;
border: none;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
color: #f4f4f4;
cursor: pointer;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
height: 50px;
text-transform: uppercase;
width: 300px;
-webkit-appearance:none;
}
form fieldset a {
color: #5a5656;
font-size: 10px;
}
form fieldset a:hover { text-decoration: underline; }
.btn-round {
background-color: #5a5656;
border-radius: 50%;
-moz-border-radius: 50%;
-webkit-border-radius: 50%;
color: #f4f4f4;
display: block;
font-size: 12px;
height: 50px;
line-height: 50px;
margin: 30px 125px;
text-align: center;
text-transform: uppercase;
width: 50px;
}
</style>
<script>
function validateForm() {
    var x = document.forms["login"]["usrname"].value;
    if (x == null || x == "") {
        alert("Username must be filled out!!");
        return false;
}
var y = document.forms["login"]["password"].value;
    if (y == null || y == "") {
        alert("Password must be filled out!!");
        return false;
}
}
</script>
</head>
<body>
<div style="background:yellow;border:1px solid #cccccc;padding: 10px;" contextmenu="mymenu">
<p><font size="30" color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shopping is Fun!</font>

<menu type="context" id="mymenu">
  
</menu>

</div><br>
<div id="login">
<h1><strong><font color="red">Welcome.</font></strong> <font color="red">Please login.</font></h1>
<form name="login" action="Shopping is Fun.html" method="get" onsubmit="return validateForm()" method="post">
<fieldset>
<strong><font color="blue">Username:</font> </strong><input type="text" name="usrname"><br>
<strong><font color="blue">Password:</font> </strong><input type="password" name="password"><br>
<p><input type="submit" value="Login"></p>
</fieldset>
</form>
</html>