<?php

    //Start session

    session_start();

    //Include server connection

    require_once "connect.php";

?>

<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="utf-8">
        <title>Joshua Catoe</title>
        <link rel="stylesheet" href="styles.css" />
        <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
        <script>
            tinymce.init({
                selector: 'textarea'
            });
        </script>
    </head>

    <body>
    
        <header>
            
            <h1>Critiques de Restaurants</h1>
            
            <nav>
                <?php
                
                    //Include navigation
                
                    require_once "nav.php";
                
                ?>
            </nav>

            <h2><?php echo $pagetitle; ?></h2>
            
        </header>
            
    </body>


