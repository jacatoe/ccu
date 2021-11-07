<?php

    //Store page title

    $pagetitle = "User List";

    //Include header

    require_once "header.php";

    //Create query

    $sql = "SELECT * FROM jacatoe_users";
    $stmt = $pdo->prepare($sql);
    $stmt->execute();
    $result = $stmt->fetchAll();

    //Echo query results in table 

    echo "<table>
            <tr> <th>User</th> <th>Options</th> </tr>";

    foreach($result as $user)
    {
        echo "<tr> <td>" . $user['fname'] . " " . $user['lname'] . " (" . $user['uname'] . ")" . "</td>
              <td>" . "<a href='userdetails.php?ID=" . $user['ID'] . "'>VIEW</a>" . " | " . "<a href='userupdate.php?ID=" . $user['ID'] . "'>UPDATE</a> </td> </tr>";
    }

    echo "</table>";
    
    //Include footer

    require_once "footer.php";

?>