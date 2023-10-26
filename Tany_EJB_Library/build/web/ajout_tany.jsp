<%-- 
    Document   : ajout_tany
    Created on : 26 Oct 2023, 00:54:22
    Author     : Cartel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="container">
                <div class="container">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="h3"> Ajouter Tany </h3>
                        </div>
                        <div class="card-body">
                            <form action="" method="POST">
                                <input type="hidden" name="cin" value="00001">
                                <div class="row">
                                    <label for="" class="form-label"> Localisation </label>
                                    <input type="text" name="adresse" id="" class="form-control">
                                </div>
                                <div class="row">
                                    <label for=""> Est Borne ? </label>
                                    <select name="borne" id="">
                                        <option value="1"> Oui </option>
                                        <option value="0"> Non </option>
                                    </select>
                                </div>
                                <div class="row">
                                    <input type="submit" value="Ajouter" class="btn btn-primary">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
