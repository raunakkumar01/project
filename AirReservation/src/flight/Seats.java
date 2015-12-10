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
public class Seats {
    String day;
    static int sz;
    int s[];
    
    public Seats(int n,String d)
    {
        day=new String(d);
        s=new int[n];
        for(int i=0;i<n;i++)
            s[i]=15;
    }
    
}
