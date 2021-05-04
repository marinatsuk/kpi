<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Казка на ніч</title>
        <link rel="stylesheet" type="text/css" href="C:\Users\serg\KURSOVIK\course_work\web\WEB-INF\css\tales.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <section>
            <table class="tales-table">
                <thead>
                    <tr>
                        <th> Казки (
                            <a href="search?sort=OLD_FIRST&text=${param.text}">Найстаріші</a>,
                            <a href="search?sort=NEW_FIRST&text=${param.text}">Найновіщі</a>,
                            <a href="search?sort=BY_TITLE&text=${param.text}">По назві</a>
                            )</th>
                        <th>
                             <a href="search?sort=BY_LIKES&text=${param.text}">Likes</a>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tale" items="${tales}">                        
                        <tr>
                            <td title="${tale.description}">
                                <a href="tale?taleId=${tale.taleId}">${tale.title}</a>
                            </td>
                            <td>${tale.numberOfLikes}</td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </section>
        <br>
        <%@include file="footer.jspf"%>             
    </body>
</html>
