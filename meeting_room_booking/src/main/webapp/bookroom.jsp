<html>
    
        <head>
            <link rel="stylesheet" href="bookroom.css">
        
        </head>
        <body>
            <center><h1>Book Room</h1></center>
            <form method="post" action="MeetingRoomController">
                <div class="container">
                <label>RoomId:</label>
                <%= request.getParameter("roomId")%>
                <br>
                <label>Username: </label>
                <%= request.getParameter("username")%>
                <br>
                
                
                 <label>Date: </label>   
                 <input type="date" placeholder="Enter Date" name="Date" required> 
                 <label>start_time: </label>   
                 <input type="time" placeholder="Enter start time" name="start_time" required>  
                 <label>end_time : </label>   
                 <input type="time" placeholder="Enter end time" name="end_time" required>  
                 <button type="submit" onclick="bookingSuccess.jsp">save</button>   
                 
               
                </div>
            </form>
        </body>
    </html>