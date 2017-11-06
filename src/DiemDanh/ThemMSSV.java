/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import form.MainForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author LongTran
 */
public class ThemMSSV extends javax.swing.JFrame {
    
    DiemDanh d;
    MainForm mf = new MainForm();
    DangNhap dn;
    QuanLiSinhVien sv;
    private String RFID;
    private String MaSK;
    private boolean vao;
    private Connection con = null;
    SimpleDateFormat f = new SimpleDateFormat("HH:mm dd/MM/yyyy");
    java.util.Date date = new java.util.Date();
    SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /**
     * Creates new form ThemMSSV
     */
    public ThemMSSV() {
        initComponents();
        rdoSV.setSelected(true);
        setTitle("Gán mã số");
    }
    
    public ThemMSSV(DiemDanh d, String RFID, boolean vao,String MaSK){
        initComponents();
        this.d = d;
        this.RFID = RFID;
        this.MaSK = MaSK;
        rdoSV.setSelected(true);
        this.vao = vao;
        txtMS.requestFocusInWindow();
        this.getRootPane().setDefaultButton(btnThem);
        System.out.println(vao);
        System.out.println("Thêm MSSV");
    }

    private void themRFIDSV(String MS){
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String suKien = "Update sinhvien set MaRFID = '"+RFID+"' where MSSV = '"+MS+"'";
            st.executeUpdate(suKien);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void themRFIDCB(String MS){
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String suKien = "Update canbo set MaRFID = '"+RFID+"' where MSCB = '"+MS+"'";
            st.executeUpdate(suKien);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void themRFID(String MS){
        if(rdoSV.isSelected()){
            try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM `sinhvien` where `MSSV` = '"+MS+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){ 
                if(vao == true){
                    themRFIDSV(MS);
                    d.loadTT(rs.getString("HoTenSV"), rs.getString("MSSV"), rs.getString("NganhHoc"), f.format(date), null, true,"vào");
                    d.DDVao(MS, ff.format(date));
                }else{
                    themRFIDSV(MS);
                    d.loadTT(rs.getString("HoTenSV"), rs.getString("MSSV"), rs.getString("NganhHoc"), null, f.format(date), true,"ra");
                    d.DDRa(MS, ff.format(date));
                }
                JOptionPane.showMessageDialog(null, "Thành công!");
            }else{
                int n = JOptionPane.showConfirmDialog(null,"Chưa có SV này bạn có muốn thêm không?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                    if(mf.DN == true){
                        d.ThemSV(MS, RFID, vao);
                    }else{
                        ThemSV();
                    }
                }else 
                return;
            }
            con.close();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(rdoCB.isSelected()){
            try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM `canbo` where `MSCB` = '"+MS+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                if(vao == true){
                    themRFIDCB(MS);
                    d.loadTT(rs.getString("HoTen"), rs.getString("MSCB"), rs.getString("BoMon_To"), f.format(date), null, false,"vào");
                    d.DDVao(MS, ff.format(date));
                }else {
                    themRFIDCB(MS);
                    d.loadTT(rs.getString("HoTen"), rs.getString("MSCB"), rs.getString("BoMon_To"), null, f.format(date), false,"ra");
                    d.DDRa(MS, ff.format(date));
                }
                JOptionPane.showMessageDialog(null, "Thành công!");
            }else{
                int n = JOptionPane.showConfirmDialog(null,"Chưa có CB này bạn có muốn thêm không?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                    if(mf.DN == true){
                        d.ThemCB(MS, RFID, vao);
                    }else{
                        ThemCB();
                    }
                }else 
                 return;
            }
            con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void ThemSV(){
        boolean DN = mf.DN;
        if(DN == false){
            int n = JOptionPane.showConfirmDialog(null,"Bạn chưa đăng nhập, bạn có muốn đăng nhập không?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                this.dispose();
                d.DN(txtMS.getText(), RFID, MaSK, vao,true);           
            }else 
             return;
        }
    }
    
    private void ThemCB(){
        boolean DN = mf.DN;
        if(DN == false){
            int n = JOptionPane.showConfirmDialog(null,"Bạn chưa đăng nhập, bạn có muốn đăng nhập không?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                this.dispose();
                d.DN(txtMS.getText(), RFID, MaSK, vao,false);           
            }else 
             return;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdoSV = new javax.swing.JRadioButton();
        rdoCB = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gán mã số");

        jLabel1.setText("Mã số");

        rdoSV.setText("Sinh viên");
        rdoSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSVActionPerformed(evt);
            }
        });

        rdoCB.setText("Cán bộ");
        rdoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCBActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtMS, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoSV)
                            .addComponent(rdoCB)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(rdoSV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoCB)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void rdoSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSVActionPerformed
        rdoCB.setSelected(false);
        rdoSV.setSelected(true);
    }//GEN-LAST:event_rdoSVActionPerformed

    private void rdoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCBActionPerformed
        rdoSV.setSelected(false);
        rdoCB.setSelected(true);
    }//GEN-LAST:event_rdoCBActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        d.txtID.setText("");
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(txtMS.getText().equals("")){
            System.out.println("Text null");
        }else{
            themRFID(txtMS.getText());
            this.dispose();
        }
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(ThemMSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemMSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemMSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemMSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemMSSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rdoCB;
    private javax.swing.JRadioButton rdoSV;
    private javax.swing.JTextField txtMS;
    // End of variables declaration//GEN-END:variables
}
