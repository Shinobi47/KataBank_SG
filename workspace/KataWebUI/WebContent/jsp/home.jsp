<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>home</title>
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
            <legend><center>Authentification</center></legend>
            <br/><br/><br/><br/><br/><br/>
            
            <f:label path = "name">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Votre nom : <span class="requis">*</span></f:label>
            <f:input path = "name" size="20" maxlength="60"/>
            <span class="erreur">${form.erreurs['adresse']}</span>
			
			<center>
			<br/><br/>
				
			<f:label path = "password">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Votre code secret : <span class="requis">*</span></f:label>
            <f:input path = "password" size="20" maxlength="60"/>
            <span class="erreur">${form.erreurs['adresse']}</span>
            <br/><br/>
			</center> 

            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${form.resultat}</p>
            <input type="submit" value="insersion" class="button" style="margin-left:100px;"/>
                           
            </fieldset>
    </f:form>
</div>
        </div>

    </body>
</html>
