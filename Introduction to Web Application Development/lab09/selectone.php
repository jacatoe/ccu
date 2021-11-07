<?php
	$pagetitle = "Select One";
	include_once "header.php";

	try
	{
		$sql = "SELECT * FROM lab09 WHERE ID = :ID";
		$stmt = $pdo->prepare($sql);
		$stmt->bindvalue(":ID", $_GET['ID']);
		$stmt->execute();
		$row = $stmt->fetch();

		echo "<table><tr><th>ID:</th><td>" . $row['ID'] . "</td></tr>";
		echo "<tr><th>Text Box:</th><td>" . $row['textbox'] . "</td></tr>";
		echo "<tr><th>Select Box:</th><td>" . $row['selectbox'] . "</td></tr>";
		echo "<tr><th>Radio Button:</th><td>" . $row['radiobutton'] . "</td></tr>";
		echo "<tr><th>Text Area Box:</th><td>" . $row['textareabox'] . "</td></tr>";
		echo "<tr><th>Input Date:</th><td>";
		echo date("F j, Y \a\\t h:i a", $row['input date']);
		echo "</td></tr></table>";

	}//try
	catch (PDOException $e)
	{
		echo "Error fetching users: <br />ERROR MESSAGE:<br />" .$e->getMessage();
		exit();
	}

	include_once "footer.php";
?>
