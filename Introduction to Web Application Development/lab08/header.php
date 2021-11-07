<?php
/**
 * Created by PhpStorm.
 * User: Joshua
 * Date: 3/1/2016
 * Time: 11:49 AM
 */
?>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>Superglobals</title>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
    <header>
        <h1>Superglobals</h1>
        <nav>
            <ul>
                <?php
                    if($_SERVER['PHP_SELF'] != "/jacatoe/csci203sp16/lab08/index.php")
                    {
                        echo "<li><a href='index.php'>Home</a></li>";
                    }
                    if($_SERVER['PHP_SELF'] != "/jacatoe/csci203sp16/lab08/form.php")
                    {
                        echo "<li><a href='form.php'>Form</a></li>";
                    }
                ?>
            </ul>
        </nav>
    </header>
