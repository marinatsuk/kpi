<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вхід</title>
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
                font-size: 20px;
                margin-bottom: -10px;
                font-weight: 500;
                color: white;
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
                <h1 class="user__title"> До побачення !</h1>
                <br>
                <a href="mainpage.jsp"> На головну </a>
            </header>
        </div>
    </body>
</html>
