<%-- 
    Document   : bornage
    Created on : 25 Oct 2023, 20:49:53
    Author     : Cartel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div id="map" style="width: 500px; height: 500px;">
                            
                        </div>
                        
                    </div>

                    <div class="col-lg-6">
                        <!-- Ato atao manao input ilay izy -->
                        <form action="Borne" class="form" method="POST">
                                <input type="hidden" name="idTany" value="1">
                                <div id="long-lat">
                                    <div class="row" id="original">
                                        <div class="col-lg-3">
                                            <label for="" class="label"> Longitude : </label>
                                            <input type="text" class="form-control" name="longitudes[]" id="">
                                        </div>
                                        <div class="col-lg-3">
                                            <label for="" class="label"> Latitude : </label>
                                            <input type="text" class="form-control" name="latitudes[]" id="">
                                        </div>
                                    </div>
                                    
                                </div>
                            <div class="row">
                                <button type="button" onclick="addRow()"> Ajouter autre </button>
                                <input type="submit" class="btn btn-primary" value="Ajouter les bornes">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" integrity="sha256-p4NxAoJBhIIN+hmNHrzRCf9tD/miZyoHS5obTRR9BMY=" crossorigin="" />
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js" integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo=" crossorigin=""></script>
        <script>
            var map = L.map('map').setView([ -18.933333, 47.516667], 13);

            L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);


            function addRow(){
                let toClone = document.querySelector('#original');
                let clone = toClone.cloneNode(true);
                let inputs = clone.querySelectorAll("input[type='text']");
                inputs.forEach( input => input.value = '' );
                clone.removeAttribute('id');
                let form = document.querySelector("#long-lat");
                form.appendChild(clone);
            }

        </script>
    </body>
</html>
