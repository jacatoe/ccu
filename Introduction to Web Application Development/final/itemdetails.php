<?php

    //Store page title

    $pagetitle = "Restaurant Details";

    //Include header

    require_once "header.php";

    //Create query

    $sql = "SELECT * FROM jacatoe_items WHERE ID = :ID";
    $stmt = $pdo->prepare($sql);
    $stmt->bindvalue(":ID", $_GET['ID']);
    $stmt->execute();
    $item = $stmt->fetch();

    //Echo table of user data

    echo "<table>
                <tr> <th>ID</th><td>" . $item['ID'] . "</td></tr>
                <tr> <th>Title</th> <td>" . $item['title'] . "</td></tr>
                <tr> <th>Overview</th> <td>" . $item['overview'] . "</td></tr>
                <tr> <th>Specials</th> <td>" . $item['specials'] . "</td></tr>
                <tr> <th>City</th> <td>" . $item['city'] . "</td></tr>
                <tr> <th>Date Added</th> <td>" . $item['inputdate'] . "</td></tr>
          </table>";


    //Include footer

    require_once "footer.php";

?>