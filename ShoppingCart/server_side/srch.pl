#!C:\Strawberry\perl\bin\perl.exe -T

#Author:Raunak Kumar CSE A 67

use DBI;

print "Content-type: text/html \n\n";

my $host = "127.0.0.1";
my $database = "user_data";
my $tablename = "xml_data";
my $user = "root";
my $pw = "";



$driver = "DBI:mysql:database=$database;host=$host";
$connect_me = DBI->connect($driver, $user, $pw);

$run_query = $connect_me->prepare("SELECT * FROM $tablename");
$run_query->execute();
print qq|
<html>
<h1>All User</h1>
<table>
|;
while(@result = $run_query->fetchrow_array()){
 
 
  print qq|  <tr>  
     <td>|;print $result[0]; 
     print qq|
     </td>
      
     
	</tr> |;
}

print qq|
<table>
<form name="form1" method="post" action="http://localhost/perl/userdata.pl">
<p>Select Name:<input type="text" name="UserName" value=""></p>
		<div style="text-align: center;"><input name="Submit" value="Find" type="submit"></div>
	</form>
</html>
|;