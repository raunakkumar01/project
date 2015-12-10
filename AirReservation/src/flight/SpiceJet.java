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
public class SpiceJet extends Flight{
    
    String effecFrom,effecTill,remk;
    public static int size=0;
    public SpiceJet()
    {
        super();
        effecFrom="";
        effecTill="";        
    }
    public SpiceJet(int v,String s,String ds,String fr,String fn,String dp,String a,String ef,String et,String rm)
    {
        super(v,s,ds,fr,fn,dp,a);
        effecFrom=new String(ef);
        effecTill=new String(et);
        remk=new String(rm);
        size++;
        //System.out.println("Entered");
    }
    public SpiceJet(SpiceJet s)
    {
        super(s);
        effecFrom=new String(s.effecFrom);
        effecTill=new String(s.effecTill);
        remk=new String(s.remk);
    }
}
