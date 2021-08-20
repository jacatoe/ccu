<?php
    include_once "header.php";

    if(isset($_POST['submit']))
    {
        $formfield['fname'] = trim($_POST['fname']);
        $formfield['mi'] = trim($_POST['mi']);
        $formfield['lname'] = trim($_POST['lname']);
        $formfield['username'] = trim(strtolower($_POST['username']));
        $formfield['password'] = trim($_POST['password']);
        $formfield['comments'] = trim($_POST['comments']);
        $formfield['url'] = trim($_POST['url']);
        $formfield['timezone'] = $_POST['timezone'];
        $formfield['agerange'] = $_POST['agerange'];
        $formfield['email'] = trim(strtolower($_POST['email']));
        $formfield['address'] = trim($_POST['address']);
        $formfield['address2'] = trim($_POST['address2']);
        $formfield['phonetype'] = $_POST['phonetype'];
        $formfield['phonenum'] = trim($_POST['phonenum']);
        
        if(empty($formfield['fname']))
        {
            $errormsg .= "<p>First name is required.</p>";
        }
        if(empty($formfield['lname']))
        {
            $errormsg .= "<p>Last name is required.</p>";
        }
        if(empty($formfield['username']))
        {
            $errormsg .= "<p>Username is required.</p>";
        }
        if(empty($formfield['password']))
        {
            $errormsg .= "<p>Password is required.</p>";
        }
        if(empty($formfield['comments']))
        {
            $errormsg .= "<p>Comments are required.</p>";
        }
        if(empty($formfield['timezone']))
        {
            $errormsg .= "<p>Time zone is required.</p>";
        }
        if(empty($formfield['address']))
        {
            $errormsg .= "<p>Address is required.</p>";
        }
        
        $sql = "INSERT INTO jacatoe4 (fname, mi, lname, username, password, comments, url, timezone, agerange, email, address, address2, phonetype, phonenum)
                          VALUES (:fname, :mi, :lname, :username, :password, :comments, :url, :timezone, :agerange, :email, :address, :address2, :phonetype, :phonenum)";
        $stmt = $pdo->prepare($sql);
        $stmt->bindvalue(':fname', $formfield['fname']);
        $stmt->bindvalue(':mi', $formfield['mi']);
        $stmt->bindvalue(':lname', $formfield['lname']);
        $stmt->bindvalue(':username', $formfield['username']);
        $stmt->bindvalue(':password', $formfield['password']);
        $stmt->bindvalue(':comments', $formfield['comments']);
        $stmt->bindvalue(':url', $formfield['url']);
        $stmt->bindvalue(':timezone', $formfield['timezone']);
        $stmt->bindvalue(':agerange', $formfield['agerange']);
        $stmt->bindvalue(':email', $formfield['email']);
        $stmt->bindvalue(':address', $formfield['address']);
        $stmt->bindvalue(':address2', $formfield['address2']);
        $stmt->bindvalue(':phonetype', $formfield['phonetype']);
        $stmt->bindvalue(':phonenum', $formfield['phonenum']);
        $stmt->execute();
        
    }   
    

?>
    <form method="post" action="index.php" name="myform">
        <fieldset><legend>User Information</legend>
            <table>
                <tr>
                    <td><label for="fname">First Name:</label></td>
                    <td><input type="text" name="fname" id="fname" size="25" required value="<?php if(isset($_POST['fname'])){echo $_POST['fname'];} ?>" /></td>
                </tr>
                <tr>
                    <td><label for="mi">Middle Initial:</label></td>
                    <td><input type="text" name="mi" id="mi" size="3" maxlength="1" value="<?php if(isset($_POST['mi'])){echo $_POST['mi'];} ?>" /></td>
                </tr>
                <tr>
                    <td><label for="lname">Last Name:</label></td>
                    <td><input type="text" name="lname" id="lname" size="35" required value="<?php if(isset($_POST['lname'])){echo $_POST['lname'];} ?>" /></td>
                </tr>
                <tr>
                    <td><label for="username">Username:</label></td>
                    <td><input type="text" name="username" id="username" size="15" maxlength="10" required value="<?php if(isset($_POST['username'])){echo $_POST['username'];} ?>" /></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" name="password" id="password" required value="<?php if(isset($_POST['password'])){echo $_POST['password'];} ?>" /></td>
                </tr>
                <tr>
                    <td><label for="comments">Comments:</label></td>
                    <td><textarea name="comments" id="comments" required><?php if(isset($_POST['comments'])){echo $_POST['comments'];} ?></textarea></td>
                </tr>
                <tr>
                    <td><label for="url">URL:</label></td>
                    <td><input type="url" name="url" id="url" value="<?php if(isset($_POST['url'])){echo $_POST['url'];} ?>" ></td>
                </tr>
                <tr>
                    <td><label for="timezone">Time Zone:</label></td>
                    <td><select name="timezone" id="timezone" required>
                        <option value="" <?php if(isset($_POST['timezone'])&& isset($_POST['timezone'])=="") {echo "selected";} ?> >SELECT ONE</option>
                        <option value="EST" <?php if(isset($_POST['timezone'])&& isset($_POST['timezone'])=="EST") {echo "selected";} ?> >Eastern (EST)</option>
                        <option value="CST" <?php if(isset($_POST['timezone'])&& isset($_POST['timezone'])=="CST") {echo "selected";} ?> >Central (CST)</option>
                        <option value="MST" <?php if(isset($_POST['timezone'])&& isset($_POST['timezone'])=="MST") {echo "selected";} ?> >Mountain (MST)</option>
                        <option value="PST" <?php if(isset($_POST['timezone'])&& isset($_POST['timezone'])=="PST") {echo "selected";} ?> >Pacific (PST)</option>
                    </select></td>
                </tr>
                <tr>
                    <td><label for="age13-17">Age Range:</label></td> <!--Can't use "agerange"?-->
                    <td><input type="radio" name="agerange" id="age13-17" value="13-17" <?php if(isset($_POST['agerange'])&& $_POST['agerange'] == "13-17"){echo "checked";} ?> >
                        <label for="age13-17">13-17</label>
                        <br />
                        <input type="radio" name="agerange" id="age18-24" value="18-24" <?php if(isset($_POST['agerange'])&& $_POST['agerange'] == "18-24"){echo "checked";} ?> >
                        <label for="age18-24">18-24</label>
                        <br />
                        <input type="radio" name="agerange" id="age25-30" value="25-30" <?php if(isset($_POST['agerange'])&& $_POST['agerange'] == "25-30"){echo "checked";} ?> >
                        <label for="age25-30">25-30</label>
                        <br />
                        <input type="radio" name="agerange" id="age30+" value="30+" <?php if(isset($_POST['agerange'])&& $_POST['agerange'] == "30+"){echo "checked";} ?> >
                        <label for="age30+">30+</label>
                    </td>
                </tr>
                <tr>
                   <td><label for="email">E-mail:</label></td>
                   <td><input type="email" name="email" id="email" size="30" value="<?php if(isset($_POST['email'])){echo $_POST['email'];} ?>" ></td>
                </tr>
                <tr>
                    <td><label for="address">Address:</label></td>
                    <td><label for="address">Address</label>
                        <br />
                        <input type="text" name="address" id="address" required value="<?php if(isset($_POST['address'])){echo $_POST['address'];} ?>" />
                        <br />
                        <label for="address2">Address 2</label>
                        <br />
                        <input type="text" name="address2" id="address2" value="<?php if(isset($_POST['address2'])){echo $_POST['address2'];} ?>" />
                    </td>
                </tr>
                <tr>
                    <td><label for="phonetype">Phone:</label></td>
                    <td>
                        <input type="radio" name="phonetype" id="phonetype" <?php if(isset($_POST['phonetype'])&& $_POST['phonetype'] == "phonetype"){echo "checked";} ?> >
                        <label for="phonetype">Mobile</label>
                        <input type="radio" name="phonetype" id="phonetype2" <?php if(isset($_POST['phonetype2'])&& $_POST['phonetype2'] == "phonetype2"){echo "checked";} ?> >
                        <label for="phonetype2">Home</label>
                        <br />
                        <label for="phonenum">Number:</label>
                        <input type="tel" name="phonenum" id="phonenum" value="<?php if(isset($_POST['phonenum'])){echo $_POST['phonenum'];} ?>">
                    </td>
                </tr>
                <tr>
                    <td><label for="submit">Submit:</label></td>
                    <td><input type="submit" name="submit" id="submit" value="submit" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
<?php
    include_once "footer.php";
?>


