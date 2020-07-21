<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> ${msg} </h1>
<h3>congratulations! The engineering college has processed your application form successfully</h3>


<h2> Details submitted by you:</h2>

<table>
    <tr>
        <td>Student Name : </td>
        <td>${student1.studentName}</td>
    </tr>
    <tr>
        <td>Student Hobby : </td>
        <td>${student1.studentHobby}</td>
    </tr>
    <tr>
        <td>Student Mobile : </td>
        <td>${student1.studentMobile}</td>
    </tr>
    <tr>
        <td>Student DOB : </td>
        <td>${student1.studentDOB}</td>
    </tr>

    <tr>
        <td>Student Skills : </td>
        <td>${student1.studentSkills}</td>
    </tr>
    <tr>
        <td> Student Address :</td>
        <td> Country: ${student1.studentAddress.country}</td>
        <td> City: ${student1.studentAddress.city}</td>
        <td> State: ${student1.studentAddress.street}</td>
        <td> Pin Code: ${student1.studentAddress.pincode}</td>
    </tr>



</table>
</body>
</html>
