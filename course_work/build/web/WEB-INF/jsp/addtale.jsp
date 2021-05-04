<%-- 
    Document   : addlate
    Created on : May 4, 2021, 11:56:13 AM
    Author     : serg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Додати казку</title>
        <style>
            * {
              box-sizing: border-box;
            }

            /* Style the body */
            body {
              font-family: Arial, Helvetica, sans-serif;
              margin: 0;
            }

            /* Header/logo Title */
            .header {
              padding: 80px;
              text-align: center;
              background: #77a6b6;
              color: white;
            }

            /* Increase the font size of the heading */
            .header h1 {
              font-size: 40px;
            }

            /* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */
            .navbar {
              overflow: hidden;
              background-color: #333;
              position: sticky;
              position: -webkit-sticky;
              top: 0;
            }

            /* Style the navigation bar links */
            .navbar a {
              float: left;
              display: block;
              color: white;
              text-align: center;
              padding: 14px 20px;
              text-decoration: none;
            }


            /* Right-aligned link */
            .navbar a.right {
              float: right;
            }

            /* Change color on hover */
            .navbar a:hover {
              background-color: #ddd;
              color: black;
            }

            /* Active/current link */
            .navbar a.active {
              background-color: #666;
              color: white;
            }

            /* Column container */
            .row {  
              display: -ms-flexbox; /* IE10 */
              display: flex;
              -ms-flex-wrap: wrap; /* IE10 */
              flex-wrap: wrap;
            }

            /* Create two unequal columns that sits next to each other */
            /* Sidebar/left column */
            .side {
              -ms-flex: 30%; /* IE10 */
              flex: 30%;
              background-color: #f1f1f1;
              padding: 20px;
            }
            /* Footer */
            .footer {
              padding: 20px;
              text-align: center;
              background: #ddd;
              color: gray;
            }           
        </style>
    </head>
    <body>
        <div class="header">
            <h1>Казка на ніч</h1>
            <p>Створено Мариною Цукановою, ІТ-03</p>
            <p>З поверненням !</p>
        </div>
        
        <div class="navbar">
            <a href="logout.jsp" class="active">Вихід</a>
        </div>
        
        <h3>Нова казка</h3>
        <form action="NewDishServlet" method="POST">
                <label for="name"><br>Название  </br></label>
                <input type="text" placeholder="Введите название" name="name">
                <br>
                <label for="price"><br>Цена      </br></label>
                <input type="number" placeholder="Введите цену" name="price">
                <br>
                <label for="description"><br>Описание  </br></label>
                <input type="text" placeholder="Описание блюда" name="description">
                <p/>
                <input type="submit" value="Добавить блюдо в меню">
        </form>
    </body>
</html>
