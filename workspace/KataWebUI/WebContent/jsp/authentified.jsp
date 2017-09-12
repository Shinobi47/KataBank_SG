<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Consultation des patients</title>
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
    <f:form method="POST" action="/KataWebUI/proceed" class="pure-form">
        <fieldset>
            <legend><center>Choose your operation</center></legend>
            <br/><br/><br/><br/><br/><br/>
            <input type="submit" name="action" value="Deposit" class="button" style="margin-left:100px;"/>
            <input type="submit" name="action" value="Withdraw" class="button" style="margin-left:100px;"/>
            <input type="submit" name="action" value="History" class="button" style="margin-left:100px;"/>
            <br/><br/>
            </fieldset>
    </f:form>
</div>
        </div>

    </body>
</html>
