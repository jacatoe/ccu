<?php

    //Include header and footer

    require_once "header.php";

    //Echo paragraph and photo

    echo "<div class='homediv'>";

    echo "<img src='http://www.anothermonkeythai.com/wp-content/uploads/2015/06/rest3.jpg' alt='Dinner Plate' height='300px' width='500px' align='center'/>";

    echo "<p>
             This website focuses on the topic of restaurants. Users are able to add restaurants to the database and <br/>
             provide an overview/review of each one and any specials they may have. This topic is very appropriate, as <br/>
             these days, people often turn to websites like these to help them decide where they should eat.
          </p>";

    echo "</div>";

    //Include items

    require_once "items.php";

    //Include footer

    require_once "footer.php";

?>