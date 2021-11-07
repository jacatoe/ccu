<?php
$pagetitle = "Delete";
include_once "header.php";

$showform = 1;

if(isset($_POST['delete']))
{
    try
    {
        $sql = 'DELETE FROM lab09 WHERE ID = :ID';
        $stmt = $pdo->prepare($sql);
        $stmt->bindvalue(':ID', $_POST['ID']);
        $stmt->execute();
        echo "<div class='success'><p>Successfully deleted.</p></div>";
        $showform = 0;
    }
    catch (PDOException $e)
    {
        echo "<div class='error'><p>ERROR deleting data!" .$e->getMessage() . "</p></div>";
        include "footer.php";
        exit();
    }
}

if($showform == 1)
{
   ?>
        <p>Are you completely, absolutely, unequivocally sure you want to delete <?php echo $_GET['ID'];?></p>
        <form name="delete" id="delete" method="post" action="delete.php">
            <input type="hidden" name="ID" value="<?php echo $_GET['ID'];?>">
            <input type="submit" name="delete" value="YES">
            <input type="button" name="nodelete" value="NO" onClick="window.location='selectall.php'" />
        </form>

   <?php
}

include_once "footer.php";

?>