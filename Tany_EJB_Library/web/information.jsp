<%-- 
    Document   : information
    Created on : 25 Oct 2023, 15:33:37
    Author     : Cartel
--%>

<%@page import="com.dto.sante.Allergie"%>
<%@page import="dto.bank.AccountDTO"%>
<%@page import="dto.bank.TransactionDTO"%>
<%@page import="com.dto.PersonDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    PersonDTO personne = (PersonDTO) request.getAttribute("personne");
    AccountDTO account = (AccountDTO) request.getAttribute("compte");

%>
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
                    <div class="row">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="h3"> Information de la Personne </h3>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <p class="name"> Nom : <%=personne.getLastName()%></p>
                                    <p class="name"> Prenom : <%=personne.getFirstName()%></p>
                                    <p class="name"> Numéro Cin : <%=personne.getCin()%></p>
                                    <p class="name"> Date de Naissance : <%=personne.getDateNaissance()%></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row p-4 d-flex flew-wrap">
                        <div class="card ms-5 mx-3" style="width: 350px">
                            <div class="card-header">
                                <h3> Santé </h3>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <tr>
                                        <th>Nom</th>
                                    </tr>
                                    <% for (Allergie allergie : personne.getSante().getAllergie()) { %>
                                    <tr>
                                        <td><%=allergie.getNom() %></td>
                                    </tr>
                                    <% } %>
                                </table>
                            </div>
                        </div>
                        <div class="card mx-3" style="width: 350px">
                            <div class="card-header">
                                <h3>Foncier</h3>
                            </div>
                            <div class="card-body">
                                
                            </div>
                        </div>
<<<<<<< Updated upstream
                        <div class="card mx-3" style="width: 350px">
                            <div class="card-header">
                                <h3>Banque</h3>
                            </div>
                            <div class="card-body">
                                <h2><%=account.getNumeroCompte() %></h2>
                                <h2><%=account.getSold() %> Ariary</h2>
                                <table class="table">
                                    <tr>
                                        <th>Debit</th>
                                        <th>Credit</th>
                                        <th>Date</th>
                                    </tr>
                                    <% for (TransactionDTO transaction : account.getTransactions()) { %>
                                    <tr>
                                        <td><%=transaction.getDebit() %></td>
                                        <td><%=transaction.getCredit() %></td>
                                        <td><%=transaction.getDate() %></td>
                                    </tr>
                                    <% } %>
                                </table>

=======
                        <div class="card">
                            <div class="card-header">
                                <h3> Santé </h3>
                            </div>
                            <div class="card-body">
                                
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h3> Santé </h3>
                            </div>
                            <div class="card-body">
                                
>>>>>>> Stashed changes
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./assets/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
