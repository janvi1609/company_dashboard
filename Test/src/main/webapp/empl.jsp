<!DOCTYPE html>
<html>
<head>
    <title>Search Page</title>
    <style>
        body {
            background-color: #d3d3d3;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        input[type="text"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        p{
        font-size: 18px;}
    </style>
</head>
<body>
    <div class="container">
        <h1>Search for Employee</h1>
        <form action="./Test21" method="post">
            <p>Enter Employee ID: <input type="text" name="employeeId"></p>
            <p><input type="submit" value="View"></p>
        </form>
        <p>Go to <a href="employee.jsp">Home</a> Page.</p>
    </div>
</body>
</html>
