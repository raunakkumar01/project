/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flight;

/**
 *
 * @author Kaustav Mitra
 */
public class Flight {
    public String source,destination,frequency,flightno,departure,arival;
    public int no;
    static int sz;
    public Flight()
    {
        no=0;
        source="";
        destination="";
        frequency="";
        flightno="";
        departure="";
        arival="";
              
    }
    public Flight(int v,String s,String ds,String fr,String fn,String dp,String a)
    {
        no=v;
        source=new String(s);
        destination=new String(ds);
        frequency=new String(fr);
        flightno=new String(fn);
        departure=new String(dp);
        arival=new String(a);
        
    }
    public Flight(Flight f)
    {
        no=f.no;
        source=new String(f.source);
        destination=new String(f.destination);
        frequency=new String(f.frequency);
        flightno=new String(f.flightno);
        departure=new String(f.departure);
        arival=new String(f.arival); 
        
    }
    public void dsplay()
    {
        System.out.print(source+" ");
    }
}
