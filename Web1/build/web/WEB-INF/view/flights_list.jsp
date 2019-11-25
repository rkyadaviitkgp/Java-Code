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
        <title>Flights List</title>

    </head>


    <body>

        <h1>List of Flights</h1>

        <table>

            <tr>

                <th>From</th>
                <th>To</th>
                <th>Time</th>
                <th>Price</th>
                <th>Airplane</th>
                <th>Seating</th>
                <th>Number of pilots</th>
                <th>Pilot names</th>


            </tr>

            <%

                List<Flight> fList = (List<Flight>) request.getAttribute("flight list");

                for (Integer i = 0; i < fList.size(); i++) {


            %>

            <tr>

                <td><%= fList.get(i).getSource()%></td>
                <td><%= fList.get(i).getDestination()%></td>
                <td><%= fList.get(i).getTime()%></td>
                <td><%= fList.get(i).getPrice()%></td>
                <td> <%= fList.get(i).getAeroplaneDetails().getModelName()%> </td>
                <td> <%= fList.get(i).getAeroplaneDetails().getSeatingCapacity()%> </td>
                <td> <%
                    if (fList.get(i).getPilots() != null){
                                    
                    %>
                    
                    <%= fList.get(i).getPilots().size()  %> pilots
                    <%
                        }else{
                    %>
                    No pilots added yet 
                    <%
                    }
                    %>
                </td>
                <td>
                     <%
                    if (fList.get(i).getPilots() != null){
                         List<Pilot> plist =  (List<Pilot>) fList.get(i).getPilots();
                         for(int j = 0; j<plist.size(); j++){
                             
                    %>
                    <%= (j+1) + ")" + plist.get(j).getFirstName() + "  "  + plist.get(j).getLastName() + " ( " + plist.get(j).getPilotRank() + " ) " %>
                    <%
                        }
                    }
                    %>
                    </td>

            </tr>
            <tr>
                <td colspan="4">No Passengers on this flight yet.</td>
            </tr>

            <%
                }
            %>
            

        </table>

    </body>
</html>