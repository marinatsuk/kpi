<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Помилка </title>
        <style>
           

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Roboto;
                font-size: 14px;
                background-size: 200% 100% !important;
                animation: move 10s ease infinite;
                transform: translate3d(0, 0, 0);
                background: linear-gradient(45deg, #49D49D 10%, #A2C7E5 90%);
                height: 100vh
            }

            .user {
                width: 90%;
                max-width: 340px;
                margin: 10vh auto;
            }

            .user__header {
                text-align: center;
                opacity: 0;
                transform: translate3d(0, 500px, 0);
                animation: arrive 500ms ease-in-out 0.7s forwards;
            }

            .user__title {
                font-size: 18px;
                margin-bottom: -10px;
                font-weight: 500;
                color: red;
                font-weight: bold;
                background-color: white;
            }

            .form {
                margin-top: 40px;
                border-radius: 6px;
                overflow: hidden;
                opacity: 0;
                transform: translate3d(0, 500px, 0);
                animation: arrive 500ms ease-in-out 0.9s forwards;
            }

            .form--no {
                animation: NO 1s ease-in-out;
                opacity: 1;
                transform: translate3d(0, 0, 0);
            }

            .form__input {
                display: block;
                width: 100%;
                padding: 20px;
                font-family: Roboto;
                -webkit-appearance: none;
                border: 0;
                outline: 0;
                transition: 0.3s;

                &:focus {
                    background: darken(#fff, 3%);
                }
            }

            .btn {
                display: block;
                width: 100%;
                padding: 20px;
                font-family: Roboto;
                -webkit-appearance: none;
                outline: 0;
                border: 0;
                color: white;
                background: #77a6b6;
                transition: 0.3s;

                &:hover {
                    background: darken(#77a6b6, 5%);
                }
            }

            @keyframes NO {
              from, to {
                -webkit-transform: translate3d(0, 0, 0);
                transform: translate3d(0, 0, 0);
              }

              10%, 30%, 50%, 70%, 90% {
                -webkit-transform: translate3d(-10px, 0, 0);
                transform: translate3d(-10px, 0, 0);
              }

              20%, 40%, 60%, 80% {
                -webkit-transform: translate3d(10px, 0, 0);
                transform: translate3d(10px, 0, 0);
              }
            }

            @keyframes arrive {
                0% {
                    opacity: 0;
                    transform: translate3d(0, 50px, 0);
                }

                100% {
                    opacity: 1;
                    transform: translate3d(0, 0, 0);
                }
            }

            @keyframes move {
                0% {
                    background-position: 0 0
                }

                50% {
                    background-position: 100% 0
                }

                100% {
                    background-position: 0 0
                }
            }        
        </style>
    </head>
    
    <body>
        <div class="user">
            <header class="user__header">
                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/3219/logo.svg" alt="" />
                <h1 class="user__title">Щось пішло не так. Спробуйте ще раз</h1>
            </header>
    
        <!-- <form class="form" action="LogInServlet" method="POST">
            
            <div class="form__group">
                <input type="text" placeholder="Логін" class="form__input" name="login" />
            </div>

            <div class="form__group">
                <input type="password" placeholder="Пароль" class="form__input" name="password" />
            </div>
        
        <input class="btn" type="submit"></input>
    </form>-->
</div>
    </body>
</html>
