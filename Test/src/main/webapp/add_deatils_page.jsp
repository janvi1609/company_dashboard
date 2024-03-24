<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Details</title>
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
    <h1>Add Employee Details</h1>
    <form action="./AddDetails" method="post">
    <pre>
         Employee ID:    <input type="text" name="employeeId" required pattern="\d+"><br>

         First Name:     <input type="text" name="firstName" required pattern="[A-Za-z]+"><br>

         Last Name:      <input type="text" name="lastName" required pattern="[A-Za-z]+"><br>

         Job Title:      <input type="text" name="jobTitle" required><br>

         Joining Date:   <input type="date" name="joiningDate" required><br>

         Monthly Salary: <input type="text" name="salary" required pattern="\d+"><br><br>

            <input type="submit" value="Add Employee">
        </pre>
    </form>
     <p style='text-size: 18px;'>Go to <a href="employee.jsp">Home</a> Page.</p>
</body>
</html>
