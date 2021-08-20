<?php

    //Store page title

    $pagetitle = "Register";

    //Include header

    require_once "header.php";

    $form = true; //Form visibility

    $error = ""; //Stores error messages

    //When submitted

    if(isset($_POST['submit']))
    {
        //Store and sanitize item data

        $formfield['title'] = trim((strtoupper($_POST['title'])));
        $formfield['overview'] = trim($_POST['overview']);
        $formfield['specials'] = trim($_POST['specials']);
        $formfield['city'] = trim($_POST['city']);
        $formfield['inputdate'] = date('F d, Y');


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
            echo "<div class='error'> <p>ERROR while selecting titles!" . $exception->getMessage() . "</p></div>";

            exit();
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

                //If no errors, insert item data into database

                $sql = "INSERT INTO jacatoe_items (title, overview, specials, city, inputdate)
                                                   VALUES (:title, :overview, :specials, :city, :inputdate)";
                $stmt = $pdo->prepare($sql);
                $stmt->bindvalue(':title', $formfield['title']);
                $stmt->bindvalue(':overview', $formfield['overview']);
                $stmt->bindvalue(':specials', $formfield['specials']);
                $stmt->bindvalue(':city', $formfield['city']);
                $stmt->bindvalue(':inputdate', $formfield['inputdate']);
                $stmt->execute();

                //Hide form and display confirmation

                $form = false;

                echo "<div class='success'><p>Your submission has been added. Thank you!</p></div>";

            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>WARNING: Error while inserting data into the database." . $exception->getMessage() . "</p></div>";

                exit();
            }
        }
    }

    if($form)
    {
?>

        <!--Show user form-->

        <form method="post" action="itemadd.php" name="additem">

            <fieldset>

                <table>

                    <tr>
                        <th><label for="title">Title</label></th>
                        <td><input type="text" name="title" id="title" maxlength="50" value="<?php if (isset($formfield['title'])) {echo $formfield['title'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="overview">Overview</label></th>
                        <td><textarea name="overview" id="overview"> <?php if (isset($formfield['overview'])){echo $formfield['overview'];} ?></textarea></td>
                    </tr>

                    <tr>
                        <th><label for="specials">Specials</label></th>
                        <td><textarea name="specials" id="specials"> <?php if (isset($formfield['specials'])){echo $formfield['specials'];} ?></textarea></td>
                    </tr>

                    <tr>
                        <th><label for="city">City</label></th>
                        <td><input type="text" name="city" id="city" maxlength="50" value="<?php if (isset($formfield['city'])) {echo $formfield['city'];} ?>"/></td>
                    </tr>
                    
                    <tr>
                        <th>Submit</th>
                        <td><input type="submit" name="submit" value="Submit"</td>
                    </tr>

                </table>

            </fieldset>

        </form>

        <?php

    } //End of form

    //Include footer

    require_once "footer.php";

?>