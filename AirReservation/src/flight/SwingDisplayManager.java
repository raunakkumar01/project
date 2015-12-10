/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flight;

/**
 *
 * @author Raunak Kumar
 */
public class SwingDisplayManager implements DisplayManager{
    SearchPage frame1;
    SearchResult frame2;
    Booking frame3;
    public void displaySearchPage(String args[])
    {
        frame1 = new SearchPage(args,this);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500,250);
        frame1.setVisible(true);        
    }
    public void displayFlightListing(String s,String d,SpiceJet sj[],SilkAir sa[],Seats ss,int n)
    {
        frame2=new SearchResult(s,d,sj,sa,ss,n,this);
        frame2.setVisible(true); 
    }
    public void displayBookingPage(String s,String d,String fl1,String fl2,int n,String tm1,String tm2)
    {        
        frame3=new Booking(s,d,fl1,fl2,n,tm1,tm2);
        frame3.setVisible(true);
    }
   /* public static void main(String args[])
    {
        SwingDisplayManager swd=new SwingDisplayManager();
        String s[]={"swing","spicejet.Schedule.csv","silkair.Schedule.csv"};
        swd.displaySearchPage(args);
        
    }*/    
    
}
