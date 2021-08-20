<?php

    //Include header

    require_once "header.php";

    $form = true; //Form visibility

    if(isset($_POST['delete']))
    {
        try
        {
            $sql = 'DELETE FROM jacatoe_items WHERE ID = :ID';
            $stmt = $pdo->prepare($sql);
            $stmt->bindvalue(':ID', $_POST['ID']);
            $stmt->execute();

            echo "<div class='success'><p>The kitten, or should i say, <i>item</i>, was deleted.</p></div>";

            $form = false;
        }
        catch (PDOException $exception)
        {
            echo "<div class='error'><p>WARNING: Error while deleting data!" .$exception->getMessage() . "</p></div>";

            include "footer.php";

            exit();
        }
    }

    if($form)
    {
?>

        <p>The lives of kittens may be at stake. Are you sure you want to delete "<?php echo $_GET['ID'] . " - " . $_GET['title']; ?>" ?</p>

        <form method="post" name="delete" id="delete" action="itemdelete.php">
            <input type="hidden" name="ID" value="<?php echo $_GET['ID']; ?>">
            <input type="submit" name="delete" value="YES">
            <input type="button" name="nodelete" value="NO" onClick="window.location='itemlist.php'"/>
        </form>

<?php

    }

    //Include footer

    require_once "footer.php";

?>
