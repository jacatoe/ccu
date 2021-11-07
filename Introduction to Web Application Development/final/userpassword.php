<?php

    //Store page title

    $pagetitle = "Update Password";

    //Include header

    require_once "header.php";

    $form = true; //Form visibility

    $error = ""; //Stores error messages

    if(isset($_POST['submit']))
    {
        //Retain ID
    
        $_GET['ID'] = $_POST['ID'];
    
        //Store and sanitize user data
            
        $formfield['newpwd'] = trim($_POST['newpwd']); 
        $formfield['confirm'] = trim($_POST['confirm']);
    
        //Check for required fields
            
        if (empty($formfield['newpwd']))
        {
            $error .= "<p>New password is required.</p>";
        }
        if (empty($formfield['confirm']))
        {
            $error .= "<p>New password was not confirmed.";
        }

        //Compare passwords

        if ($formfield['confirm'] != $formfield['newpwd'])
        {
            $error .= "<p>The passwords you entered do not match.</p>";
        }

        //Hash new password

        $lowersymbols = "./abcdefghijklmnopqrstuvwxyz!@#$%^&*";

        for ($i = 0; $i < 22; $i++)
        {
            $grains .= substr($lowersymbols, mt_rand(0, 34), 1);
        }

        $newsalt = '$2y$10$' . $grains;
        $newpwd = crypt($formfield['newpwd'], $salt);

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

                //If no errors, update password in database

                $sql = "UPDATE jacatoe_users SET salt = :newsalt, pwd = :newpwd
                        WHERE ID = :ID ";
                $stmt = $pdo->prepare($sql);
                $stmt->bindvalue(':ID', $_POST['ID']);
                $stmt->bindvalue(':newsalt', $newsalt);
                $stmt->bindvalue(':newpwd', $newpwd);
                $stmt->execute();

                //Hide form and redirect to confirmation

                $form = false;

                header("Location: logout.php?state=3");

            }
            catch (PDOException $exception)
            {
                echo "<div class='error'> <p>WARNING: Error while updating password! " . $exception->getMessage() . "</p></div>";

                exit();
            }

        }//End of errors
        
        
            
    }//End of submit

    if($form)
    {

?>
        <!--Show user form-->

        <form method="post" action="userpassword.php" name="uppwd">

            <fieldset>

                <table>

                    <tr>
                        <th><label for="newpwd">New Password</label></th>
                        <td><input type="password" name="newpwd" id="newpwd" /></td>
                    </tr>

                    <tr>
                        <th><label for="confirm">Confirm Password</label></th>
                        <td><input type="password" name="confirm" id="confirm" /></td>
                    </tr>

                    <tr>
                        <th>Submit</th>
                        <td><input type="submit" name="submit" value="Submit"</td>
                    </tr>

                </table>

            </fieldset>

        </form>

<?php

    }//End of form

    //Include footer

    require_once "footer.php";

?>