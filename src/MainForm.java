


import DiemDanh.DiemDanh;
import DiemDanh.QuanLiCanBo;
import DiemDanh.QuanLiSinhVien;
import DiemDanh.QuanLiSuKien;



public class MainForm extends javax.swing.JFrame {

    
    public MainForm() {
        initComponents();
<<<<<<< HEAD
        DiemDanh DD = new DiemDanh();
        pnBody.removeAll();
        pnBody.add(DD);
        pnBody.validate();
        this.setResizable(false);
=======
>>>>>>> master
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        Menu = new javax.swing.JPanel();
<<<<<<< HEAD
        btnDiemDanh = new javax.swing.JButton();
        btnQunLiSuKien = new javax.swing.JButton();
        btnQuanLiCanBo = new javax.swing.JButton();
        btnQuanLySinhVien = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        Body = new javax.swing.JPanel();
        pnBody = new javax.swing.JPanel();
=======
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Body = new javax.swing.JPanel();
>>>>>>> master

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Header.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HỆ THỐNG ĐIỂM DANH");

        btnDangNhap.setBackground(new java.awt.Color(51, 153, 255));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng Nhập");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(btnDangNhap)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(0, 153, 255));
        Menu.setMaximumSize(new java.awt.Dimension(996, 32767));
        Menu.setMinimumSize(new java.awt.Dimension(996, 25));
        Menu.setPreferredSize(new java.awt.Dimension(996, 25));
        Menu.setLayout(new java.awt.GridLayout(1, 0));

<<<<<<< HEAD
        btnDiemDanh.setBackground(new java.awt.Color(0, 153, 255));
        btnDiemDanh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDiemDanh.setForeground(new java.awt.Color(255, 255, 255));
        btnDiemDanh.setText("Điểm Danh");
        btnDiemDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemDanhActionPerformed(evt);
            }
        });
        Menu.add(btnDiemDanh);

        btnQunLiSuKien.setBackground(new java.awt.Color(0, 153, 255));
        btnQunLiSuKien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQunLiSuKien.setForeground(new java.awt.Color(255, 255, 255));
        btnQunLiSuKien.setText("Quản lí Sự Kiện");
        btnQunLiSuKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQunLiSuKienActionPerformed(evt);
            }
        });
        Menu.add(btnQunLiSuKien);

        btnQuanLiCanBo.setBackground(new java.awt.Color(0, 153, 255));
        btnQuanLiCanBo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuanLiCanBo.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLiCanBo.setText("Quản lí Cán Bộ");
        btnQuanLiCanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiCanBoActionPerformed(evt);
            }
        });
        Menu.add(btnQuanLiCanBo);

        btnQuanLySinhVien.setBackground(new java.awt.Color(0, 153, 255));
        btnQuanLySinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuanLySinhVien.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLySinhVien.setText("Quản lí Sinh Viên");
        btnQuanLySinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySinhVienActionPerformed(evt);
            }
        });
        Menu.add(btnQuanLySinhVien);

        btnThongKe.setBackground(new java.awt.Color(0, 153, 255));
        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống Kê");
        Menu.add(btnThongKe);
=======
        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Điểm Danh");
        Menu.add(jButton2);

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Quản lí Sự Kiện");
        Menu.add(jButton3);

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Quản lí Cán Bộ - Sinh Viên");
        Menu.add(jButton4);

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Quản lí Khoa - Đơn vị");
        jButton6.setToolTipText("");
        Menu.add(jButton6);
>>>>>>> master

        jButton7.setBackground(new java.awt.Color(0, 153, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Thống Kê");
        Menu.add(jButton7);

        Body.setBackground(new java.awt.Color(255, 255, 255));
        Body.setMaximumSize(new java.awt.Dimension(1060, 511));
        Body.setMinimumSize(new java.awt.Dimension(1060, 511));
        Body.setPreferredSize(new java.awt.Dimension(1060, 511));
        Body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
<<<<<<< HEAD

        pnBody.setLayout(new java.awt.BorderLayout());
        Body.add(pnBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 510));
=======
>>>>>>> master

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQunLiSuKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQunLiSuKienActionPerformed
        QuanLiSuKien QLSK = new QuanLiSuKien();
        pnBody.removeAll();
        pnBody.add(QLSK);
        pnBody.validate();
    }//GEN-LAST:event_btnQunLiSuKienActionPerformed

    private void btnDiemDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemDanhActionPerformed
        DiemDanh DD = new DiemDanh();
        pnBody.removeAll();
        pnBody.add(DD);
        pnBody.validate();
    }//GEN-LAST:event_btnDiemDanhActionPerformed

    private void btnQuanLiCanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiCanBoActionPerformed
        QuanLiCanBo QLCB = new QuanLiCanBo();
        pnBody.removeAll();
        pnBody.add(QLCB);
        pnBody.validate();
    }//GEN-LAST:event_btnQuanLiCanBoActionPerformed

    private void btnQuanLySinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLySinhVienActionPerformed
        QuanLiSinhVien QLSV = new QuanLiSinhVien();
        pnBody.removeAll();
        pnBody.add(QLSV);
        pnBody.validate();
    }//GEN-LAST:event_btnQuanLySinhVienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Menu;
<<<<<<< HEAD
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDiemDanh;
    private javax.swing.JButton btnQuanLiCanBo;
    private javax.swing.JButton btnQuanLySinhVien;
    private javax.swing.JButton btnQunLiSuKien;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnBody;
=======
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
>>>>>>> master
    // End of variables declaration//GEN-END:variables
}
