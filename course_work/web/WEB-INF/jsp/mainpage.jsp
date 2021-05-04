<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <title>Казка на ніч</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
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

            .search-form {
                grid-area: search-form;
                display: grid;
                grid-template-columns: 1fr auto;
                grid-template-rows: auto;
                grid-template-areas: 
                    "search-text search-button";
                align-items: center;
                flex-direction: column;

                justify-content: center;
            }

              .search-text {
                grid-area: search-text;
                place-self: stretch;
            }

            .search-button {
                grid-area: search-button;
            }
            .tales-table {
                width: 100%;
                border: 1px solid black;
                border-collapse: collapse;
            }

            .tales-table td, th {
                border: 1px solid black;
                padding: 5px;
            }

            .tales-table th {
                background-color: #d7e3ea;
            }

            .tales-table td {
                background-color: #F0FFCE;
            }

            .tales-table td:nth-child(2), td:nth-child(3) {
                text-align: center;
            }
            
     </style>
    </head>
<body>

<div class="header">
  <h1>Казка на ніч</h1>
  <p>Створено Мариною Цукановою, ІТ-03</p>
</div>

<form class="search-form" action="search">
     <input class="search-text" type="text" name="text" value=""${text} />
     <input class="search-button" type="submit" value="Пошук"/>
  </form>
     
<div class="navbar">
  <a href="login.jsp" class="active">Вхід</a>
  <!-- <a href="#">Тут будет персональный кабинет </a>
  <!-- <a href="#">Link</a>
  <a href="#" class="right">Link</a> -->
</div>

<div class="row">
  <div class="side">
    <h2>Всі казки</h2>
    <section>
            <table class="tales-table">
                <thead>
                    <tr>
                        <th> Казки (
                            <a href="search?sort=OLD_FIRST&text=${param.text}">Найстаріші</a>,
                            <a href="search?sort=NEW_FIRST&text=${param.text}">Найновіші</a>,
                            <a href="search?sort=BY_TITLE&text=${param.text}">По назві</a>
                            )</th>
                        <th>
                             <a href="search?sort=BY_LIKES&text=${param.text}">Likes</a>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tale" items="${tales}"  >                        
                        <tr>
                            <td title="${tale.description}">
                                <details>
                                    <summary>
                                         ${tale.title}
                                    </summary>
                                    ${tale.description}
                                </details>
                                <!--<button type="button" data-toggle="collapse" data-target="#demo">
                                   
                                </button>
                                <div class="collapse" id="demo">
                                    
                                </div>
                                <a href="tale?taleId=${tale.taleId}">${tale.title}</a>-->
                            </td>
                            <td>${tale.numberOfLikes}</td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </section>
  </div>
</div>

<div class="footer">
  <h2>@ Цуканова Марина, ІТ-03, 2021</h2>
</div>

</body>
</html>