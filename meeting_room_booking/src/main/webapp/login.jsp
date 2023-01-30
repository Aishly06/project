<html>
    
        <head>
            <link rel="stylesheet" href="stylelogin.css">
        
        </head>
        <body>
            <center><h1>Sign In</h1></center>
            <form method="GET" action="LoginController">
                <div class="container">
                 <label>Username : </label>   
                 <input type="text" placeholder="Enter Username" name="username" required>  
                 <label>Password : </label>   
                 <input type="password" placeholder="Enter Password" name="password" required>  
                 <button type="submit">Login</button>   
                 <input type="checkbox" checked="checked"> Remember me   
                   
                </div>
            </form>
        </body>
    </html>