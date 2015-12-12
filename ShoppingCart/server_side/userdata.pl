#!C:\Strawberry\perl\bin\perl.exe -T

#Author:Raunak Kumar CSE A 67

use DBI;
use CGI;
use XML::Simple;
use Data::Dumper;

print "Content-type: text/html \n\n";

my $host = "127.0.0.1";
my $database = "user_data";
my $tablename = "xml_data";
my $user = "root";
my $pw = "";

	 my $cgi = new CGI;
	 my $nm = $cgi->param( 'UserName' ) || '';



$driver = "DBI:mysql:database=$database;host=$host";
$connect_me = DBI->connect($driver, $user, $pw);

$run_query = $connect_me->prepare("SELECT * FROM $tablename WHERE user_name=?");
$run_query->execute($nm);
print qq|
<html>
<h1>User Data</h1>

|;
@result = $run_query->fetchrow_array(); 
 
  print qq|  <div>  
     |;print $result[0]; 
     print qq|
     </div>
 |;

my $datalist = XMLin($result[1]);

#print Dumper($datalist);

print qq|

<table>
|;

foreach my $data (@{$datalist->{element}}) {
	

	
	print qq|  <tr>  
     <td>|;print $data->{ename} . "\n";
	  print qq|
     </td>
      
     
 |;
 print qq|    
     <td>
     |;print $data->{eprice} . "\n";
	  print qq|
    </td>
      
     </tr>
 |;
}

#}
print qq|
<table>
</html>
|;

