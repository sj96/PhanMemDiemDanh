/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
import javax.swing.JOptionPane;

/**
 *
 * @author trana
 */
public class SuaSK extends javax.swing.JFrame {

    /**
     * Creates new form SuaSK
     */
    public SuaSK() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spnNgayBD = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spnNgayKT = new javax.swing.JSpinner();
        spnGioBD = new javax.swing.JSpinner();
        spnGioKT = new javax.swing.JSpinner();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sửa Sự Kiện");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã sự kiện:");

        txtMaSK.setEditable(false);
        txtMaSK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên sự kiện:");

        txtTenSK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian bắt đầu:");

        spnNgayBD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnNgayBD.setModel(new javax.swing.SpinnerDateModel());
        spnNgayBD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnNgayBD.setEditor(new javax.swing.JSpinner.DateEditor(spnNgayBD, " dd/MM/yyyy"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian kết thúc:");

        spnNgayKT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnNgayKT.setModel(new javax.swing.SpinnerDateModel());
        spnNgayKT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnNgayKT.setEditor(new javax.swing.JSpinner.DateEditor(spnNgayKT, " dd/MM/yyyy"));

        spnGioBD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnGioBD.setModel(new javax.swing.SpinnerDateModel());
        spnGioBD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
<<<<<<< HEAD
        spnGioBD.setEditor(new javax.swing.JSpinner.DateEditor(spnGioBD, "HH:mm"));
=======
        spnGioBD.setEditor(new javax.swing.JSpinner.DateEditor(spnGioBD, "HH:00"));
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921

        spnGioKT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnGioKT.setModel(new javax.swing.SpinnerDateModel());
        spnGioKT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
<<<<<<< HEAD
        spnGioKT.setEditor(new javax.swing.JSpinner.DateEditor(spnGioKT, "HH:mm"));
=======
        spnGioKT.setEditor(new javax.swing.JSpinner.DateEditor(spnGioKT, "HH:00"));
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921

        btnLuu.setBackground(new java.awt.Color(51, 153, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(51, 153, 255));
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSK)
                            .addComponent(txtTenSK, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(spnGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(spnGioKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnLuu)
                .addGap(18, 18, 18)
                .addComponent(btnHuy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnGioKT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private QuanLiSuKien sk = new QuanLiSuKien();
    private Connection con = null;
<<<<<<< HEAD

    
=======
    private void loadTable(){
         try {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            con = Connect.connect();
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM sukien");
            String []colsName = {"Mã sự kiện", "Tên sự kiện","Ngày BĐ","Thời gian BĐ","Thời gian KT","Ngày KT"};
            sk.tableModel.setColumnIdentifiers(colsName); 
            sk.tblSuKien.setModel(sk.tableModel);
            while(rs.next()){ 
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = formater.format(rs.getDate(5));
                rows[3] = format.format(rs.getTime(3));
                rows[4] = format.format(rs.getTime(4));
                rows[5] =formater.format(rs.getDate(6));
                sk.tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void clearTable(){
        int dem = sk.tblSuKien.getRowCount();
        try{
        while (dem > 0 ){
            sk.tableModel.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
    
    private void Sua(){
        try {
            con = Connect.connect();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Statement st = con.createStatement();
            String Ma = txtMaSK.getText();
            String Ten = txtTenSK.getText();
            String TGBD =  format.format(spnGioBD.getValue());
            String TGKT =  format.format(spnGioKT.getValue());
            String NgayBD =  formater.format(spnNgayBD.getValue());
            String NgayKT = formater.format(spnNgayKT.getValue());
            String suKien = "Update sukien set TenSK = '"+Ten+"',TGBatDau = '"+TGBD+"', TGKetThuc = '"+TGKT+"', NgayBD = '"+NgayBD+"', NgayKT = '"+NgayKT+"' where MSK = '"+Ma+"'";
            st.executeUpdate(suKien);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean kTraNgay(){
        boolean ktra = false;
        SimpleDateFormat ngay = new SimpleDateFormat("dd");
        SimpleDateFormat thang = new SimpleDateFormat("MM");
        SimpleDateFormat nam = new SimpleDateFormat("yyyy");
        SimpleDateFormat gio = new SimpleDateFormat("HH");
        SimpleDateFormat phut = new SimpleDateFormat("mm");
        
        int ngayBD = Integer.parseInt(ngay.format(spnNgayBD.getValue()));
        int ngayKT = Integer.parseInt(ngay.format(spnNgayKT.getValue()));
        int thangBD = Integer.parseInt(thang.format(spnNgayBD.getValue()));
        int thangKT = Integer.parseInt(thang.format(spnNgayKT.getValue()));
        int namBD = Integer.parseInt(nam.format(spnNgayBD.getValue()));
        int namKT = Integer.parseInt(nam.format(spnNgayKT.getValue()));
        int gioBD = Integer.parseInt(gio.format(spnGioBD.getValue()));
        int gioKT = Integer.parseInt(gio.format(spnGioKT.getValue()));

        
        if(namKT == namBD){
            if(thangKT == thangBD){
                if(ngayKT == ngayBD){
                    if(gioKT > gioBD){
                        ktra = true;
                    }else if(gioKT <= gioBD){
                        ktra = false;
                    }
                }else if(ngayKT > ngayBD){
                    ktra = true;
                }else{
                    ktra = false;
                }
            }else if(thangKT > thangBD){
                ktra = true;
            }else{
                ktra = false;
            }
        }else if(namKT > namBD){
            ktra = true;
        }else{
            ktra = false;
        }
            
        return ktra;
    }
    
<<<<<<< HEAD
    private boolean kTraNgayHT(){
        boolean ktra = false;
         Date date = new Date();
        SimpleDateFormat ngay = new SimpleDateFormat("dd");
        SimpleDateFormat thang = new SimpleDateFormat("MM");
        SimpleDateFormat nam = new SimpleDateFormat("yyyy");
        SimpleDateFormat gio = new SimpleDateFormat("HH");
        SimpleDateFormat phut = new SimpleDateFormat("mm");
        
        int ngayBD = Integer.parseInt(ngay.format(spnNgayBD.getValue()));
        int ngayHT = Integer.parseInt(ngay.format(date));
        int thangBD = Integer.parseInt(thang.format(spnNgayBD.getValue()));
        int thangHT = Integer.parseInt(thang.format(date));
        int namBD = Integer.parseInt(nam.format(spnNgayBD.getValue()));
        int namHT = Integer.parseInt(nam.format(date));
        int gioBD = Integer.parseInt(gio.format(spnGioBD.getValue()));
        int gioHT = Integer.parseInt(gio.format(date));

        
        if(namHT == namBD){
            if(thangHT == thangBD){
                if(ngayHT == ngayBD){
                    if(gioBD > gioHT){
                        ktra = true;
                    }else if(gioBD <= gioHT){
                        ktra = false;
                    }
                }else if(ngayBD > ngayHT){
                    ktra = true;
                }else{
                    ktra = false;
                }
            }else if(thangBD > thangHT){
                ktra = true;
            }else{
                ktra = false;
            }
        }else if(namBD > namHT){
            ktra = true;
        }else{
            ktra = false;
        }
            
        return ktra;
    }
    
=======
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int n = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn hủy?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            this.dispose();
        }else 
            return;
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
<<<<<<< HEAD
        QuanLiSuKien ql = new QuanLiSuKien();
        if(txtTenSK.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tên sự kiện không được trống!");
        }else{
            if(kTraNgayHT() == true){
                if(kTraNgay() == true){
                    ql.clearTable();
                    Sua();
                    ql.loadTable();
                    JOptionPane.showMessageDialog(null, "Sửa dữ liệu thành công!");
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Ngày tháng hoặc giờ không hợp lý!");
                }
=======
        if(txtTenSK.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tên sự kiện không được trống!");
        }else{
            if(kTraNgay() == true){
                clearTable();
                Sua();
                loadTable();
                JOptionPane.showMessageDialog(null, "Sửa dữ liệu thành công!");
                this.dispose();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
            }else{
                JOptionPane.showMessageDialog(null, "Ngày tháng hoặc giờ không hợp lý!");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

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
            java.util.logging.Logger.getLogger(SuaSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaSK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaSK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JSpinner spnGioBD;
    public javax.swing.JSpinner spnGioKT;
    public javax.swing.JSpinner spnNgayBD;
    public javax.swing.JSpinner spnNgayKT;
    public javax.swing.JTextField txtMaSK;
    public javax.swing.JTextField txtTenSK;
    // End of variables declaration//GEN-END:variables
}
