<%-- 
    Document   : details_tany
    Created on : 26 Oct 2023, 01:30:55
    Author     : Cartel
--%>

<%@page import="dto.tany.TanyDTO"%>

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
                <div class="container">
                    <div class="row information-container">
                        <div class="col-lg-6">
                            <div id="map" style="height: 500px;width: 500px">
                                <!-- Asiana anle data ana vorne ireny avy eo -->
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header">
                                    <h3> Informations Tany </h3>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <p class="p"> Est Borne :  </p>
                                        <p class="p"> Addresse :  </p>
                                    </div>
                                    <div class="row">
                                        Localisation des bornes :
                                        <table class="table">
                                            <thead>
                                                <th> Longitude </th>
                                                <th> Latitude </th>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td> long </td>
                                                    <td> lat </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
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
</script>
    </body>
</html>
