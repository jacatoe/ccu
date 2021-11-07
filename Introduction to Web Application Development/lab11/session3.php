<?php
/**
 * Created by PhpStorm.
 * User: jennis
 * Date: 3/23/2016
 * Time: 12:50 PM
 */
    $pagetitle = "Session 3";
    session_start();
    include_once "sessionheader.php";
    echo $_SESSION['num'];
    include_once "sessionfooter.php";
?>

