/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_oct;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amolika
 */
public class ManageCashier extends javax.swing.JFrame {

    /**
     * Creates new form ManageCashier
     */
    public ManageCashier() {
        initComponents();
        getCashier();
        setVisible(true);
        setSize(800,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(115, 70, 456, 406);

        jButton1.setText("Delete Cashier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 510, 290, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(rootPane, "Please select a row");
        }
        else{
            String username=al.get(jTable1.getSelectedRow()).username;
            try{
            ResultSet rs2=DbLoader.executestatment("select * from cashier where username='"+username+"'");
            if(rs2.next()){
                rs2.deleteRow();
                getCashier();;
            }
            JOptionPane.showMessageDialog(rootPane, "cashier deleted");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    ArrayList<cashier> al=new ArrayList<>();
    void getCashier(){
        try{
        ResultSet rs=DbLoader.executestatment("select * from cashier");
        while(rs.next()){
            
            
            
            
       
        String username=rs.getString("username");
        String pass=rs.getString("password");
        String Mobile=rs.getString("MobileNumber");
        String status=rs.getString("status");
                
        al.add(new cashier(username,pass,Mobile,status));   
        tablemodel tm=new tablemodel();
        jTable1.setModel(tm);
        
        }
                }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    class tablemodel extends AbstractTableModel {

        String names[] = {"username","password","MobileNumber","status"};

        public int getRowCount() {
            return al.size();
        }

        public int getColumnCount() {
            return 4;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).username;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).pass;
            } else if(columnIndex==2){
                return al.get(rowIndex).Mobile;
            }
            else if(columnIndex==3){
                return al.get(rowIndex).status;
            }
            
            return null;
        }

        public String getColumnName(int columnIndex) {
            return names[columnIndex];
        }

    }
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
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
