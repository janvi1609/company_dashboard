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
            background-color: #d3d3d3;
      
            padding: 0;
            display: flex;
        flex-direction: column;
        min-height: 100vh;
        margin: 0;
       
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
           
            background-color: #d3d3d3;
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
        margin-top: auto;
    }

    </style>
</head>

    <header>
        
        <img align="left" src="./puffin_logo_re.jpg" alt="" height="90px" width="100px">
      <!--   <img align="left" src="./com.jpg" alt="" height="90px" width="100px">--> 
        <h1>PUFFIN</h1>
    </header>

<body>    
 <img src="./company_reimage.jpg" alt="" height="500px" width="1500px">
    <div class="welcome-message">
    
        <h2>Simplifying Complexity through Technology.</h2>
        <!--<a class="menu-button" href="chatgpt_coffee.html">View Menu</a>-->
    </div>
    <div class="search-container">
    <!--- <form action="./Test21" method="post">
         <input type="text" id="search-input" placeholder="Enter your search term">-->
         <a href="empl.jsp">
        <button id="search-button1" name="viewDetails">View Details</button></a>
        <a href="add_deatils_page.jsp">
        <button id="search-button" name="addDetails">Add Details</button></a>
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