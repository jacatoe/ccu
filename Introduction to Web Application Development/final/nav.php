<?php
    
    $currentpage = $_SERVER['PHP_SELF'];

    //If on home page, do not echo link

    if($currentpage != '/jacatoe/csci203sp16/final/index.php')
    {
        echo "<a href='index.php'>Home</a>";
    }

    //If logged in, show pages, else show login

    if(isset($_SESSION['ID']))
    {

        if($currentpage != '/jacatoe/csci203sp16/final/userlist.php')
        {
            echo "<a href='userlist.php'>User List</a>";
        }

        if($currentpage != '/jacatoe/csci203sp16/final/userpassword.php')
        {
            echo "<a href='userpassword.php'>Update Password</a>";
        }

        if($currentpage != '/jacatoe/csci203sp16/final/itemadd.php')
        {
            echo "<a href='itemadd.php'>Add Restaurant</a>";
        }

        if($currentpage != '/jacatoe/csci203sp16/final/itemlist.php')
        {
            echo "<a href='itemlist.php'>Restaurant List</a>";
        }

        if($currentpage != '/jacatoe/csci203sp16/final/logout.php')
        {
            echo "<a href='logout.php'>Log Out</a>";
        }
        
    }
    else
    {

        if($currentpage != '/jacatoe/csci203sp16/final/useradd.php')
        {
            echo "<a href='useradd.php'>Sign-Up</a>";
        }
        
        if($currentpage != '/jacatoe/csci203sp16/final/login.php')
        {
            echo "<a href='login.php'>Log In</a>";
        }
        
    }

?>