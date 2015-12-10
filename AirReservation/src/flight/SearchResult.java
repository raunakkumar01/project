/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flight;

/**
 *
 * @author Koustav Pain
 */
import javax.swing.*;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchResult extends javax.swing.JFrame {
    
     
    /**
     * Creates new form Frame1
     */
    String fl1,fl2,src,dy,tm1,tm2;
    int n;
    CombinedFlight cf[];
    Seats ss;
    SwingDisplayManager dm;
    public SearchResult(String s,String d,SpiceJet sj[],SilkAir sa[],Seats ss,int nt,SwingDisplayManager dm) {
        
        this.dm=dm;
        this.ss=ss;
        n=nt;
        src=s;
        dy=d;
        initComponents();
        jLabel8.setText(d);
        FlightManager fm=new FlightManager();
        cf=fm.connect(s,d,sj,sa,nt,ss);
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        int i;
        SimpleDateFormat simpDate = new SimpleDateFormat("hh:mm aa");
        Date saTime=new Date();
        SimpleDateFormat simpDate1 = new SimpleDateFormat("hhmm");
        for( i=0;i<CombinedFlight.sz;i++)
            try {
                model.addRow(new Object[]{new String(cf[i].sj.source),new String(cf[i].sj.flightno),cf[i].sj.departure,cf[i].sj.arival,ss.s[cf[i].sj.no],new String(cf[i].sa.source),new String(cf[i].sa.flightno),simpDate.format(simpDate1.parse(cf[i].sa.departure)),simpDate.format(simpDate1.parse(cf[i].sa.arival.substring(0,4))),ss.s[cf[i].sa.no],cf[i].durationS});
            } catch (ParseException ex) {
                //Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
            }
        jLabel5.setText("No. of Tickets:- "+n);
       /* jComboBox1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {        
            if (e.getStateChange() == ItemEvent.SELECTED) {
                      JComboBox cb = (JComboBox)e.getSource();
                      //n = Integer.parseInt((String)cb.getSelectedItem());
                      jLabel13.setText("");
                      jLabel6.setText("");
                      //System.out.print(n+" ");
                  }
          }
        });*/
    }
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Blue Airline  Reservation System");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(140, 20, 390, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Destination :-");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 70, 100, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Singapore");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(140, 70, 61, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Journey Date:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 100, 97, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Select Flight from search list for booking process");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 130, 274, 14);

        jButton2.setText("Book Ticket");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(170, 310, 110, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Source", "Flight1", "Dep", "Arr", "Seats left", "Via", "Flight2", "Dep", "Arr", "Seats left", "Duration(min.)"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 150, 630, 90);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Flight1 :-");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(60, 250, 48, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(150, 250, 60, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Flight2 :-");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(60, 280, 60, 15);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 280, 70, 20);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(140, 100, 90, 20);

        jLabel5.setText("No. of Tickets :-");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(320, 280, 120, 20);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(380, 310, 70, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flight/images (2).jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 640, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(jLabel13.getText().equalsIgnoreCase("")||jLabel6.getText().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Select a flight combination");
                return;
            }
        if(jLabel13.getText().equalsIgnoreCase("Unavailable")||jLabel6.getText().equalsIgnoreCase("Unavailable"))
            {
                JOptionPane.showMessageDialog(null, "Select another combination");
                return;
            }
        int reply = JOptionPane.showConfirmDialog(null, "Want to book the flight", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          
        }
        else {
           return;
        }
        int row=jTable1.getSelectedRow();
       
        ss.s[cf[row].sj.no]-=n;
        ss.s[cf[row].sa.no]-=n;
        /*DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        SimpleDateFormat simpDate = new SimpleDateFormat("hh:mm aa");
        Date saTime=new Date();
        SimpleDateFormat simpDate1 = new SimpleDateFormat("hhmm");
        
        for (int i=0;i<CombinedFlight.sz;i++) { 
            try {
                  model.setValueAt((cf[i].sj.source+"("+cf[i].sj.departure+")"), i, 0);
                  model.setValueAt((cf[i].sj.flightno), i, 1);
                  model.setValueAt(ss.s[cf[i].sj.no], i, 2);
                  model.setValueAt((cf[i].sa.source+"("+simpDate.format(simpDate1.parse(cf[i].sa.departure))+")"), i, 3);
                  model.setValueAt((cf[i].sa.flightno), i, 4);
                  model.setValueAt(ss.s[cf[i].sa.no], i, 5);
                  model.setValueAt(cf[i].durationS, i, 6);
                  } catch (ParseException ex) {
                  }
        }       
        new Booking(src,dy,fl1,fl2,n).setVisible(true);*/
        dm.displayBookingPage(src,dy,fl1,fl2,n,tm1,tm2);
        
        this.dispose();
        JOptionPane.showMessageDialog(null, "Succesful Booking");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            int row=jTable1.getSelectedRow();
            fl1=new String(jTable1.getModel().getValueAt(row,1).toString());
            tm1=new String(jTable1.getModel().getValueAt(row,2).toString());
            //System.out.print(row+"n "+n);
            
            jLabel13.setText(fl1);
            fl2=new String(jTable1.getModel().getValueAt(row,6).toString());
            tm2=new String(jTable1.getModel().getValueAt(row,7).toString());
            jLabel6.setText(fl2);
        }catch(Exception e){
            //JOptionPane.showMessage(null,e);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //new Feame1().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(CombinedFlight.sz==0){
            JOptionPane.showMessageDialog(null, "No flights Available go Back");
            this.dispose();
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

  
}