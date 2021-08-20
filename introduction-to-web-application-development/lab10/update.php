<?php
	$pagetitle = "Update";
	include_once "header.php";

	//NEEDED VARIABLES & INCLUDES
	$errormsg = "";
	$showform = 1;
	$inputdate = time();  //Unix time stamp for right now

	if(isset($_POST['submitbutton']))
	{
		$_GET['ID'] = $_POST['ID'];
		/* ****************************************************************************
		  CREATE NEW VARS TO STORE USER DATA & SANITIZE DATA FROM USER.
          NOTICE ALL FIELDS ARE INCLUDED, BUT ONLY SOME HAVE SANITIZING FUNCTIONS
		**************************************************************************** */
		$formfield['textbox'] = trim(strtolower($_POST['textbox']));
		$formfield['selectbox'] = $_POST['selectbox'];
		$formfield['radiobutton'] = $_POST['radiobutton'];
		$formfield['textareabox'] = trim($_POST['textareabox']);


		/*  ****************************************************************************
     	  CHECK FOR EMPTY FIELDS
    	  Complete the lines below for any REQIURED form fields only.
		  Do not do for optional fields.  (Middle initial is NEVER included here).
		  All are handled the same except for radio buttons.
    	**************************************************************************** */

		if(empty($formfield['textbox']))
		{
			$errormsg .= "<p>The textbox is empty. Repopulating values.</p>";
		}

		if(empty($formfield['selectbox']))
		{
			$errormsg .= "<p>The selectbox is empty. Repopulating values.</p>";
		}

		if(empty($formfield['textareabox']))
		{
			$errormsg .= "<p>The text area is empty. Repopulating values.</p>";
		}

		if(!isset($formfield['radiobutton']) || empty($formfield['radiobutton']))
		{
			$errormsg .= "<p>Your radio button selection is empty. Repopulating values.</p>";
		}
		
		if($errormsg != "")
		{
			echo "<div class='error'><p>ERRORS DETECTED! Review entries and try again.</p>";
			echo $errormsg;
			echo "</div>";
		}	


		/*  ****************************************************************************
            CONTROL FOR ERRORS.  IF ERRORS, DISPLAY THEM.  IF NOT, CONTINUE WITH FORM PROCESSING.
            **************************************************************************** */
		if($errormsg != "")
		{
			echo "<div class='error'><p>THERE ARE ERRORS!</p>";
			echo $errormsg;
			echo "</div>";
		}
		else
		{
			try
			{
				/*  ****************************************************************************
					INSERT DATA INTO DATABASE
            		**************************************************************************** */
				$sql = "UPDATE lab09 SET textbox = :textbox,
										 selectbox = :selectbox,
										 radiobutton = :radiobutton,
										 textareabox = :textareabox,
										 inputdate = :inputdate
									 WHERE ID = :ID";
				$stmt = $pdo->prepare($sql);
				$stmt->bindvalue(':textbox', $formfield['textbox']);
				$stmt->bindvalue(':selectbox', $formfield['selectbox']);
				$stmt->bindvalue(':radiobutton', $formfield['radiobutton']);
				$stmt->bindvalue(':textareabox', $formfield['textareabox']);
				$stmt->bindvalue(':inputdate', $inputdate);
				$stmt->bindvalue(':ID', $_POST['ID']);
				$stmt->execute();
				//hide the form
				$showform=0;
				echo "<div class='success'><p>There are no errors.  Thank you.</p></div>";
			}//try
			catch(PDOException $e)
			{
				echo "<div class='error'><p></p>ERROR updating data into the database!" .$e->getMessage() . "</p></div>";
				exit();
			}
		}//else errors
	}//isset submit

if($showform == 1) {
$sql = 'SELECT * FROM lab09 WHERE ID = :ID';
$stmt = $pdo->prepare($sql);
$stmt->bindValue(' :ID', $_GET['ID']);
$stmt->execute();
$row = $stmt->fetch();
?>
<form method="post" action="update.php" name="myform">
	<fieldset>
		<legend>Example Form</legend>
		<table>
			<tr>
				<th><label for="textbox">Text Box:</label></th>
				<td><input type="text" name="textbox" id="textbox"
						   value="<?php if (isset($formfield['textbox']) && !empty($formfield['textbox'])) {
							   echo $formfield['textbox'];
						   } else {
							   echo $row['textbox'];
						   }
						   } ?>"/></td>
				</tr>
				<tr>
					<th><label for="selectbox">Select Box:</label></th>
					<td><select name="selectbox" id="selectbox">
							<option value="" <?php if (isset($formfield['selectbox']) && $formfield['selectbox'] == "")
							{echo "selected";} 
							elseif(isset($row['selectbox']) && $row['selectbox'] == "")
							{echo "selected";}
							?>>SELECT ONE
							</option>
							<option value="A" <?php if (isset($formfield['selectbox']) && $formfield['selectbox'] == "A") 
							{echo "selected";} 
							elseif(isset($row['selectbox']) && $row['selectbox'] == "A")
							{echo "selected";}
							?>>Option A
							</option>
							<option value="B" <?php if (isset($formfield['selectbox']) && $formfield['selectbox'] == "B") 
							{echo "selected";}
							elseif(isset($row['selectbox']) && $row['selectbox'] == "B")
							{echo "selected";}
							?>>Option B
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Radio Button:</th>
					<td><input type="radio" name="radiobutton" id="radiobutton1"
							   value="1" <?php if (isset($formfield['radiobutton']) && $formfield['radiobutton'] == 1) 
						{echo "checked";}
						elseif(isset($row['radiobutton']) && $row['radiobutton'] == 1)
						{echo "checked";}
						?> /><label for="radiobutton1">One</label>
						<input type="radio" name="radiobutton" id="radiobutton2"
							   value="2" <?php if (isset($formfield['radiobutton']) && $formfield['radiobutton'] == 2) 
						{echo "checked";}
						elseif(isset($row['radiobutton']) && $row['radiobutton'] == 2)
						{echo "checked";}
						?> /><label for="radiobutton2">Two</label>
					</td>
				</tr>
				<tr>
					<th><label for="textareabox">Text Area:</label></th>
					<td><textarea name="textareabox" id="textareabox">
							<?php if (isset($formfield['textareabox']) && !empty($formfield['textareabox']))
							{echo $formfield['textareabox'];}
							else {echo $row['textareabox'];}?>
						</textarea></td>
				</tr>
				<tr>
					<th>Submit:</th>
					<td><input type="hidden" name="ID" id="ID" value="<?php echo $row['ID'];?>" />
						<input type="submit" name="submitbutton" value="GO"/></td>
				</tr>
			</table>
		</fieldset>
	</form>
} //showform

<?php
	include_once "footer.php";
?>
