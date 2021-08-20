<?php
/**
 * Created by PhpStorm.
 * User: Joshua
 * Date: 3/21/2016
 * Time: 4:45 PM
 */
    include_once "header.php";
?>

    <table>
            <tr><th>Date of Birth</th> <td><?php echo $_POST['dob']; ?></td></tr>
            <tr><th>First Name</th> <td><?php echo $_POST['fname']; ?></td></tr>
            <tr><th>Middle Initial</th> <td><?php echo $_POST['mi']; ?></td></tr>
            <tr><th>Last Name</th> <td><?php echo $_POST['lname']; ?></td></tr>
            <tr><th>Username</th> <td><?php echo $_POST['username']; ?></td></tr>
            <tr><th>Password</th> <td><?php echo $_POST['password']; ?></td></tr>
            <tr><th>Comments</th> <td><?php echo $_POST['comments']; ?></td></tr>
            <tr><th>URL</th> <td><?php echo $_POST['url']; ?></td></tr>
            <tr><th>Time Zone</th> <td><?php echo $_POST['timezone']; ?></td></tr>
            <tr><th>Age Range</th> <td><?php echo $_POST['agerange']; ?></td></tr>
            <tr><th>E-mail</th> <td><?php echo $_POST['email']; ?></td></tr>
            <tr><th>Address</th> <td><?php echo $_POST['address']; ?></td></tr>
            <tr><th>Phone</th> <td><?php echo $_POST['phonetype']; ?></td></tr>
    </table>

<?php
    include_once "footer.php";
?>
