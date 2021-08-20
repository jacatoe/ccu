<?php

    //Store page title

    $pagetitle = "Restaurant List";

    //Include header

    require_once "header.php";

    //Create query

    $sql = "SELECT * FROM jacatoe_items";
    $stmt = $pdo->prepare($sql);
    $stmt->execute();
    $result = $stmt->fetchAll();

    //Echo query results in table

    echo "<table>
                <tr> <th colspan='2'>Restaurants</th> <th>Options</th> </tr>";

    foreach($result as $item)
    {
        echo "<tr><td>" . $item['ID'] . "</td><td>" . $item['title'] . "</td><td>" . "<a href='itemdetails.php?ID=" . $item['ID'] . "'>VIEW</a>" 
             . " | " . "<a href='itemupdate.php?ID=" . $item['ID'] . "'>UPDATE</a>" . " | " . "<a href='itemdelete.php?ID=" . $item['ID'] . "'>DELETE</a>";
    }

    echo "</table>";

    //Include footer

    require_once "footer.php";

?>