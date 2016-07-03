<html>
<body>
<?php

echo "Hi there sql<br>";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
  $text = $_GET['input'];
  

$servername = "*******";
$username = "******";
$password = "*****";

// Create connection
$conn = mysqli_connect($servername, $username, $password);

// Check connection
if (mysqli_connect_errno())
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$sql = "SELECT English FROM TABLE2 WHERE Arabic = $text LIMIT 10";
echo "$sql";
$result = mysqli_query($conn,$sql);
echo "<br>Here:result<br>";

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $result = $row["English"] ;
        echo $result."<br>";
    }
} else {
    $result = 0;
}
$conn->close();
#}
?>
</body>
</html>
