<%-- 
    Document   : juros-simples
    Created on : 24/02/2019, 23:59:08
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculo de juros simples</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/juros-simples.css">
    </head>
    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="index.html">POO</a>
                <ul class="nav nav-pills">
                    <li class="nav-item">
                        <a class="nav-link" href="juros-simples">Juros simples</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="juros-compostos">Juros compostos</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row">
            <div class="col-6 ml-auto mr-auto">
                <div class="row">
                    <form class="mt-5" name="myform" action="${pageContext.request.contextPath}/calcjurossimples" method="post">
                        <div class="form-row">
                            <div class="col-6">
                                <input type="number" step="0.01" min=0 class="form-control" name="amount" placeholder="valor inicial depositado">
                            </div>
                            <div class="col-3">
                                <input type="number" step="0.01" min=0 class="form-control" name="interest" placeholder="taxa de juros">
                            </div>
                            <div class="col-2">
                                <input type="number" min=0 class="form-control" name="time" placeholder="meses">
                            </div>   
                            <div class="col-1">
                                <input type="submit" class="btn btn-outline-secondary" value="Calc">
                            </div>
                        </div>
                    </form>
                        <h3 class="ml-auto mr-auto mt-5">${res}</h3>
                </div>

            </div> 
        </div>
    </body>
</html>