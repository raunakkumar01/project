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
public class CombinedFlight {
    SpiceJet sj;
    SilkAir sa;
    public static int sz;
    public double durationS;
    
    public CombinedFlight()
    {
        //this.sj=new SpiceJet();
        //this.sa=new SilkAir();
        durationS=0;
    }
    public CombinedFlight(SpiceJet sj,SilkAir sa,long diff)
    {
        //this.sj=new SpiceJet(sj);
        //this.sa=new SilkAir(sa);
        this.sj=sj;
        this.sa=sa;
        durationS=(double)diff/(1000*60);//(diff / (60 * 60 * 1000));
    }
    
}
