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
public class Booking extends javax.swing.JFrame {

    /**
     * Creates new form Frame1
     */
    public Booking(String s,String d,String fl1,String fl2,int n,String tm1,String tm2) {
        initComponents();
        jLabel7.setText(s);
        jLabel9.setText(d);
        jLabel8.setText("Singapore");
        jLabel13.setText(fl1);
        jLabel15.setText(fl2);
        jLabel18.setText(tm1);
        jLabel19.setText(tm2);
        String ss=String.valueOf(n);
        jLabel11.setText(ss);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

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
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Blue Airline ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(140, 30, 200, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flight/download (1).jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 10, 80, 60);

        jLabel3.setText("Date :-");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 110, 90, 20);

        jLabel5.setText("Source :-");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 110, 60, 20);

        jLabel6.setText("Destination :-");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 150, 80, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(120, 190, 50, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jLabel15);
        jLabel15.setBounds(120, 220, 60, 20);

        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(120, 250, 90, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Time1:-");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(230, 190, 42, 15);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Time2:- :-");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(230, 220, 60, 15);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jLabel18);
        jLabel18.setBounds(320, 190, 60, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jLabel19);
        jLabel19.setBounds(320, 220, 60, 20);

        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(130, 110, 60, 20);

        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(130, 150, 80, 20);

        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(360, 110, 90, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Flight1 :-");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 190, 48, 15);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Flight2 :-");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 220, 60, 15);

        jLabel10.setText("No. of Tickets :-");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 240, 90, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flight/images (1).jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 100, 250, 190);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(180, 310, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
