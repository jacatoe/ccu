<?php

    //Store page title

    $pagetitle = "Update Restaurant Info";

    //Include header

    require_once "header.php";

    $form = true; //Form visibility

    $error = ""; //Stores error messages

    //Query for user authentication

    $sql = "SELECT * FROM jacatoe_users WHERE ID = :ID ";
    $stmt = $pdo->prepare($sql);
    $stmt->bindvalue(':ID', $_GET['ID']);
    $stmt->execute();
    $user = $stmt->fetch();

    //A user can only update their own profiles

    if($_SESSION['ID'] != $user['ID'])
    {
        echo "<p>You cannot update another member's profile.</p>";
        
        require_once "footer.php";
        
        exit();
    }    

    if(isset($_POST['submit']))
    {
        
        //Retain ID
        
        $_GET['ID'] = $_POST['ID'];

        //Store and sanitize user data
        
        $formfield['fname'] = trim($_POST['fname']);
        $formfield['mi'] = trim($_POST['mi']);
        $formfield['lname'] = trim($_POST['lname']);
        $formfield['email'] = trim(strtolower($_POST['email']));
        $formfield['uname'] = trim(strtolower($_POST['uname']));
        $formfield['address1'] = trim($_POST['address1']);
        $formfield['address2'] = trim($_POST['address2']);
        $formfield['city'] = trim($_POST['city']);
        $formfield['state'] = trim($_POST['state']);
        $formfield['zip'] = trim($_POST['zip']);

        //Check for required fields

        if (empty($formfield['fname']))
        {
            $error .= "<p>First Name is required.</p>";
        }
        if (empty($formfield['lname']))
        {
            $error .= "<p>Last Name is required</p>";
        }
        if (empty($formfield['email']))
        {
            $error .= "<p>E-mail is required.</p>";
        }
        if (empty($formfield['uname']))
        {
            $error .= "<p>Username is required.</p>";
        }
        if (empty($formfield['address1']))
        {
            $error .= "<p>Street Address is required.";
        }
        if (empty($formfield['city']))
        {
            $error .= "<p>City is required.</p>";
        }
        if (empty($formfield['state']))
        {
            $error .= "<p>State is required.</p>";
        }
        if (empty($formfield['zip']))
        {
            $error .= "<p>Zip Code is required.</p>";
        }

        //Check for duplicate usernames

        if($formfield['uname'] != $_POST['ouname'])
        {
            try
            {
                $sql = "SELECT * FROM jacatoe_users WHERE uname = :uname";
                $stmt = $pdo->prepare($sql);
                $stmt->bindValue(':uname', $formfield['uname']);
                $stmt->execute();

                $count = $stmt->rowCount();

                if ($count > 0)
                {
                    $error .= "<p>Username is already in use.</p>";
                }
            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>WARNING: Something went wrong when selecting users!" . $exception->getMessage() . "</p></div>";

                exit();
            }
        }

        //Check for duplicate emails

        if($formfield['email'] != $_POST['email'])
        {
            try
            {
                $sql = "SELECT * FROM jacatoe_users WHERE email = :email";
                $stmt = $pdo->prepare($sql);
                $stmt->bindValue(':email', $formfield['email']);
                $stmt->execute();

                $count = $stmt->rowCount();

                if ($count > 0)
                {
                    $error .= "<p>E-mail is already in use.</p>";
                }
            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>ERROR while selecting emails!" . $exception->getMessage() . "</p></div>";

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

                //If no errors, update user data in database

                $sql = "UPDATE jacatoe_users SET fname = :fname, mi = :mi, lname = :lname, email = :email, uname = :uname,
                                                 address1 = :address1, address2 = :address2, city = :city, state = :state, zip = :zip
                        WHERE ID = :ID ";
                $stmt = $pdo->prepare($sql);
                $stmt->bindvalue(':ID', $_POST['ID']);
                $stmt->bindvalue(':fname', $formfield['fname']);
                $stmt->bindvalue(':mi', $formfield['mi']);
                $stmt->bindvalue(':lname', $formfield['lname']);
                $stmt->bindvalue(':email', $formfield['email']);
                $stmt->bindvalue(':uname', $formfield['uname']);
                $stmt->bindvalue(':address1', $formfield['address1']);
                $stmt->bindvalue(':address2', $formfield['address2']);
                $stmt->bindvalue(':city', $formfield['city']);
                $stmt->bindvalue(':state', $formfield['state']);
                $stmt->bindvalue(':zip', $formfield['zip']);
                $stmt->execute();

                //Hide form and display confirmation

                $form = false;

                echo "<div class='success'><p>Your information has been updated.</p></div>";

            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>WARNING: Error while inserting data into the database." . $exception->getMessage() . "</p></div>";

                exit();
            }
            
        }//End of errors
        
    } //End of submit

    if($form)
    {

        //Query to get item info from database

        $sql = 'SELECT * FROM jacatoe_users WHERE ID = :ID';
        $stmt = $pdo->prepare($sql);
        $stmt->bindValue(':ID', $_GET['ID']);
        $stmt->execute();
        $user = $stmt->fetch();
?>
        <!--Show user form-->

        <form method="post" action="userupdate.php" name="upuser">

            <fieldset>

                <table>

                    <tr>
                        <th><label for="fname">First Name</label></th>
                        <td><input type="text" name="fname" id="fname" maxlength="30" value="<?php if (isset($formfield['fname']) && !empty($formfield['fname'])) {echo $formfield['fname'];}
                                                                                                   else {echo $user['fname'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="mi">Middle Initial</label></th>
                        <td><input type="text" name="mi" id="mi" maxlength="1" value="<?php if (isset($formfield['mi']) && !empty($formfield['mi'])) {echo $formfield['mi'];}
                                                                                            else {echo $user['mi'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="lname">Last Name</label></th>
                        <td><input type="text" name="lname" id="lname" maxlength="30" value="<?php if (isset($formfield['lname']) && !empty($formfield['lname'])) {echo $formfield['lname'];}
                                                                                                   else {echo $user['lname'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="email">E-mail</label></th>
                        <td><input type="email" name="email" id="email" value="<?php if (isset($formfield['email']) && !empty($formfield['email'])) {echo $formfield['email'];}
                                                                                     else {echo $user['email'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="uname">Username</label></th>
                        <td><input type="text" name="uname" id="uname" maxlength="30" value="<?php if (isset($formfield['uname']) && !empty($formfield['uname'])) {echo $formfield['uname'];}
                                                                                                   else {echo $user['uname'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="address1">Street Address</label></th>
                        <td><input type="text" name="address1" id="address1" maxlength="50" value="<?php if (isset($formfield['address1']) && !empty($formfield['address1'])) {echo $formfield['address1'];}
                                                                                                         else {echo $user['address1'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="address2">Apt./Suite</label></th>
                        <td><input type="text" name="address2" id="address2" maxlength="50" value="<?php if (isset($formfield['address2']) && !empty($formfield['address2'])) {echo $formfield['address2'];}
                                                                                                         else {echo $user['address2'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="city">City</label></th>
                        <td><input type="text" name="city" id="city" maxlength="50" value="<?php if (isset($formfield['city']) && !empty($formfield['city'])) {echo $formfield['city'];}
                                                                                                 else {echo $user['city'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="state">State</label></th>
                        <td><input type="text" name="state" id="state" maxlength="2" value="<?php if (isset($formfield['state']) && !empty($formfield['state'])) {echo $formfield['state'];}
                                                                                                  else {echo $user['state'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="zip">Zip Code</label></th>
                        <td><input type="text" name="zip" id="zip" maxlength="5" value="<?php if (isset($formfield['zip']) && !empty($formfield['zip'])) {echo $formfield['zip'];}
                                                                                              else {echo $user['zip'];} ?>"/></td>
                    </tr>

                    <!--All required fields populated with original values, as most fields will not change often -->

                    <tr>
                        <th>Submit</th>
                        <td><input type="hidden" name="ID" id="ID" value="<?php echo $user['ID']; ?>" />
                            <input type="hidden" name="ofname" id="ofname" value="<?php echo $user['fname']; ?>" />
                            <input type="hidden" name="olname" id="olname" value="<?php echo $user['lname']; ?>" />
                            <input type="hidden" name="ouname" id="ouname" value="<?php echo $user['uname']; ?>" />
                            <input type="hidden" name="oemail" id="oemail" value="<?php echo $user['email']; ?>" />
                            <input type="hidden" name="oaddress1" id="oaddress1" value="<?php echo $user['address1']; ?>" />
                            <input type="hidden" name="ocity" id="ocity" value="<?php echo $user['city']; ?>" />
                            <input type="hidden" name="ostate" id="ostate" value="<?php echo $user['state']; ?>" />
                            <input type="hidden" name="ozip" id="ozip" value="<?php echo $user['zip']; ?>" />
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