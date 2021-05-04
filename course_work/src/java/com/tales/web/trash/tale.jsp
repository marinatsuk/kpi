<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Казка на ніч</title>
        <link rel="stylesheet" type="text/css" href="../css/tales.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <section>
            <div class="tale-title">
                <h3>${tale.author}</h3>
                <h1>${tale.title}</h1>
                <p>${tale.description}</p>
            </div>
            
            <c:if test="${!empty user}">
                <c:if  test="${!tale.likers.contains(user)}">
                    <form action="like" method="POST">
                        <input type="hidden" name="taleId" value="${tale.taleId}" />
                        <input type="submit" value="Like" />
                    </form>
                </c:if>
                <c:if test="${tale.likers.contains(user)}">
                    <form action="unlike" method="POST">
                        <input type="hidden" name="taleId" value="${tale.taleId}" />
                        <input type="submit" value="Unlike" />
                    </form>
                </c:if>
                <br>  
            </c:if>
    
        </section>
        <%@include file="footer.jspf"%>
    </body>
</html>
