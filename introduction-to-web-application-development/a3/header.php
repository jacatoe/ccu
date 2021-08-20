<?php
/**
 * Created by PhpStorm.
 * User: Joshua
 * Date: 3/21/2016
 * Time: 1:19 PM
 */
?>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="utf-8">
        <title>Assignment 3</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <header>
            <h1>YourInformation.com</h1>
                <nav>
                    <?php
                        if($_SERVER['PHP_SELF'] != "index.php")
                        {
                            echo "<a href='index.php'>Form</a>";
                        }
                    ?>
                </nav>
        </header>
    </body>
