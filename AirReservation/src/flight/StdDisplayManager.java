/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Raunak Kumar
 */

public class StdDisplayManager implements DisplayManager{
   
    public Seats ss[]=new Seats[100];
    public PersistenceManager pm=new PersistenceManager();
    public SpiceJet sj[];
    public SilkAir sa[];
    public int m;
    String day,srcNM;
    int i,nt;
    Date date=new Date();
    boolean r=false;
    SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
    Scanner in =new Scanner(System.in);
    CombinedFlight cf[];
    String ans,args[];
    
    public StdDisplayManager(String args[]){
        sj=pm.readSpiceJet(args[0]);
        sa=pm.readSilkAir(args[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
        try {
            if(sdf.parse(sj[0].effecTill).before(sdf.parse(sa[0].effecFrom))&&sdf.parse(sj[0].effecTill).before(sdf.parse(sa[0].effecTill))||sdf.parse(sj[0].effecFrom).after(sdf.parse(sa[0].effecFrom))&&sdf.parse(sj[0].effecFrom).after(sdf.parse(sa[0].effecTill))){
                System.out.println("Incompatible dates, please check input data");
                System.exit(0);
            }
        } catch (ParseException ex) {
            Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void prind()
    {
        for(int i=0;i<50;i++)System.out.print("=");
        System.out.println();
    }
    public void displaySearchPage(String[] args)
    {
        this.args=args;
        System.out.println("Welcome to the Flight Reservation System!");
        prind();
        do
        {
            r=false;        
            while(!r){
                System.out.println("Please enter Date of Travel (dd-MMM-yyyy):");
                day=in.nextLine();//System.out.println(dt);
                try {
                    date = sdf.parse(day);
                    r=true;
                } catch (ParseException ex) {
                    System.out.println("Wrong syntax");               
                }
            }
            r=false;

            String c[]={"DELHI","MUMBAI","PUNE"};                
            while(!r){
                System.out.println("Please enter Source City (DELHI, MUMBAI or PUNE):");
                srcNM=in.nextLine();//System.out.println(srcNM);
                for(i=0;i<3;i++){
                    if(srcNM.equalsIgnoreCase(c[i])){
                        r=true;break;
                    }
                if(i==3)System.out.println("Wrong City");
                }
            }
            r=false;
            while(!r){
                try{

                    System.out.println("Please enter Number of Tickets (1 to 10):");
                    nt=in.nextInt();//System.out.println(srcNM);
                    if(1<=nt&&nt<=10){break;}
                    System.out.println("Wrong number");
                }
                            catch(NoSuchElementException ex){
                    System.out.println("Invalid input. Please try again.");in.nextLine();
                }
            }

            System.out.println("You have entered:\n"+"Date of Travel - "+day+"\nSource City - "+(srcNM.toUpperCase())+"\nNumber of Tickets - "+nt);

            m=-1;

                for(i=0;i<Seats.sz;i++)
                {
                    if((day).equalsIgnoreCase(ss[i].day))
                    {m=i;break;}

                }
                if(m==-1){
                    ss[Seats.sz]=new Seats(Flight.sz,day);
                    m=Seats.sz;
                    Seats.sz++;
                }//System.out.println(m);

                //in.nextLine();
            r=false;

            while(!r){
                System.out.print("Proceed to Search (y/n)?");
                 ans=in.next();
                 in.nextLine();
                 if(ans.equalsIgnoreCase("y")||ans.equalsIgnoreCase("n"))r=true;
                 else System.out.println("Wrong choice");
            }
                //System.out.println("a="+ans);
                if(ans.equalsIgnoreCase("y")){
                    this.displayFlightListing(srcNM,"SINGAPORE",sj,sa,ss[m],nt);
                }
                r=false;
        int a=0;
        while(!r){
            try{
                System.out.println("Please select:\n" +"0.  Exit\n"+"1.  Make another reservation\n");
                 a=in.nextInt();
                 in.nextLine();
                if(a==0||a==1)break;
                else System.out.println("Wrong choice");
            }
            catch(NoSuchElementException ex){
                    System.out.println("Invalid input. Please try again.");in.nextLine();
                }
        }        
        if(a==0) System.exit(0);
        }while(ans.equalsIgnoreCase("n"));  
    }
    
    public void displayFlightListing(String s, String d, SpiceJet[] sj, SilkAir[] sa, Seats ss, int n)
    {
        System.out.println("Search Results");
            prind();
            FlightManager fm=new FlightManager();
            cf=fm.connect(srcNM,day,sj,sa,nt,ss);
            if(CombinedFlight.sz==0){
                System.out.println("No Flight combinations available\n");
                r=false;
                int a=0;
                while(!r){
                    try{
                    System.out.println("Please select:\n" +"0.  Exit\n"+"1.  Make another reservation\n");
                     a=in.nextInt();
                     in.nextLine();
                    if(a==0||a==1)break;
                    else System.out.println("Wrong choice");
                    }
            catch(NoSuchElementException ex){
                    System.out.println("Invalid input. Please try again.");in.nextLine();in.nextLine();
                    
            }
                }
                if(a==1)this.displaySearchPage(args);
                else System.exit(0);
            }
            SimpleDateFormat simpDate = new SimpleDateFormat("hh:mm aa");
            Date saTime=new Date();
            SimpleDateFormat simpDate1 = new SimpleDateFormat("hhmm");
            System.out.println("No. Destination   Flight1 Seats Via               Flight2  Seats TotalTime");
            for( i=0;i<CombinedFlight.sz;i++)            
                   try {
                       System.out.println((i+1)+"  "+(cf[i].sj.source+"("+cf[i].sj.departure+")")+"  "+(cf[i].sj.flightno)+"  "+ss.s[cf[i].sj.no]+"  "+(cf[i].sa.source+"("+simpDate.format(simpDate1.parse(cf[i].sa.departure))+")")+"  "+(cf[i].sa.flightno)+"  "+ss.s[cf[i].sa.no]+"  "+cf[i].durationS);
                } catch (ParseException ex) {
                }
        do
        {            
            r=false;

            while(!r){ 
                try{
                System.out.println("Please enter your selection (1 to "+(CombinedFlight.sz)+")");
                i=in.nextInt();//System.out.println(srcNM);

                if(1<=i&&i<=CombinedFlight.sz){break;}
                System.out.println("Wrong number");
                }
                            catch(NoSuchElementException ex){
                    System.out.println("Invalid input. Please try again.");in.nextLine();
                }
                
            }

            System.out.println("You have selected  SpiceJet Flight "+cf[i-1].sj.flightno+" And SilkAir Flight "+cf[i-1].sa.flightno);
            while(!r){
                System.out.print("Proceed to Search (y/n)?");
                 ans=in.next();
                 in.nextLine();
                 if(ans.equalsIgnoreCase("y")||ans.equalsIgnoreCase("n"))r=true;
                 else System.out.println("Wrong choice");
            }
            //System.out.println("a="+ans);
            if(ans.equalsIgnoreCase("y")){
                ss.s[cf[i-1].sj.no]-=nt;
                ss.s[cf[i-1].sa.no]-=nt;
                this.displayBookingPage(s,d,cf[i-1].sj.flightno,cf[i-1].sa.flightno,n,cf[i-1].sj.departure,cf[i-1].sa.departure.substring(0, 4));
            }
            r=false;
        int a=0;
        while(!r){
            try{
            System.out.println("Please select:\n" +"0.  Exit\n"+"1.  Make another reservation\n" +"2.Chose another Combination");
             a=in.nextInt();
             in.nextLine();
            if(a==0||a==1||a==2)break;
            else System.out.println("Wrong choice");
            }
                            catch(NoSuchElementException ex){
                    System.out.println("Invalid input. Please try again.");in.nextLine();
                }
        }
        if(a==1)this.displaySearchPage(args);
        else if(a==0) System.exit(0);
        }while(ans.equalsIgnoreCase("n"));
    }
    public void displayBookingPage(String s, String d, String fl1, String fl2, int n,String tm1,String tm2)
    {
        System.out.println("Booking");
        prind();
        System.out.println(tm1+" "+tm2);
        SimpleDateFormat simpDate = new SimpleDateFormat("hh:mm aa");
        SimpleDateFormat simpDate1 = new SimpleDateFormat("hhmm");
        try {
            System.out.println("Source- "+srcNM.toUpperCase()+"\tDate- "+day+"\nDesination- SINGAPORE"+"\nFlight1- "+fl1+"      Time1- "+(tm1)+"\nFlight2- "+fl2+"      Time2- "+simpDate.format(simpDate1.parse(tm2))+"\nNo. of Tickets- "+nt);
        } catch (ParseException ex) {
            Logger.getLogger(StdDisplayManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Congratulation! Your flight reservation was successful!");        
        r=false;
        int a=0;
        while(!r){
            try{
            System.out.println("Please select:\n" +"0.  Exit\n"+"1.  Make another reservation\n");
             a=in.nextInt();
             in.nextLine();
            if(a==0||a==1)break;
            else System.out.println("Wrong choice");
            }
            catch(NoSuchElementException ex){
                    System.out.println("Invalid input. Please try again.");in.nextLine();in.nextLine();
                    
            }
        }
        if(a==1)this.displaySearchPage(args);
        else System.exit(0);
    }
   /* public static void main(String args[])
    {
        StdDisplayManager sdm=new StdDisplayManager(args);
        sdm.displaySearchPage();
    }*/

}
