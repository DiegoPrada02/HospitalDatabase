
package Main;

import javax.swing.ImageIcon;
import java.sql.*;

/**
 *
 * @author diego
 */
public class ViewDoctorPage extends javax.swing.JFrame {

    // parameter for the doctor page
    private static String id;
    private DatabaseConnect hospitalDB;
    private static boolean admin;
    /**
     * Creates new form ViewDoctorPage
     */
    public ViewDoctorPage(String docid,boolean isAdmin) {
        initComponents();
        hospitalDB = new DatabaseConnect();
        ImageIcon img = new ImageIcon("Picon.png");
        setIconImage(img.getImage());
        id = docid;
        setData();
        admin = isAdmin;
        if(admin==true)
            btSO.setText("Close");
        else btSO.setText("Sign Out");
        setAppointments();
            
    }
    
    //SET UP DOCTOR'S UPCOMING APPOINTMENTS
    private void setAppointments(){
        taApp.setText("");
        String sql = "select appointmentID as id, patient.FirstName as fname, patient.LastName as lname, AppointmentDateTime as adt, AdditionalInformation as ai From" +
        " appointment inner join patient inner join doctor on appointment.DoctorID = doctor.ID AND PatientID = patient.ID WHERE appointment.DoctorID = " +                
        id + " order by AppointmentDateTime ASC limit 5;";
        try{
            Statement stm = hospitalDB.database.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
               taApp.append(rs.getString("id")+"\n"+
                      rs.getString("fname")+", "+rs.getString("lname")+"\n"+
                       rs.getString("adt"));
               if(rs.getString("ai")!=null)
                   taApp.append("\n"+rs.getString("ai"));
               taApp.append("\n----------------------------------------------\n");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
   
    
    
    // SETS UP THE DOCTORS PROFILE
    private void setData(){
        String ID = "";
        String name = "";
        String spe = "";
        String dob = "";
        String phone ="";
        try{
            String sql = "select * From doctor where ID = "+id;
            Statement stm =  hospitalDB.database.createStatement();
            ResultSet rs  =  stm.executeQuery(sql);
            while(rs.next()){
                 ID = rs.getString("ID");
                 name = rs.getString("FirstName")+", "+rs.getString("LastName");
                 spe = rs.getString("Specialization");
                 dob = rs.getString("BirthDate");
                 phone = rs.getString("phone");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        lbID.setText("ID: "+ID);
        lbName.setText("Name: "+name);
        lbSpe.setText("Specialization: "+spe);
        lbDob.setText("DoB: "+dob);
        lbPhone.setText("Contact: "+phone);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbID = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbSpe = new javax.swing.JLabel();
        lbDob = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btSO = new javax.swing.JButton();
        btCvisit = new javax.swing.JButton();
        btCapp = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        taApp = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doctor Page");
        setResizable(false);

        lbID.setText("ID - 000000000000000");

        lbName.setText("NAME NAME NAME");

        lbSpe.setText("SPESPESPE");

        lbDob.setText("DOBDOBDOB");

        lbPhone.setText("PHONE#");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doctor.jpg"))); // NOI18N

        btSO.setText("Sign Out");
        btSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSOActionPerformed(evt);
            }
        });

        btCvisit.setText("Create Visit");
        btCvisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCvisitActionPerformed(evt);
            }
        });

        btCapp.setText("Create Appointment");
        btCapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCappActionPerformed(evt);
            }
        });

        taApp.setEditable(false);
        taApp.setColumns(20);
        taApp.setRows(5);
        jScrollPane6.setViewportView(taApp);

        jLabel2.setText("Upcoming Appointments: ");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDob, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSpe, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btSO)
                            .addGap(124, 124, 124)))
                    .addComponent(lbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btCapp)
                        .addGap(18, 18, 18)
                        .addComponent(btCvisit)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(lbID)
                        .addGap(12, 12, 12)
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSpe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPhone)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSO)
                    .addComponent(btCvisit)
                    .addComponent(btCapp))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSOActionPerformed
       dispose();
       if(admin==false)
        new Login().setVisible(true);
    }//GEN-LAST:event_btSOActionPerformed

    private void btCappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCappActionPerformed
        // TODO add your handling code here:
        AppointmentSetup ast = new AppointmentSetup(id);
        ast.show();
    }//GEN-LAST:event_btCappActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setAppointments();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btCvisitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCvisitActionPerformed
        // TODO add your handling code here:
        
        VisitSetup vs = new VisitSetup(id);
        vs.show();
    }//GEN-LAST:event_btCvisitActionPerformed

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
            java.util.logging.Logger.getLogger(ViewDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDoctorPage(id,admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCapp;
    private javax.swing.JButton btCvisit;
    private javax.swing.JButton btSO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbDob;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbSpe;
    private javax.swing.JTextArea taApp;
    // End of variables declaration//GEN-END:variables
}
