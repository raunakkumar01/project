#!C:\Strawberry\perl\bin\perl.exe -T

 
#Author:Raunak Kumar CSE A 67

 use CGI;


use DBI;

print "Content-type: text/html \n\n";


my $host = "127.0.0.1";
my $database = "user_data";
my $tablename = "xml_data";
my $user = "root";
my $pw = "";





 my $cgi = new CGI;
 
=begin comment
	 my $nname = $cgi->param( 'nname' ) || '';
	 my $npassword = $cgi->param( 'npassword' ) || '';
	 my $nemail = $cgi->param( 'nemail' ) || '';
	   <input type ="hidden" value=|;print $herb1; 
     print qq|
     >
     <input type ="hidden" value=|;print $xmltype_string; 
     print qq|
     >
=cut
 my $query = CGI->new;
 my $herb1 =  $query->param('UserName');
 local $/=undef;
             open (FILE , "<" , "myfile.xml" );
             my $xml=<FILE>;
             close (FILE);
             my $xmltype_string = $xml;#"XMLTYPE('$xml')";

my $driver = "DBI:mysql:database=$database;host=$host";
my $connect_me = DBI->connect($driver, $user, $pw);

my $run_query = $connect_me->prepare("insert into $tablename (user_name,user_xml) values ( ?, ?)");
$run_query->execute($herb1,$xmltype_string)
or die ("Couldn't connect to database: "), $DBI::errstr;


 

print "Content-type: text/html \n\n";

 print qq|
 <html>
     <h1> Result Submitted Succesfully</h1>
   <body>
     <a href="http://localhost/Shopping is Fun.html">Home</a>
	</body>
<html>
|;
