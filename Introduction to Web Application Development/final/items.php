<?php

    //Include header
    
    require_once "header.php";

    //Create query
    
    $sql = "SELECT * FROM jacatoe_items";
    $stmt = $pdo->prepare($sql);
    $stmt->execute();
    $result = $stmt->fetchAll();

    //Echo query results in table 
    
    echo "<table>
                <tr> <th>Restaurants</th> </tr>";
    
    foreach($result as $item)
    {
        echo "<tr><td>" . "<a href='itemdetails.php?ID=".$item['ID']." ' />".$item['title']."</a></td></tr>";
    }
    
    echo "</table>";
    
    //Include footer
    
    require_once "footer.php";

?>