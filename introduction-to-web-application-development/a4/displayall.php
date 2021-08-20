<?php
    include_once "header.php";

    $sql = "SELECT * FROM jacatoe4";
    $stmt = $pdo->prepare($sql);
    $stmt->execute();
    $result = $stmt->fetchAll();

    echo "<table> <tr><th>ID</th><th>Last Name</th></tr>";
    foreach($result as $row)
    {
        echo "<tr><td>" . $row['ID'] . "</td><td>" . $row['lname'] . "</td><td>" . "<a href='displayone.php?ID=" . $row['ID'] . "'>Details</a></td></tr>";
    }
    echo "</table>";

    include_once "footer.php";
?>