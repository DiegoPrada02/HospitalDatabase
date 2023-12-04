/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class AppointmentSetup extends javax.swing.JFrame {

    private DatabaseConnect hospitalDB;
    private static String doctorID;
    private static String pID;
    private final int CurrentYear = 2023; // UPDATE TO CURRENT YEAR!
    
    /**
     * Creates new form AppointmentSetup
     */
    public AppointmentSetup(String pID,String docID) {
        initComponents();
        hospitalDB = new DatabaseConnect();
        ImageIcon img = new ImageIcon("Picon.png");
        setIconImage(img.getImage());
        doctorID = docID;
        setDoctorList(); 
        updateDateDD();
        this.pID = pID;
    }
    
    
    public AppointmentSetup(String docid){
        ImageIcon img = new ImageIcon("Picon.png");
        setIconImage(img.getImage());
        hospitalDB = new DatabaseConnect();
        initComponents();
        setPatientList();
        doctorID = docid;
        updateDateDD();
    }
    
    private void setPatientList(){
          jLabel5.setText("Select a Patient*");
          cbDoctors.removeAllItems();
        try{
            Statement stm = hospitalDB.database.createStatement();
            String sql = "SELECT ID, FirstName, LastName FROM patient";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String item = "";
                item += rs.getString("ID") + " - "+rs.getString("FirstName")+", "
                        +rs.getString("LastName");
                cbDoctors.addItem(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
        
    private void buildAppointment(String date, String addinfo){
        String did = cbDoctors.getSelectedItem()+"";
        did = did.substring(0,6);
        if("".equals(date))
                 JOptionPane.showMessageDialog(this,"One or more required fields are empty!");
            try{
                String sql = "INSERT INTO appointment(PatientID,DoctorID,AppointmentDateTime,AdditionalInformation)"
                        + "VALUES("+ did +", "+doctorID+", '"+date+"', '"+addinfo+"')";
                PreparedStatement stm = hospitalDB.database.prepareStatement(sql);
                stm.executeUpdate();
                JOptionPane.showMessageDialog(this,"Appointment created successfuly!");
                dispose();
            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this,"Something went wrong, Please try again!");
            }
    }
    
    
    private void buildAppointment(String DoctorID,String date,String AddInfo){
            if("".equals(DoctorID)||"".equals(date))
                 JOptionPane.showMessageDialog(this,"One or more required fields are empty!");
            try{
                String sql = "INSERT INTO appointment(PatientID,DoctorID,AppointmentDateTime,AdditionalInformation)"
                        + "VALUES("+pID+", "+DoctorID+", '"+date+"', '"+AddInfo+"')";
                PreparedStatement stm = hospitalDB.database.prepareStatement(sql);
                stm.executeUpdate();
                JOptionPane.showMessageDialog(this,"Appointment created successfuly!");
                dispose();
            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this,"Something went wrong, Please try again!");
            }
    }
    
    
    
    private void setDoctorList(){
        jLabel5.setText("Select a Doctor*");
        cbDoctors.removeAllItems();
        try{
            Statement stm = hospitalDB.database.createStatement();
            String sql = "SELECT ID, FirstName, LastName,Specialization FROM doctor";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String item = "";
                item += rs.getString("ID") + " - "+rs.getString("FirstName")+", "
                        +rs.getString("LastName")+" - "+rs.getString("Specialization");
                if(rs.getString("ID").equals(doctorID))
                    item += " - Primary Doctor";
                cbDoctors.addItem(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void updateDateDD(){
        cbYear.removeAllItems();
        cbMonth.removeAllItems();
        cbDay.removeAllItems(); 
        for(int i=CurrentYear;i<=CurrentYear+20;i++)
            cbYear.addItem(i+"");
        for(int i=1;i<=31;i++){
            if(i<10)
                cbDay.addItem("0"+i);
            else
                cbDay.addItem(i+"");
        }
         for(int i=1;i<=12;i++){
            if(i<10)
                cbMonth.addItem("0"+i);
            else
                cbMonth.addItem(i+"");
        }
    }
    
    private String formatDate(){
       String fdate = cbYear.getSelectedItem()+"-"+cbMonth.getSelectedItem()+"-"+cbDay.getSelectedItem();
       lbDate.setText(fdate);
       return fdate;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        cbDoctors = new javax.swing.JComboBox<>();
        cbYear = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbDay = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAI = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btSchedule = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        lbDate = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Schedule Appointment");
        setResizable(false);

        cbDoctors.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbDoctors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbYear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Year*");

        cbMonth.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Month*");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Day*");

        cbDay.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDayActionPerformed(evt);
            }
        });

        taAI.setColumns(20);
        taAI.setRows(5);
        jScrollPane1.setViewportView(taAI);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Additional Information");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Choose a Doctor*");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("* Required fields");

        btSchedule.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btSchedule.setText("Schedule Appointment");
        btSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btScheduleActionPerformed(evt);
            }
        });

        btClose.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        lbDate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDate.setText("DATE HERE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btClose)
                        .addGap(18, 18, 18)
                        .addComponent(btSchedule))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbDate))))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(cbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSchedule)
                    .addComponent(btClose)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btScheduleActionPerformed
        // TODO add your handling code here:
        String fdate = formatDate();
        String addinfo = taAI.getText();
        String did = cbDoctors.getSelectedItem()+"";
        did = did.substring(0,6);
        //System.out.println(did);
        if(pID!=null)
            buildAppointment(did,fdate,addinfo);
        else
            buildAppointment(fdate,addinfo);
    }//GEN-LAST:event_btScheduleActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void cbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbYearActionPerformed
        // TODO add your handling code here:
        formatDate();
    }//GEN-LAST:event_cbYearActionPerformed

    private void cbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthActionPerformed
        // TODO add your handling code here:
        formatDate();
    }//GEN-LAST:event_cbMonthActionPerformed

    private void cbDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDayActionPerformed
        // TODO add your handling code here:
        formatDate();
    }//GEN-LAST:event_cbDayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppointmentSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentSetup(pID,doctorID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btSchedule;
    private javax.swing.JComboBox<String> cbDay;
    private javax.swing.JComboBox<String> cbDoctors;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JTextArea taAI;
    // End of variables declaration//GEN-END:variables
}
