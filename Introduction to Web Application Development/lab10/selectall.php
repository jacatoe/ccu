<?php
	$pagetitle = "Select All";
	include_once "header.php";

	try
	{
		$sql = "SELECT * FROM lab09";
		$stmt = $pdo->prepare($sql);
		$stmt->execute();
		$result = $stmt->fetchAll();

		echo "<table><tr><th>Options</th><th>ID</th><th>Text Box</th></tr>";
		foreach ($result as $row)
		{
			echo "<tr>
					<td><a href='selectone.php?ID=" . $row['ID'] . "'>VIEW</a> |
						  <a href='update.php?ID=" . $row['ID'] . "'>UPDATE</a> |
						  <a href='delete.php?ID=" . $row['ID'] . "$textbox=" . $row['textbox'] . "'>DELETE</a></td>
				  	<td>" . $row['ID'] . "</td>
				  	<td>" . $row['textbox'] . "</td>
				  </tr>";
		}
		echo "</table>";
	}//try
	catch (PDOException $e)
	{
		echo 'Error fetching users: <br />ERROR MESSAGE:<br />' .$e->getMessage();
		exit();
	}
	include_once "footer.php";
?>
