<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>you don't exist boy</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
        <style>
        <%@include file="../css/default.css" %>
        <%@include file="../css/fonts.css" %>
        <%@include file="../css/tables.css" %>
        </style>    
    </head>
    <body>
        <div id="header-wrapper">
                <div id="header" class="container">
                        <div id="logo">
                                <h1><img src="file://C:/Users/Kenji/workspace/WebUI/WebContent/css/cake.png" width ="80" height="80"/><font color="white">    Welcome to the SG</font></a></h1>
                        </div>
                </div>
        </div>
        <div id="page-wrapper">
                <div id="page" class="container">
    <f:form modelAttribute="authDto" method="POST" action="/KataWebUI/post_auth" class="pure-form">
        <fieldset>
            <legend><center>You shall not pass !</center></legend>
            <br/><br/><br/><br/><br/><br/>
			<center><h1>${msg}</h1></center> 
 			<br/><br/><br/><br/>
            </fieldset>
    </f:form>
</div>
        </div>

    </body>
</html>
