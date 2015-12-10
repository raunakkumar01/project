/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flight;
import java.io.*;
import java.util.*;
/**
 *
 * @author Sayan Chaudhuri
 */
public class PersistenceManager {
 
 public SpiceJet[] readSpiceJet(String s)
 {
     
     SpiceJet sj[]=new SpiceJet[100];
     int i=0,j;
     BufferedReader bfRdr = null;        
     String str;
        
        try 
        {
            bfRdr= new BufferedReader(new FileReader(s));
            str=bfRdr.readLine();
            while((str=bfRdr.readLine())!=null)  //
            {
                String prm[]=new String[10];  
                String ch=""+(char)34;
                StringTokenizer stn1= new StringTokenizer(str,ch); 
                String str1= stn1.nextToken().trim();
                //System.out.println(str1);                
                if(!stn1.hasMoreTokens())
                {
                    StringTokenizer stn2= new StringTokenizer(str1,",");                    
                    for(j=0;j<9;j++)
                        prm[j]=stn2.nextToken().trim();                        
                    
                    prm[9]="";
                    while(stn2.hasMoreTokens())prm[j++]=stn2.nextToken().trim();
                    //System.out.println(prm[j-1]);                    
                }                
                else
                {
                    StringTokenizer stn2= new StringTokenizer(str1,",");                     
                    prm[0]=stn2.nextToken().trim();                    
                    prm[1]=stn2.nextToken().trim();
                    
                    prm[2]=stn1.nextToken().trim();
                                       
                    str1=stn1.nextToken().trim();
                    stn2= new StringTokenizer(str1,",");
                    for(j=3;j<9;j++)
                        prm[j]=stn2.nextToken().trim();
                    
                    prm[9]="";
                    while(stn2.hasMoreTokens())prm[j++]=stn2.nextToken().trim();
                    //System.out.println(prm[j-1]);                                             
                }                   
                sj[i++]=new SpiceJet(Flight.sz++,prm[0],prm[1],prm[2],prm[3],prm[4],prm[5],prm[7],prm[8],prm[9] );
		//System.out.println(" "+sj[i-1].source + " " + sj[i-1].destination + " " + sj[i-1].frequency);			
	    }            
        bfRdr.close();
        }catch (FileNotFoundException e) {
			 System.out.println("Error opening the input file!" + e.getMessage());
			 System.exit(0);
	}catch ( IOException e) {
			 System.out.println(" IO Error!" + e.getMessage());
			 e.printStackTrace();
			 System.exit(0);			 		
	}
        return sj;
}

 
public SilkAir[] readSilkAir(String s)
{
    SilkAir sa[]=new SilkAir[20];
    BufferedReader bfRdr = null;      
    String str;
    int i=0,j;
        
        try 
        {
            String prm[]=new String[8];
            bfRdr= new BufferedReader(new FileReader(s));
            str=bfRdr.readLine();
            String std[]=str.split(" ");
            prm[6]=std[1]+"-"+std[2].substring(0, 3)+"-"+std[3];
            prm[7]=std[5]+"-"+std[6].substring(0, 3)+"-"+std[7].substring(0, 4);
            //System.out.println(prm[7]);
            
            str=bfRdr.readLine();
            str=bfRdr.readLine();
            while((str=bfRdr.readLine())!=null)
            {
                
                
                String ch=""+(char)34;
                StringTokenizer stn1= new StringTokenizer(str,ch); 
                String str1=stn1.nextToken().trim();
                if(!stn1.hasMoreTokens())
                {
                    stn1= new StringTokenizer(str1,",");
                    prm[0]=stn1.nextToken().trim().split(" ")[0];
                    prm[1]="Singapore";
                    for(j=2;j<4;j++)
                        prm[j]=stn1.nextToken().trim();                        
                }
                else{
                    String sj[]=str1.split(" ");
                    prm[0]= sj[0];

                    prm[1]="Singapore";

                    prm[2]=stn1.nextToken().trim(); 

                    String str2;
                    str2= stn1.nextToken().trim().substring(1);   
                  
                    stn1= new StringTokenizer(str2,",");
                    prm[3]=stn1.nextToken();                    
                }
                String time[]= stn1.nextToken().trim().split("/");                
                prm[4]=time[0].trim();
                prm[5]=time[1].trim();
                
                sa[i++]=new SilkAir(Flight.sz++,prm[0],prm[1],prm[2],prm[3],prm[4],prm[5],prm[6],prm[7]);		
		//System.out.println(" "+sa[i-1].source + " " +sa[i-1].frequency +" "+ sa[i-1].departure + " " + sa[i-1].arival);		
            }
        bfRdr.close();             
       }catch (FileNotFoundException e) {
			 System.out.println("Error opening the input file!" + e.getMessage());
			 System.exit(0);
       }catch ( IOException e) {
			 System.out.println(" IO Error!" + e.getMessage());
			 e.printStackTrace();
			 System.exit(0);			 		
        }
        return sa;
    }
       
}
