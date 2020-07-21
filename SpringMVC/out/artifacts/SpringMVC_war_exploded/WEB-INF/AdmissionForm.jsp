<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${msg}</h1>
<h2>Student Admission Form For Engineering Courses </h2>

<form action="submitAdmissionForm.html" method="post">

    <table>
        <tr>
            <td>Student's Name : <input type="text" name="studentName"/></td>
        </tr>


        <tr>

           <td>  Student's Hobby : <input type="text" name="studentHobby"/> </td>


        </tr>


        <tr>
            <td>Student's Mobile : <input type="text" name="studentMobile"/></td>
        </tr>

<%--        <tr>--%>
<%--            <td>Student's DOB : <input type="date" name="studentDOB"/></td>--%>
<%--        </tr>--%>

        <tr>
            <td>Student's Skills : </td>
            <td>   <select> name="studentSkills" multiple>
                                    <option VALUE="Java Core">Java Core</option>
                                    <option VALUE="Spring Core">Spring Core</option>
                                    <option VALUE="Spring MVC ">Spring MVC</option>
                               </select></td>
        </tr>

    </table>


    <input type="submit" value="Submit"/>

</form>

</body>
</html>
