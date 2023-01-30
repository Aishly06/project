<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    
        <head>
            <link rel="stylesheet" href="availableroom.css">
            <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">


        </head>
        <body>
        <style>
                body {
                  background-image: url('https://img.freepik.com/premium-photo/modern-office-with-office-supplies-table-with-office-environment-background_67155-5307.jpg?w=2000');
                  background-attachment: fixed;
                  background-size: cover;
                  background-repeat: no-repeat;
                }
                </style>
            
            <div class="container">
           <center> <h1 class="title">Available rooms</h1></center>
        </div>
            <table class="table table-striped table-bordered">
            <thead>
            	<tr class="thead-dark">
            	<th>Room Name</th>
            	</tr>
            </thead>
            
            <tbody>
            	<c:forEach items="${list}" var="room">
            	<tr>
            		<td>${room.id}</td>
            		<td><a href="bookroom.jsp?roomId=${room.id}&username=${username}">${room.name}</a></td>
            	</tr>
            </c:forEach>
            </tbody>
            </table>
            
            
            
        </body>
        

        
    
</html>