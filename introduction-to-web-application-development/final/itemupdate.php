<?php

    //Store page title

    $pagetitle = "Update Restaurant Info";

    //Include header

    require_once "header.php";

    $form = true; //Form visibility

    $error = ""; //Stores error messages

    if(isset($_POST['submit']))
    {
        
        //Retain ID
        
        $_GET['ID'] = $_POST['ID'];
        
        //Store and sanitize item data

        $formfield['title'] = trim((strtoupper($_POST['title'])));
        $formfield['overview'] = trim($_POST['overview']);
        $formfield['specials'] = trim($_POST['specials']);
        $formfield['city'] = trim($_POST['city']);

        //Check for required fields

        if (empty($formfield['title']))
        {
            $error .= "<p>Title is required.</p>";
        }
        if (empty($formfield['overview']))
        {
            $error .= "<p>Overview is required</p>";
        }
        if (empty($formfield['specials']))
        {
            $error .= "<p>Specials is required.</p>";
        }
        if (empty($formfield['city']))
        {
            $error .= "<p>City is required.</p>";
        }

        //Check for duplicate titles

        if($formfield['title'] != $_POST['otitle'])
        {
            try
            {
                $sql = "SELECT * FROM jacatoe_items WHERE title = :title";
                $stmt = $pdo->prepare($sql);
                $stmt->bindValue(':title', $formfield['title']);
                $stmt->execute();

                $count = $stmt->rowCount();

                if ($count > 0)
                {
                    $error .= "<p>Title is already in use.</p>";
                }
            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>WARNING: Error while selecting titles!" . $exception->getMessage() . "</p></div>";

                exit();
            }
        }    
        
        //Test for and display any errors

        if ($error != "")
        {
            echo "<div class='error'> <p>WARNING: Errors occured. Please correct and try again.</p>";

            echo $error;

            echo "</div>";
        }
        else
        {
            try
            {

                //If no errors, update item data in database

                $sql = "UPDATE jacatoe_items SET title = :title, overview = :overview, specials = :specials, city = :city
                        WHERE ID = :ID ";
                $stmt = $pdo->prepare($sql);
                $stmt->bindvalue('ID', $_POST['ID']);
                $stmt->bindvalue(':title', $formfield['title']);
                $stmt->bindvalue(':overview', $formfield['overview']);
                $stmt->bindvalue(':specials', $formfield['specials']);
                $stmt->bindvalue(':city', $formfield['city']);
                $stmt->execute();

                //Hide form and display confirmation

                $form = false;

                echo "<div class='success'><p>Restaurant info has been updated. Thank you!</p></div>";

            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>WARNING: Error while updating data!" . $exception->getMessage() . "</p></div>";

                exit();
            }
            
        } //End of errors
        
    } //End of submit

    if($form) 
    {
        
        //Query to get item info from database

        $sql = 'SELECT * FROM jacatoe_items WHERE ID = :ID';
        $stmt = $pdo->prepare($sql);
        $stmt->bindValue(':ID', $_GET['ID']);
        $stmt->execute();
        $item = $stmt->fetch();
        
?>
        <!--Show user form-->

        <form method="post" action="itemupdate.php" name="upitem">

            <fieldset>

                <table>

                    <tr>
                        <th><label for="title">Title</label></th>
                        <td><input type="text" name="title" id="title" maxlength="50" value="<?php if (isset($formfield['title']) && !empty($formfield['title'])) {echo $formfield['title'];} 
                                                                                                   else {echo $item['title'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="overview">Overview</label></th>
                        <td><textarea name="overview" id="overview"> <?php if (isset($formfield['overview']) && !empty($formfield['overview'])){echo $formfield['overview'];} 
                                                                           else {echo $item['overview'];} ?></textarea></td>
                    </tr>

                    <tr>
                        <th><label for="specials">Specials</label></th>
                        <td><textarea name="specials" id="specials"> <?php if (isset($formfield['specials']) && !empty($formfield['specials'])){echo $formfield['specials'];} 
                                                                           else {echo $item['specials'];} ?></textarea></td>
                    </tr>

                    <tr>
                        <th><label for="city">City</label></th>
                        <td><input type="text" name="city" id="city" maxlength="50" value="<?php if (isset($formfield['city']) && !empty($formfield['city'])) {echo $formfield['city'];} 
                                                                                                 else {echo $item['city'];} ?>"/></td>
                    </tr>
                    
                    <!--Title and city are unlikely to change, so they are retained-->
                    
                    <tr>
                        <th>Submit</th>
                        <td><input type="hidden" name="ID" id="ID" value="<?php echo $item['ID']; ?>" />
                            <input type="hidden" name="otitle" id="otitle" value="<?php echo $item['title']; ?>" />
                            <input type="hidden" name="ocity" id="ocity" value="<?php echo $item['city']; ?>" />
                            <input type="submit" name="submit" value="Submit"</td>
                    </tr>

                </table>

            </fieldset>

        </form>
        
<?php

    }   
        
    //Include footer

    require_once "footer.php";

?>