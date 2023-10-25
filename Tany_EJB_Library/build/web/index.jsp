<%-- 
    Document   : index
    Created on : 24 Sept 2023, 07:11:49
    Author     : Cartel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Numéro CIN</title>
    </head>
    <body>
        <div class="container">
            <div class="container">
                <form action="tany" method="POST">
                    <div class="row">
                        <label class="form-label"> Entrer numéro CIN : </label>
                        <input type="text" name="cin" />
                    </div>
                    <div class="row">
                        <input type="submit" value="Recuperer les informations" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
