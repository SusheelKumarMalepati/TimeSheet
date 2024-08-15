<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            color: #444;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 80%;
            max-width: 600px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }
        h1 {
            color: #e74c3c;
            margin-bottom: 20px;
            font-size: 28px;
        }
        .error-message {
            background-color: #fbe9e7;
            border: 1px solid #f7c6c7;
            padding: 20px;
            border-radius: 4px;
            margin-top: 20px;
            color: #e74c3c;
            font-size: 18px;
        }
        a {
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
            display: inline-block;
            margin-top: 20px;
            font-size: 16px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>An Error Occurred</h1>
        <div class="error-message">
            <p>${errorMessage}</p>
        </div>
        <a href="/getTimesheet/${employeeId}">Go back to Timesheet</a>
    </div>
</body>
</html>
