<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            background-color: #d3d3d3; /* Set your desired background color */
            font-family: Arial, sans-serif;
            text-align: center; /* Center-align the content */
        }

        h1 {
            font-size: 24px; /* Set your desired font size */
        }

        form {
            background-color: #fff; /* Form background color */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            display: inline-block; /* Center the form within the body */
            text-align: left; /* Left-align form content */
        }

        input[type="text"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #007bff; /* Button background color */
            color: #fff; /* Button text color */
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Hover background color */
        }
        .error {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <h2>Login</h2>
    <form action="./loginServlet" method="post">
    <pre>
        User ID: <input type="text" name="userId" required><br>
        
        Password: <input type="password" name="password" required><br>
        
        <input type="submit" value="Login">
     </pre>
    </form>
    <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
</body>
</html>
