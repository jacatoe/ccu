<?php
    require_once "connect.php";
?>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="utf-8">
        <title>Assignment 4</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <header>
            <h1>YourInformation.com</h1>
                <nav>
                    <?php
                        if($_SERVER['PHP_SELF'] != "/jacatoe/csci203sp16/a4/index.php")
                        {
                            echo "<a href='index.php'>Form</a>";
                        }
                    
                        if($_SERVER['PHP_SELF'] != "/jacatoe/csci203sp16/a4/displayall.php")
                        {
                            echo "<a href='displayall.php'>Display All</a>";
                        }
                    ?>
                </nav>
        </header>
    </body>
