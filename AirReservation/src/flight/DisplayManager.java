/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flight;

import javax.swing.JFrame;

/**
 *
 * @author Raunak Kumar
 */
public interface DisplayManager {
    
    public void displaySearchPage(String args[]);
    public void displayFlightListing(String s,String d,SpiceJet sj[],SilkAir sa[],Seats ss,int n);
    public void displayBookingPage(String s,String d,String fl1,String fl2,int n,String tm1,String tm2);
    
    /* public static void main(String args[]){
         System.out.println(args[1]+":"+args[2]);
         String s[]={"spicejet.Schedule.csv","silkair.Schedule.csv"};
        Feame1 frame = new Feame1(args);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500,250);
        frame.setVisible(true);
    }*/
}
