<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>History</title>
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
                                <h1><img src="http://is1.mzstatic.com/image/thumb/Purple118/v4/1c/71/bd/1c71bd0e-f3a4-481e-4c3b-2065d2c7d9ec/source/1200x630bb.jpg" width ="80" height="80"/><font color="white">    Welcome to SG</font></a></h1>
                        </div>
                </div>
        </div>
        <div id="page-wrapper">
                <div id="page" class="container">
                    <h3>Your operations history</h3><br/>
                    <table class="pure-table pure-table-bordered" align="center">
                        <thead>
                            <tr>
                                <td>Operation ID</td>
                                <td>Type</td>
                                <td>Date</td>
                                <td>Amount</td>
                                <td>Balance</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ operations }" var="operation">
                                <tr>
                                <td>${ boucle.count } ${ operation.idOperation }</td>
                                <td>${ boucle.count } ${ operation.operationName }</td>
                                <td>${ boucle.count } ${ operation.operationDate }</td>
                                <td>${ boucle.count } ${ operation.amount } €</td>
                                <td>${ boucle.count } ${ operation.balance } €</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                </div>
        </div>
        <div id="copyright" class="container">
                <p>&copy; HB. All rights reserved ©. | Powered by <a href="http://google.com">Société générale</a></p>
                        <ul class="contact">
                                <li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
                                <li><a href="#" class="icon icon-facebook"><span></span></a></li>
                                <li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
                                <li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
                                <li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
                        </ul>
        </div>
    </body>
</html>
