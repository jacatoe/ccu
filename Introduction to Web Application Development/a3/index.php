<?php
    include_once "header.php";
?>
    <form method="post" action="thanks.php" name="myform">
        <fieldset><legend>User Information</legend>
            <table>
                <tr>
                    <td><label for="dob">Date of Birth:</label></td>
                    <td><input type="date" name="dob" id="dob" required /></td>
                </tr>
                <tr>
                    <td><label for="fname">First Name:</label></td>
                    <td><input type="text" name="fname" id="fname" size="25" required /></td>
                </tr>
                <tr>
                    <td><label for="mi">Middle Initial:</label></td>
                    <td><input type="text" name="mi" id="mi" size="3" maxlength="1" /></td>
                </tr>
                <tr>
                    <td><label for="lname">Last Name:</label></td>
                    <td><input type="text" name="lname" id="lname" size="35" required /></td>
                </tr>
                <tr>
                    <td><label for="username">Username:</label></td>
                    <td><input type="text" name="username" id="username" size="15" maxlength="10" required/></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" name="password" id="password" required /></td>
                </tr>
                <tr>
                    <td><label for="comments">Comments:</label></td>
                    <td><textarea name="comments" id="comments" required></textarea></td>
                </tr>
                <tr>
                    <td><label for="url">URL:</label></td>
                    <td><input type="url" name="url" id="url"></td>
                </tr>
                <tr>
                    <td><label for="timezone">Time Zone:</label></td>
                    <td><select name="timezone" id="timezone" required>
                        <option value="">SELECT ONE</option>
                        <option value="EST">Eastern (EST)</option>
                        <option value="CST">Central (CST)</option>
                        <option value="MST">Mountain (MST)</option>
                        <option value="PST">Pacific (PST)</option>
                    </select></td>
                </tr>
                <tr>
                    <td><label for="age13-17">Age Range:</label></td> <!--Can't use "agerange"?-->
                    <td><input type="radio" name="agerange" id="age13-17" value="13-17">
                        <label for="age13-17">13-17</label>
                        <br />
                        <input type="radio" name="agerange" id="age18-24" value="18-24">
                        <label for="age18-24">18-24</label>
                        <br />
                        <input type="radio" name="agerange" id="age25-30" value="25-30">
                        <label for="age25-30">25-30</label>
                        <br />
                        <input type="radio" name="agerange" id="age30+" value="30+">
                        <label for="age30+">30+</label>
                    </td>
                </tr>
                <tr>
                   <td><label for="email">E-mail:</label></td>
                   <td><input type="email" name="email" id="email" size="30"></td>
                </tr>
                <tr>
                    <td><label for="address">Address:</label></td>
                    <td><label for="address">Address</label>
                        <br />
                        <input type="text" name="address" id="address" required />
                        <br />
                        <label for="address2">Address 2</label>
                        <br />
                        <input type="text" name="address2" id="address2" />
                    </td>
                </tr>
                <tr>
                    <td><label for="phonetype">Phone:</label></td>
                    <td>
                        <input type="radio" name="phonetype" id="phonetype">
                        <label for="phonetype">Mobile</label>
                        <input type="radio" name="phonetype" id="phonetype2">
                        <label for="phonetype2">Home</label>
                        <br />
                        <label for="phonenum">Number:</label>
                        <input type="tel" name="phonenum" id="phonenum">
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


