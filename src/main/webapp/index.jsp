<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>

<form action="searchUser" method="GET">
    <br>
    Search User by Last Name:<br>
    <input type="text" name="searchTerm" />
    <br>

    <button type="submit" name="submit" value="search">Search</button>
    <button type="submit" name="submit" value="getAll">Get All Users</button>

</form>

</body>
</html>