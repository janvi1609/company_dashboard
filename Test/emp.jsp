<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <h1>Employee Details</h1>
    <form action="./Test21" method="post">
        Employee ID: <input type="text" name="id">
        <input type="submit" value="Get Details">
    </form>
</body>
</html>-->
<!DOCTYPE html>
<html>
<head>
    <title>Company</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .search-container {
    text-align: center;
}

input[type="text"] {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-right: 10px;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-bottom: 20px;
}

button:hover {
    background-color: #0056b3;
}
        header {
            background-color: rgba(255, 255, 255, 0.867);
            color: #000000;
            font-size: 30px;
            text-align: center;
            padding: 20px;
            height: 70px;
            width: auto;
        }

        h1 {
            margin: 0;
        }

        .hero-image {
            width: 100%;
            height: auto;
        }

        .welcome-message {
            text-align: center;
            margin: 20px;
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
            
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px;
            font-weight: bold;
        }

        .button:hover {
            background-color: #444;
        }

        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }
    </style>
</head>
<body>
    <header>
        <img align="left" src="C:\Users\admin\eclipse-workspace\Test\src\main\webapp\puffin_logo_re.jpg" alt="" height="90px" width="100px">
        <h1>PUFFIN</h1>
    </header>

    <img class="hero-image" src="C:\Users\admin\eclipse-workspace\Test\src\main\webapp\company_reimage.jpg" alt="Tech Company" height="300px">

    <div class="welcome-message">
        <h2>Simplifying Complexity through Technology.</h2>
        <!--<a class="menu-button" href="chatgpt_coffee.html">View Menu</a>-->
    </div>
    <div class="search-container">
    <!--- <form action="./Test21" method="post">
         <input type="text" id="search-input" placeholder="Enter your search term">-->
         <a href="employees.jsp">
        <button id="search-button1">View Details</button></a>
        <button id="search-button">Add Details</button>
       <!-- </form>-->
    </div>
    
    <!--   <script>// JavaScript code for handling the search functionality
    document.getElementById("search-button1").addEventListener("click", function() {
        //const searchTerm = document.getElementById("search-input").value;
        // You can implement your search logic here.
         <h1>Employee Details</h1>
    <form action="./Test21" method="post">
        Employee ID: <input type="text" name="id">
        <input type="submit" value="Get Details">
    </form>
        // For this example, let's just display the search term in the results div.
       /* const resultsDiv = document.getElementById("search-results");
        resultsDiv.innerHTML = `You searched for: ${searchTerm}`;*/
    });
</script>-->

    <!--<div class="button-container">
        <a class="button" href="references.html">References</a>
        <a class="button" href="privacy-policy.html">Privacy Policy</a>
    </div>-->

    <div class="footer">
        &copy; 2023 PUFFIN. All rights reserved.
    </div>
   <!--   <pre>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <div id="search-results">
    <h1>Employee Details</h1>
    <form action="./Test21" method="post">
        Employee ID: <input type="text" name="id">
        <input type="submit" value="Get Details">
    </form>
        </div>
        </pre>-->
</body>
</html>