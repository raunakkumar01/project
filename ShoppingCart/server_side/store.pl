#!C:\Strawberry\perl\bin\perl.exe -T
#Author:Raunak Kumar CSE A 67
use strict;
use warnings;
use CGI;
use HTML::TableContentParser;
use XML::Writer;
use IO::File;

my $query = CGI->new;
#my $name = 
my @names = $query->param;

my $nm=$query->param('UserName');
my $dt=$query->param('mobval');
my @abc = split(',',$dt);
my $sz = @abc;


my $output_file = "myfile.xml";
my $output = new IO::File(">$output_file");

my $writer = new XML::Writer(OUTPUT=>$output, DATA_MODE=>1);



	$writer->startTag("elements");
	$writer->startTag("element");
			$writer->startTag("ename");
				$writer->characters("Name");
			$writer->endTag("ename");
	
			$writer->startTag("eprice");
				$writer->characters("Price");
			$writer->endTag("eprice");
		
		$writer->endTag("element");
for(my $a = 0; $a < $sz  ;$a=$a+2  ){
	## Create a <title> element, with content
		$writer->startTag("element");
			$writer->startTag("ename");
				$writer->characters($abc[$a]);
			$writer->endTag("ename");
	
			$writer->startTag("eprice");
				$writer->characters($abc[$a+1]);
			$writer->endTag("eprice");
		
		$writer->endTag("element");
}

	$writer->endTag("elements");





$writer->end();
$output->close();


print "Content-type: text/html\n\n";
print "<html><head>";
print "<title>CGI Test</title>";
print "</head>";
print "<body><h2>Want to submit the Page! </h2>";




print qq|
<form name="form1" method="post" action="http://localhost/perl/insrt.pl">
	<div style="text-align: center;"><input type="text" name="UserName" value="|;print $nm; print qq|"><input name="Insert" value="Insert" type="submit"></div></form>
|;

print "</body></html>";