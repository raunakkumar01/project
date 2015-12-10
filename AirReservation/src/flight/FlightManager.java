/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Raunak Kumar
 */
package flight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class FlightManager {
    
      
    
        String dt;
        String firstAndThirdSunday="";
        Date date1;
        Date date2=new Date();
        Date date3=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy");
        String finalDay=new String();
        Date sjTime=new Date();
        Date sjTime6=new Date();
        Date sjTime2=new Date();
        
    public CombinedFlight[] connect(String sc,String day,SpiceJet sj[],SilkAir sa[],int nt,Seats ss)
    { 
        CombinedFlight cf[]=new CombinedFlight[100];
        CombinedFlight.sz=0;
        int i,j;
        
        dt=day;//new String(day+"-Oct-2014");;
        try {                     
            date1 = sdf.parse(dt);           
            
            DateFormat format2=new SimpleDateFormat("EEEE"); 
            finalDay=(format2.format(date1));            
            //System.out.println(date1);
            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            //int wk=c.get(Calendar.WEEK_OF_MONTH);
            //int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            c.setFirstDayOfWeek(Calendar.SUNDAY);
           // System.out.println(c.get(Calendar.DAY_OF_WEEK)+" "+finalDay+" ");
            
            if (Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK) && c.get(Calendar.DAY_OF_MONTH) <= 7)
                firstAndThirdSunday+="FIRST AND THIRD SUNDAY OF EVERY MONTH";
                //System.out.println("First Sunday");
            if (Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK) && c.get(Calendar.DAY_OF_MONTH) <= 21&& c.get(Calendar.DAY_OF_MONTH) >=14)
                firstAndThirdSunday+="FIRST AND THIRD SUNDAY OF EVERY MONTH";//System.out.println("Third Sunday");
        } catch (ParseException ex) {
           ex.printStackTrace();
        }
   // System.out.println(SpiceJet.size+","+SilkAir.size);
    try{    
            for(i=0;i<SpiceJet.size;i++)
            {
            if(sc.equalsIgnoreCase(sj[i].source))
              if((checkSpice(sj[i])))
             {
                 //System.out.println("sj[i]- "+sj[i].frequency+" "+sj[i].effecTill);
                  // System.out.println("sj[i].src- "+sj[i].effecFrom+" "+sj[i].effecTill);
                    for(j=0;j<SilkAir.size;j++)
                    {                    
                        String s1=new String(sj[i].destination);
                        String s2=new String(sa[j].source);
                        SimpleDateFormat simpDate = new SimpleDateFormat("hh:mm aa");
                        try {                        
                            sjTime=simpDate.parse(sj[i].arival);                        
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }                        
                        Calendar cal = Calendar.getInstance(); // creates calendar
                        cal.setTime(sjTime); // sets calendar time/date
                        if(sj[i].remk.equalsIgnoreCase("next day"))cal.add(Calendar.DATE, 1);//adds one day
                        cal.add(Calendar.HOUR_OF_DAY, 6); // adds 6 hour
                        sjTime6=cal.getTime();
                        cal.setTime(sjTime); // sets calendar time/date
                        if(sj[i].remk.equalsIgnoreCase("next day"))cal.add(Calendar.DATE, 1);//adds one day
                        cal.add(Calendar.HOUR_OF_DAY, 2); // adds 2 hour
                        sjTime2=cal.getTime();
                        //System.out.println(sjTime2+" "+sjTime6);

                        if(s1.equalsIgnoreCase(s2)){ 
                            if(checkSilk(sa[j]))
                                if(nt<=ss.s[sj[i].no]&&nt<=ss.s[sa[j].no])
                                {
                                    //System.out.println(pm.sj[i].source+" "+s2+" "+pm.sj[i].flightno+","+pm.sa[j].flightno);
                                    long diff=calDur(sa[j]);
                                    cf[CombinedFlight.sz++]=new CombinedFlight((sj[i]),(sa[j]),diff);                            
                                }
                        }
                    }
                }
            } 
        }catch(Exception e){
            System.out.println("Erroe- "+e.getMessage());
        }
    
    Arrays.sort(cf,0,CombinedFlight.sz, new Comparator<CombinedFlight>() {
        @Override
        public int compare(CombinedFlight o1, CombinedFlight o2) {
            //System.out.println(o1.durationS+" : "+o2.durationS);
           return Double.compare(o1.durationS, o2.durationS);
        }
    });
        return cf;
    }    
     
    public boolean checkSpice(SpiceJet sj)
    {       
        try {
            date2 = sdf.parse(sj.effecFrom);
            date3 = sdf.parse(sj.effecTill);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        if(date1.after(date2)&&date1.before(date3)||date1.equals(date2)||date1.equals(date3))
        {
            //System.out.println("sj- "+sj.frequency+" "+sj.effecTill);
            String fr=new String(sj.frequency);
            if(fr.equalsIgnoreCase("daily")) return true;
            else if(fr.equalsIgnoreCase("FIRST AND THIRD SUNDAY OF EVERY MONTH")&&(firstAndThirdSunday.equalsIgnoreCase("FIRST AND THIRD SUNDAY OF EVERY MONTH")))
                return true;
            else
            {
                String k[]=fr.trim().split(",");
                for(int i=0;i<k.length;i++)
                    if(finalDay.equalsIgnoreCase(k[i].trim()))return true;
                return false;
            }
        }
        else return false;        
    }
    
    public boolean checkSilk(SilkAir sa)
    {
        String fr=new String(sa.frequency);
        String day;
        try {
            date2 = sdf.parse(sa.effecFrom);
            date3 = sdf.parse(sa.effecTill);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Date saTime=new Date();
        SimpleDateFormat simpDate = new SimpleDateFormat("hhmm");
        try {
            saTime=simpDate.parse(sa.departure);
            //System.out.println(saTime);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }        
        
        if(date1.after(date2)&&date1.before(date3)||date1.equals(date2)||date1.equals(date3)){
        //String DateTimeSJ=dt+"T"+arrival;
            if(fr.equalsIgnoreCase("daily")&&saTime.after(sjTime2)&&saTime.before(sjTime6)) 
                return true;
            else
            {
                String k[]=fr.split(",");
                for(int i=0;i<k.length;i++){
                    day=new String(finalDay.substring(0, 3));
                    //System.out.println(day+" "+fr);
                    if(day.equalsIgnoreCase(k[i])&&saTime.after(sjTime2)&&saTime.before(sjTime6))
                        return true;
                }
                return false;
            } 
        }
        else return false;
    }
    
    public long calDur(SilkAir sa)
    {
        SimpleDateFormat simpDate1 = new SimpleDateFormat("hhmm");
        long diff=0;
                    try {
                        
                        Date saTimea=(simpDate1.parse(sa.arival));
                        
                        if(sa.arival.length()>4)
                        {
                            Calendar cal = Calendar.getInstance(); // creates calendar
                            cal.setTime(saTimea); // sets calendar time/date
                            cal.add(Calendar.DATE, 1); // adds one hour
                            saTimea=cal.getTime();
                        }
                        
                        diff = saTimea.getTime() - sjTime.getTime();
                        //System.out.println(sjTime+" "+saTimea+" "+diff/1000+" "+(float)(diff / (60 * 60 * 1000)));
                        } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    return diff;
    }
}
