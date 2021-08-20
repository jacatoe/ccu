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
        //Store and sanitize user data
    
        $formfield['fname'] = trim($_POST['fname']);
        $formfield['mi'] = trim($_POST['mi']);
        $formfield['lname'] = trim($_POST['lname']);
        $formfield['email'] = trim(strtolower($_POST['email']));
        $formfield['uname'] = trim(strtolower($_POST['uname']));
        $formfield['pwd'] = trim($_POST['pwd']);
        $formfield['pwd2'] = trim($_POST['pwd2']);
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
        if (empty($formfield['pwd']))
        {
            $error .= "<p>Password is required.</p>";
        }
        if (empty($formfield['pwd2']))
        {
            $error .= "<p>Password was not confirmed.</p>";
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
    
        //Compare passwords
    
        if ($formfield['pwd'] != $formfield['pwd2'])
        {
            $error .= "<p>The passwords you entered do not match.</p>";
        }
    
        //Hash password
    
        $lowersymbols = "./abcdefghijklmnopqrstuvwxyz!@#$%^&*";
    
        for ($i = 0; $i < 22; $i++)
        {
            $grains .= substr($lowersymbols, mt_rand(0, 34), 1);
        }
    
        $salt = '$2y$10$' . $grains;
        $newpwd = crypt($formfield['pwd'], $salt);
    
        //Check for duplicate usernames
    
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
    
        //Check for duplicate emails
    
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
    
                //If no errors, insert user data into database
    
                $sql = "INSERT INTO jacatoe_users (fname, mi, lname, email, uname, salt, pwd, address1, address2, city, state, zip)
                                               VALUES (:fname, :mi, :lname, :email, :uname, :salt, :pwd, :address1, :address2, :city, :state, :zip)";
                $stmt = $pdo->prepare($sql);
                $stmt->bindvalue(':fname', $formfield['fname']);
                $stmt->bindvalue(':mi', $formfield['mi']);
                $stmt->bindvalue(':lname', $formfield['lname']);
                $stmt->bindvalue(':email', $formfield['email']);
                $stmt->bindvalue(':uname', $formfield['uname']);
                $stmt->bindvalue(':salt', $salt);
                $stmt->bindvalue(':pwd', $newpwd);
                $stmt->bindvalue(':address1', $formfield['address1']);
                $stmt->bindvalue(':address2', $formfield['address2']);
                $stmt->bindvalue(':city', $formfield['city']);
                $stmt->bindvalue(':state', $formfield['state']);
                $stmt->bindvalue(':zip', $formfield['zip']);
                $stmt->execute();
    
                //Hide form and display confirmation
    
                $form = false;
    
                echo "<div class='success'><p>Thank you for joining!   Go to <a href='userlist.php'>User List</a></p></div>";
    
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
?>

        <!--Show user form-->

        <form method="post" action="useradd.php" name="register">

            <fieldset>
                
                <table>

                    <tr>
                        <th><label for="fname">First Name</label></th>
                        <td><input type="text" name="fname" id="fname" maxlength="30" value="<?php if (isset($formfield['fname'])) {echo $formfield['fname'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="mi">Middle Initial</label></th>
                        <td><input type="text" name="mi" id="mi" maxlength="1" value="<?php if (isset($formfield['mi'])) {echo $formfield['mi'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="lname">Last Name</label></th>
                        <td><input type="text" name="lname" id="lname" maxlength="30" value="<?php if (isset($formfield['lname'])) {echo $formfield['lname'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="email">E-mail</label></th>
                        <td><input type="email" name="email" id="email" value="<?php if (isset($formfield['email'])) {echo $formfield['email'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="uname">Username</label></th>
                        <td><input type="text" name="uname" id="uname" maxlength="30" value="<?php if (isset($formfield['uname'])) {echo $formfield['uname'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="pwd">Password</label></th>
                        <td><input type="password" name="pwd" id="pwd" value="<?php if (isset($formfield['pwd'])) {echo $formfield['pwd'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="pwd2">Confirm Password</label></th>
                        <td><input type="password" name="pwd2" id="pwd2" value="<?php if (isset($formfield['pwd2'])) {echo $formfield['pwd2'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="address1">Street Address</label></th>
                        <td><input type="text" name="address1" id="address1" maxlength="50" value="<?php if (isset($formfield['address1'])) {echo $formfield['address1'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="address2">Apt./Suite</label></th>
                        <td><input type="text" name="address2" id="address2" maxlength="50" value="<?php if (isset($formfield['address2'])) {echo $formfield['address2'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="city">City</label></th>
                        <td><input type="text" name="city" id="city" maxlength="50" value="<?php if (isset($formfield['city'])) {echo $formfield['city'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="state">State</label></th>
                        <td><input type="text" name="state" id="state" maxlength="2" value="<?php if (isset($formfield['state'])) {echo $formfield['state'];} ?>"/></td>
                    </tr>

                    <tr>
                        <th><label for="zip">Zip Code</label></th>
                        <td><input type="text" name="zip" id="zip" maxlength="5" value="<?php if (isset($formfield['zip'])) {echo $formfield['zip'];} ?>"/></td>
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