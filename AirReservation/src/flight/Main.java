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
public class Main {
    public static void main(String args[])
    {
        if(args.length<3)
        {
            StdDisplayManager sdm=new StdDisplayManager(args);
            sdm.displaySearchPage(args);
        }
        else if(args[2].equalsIgnoreCase("swing")){
            SwingDisplayManager swd=new SwingDisplayManager();
            swd.displaySearchPage(args);}
        else
        {
            StdDisplayManager sdm=new StdDisplayManager(args);
            sdm.displaySearchPage(args);
        }
    }
    
}
