<!DOCTYPE html>
<html>
<head>
    <title>Employee Information</title>
    <style>
    body {
    background-color: #f0f0f0;
    font-family: Arial, sans-serif;
    text-align: center;
}

h1 {
    color: #333;
}
.details {
            display: none;
        }
.table-container {
    margin: 20px;
    border: 1px solid #333;
    padding: 10px;
    background-color: #fff;
    border-radius: 5px;
    overflow: auto;
    max-height: 400px;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid #333;
}

th, td {
    padding: 10px;
    text-align: left;
}

th {
    background-color: #333;
    color: #fff;
}
  </style>  
</head>
<body>
<h1>Employee Details</h1>
    <form action="./Test21" method="post">
        Employee ID: <input type="text" name="id">
        <input type="submit" value="Get Details" onclick="showDetails()">
    </form>
    <div class="details">
    <h1>Employee Information</h1>
    <div class="table-container">
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Job Title</th>
            </tr>
            <!-- Data from Java Servlet will be inserted here -->
        </table>
    </div>
    </div>
     <script>
        function showDetails() {
            var details = document.querySelector('.details');
            details.style.display = 'block';
        }
    </script>
</body>
</html>
