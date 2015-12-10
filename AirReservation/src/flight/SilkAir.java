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
public class SilkAir extends Flight{
    String effecFrom,effecTill;
    public static int size;
    public SilkAir()
    {
        super(); 
        effecFrom="";
        effecTill="";
    }
    public SilkAir(int v,String s,String ds,String fr,String fn,String dp,String a,String ef,String et)
    {
        super(v,s,ds,fr,fn,dp,a);
        effecFrom=new String(ef);
        effecTill=new String(et);
        size++;
        //System.out.println("Entered");
    }
    public SilkAir(SilkAir s)
    {
        super(s);
        effecFrom=new String(s.effecFrom);
        effecTill=new String(s.effecTill);
    }
}
