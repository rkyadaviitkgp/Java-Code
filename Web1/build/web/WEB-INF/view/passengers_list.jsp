<%-- 
    Document   : flights_list
    Created on : 21 Nov, 2019, 11:15:58 AM
    Author     : rajeshkumar.yadav
--%>
<%@ page import="java.util.*, com.airlines.models.*" %>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="resources/css/jpaStyles.css" />
        <title>Passengers List</title>

    </head>


    <body>

        <h1>List of Passengers</h1>

        <table>

            <tr>

                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                 


            </tr>

            <%

                List<Passenger> pList = (List<Passenger>)request.getAttribute("passenger list");

                for (Integer i = 0; i < pList.size(); i++) {


            %>

            <tr>

                <td><%= pList.get(i).getFirstName()%></td>
                <td><%= pList.get(i).getLastName()%></td>
                <td><%= pList.get(i).getDob() %></td>
                <td><%= pList.get(i).getGender() %></td>
       
            </tr>
            <tr>
                <td colspan="4">No Flight tickets yet.</td>
            </tr>

            <%
                }
            %>

        </table>

    </body>
</html>