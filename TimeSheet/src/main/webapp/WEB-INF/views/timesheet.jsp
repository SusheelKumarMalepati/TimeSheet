<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Timesheet Management</title>
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
            max-width: 1200px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
            font-size: 28px;
            text-align: center;
        }
        h2 {
            color: #555;
            margin-top: 40px;
            margin-bottom: 20px;
            font-size: 22px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f9fafb;
            color: #555;
            text-transform: uppercase;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .form-group {
            max-width: 400px;
            margin: 0 auto;
            display: flex;
            flex-direction: column;
        }
        .form-group label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        .form-group input[type="date"],
        .form-group input[type="number"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        .form-group input[type="submit"] {
            padding: 12px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: not-allowed; /* default cursor for disabled state */
            font-size: 16px;
            transition: background-color 0.3s ease;
            opacity: 0.5;
            pointer-events: none;
        }
        .form-group input[type="submit"].enabled {
            cursor: pointer; /* cursor when enabled */
            opacity: 1;
            pointer-events: auto;
        }
        .form-group input[type="submit"]:hover.enabled {
            background-color: #2980b9;
        }
        .form-group a {
            color: #3498db;
            text-decoration: none;
            text-align: center;
            display: block;
            margin-top: 20px;
            font-size: 16px;
        }
        .form-group a:hover {
            text-decoration: underline;
        }
    </style>
    <script>
        function validateTimesheetForm() {
            const form = document.querySelector('form');
            const inputs = form.querySelectorAll('input[type="date"], input[type="number"]');
            const submitButton = document.getElementById('submitBtn');
            
            let allFilled = true;
            inputs.forEach(input => {
                if (input.value.trim() === '') {
                    allFilled = false;
                }
            });

            submitButton.classList.toggle('enabled', allFilled);
        }

        document.addEventListener('DOMContentLoaded', () => {
            const form = document.querySelector('form');
            form.addEventListener('input', validateTimesheetForm);
        });
    </script>
</head>
<body>
    <div class="container">
        <h1>Timesheet for Employee ID: ${employeeId}</h1>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Job Type</th>
            </tr>
            <tr>
                <td>${employee.employeeId}</td>
                <td>${employee.employeeName}</td>
                <td>${employee.employeePhoneNumber}</td>
                <td>${employee.employeeEmail}</td>
                <td>${employee.jobType}</td>
            </tr>
        </table>
        
        <table>
            <tr>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Hours Worked Per Day</th>
                <th>Total Hours Worked</th>
            </tr>
            <c:forEach var="timesheet" items="${timesheets}">
                <tr>
                    <td>${timesheet.startDate}</td>
                    <td>${timesheet.endDate}</td>
                    <td>${timesheet.hoursWorkedPerDay}</td>
                    <td>${timesheet.hoursWorked}</td>
                </tr>
            </c:forEach>
        </table>
        
        <h2>Submit Timesheet</h2>
        <form action="/submitTimesheet" method="post" class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate">
            
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate">
            
            <label for="hoursWorkedPerDay">Hours Worked Per Day:</label>
            <input type="number" id="hoursWorkedPerDay" name="hoursWorkedPerDay">
            
            <input type="hidden" name="employeeId" value="${employeeId}">
            
            <input type="submit" id="submitBtn" value="Submit Timesheet">
        </form>
        
        <a href="/employee/getAll">Click here to go to Home Page</a>
    </div>
</body>
</html>
