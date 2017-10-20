package form;


import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainForm extends javax.swing.JFrame {
    
    private static Boolean isAdmin = false;
    public void setisAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    public MainForm() {
        initComponents();
        lbNameUser.setVisible(false);
        resetForm();
        dashBroad1.setVisible(true);
        baoCao11.setPanel(baoCao21);
        quanLiSuKien1.setPanel(dangkythamgia1);
        dangNhap1.setMf(this);
    }
    
    public void resetForm(){
        dashBroad1.setVisible(false);
        chonSK1.setVisible(false);
        dangNhap1.setVisible(false);
        dangkythamgia1.setVisible(false);        
        diemDanh1.setVisible(false);
        quanLiCanBo1.setVisible(false);
        quanLiSinhVien1.setVisible(false);
        quanLiSuKien1.setVisible(false);
        quanLiSuKien_user1.setVisible(false);
        baoCao11.setVisible(false);
        baoCao21.setVisible(false);
    }
    public void resetHome(){
        dashBroad1.setVisible(true);
    }
    
    public void setAdmin(String name){
        btnDangNhap.setText("Đăng Xuất");
        lbNameUser.setText(name);
        lbNameUser.setVisible(true);
        isAdmin = true;
        btnBaoCao.setEnabled(true);
        btnQuanLiCanBo.setEnabled(true);
        btnQuanLiSinhVien.setEnabled(true);
        
        resetForm();
        dashBroad1.setVisible(true);
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
        btnDangNhap = new javax.swing.JButton();
        lbNameUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnDiemDanh = new javax.swing.JButton();
        btnDanhSachSuKien = new javax.swing.JButton();
        btnQuanLiCanBo = new javax.swing.JButton();
        btnQuanLiSinhVien = new javax.swing.JButton();
        btnBaoCao = new javax.swing.JButton();
        Body = new javax.swing.JPanel();
        dashBroad1 = new DiemDanh.DashBoard();
        dangNhap1 = new DiemDanh.DangNhap();
        dangkythamgia1 = new DiemDanh.Dangkythamgia();
        diemDanh1 = new DiemDanh.DiemDanh();
        quanLiCanBo1 = new DiemDanh.QuanLiCanBo();
        quanLiSinhVien1 = new DiemDanh.QuanLiSinhVien();
        quanLiSuKien1 = new DiemDanh.QuanLiSuKien();
        quanLiSuKien_user1 = new DiemDanh.QuanLiSuKien_user();
        chonSK1 = new DiemDanh.ChonSK();
        baoCao21 = new DiemDanh.BaoCao2();
        baoCao11 = new DiemDanh.BaoCao1();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm Điểm Danh");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1001, 662));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 102, 204));
        Header.setMinimumSize(new java.awt.Dimension(1000, 114));
        Header.setName(""); // NOI18N
        Header.setPreferredSize(new java.awt.Dimension(1000, 114));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDangNhap.setBackground(new java.awt.Color(51, 153, 255));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        Header.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, 34));

        lbNameUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNameUser.setForeground(new java.awt.Color(255, 255, 255));
        lbNameUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNameUser.setText("Name,");
        Header.add(lbNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 120, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 280, 114));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHẦN MỀM ĐIỂM DANH");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1000, 114));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, -1, -1));

        Menu.setBackground(new java.awt.Color(0, 153, 255));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setBackground(new java.awt.Color(0, 153, 255));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-icon-silhouette.png"))); // NOI18N
        btnHome.setMaximumSize(new java.awt.Dimension(50, 25));
        btnHome.setMinimumSize(new java.awt.Dimension(25, 25));
        btnHome.setPreferredSize(new java.awt.Dimension(25, 25));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        Menu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 55, 25));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnDiemDanh.setBackground(new java.awt.Color(0, 153, 255));
        btnDiemDanh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDiemDanh.setForeground(new java.awt.Color(255, 255, 255));
        btnDiemDanh.setText("Điểm Danh");
        btnDiemDanh.setMaximumSize(new java.awt.Dimension(77, 25));
        btnDiemDanh.setMinimumSize(new java.awt.Dimension(77, 25));
        btnDiemDanh.setPreferredSize(new java.awt.Dimension(77, 25));
        btnDiemDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemDanhActionPerformed(evt);
            }
        });
        jPanel1.add(btnDiemDanh);

        btnDanhSachSuKien.setBackground(new java.awt.Color(0, 153, 255));
        btnDanhSachSuKien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDanhSachSuKien.setForeground(new java.awt.Color(255, 255, 255));
        btnDanhSachSuKien.setText("Danh sách sự kiện");
        btnDanhSachSuKien.setMaximumSize(new java.awt.Dimension(77, 25));
        btnDanhSachSuKien.setMinimumSize(new java.awt.Dimension(77, 25));
        btnDanhSachSuKien.setPreferredSize(new java.awt.Dimension(77, 25));
        btnDanhSachSuKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachSuKienActionPerformed(evt);
            }
        });
        jPanel1.add(btnDanhSachSuKien);

        btnQuanLiCanBo.setBackground(new java.awt.Color(0, 153, 255));
        btnQuanLiCanBo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuanLiCanBo.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLiCanBo.setText("Quản lí Cán Bộ");
        btnQuanLiCanBo.setToolTipText("");
        btnQuanLiCanBo.setEnabled(false);
        btnQuanLiCanBo.setMaximumSize(new java.awt.Dimension(77, 25));
        btnQuanLiCanBo.setMinimumSize(new java.awt.Dimension(77, 25));
        btnQuanLiCanBo.setPreferredSize(new java.awt.Dimension(77, 25));
        btnQuanLiCanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiCanBoActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuanLiCanBo);

        btnQuanLiSinhVien.setBackground(new java.awt.Color(0, 153, 255));
        btnQuanLiSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuanLiSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLiSinhVien.setText("Quản lí Sinh Viên");
        btnQuanLiSinhVien.setEnabled(false);
        btnQuanLiSinhVien.setMaximumSize(new java.awt.Dimension(77, 25));
        btnQuanLiSinhVien.setMinimumSize(new java.awt.Dimension(77, 25));
        btnQuanLiSinhVien.setPreferredSize(new java.awt.Dimension(77, 25));
        btnQuanLiSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiSinhVienActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuanLiSinhVien);

        btnBaoCao.setBackground(new java.awt.Color(0, 153, 255));
        btnBaoCao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBaoCao.setForeground(new java.awt.Color(255, 255, 255));
        btnBaoCao.setText("Báo cáo");
        btnBaoCao.setToolTipText("");
        btnBaoCao.setEnabled(false);
        btnBaoCao.setMaximumSize(new java.awt.Dimension(77, 25));
        btnBaoCao.setMinimumSize(new java.awt.Dimension(77, 25));
        btnBaoCao.setPreferredSize(new java.awt.Dimension(77, 25));
        btnBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoCaoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBaoCao);

        Menu.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 0, 950, -1));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 120, 1000, -1));

        Body.setBackground(new java.awt.Color(204, 204, 204));
        Body.setMinimumSize(new java.awt.Dimension(996, 511));
        Body.setPreferredSize(new java.awt.Dimension(1000, 511));
        Body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Body.add(dashBroad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(dangNhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(dangkythamgia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(diemDanh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(quanLiCanBo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(quanLiSinhVien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(quanLiSuKien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
        Body.add(quanLiSuKien_user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(chonSK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(baoCao21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Body.add(baoCao11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Body, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 151, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //xu li button
    
    private void btnDanhSachSuKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachSuKienActionPerformed
        resetForm();
        if(!isAdmin){
            quanLiSuKien_user1.setVisible(true);
        }
        else {
            quanLiSuKien1.setVisible(true);
        }
    }//GEN-LAST:event_btnDanhSachSuKienActionPerformed

    private void btnDiemDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemDanhActionPerformed
        resetForm();
        chonSK1.setVisible(true);        
    }//GEN-LAST:event_btnDiemDanhActionPerformed

    private void btnQuanLiCanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiCanBoActionPerformed
        resetForm();
        quanLiCanBo1.setVisible(true);
    }//GEN-LAST:event_btnQuanLiCanBoActionPerformed

    private void btnQuanLiSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiSinhVienActionPerformed
        resetForm();
        quanLiSinhVien1.setVisible(true);
    }//GEN-LAST:event_btnQuanLiSinhVienActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        resetForm();
        dashBroad1.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if(!isAdmin){
            resetForm();
            dangNhap1.setVisible(true);
//            dangNhap1.getRootPane().setDefaultButton(dangNhap1.btnDangNhap);
            lbNameUser.setText("admin");
        }
        else {
            isAdmin = false;
            lbNameUser.setVisible(false);
            btnDangNhap.setText("Đăng Nhập");
            btnBaoCao.setEnabled(false);
            btnQuanLiCanBo.setEnabled(false);
            btnQuanLiSinhVien.setEnabled(false);
            resetForm();
            dashBroad1.setVisible(true);
//            quanLiSuKien_user1.clearTable();
//            quanLiSuKien_user1.loadTable();
            try {
                quanLiSuKien_user1.loadTableDate();
            } catch (ParseException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoCaoActionPerformed
        resetForm();
        baoCao11.setVisible(true);
    }//GEN-LAST:event_btnBaoCaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
    private DiemDanh.BaoCao1 baoCao11;
    private DiemDanh.BaoCao2 baoCao21;
    public javax.swing.JButton btnBaoCao;
    public javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDanhSachSuKien;
    private javax.swing.JButton btnDiemDanh;
    private javax.swing.JButton btnHome;
    public javax.swing.JButton btnQuanLiCanBo;
    public javax.swing.JButton btnQuanLiSinhVien;
    private DiemDanh.ChonSK chonSK1;
    private DiemDanh.DangNhap dangNhap1;
    private DiemDanh.Dangkythamgia dangkythamgia1;
    private DiemDanh.DashBoard dashBroad1;
    private DiemDanh.DiemDanh diemDanh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbNameUser;
    private DiemDanh.QuanLiCanBo quanLiCanBo1;
    private DiemDanh.QuanLiSinhVien quanLiSinhVien1;
    private DiemDanh.QuanLiSuKien quanLiSuKien1;
    private DiemDanh.QuanLiSuKien_user quanLiSuKien_user1;
    // End of variables declaration//GEN-END:variables
}
