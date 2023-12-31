
package Main;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego Prada
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    private final DatabaseConnect hospitalDB = new DatabaseConnect(); 
    public static String user = "";
    public static String username;
    public static String password;
    
    public Login() {
        ImageIcon img = new ImageIcon("Picon.png");
        setIconImage(img.getImage());
        initComponents();
    }
    
    
     private void reset(){
        tfUSERNAME.setText("");
        tfPASSWORD.setText("");
    }

     
      

     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUSERNAME = new javax.swing.JTextField();
        btLOGIN = new javax.swing.JButton();
        btRESET = new javax.swing.JButton();
        cbDoctor = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cbPatient = new javax.swing.JCheckBox();
        cbAdministrator = new javax.swing.JCheckBox();
        tfPASSWORD = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(635, 394));
        setMinimumSize(new java.awt.Dimension(635, 394));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setText("HospitalDB");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel2.setText("USERNAME");

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setText("PASSWORD");

        tfUSERNAME.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        tfUSERNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUSERNAMEActionPerformed(evt);
            }
        });

        btLOGIN.setText("LOGIN");
        btLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLOGINActionPerformed(evt);
            }
        });

        btRESET.setText("RESET");
        btRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRESETActionPerformed(evt);
            }
        });

        cbDoctor.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        cbDoctor.setText("Doctor");
        cbDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDoctorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Login as:");

        cbPatient.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        cbPatient.setText("Patient");
        cbPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPatientActionPerformed(evt);
            }
        });

        cbAdministrator.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        cbAdministrator.setText("Administrator");
        cbAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdministratorActionPerformed(evt);
            }
        });

        tfPASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPASSWORDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRESET)
                .addGap(18, 18, 18)
                .addComponent(btLOGIN)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfUSERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(tfPASSWORD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAdministrator)
                    .addComponent(cbPatient)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(cbDoctor)))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPatient)
                .addGap(2, 2, 2)
                .addComponent(cbAdministrator)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(tfPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRESET)
                    .addComponent(btLOGIN))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUSERNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUSERNAMEActionPerformed
        // TODO add your handling code here:
        
        
       
        
        
        
    }//GEN-LAST:event_tfUSERNAMEActionPerformed

    private void btLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLOGINActionPerformed
        // TODO add your handling code here:
        String sql = "";
        if(user.equals("")) 
            JOptionPane.showMessageDialog(this,"Must check one of the login options!");
        username = tfUSERNAME.getText();
        password = tfPASSWORD.getText();
        try{
            Statement stm = hospitalDB.database.createStatement();
            sql = "SELECT * from "+ user +" where Username = '"+username+"' AND Password = '"+password+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()&&!user.equals("")){
               
                switch (user){
                    case "doctor":
                      ViewDoctorPage vdp = new ViewDoctorPage(rs.getString("ID"),false);
                      vdp.show();
                     break;
                   case "patient":
                        String id = rs.getString("ID");
                        PatientPage hpp = new PatientPage(id);
                        hpp.show();
                        break;
                    case "administrator":
                        AdministratorPage adp = new AdministratorPage();
                        adp.show();
                        break;
                }
                       
                dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Username or Password are invalid or do not exist!");
                reset();
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

        
    }//GEN-LAST:event_btLOGINActionPerformed

    private void btRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRESETActionPerformed
        // TODO add your handling code here:
       reset();
    }//GEN-LAST:event_btRESETActionPerformed

    private void cbDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDoctorActionPerformed
        // TODO add your handling code here:
       cbPatient.setSelected(false);
       cbAdministrator.setSelected(false);
       user = "doctor";       
    }//GEN-LAST:event_cbDoctorActionPerformed

    private void cbPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPatientActionPerformed
        // TODO add your handling code here:
        cbDoctor.setSelected(false);
        cbAdministrator.setSelected(false);
        user = "patient";    
        
    }//GEN-LAST:event_cbPatientActionPerformed

    private void cbAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdministratorActionPerformed
        // TODO add your handling code here:
        cbPatient.setSelected(false);
        cbDoctor.setSelected(false);
        user = "administrator";     
    }//GEN-LAST:event_cbAdministratorActionPerformed

    private void tfPASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPASSWORDActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLOGIN;
    private javax.swing.JButton btRESET;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAdministrator;
    private javax.swing.JCheckBox cbDoctor;
    private javax.swing.JCheckBox cbPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField tfPASSWORD;
    private javax.swing.JTextField tfUSERNAME;
    // End of variables declaration//GEN-END:variables
}
