<?php

    //Store page title

    $pagetitle = "User Details";

    //Include header

    require_once "header.php";

    //Create query

    $sql = "SELECT * FROM jacatoe_users WHERE ID = :ID";
    $stmt = $pdo->prepare($sql);
    $stmt->bindvalue(":ID", $_GET['ID']);
    $stmt->execute();
    $user = $stmt->fetch();

    //Echo table of user data

    echo "<table>
            <tr> <th>ID:</th><td>" . $user['ID'] . "</td></tr>
            <tr> <th>First Name:</th> <td>" . $user['fname'] . "</td></tr>
            <tr> <th>Middle Initial:</th> <td>" . $user['mi'] . "</td></tr>
            <tr> <th>Last Name:</th> <td>" . $user['lname'] . "</td></tr>
            <tr> <th>E-mail:</th> <td>" . $user['email'] . "</td></tr>
            <tr> <th>Username:</th> <td>" . $user['uname'] . "</td></tr>
            <tr> <th>Street Address:</th> <td>" . $user['address1'] . "</td></tr>
            <tr> <th>Apt./Suite:</th> <td>" . $user['address2'] . "</td></tr>
            <tr> <th>City:</th> <td>" . $user['city'] . "</td></tr>
            <tr> <th>State:</th> <td>" . $user['state'] . "</td></tr>
            <tr> <th>Zip Code:</th> <td>" . $user['zip'] . "</td></tr>
          </table>";


    //Include footer

    require_once "footer.php";
?>