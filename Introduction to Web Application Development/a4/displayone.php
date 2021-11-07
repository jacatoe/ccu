<?php
    include_once "header.php";

    $sql = "SELECT * FROM jacatoe4 WHERE ID = :ID";
    $stmt = $pdo->prepare($sql);
    $stmt->bindvalue(":ID", $_GET['ID']);
    $stmt->execute();
    $row = $stmt->fetch();

    echo "<table><tr><th>ID:</th><td>" . $row['ID'] . "</td></tr>";
    echo "<tr><th>First Name:</th><td>" . $row['fname'] . "</td></tr>";
    echo "<tr><th>Middle Initial:</th><td>" . $row['mi'] . "</td></tr>";
    echo "<tr><th>Last Name:</th><td>" . $row['lname'] . "</td></tr>";
    echo "<tr><th>Username:</th><td>" . $row['username'] . "</td></tr>";
    echo "<tr><th>Password:</th><td>" . $row['password'] . "</td></tr>";
    echo "<tr><th>Comments:</th><td>" . $row['comments'] . "</td></tr>";
    echo "<tr><th>URL:</th><td>" . $row['url'] . "</td></tr>";
    echo "<tr><th>Time Zone:</th><td>" . $row['timezone'] . "</td></tr>";
    echo "<tr><th>Age Range:</th><td>" . $row['agerange'] . "</td></tr>";
    echo "<tr><th>E-mail:</th><td>" . $row['email'] . "</td></tr>";
    echo "<tr><th>Address:</th><td>" . $row['address'] . "</td></tr>";
    echo "<tr><th>Address 2:</th><td>" . $row['address2'] . "</td></tr>";
    echo "<tr><th>Phone Type:</th><td>" . $row['phonetype'] . "</td></tr>";
    echo "<tr><th>Phone Number:</th><td>" . $row['phonenum'] . "</td></tr>";
    echo "</td></tr></table>";


    include_once "footer.php";
?>