/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import static DiemDanh.QuanLiSinhVien.tableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author trana
 */
public class DiemDanh extends javax.swing.JPanel {
    DangNhap dn;
    QuanLiSinhVien sv;
    QuanLiCanBo cb;
    /**
     * Creates new form DiemDanh
     */
    public static String MaSK;
    public void getMaSK(String MaSK){
        this.MaSK = MaSK;
    }
    private String GioV = null;
    public DiemDanh() {
        initComponents();
        txtID.addActionListener( action );
        txtID.setDocument(new LengthRestrictedDocument(10));
        rdoVao.setSelected(true);
        this.MaSK = MaSK;
        loadSK(MaSK);
        System.out.println("Diem Danh");

    }
    
    public void setPanelDN(DangNhap dn){
        this.dn = dn;
    }
    
    public void setPanelSV(QuanLiSinhVien sv){
        this.sv = sv;
    }
    public void setPanelCB(QuanLiCanBo cb){
        this.cb = cb;
    }
//    public DiemDanh(String MaSK) {
//        initComponents();
//        txtID.addActionListener( action );
//        txtID.setDocument(new LengthRestrictedDocument(10));
//        rdoVao.setSelected(true);
//        this.MaSK = MaSK;
//        loadSK(MaSK);
//
//    }
    
    
    
    Action action = new AbstractAction(){
    @Override
        public void actionPerformed(ActionEvent e){
            if(!txtID.getText().equals("")){
//                Tim();
                kCo();
            }
        }
    };


    public void loadSK(String maSK){
        System.out.println(maSK);
        try {
            SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
            con = Connect.connect();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM `sukien` where `MSK` = '"+maSK+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){ 
//                lbMa.setText(maSK);
                lbTenSK.setText(rs.getString("TenSK"));
                String d = String.valueOf(fd.format(rs.getDate("NgayBD")));
                String t = String.valueOf(ft.format(rs.getTime("TGBatDau")));
                String ds = d+" "+t;
                lbTG.setText("Thời gian: "+ ds);
                lbDD.setText("Địa điểm: "+ rs.getString("DiaDiem"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTT(String HoTen, String Ma, String Nganh, String GiVao, String GioRa, boolean isSV,String TT){
        lbHoTen.setText("Họ Tên: "+HoTen);
        if(isSV){
        lbMa.setText("Mã số SV: "+Ma);
        lbNganh.setText("Ngành: "+ Nganh);
        }else{
        lbMa.setText("Mã số CB: "+Ma);
        lbNganh.setText("Đơn vị: "+ Nganh);
        }
        lbGioVao.setText("Giờ vào: "+GiVao);
        lbGiora.setText("Giờ ra: "+GioRa);
        lbTT.setText("Đã điểm danh "+TT);
    }
    private Connection con = null;
    SimpleDateFormat f = new SimpleDateFormat("HH:mm dd/MM/yyyy");
    
    private void kDangKy(String MaDK, String MSK, String MS){
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String SK = "insert into kdangky  values('"+MaDK+"','"+MSK+"','"+MS+"')";
            st.executeUpdate(SK);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
    
    
    
    private void Tim(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if(rdoVao.isSelected()){
        try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtID.getText();
            String sql = "SELECT * FROM `sinhvien` where `MaRFID` = '"+Search+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){ 
                Statement s1 = con.createStatement();
                String sql1 = "SELECT * FROM `diemdanh` where `MaDK` = '"+MaSK+rs.getString("MSSV")+"'";
                ResultSet rs1 = s1.executeQuery(sql1);
                if(rs1.next()){
                    JOptionPane.showMessageDialog(null, "Bạn đã điểm danh vào rồi!");
                }else{
                    loadTT(rs.getString("HoTenSV"), rs.getString("MSSV"), rs.getString("NganhHoc"), f.format(date), null,true,"vào");
                    DDVao(rs.getString("MSSV"), ff.format(date));
                    JOptionPane.showMessageDialog(null, "Điểm danh SV thành công");
                    txtID.setText("");

                }
            }else{
                Statement s1 = con.createStatement();
                String sql1 = "SELECT * FROM `canbo` where `MaRFID` = '"+Search+"' ";
                ResultSet rs1 = s1.executeQuery(sql1);
                if(rs1.next()){ 
                    Statement s2 = con.createStatement();
                    String sql2 = "SELECT * FROM `diemdanh` where `MaDK` = '"+MaSK+rs1.getString("MSCB")+"'";
                    ResultSet rs2 = s2.executeQuery(sql2);
                    if(rs2.next()){
                        JOptionPane.showMessageDialog(null, "Bạn đã điểm danh vào rồi!");
                    }else{
                        loadTT(rs1.getString("HoTen"), rs1.getString("MSCB"), rs1.getString("BoMon_To"), f.format(date), null,false,"vào");
                        DDVao(rs1.getString("MSCB"), ff.format(date));
                        JOptionPane.showMessageDialog(null, "Điểm danh CB thành công");
                        txtID.setText("");
                    }
                }
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }else if(rdoRa.isSelected()){
            try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtID.getText();
            String sql = "SELECT * FROM `sinhvien` where `MaRFID` = '"+Search+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                DDRa(rs.getString("MSSV"), ff.format(date));
                loadTT(rs.getString("HoTenSV"), rs.getString("MSSV"), rs.getString("NganhHoc"), GioV, f.format(date),true,"ra");
                JOptionPane.showMessageDialog(null, "Điểm danh SV thành công");
                txtID.setText("");
                GioV = null;
            }else{
                Statement s1 = con.createStatement();
                String sql1 = "SELECT * FROM `canbo` where `MaRFID` = '"+Search+"' ";
                ResultSet rs1 = s1.executeQuery(sql1);
                if(rs1.next()){
                    DDRa(rs1.getString("MSCB"), ff.format(date));
                    loadTT(rs1.getString("HoTen"), rs1.getString("MSCB"), rs1.getString("BoMon_To"), GioV, f.format(date),true,"ra");
                    JOptionPane.showMessageDialog(null, "Điểm danh CB thành công");
                    txtID.setText("");
                    GioV = null;
                }
            }
            } catch (Exception ex) {
            ex.printStackTrace();
            }
        }
    }
    
    public void DDVao(String MS,String GioVao){
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String vao = "insert into diemdanh (MaDK, DiemDanhVao)  values('"+MaSK+MS+"','"+GioVao+"')";
            st.executeUpdate(vao);
            Statement s2 = con.createStatement();
            String sql2 = "SELECT * FROM `dangky` where `MaDK` = '"+MaSK+MS+"'";
            ResultSet rs2 = s2.executeQuery(sql2);
            if(!rs2.next()){
                kDangKy(MaSK+MS, MaSK, MS);
                System.out.println("Người này không đăng ký");
            }else{
                System.out.println("Người này có đăng ký");
            }
            con.close();
        } catch (Exception ex) {}
    }
    
    public void DDRa(String MS, String GioRa){
        try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM `diemdanh` where `MaDK` = '"+MaSK+MS+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                Statement st = con.createStatement();
                String up = "Update diemdanh set DiemDanhRa = '"+GioRa+"' where MaDK = '"+MaSK+MS+"'";
                   GioV = f.format(rs.getTimestamp("DiemDanhVao"));
                st.executeUpdate(up);
            }else{
                Statement st = con.createStatement();
                String ra = "insert into diemdanh (MaDK, DiemDanhRa) values('"+MaSK+MS+"','"+GioRa+"')";
                st.executeUpdate(ra);
                Statement s1 = con.createStatement();
                String sql1 = "SELECT * FROM `dangky` where `MaDK` = '"+MaSK+MS+"' ";
                ResultSet rs1 = s1.executeQuery(sql1);
                if(!rs1.next()){
                    kDangKy(MaSK+MS, MaSK, MS);
                    System.out.println("Người này không đăng ký");
                }else{
                    System.out.println("Người này có đăng ký");
                }
            }
            con.close();
        } catch (Exception ex) {}
    }
    
    private void kCo(){
        try {
            con = Connect.connect();
            Statement s = con.createStatement();
            if(rdoVao.isSelected()){
                String Search = txtID.getText();
                String sql = "SELECT * FROM `sinhvien` where `MaRFID` = '"+Search+"' ";
                ResultSet rs = s.executeQuery(sql);
                if(rs.next()){
                    Tim();
                }else{
                    Statement s1 = con.createStatement();
                    String sql1 = "SELECT * FROM `canbo` where `MaRFID` = '"+Search+"' ";
                    ResultSet rs1 = s1.executeQuery(sql1);
                    if(rs1.next()){
                        Tim();
                    }else{
                            ThemMSSV th = new ThemMSSV(this, Search, true, MaSK);
                            th.setVisible(true);
                    }
                }
            }else{
                String Search = txtID.getText();
                String sql = "SELECT * FROM `sinhvien` where `MaRFID` = '"+Search+"' ";
                ResultSet rs = s.executeQuery(sql);
                if(rs.next()){
                    Tim();
                }else{
                    Statement s1 = con.createStatement();
                    String sql1 = "SELECT * FROM `canbo` where `MaRFID` = '"+Search+"' ";
                    ResultSet rs1 = s1.executeQuery(sql1);
                    if(rs1.next()){
                        Tim();
                    }else{
                            ThemMSSV th = new ThemMSSV(this, Search, false, MaSK);
                            th.setVisible(true);
                    }
                }
            }
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
    
    public void DN(String MS, String RFID, String MaSK, boolean vao,boolean isSV){
        this.setVisible(false);
        dn.setVisible(true);
        dn.setMS(MS);
        dn.setVao(vao);
        dn.setMaT(RFID);
        dn.setMaSK(MaSK);
        if(isSV == true){
            dn.setIsSV(true);
            dn.setIsCB(false);
        }else{
            dn.setIsSV(false);
            dn.setIsCB(true);
        }
    }
    
    public void ThemSV(String MS, String RFID, boolean vao){
        this.setVisible(false);
        sv.setVisible(true);
        sv.loadDD(MS, RFID);
        sv.setDL(true, MaSK, vao);
        sv.setTextDN();
    }
    
    public void ThemCB(String MS, String RFID, boolean vao){
        this.setVisible(false);
        cb.setVisible(true);
        cb.loadDD(MS, RFID);
        cb.setDL(true, MaSK, vao);
        cb.setTextDN();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnDiemDanh = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        rdoVao = new javax.swing.JRadioButton();
        rdoRa = new javax.swing.JRadioButton();
        CTSuKien = new javax.swing.JPanel();
        lbTenSK = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTG = new javax.swing.JLabel();
        lbDD = new javax.swing.JLabel();
        TTThe = new javax.swing.JPanel();
        lbMa = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbGiora = new javax.swing.JLabel();
        lbGioVao = new javax.swing.JLabel();
        lbNganh = new javax.swing.JLabel();
        TrangThai = new javax.swing.JPanel();
        lbTT = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(1000, 511));
        setMinimumSize(new java.awt.Dimension(1000, 511));
        setPreferredSize(new java.awt.Dimension(1000, 511));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vui lòng quét thẻ");

        btnDiemDanh.setBackground(new java.awt.Color(51, 153, 255));
        btnDiemDanh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDiemDanh.setForeground(new java.awt.Color(255, 255, 255));
        btnDiemDanh.setText("Điểm danh");
        btnDiemDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemDanhActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setFocusCycleRoot(true);
        txtID.setFocusTraversalPolicyProvider(true);
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDMouseClicked(evt);
            }
        });

        rdoVao.setBackground(new java.awt.Color(255, 255, 255));
        rdoVao.setText("Điểm danh vào");
        rdoVao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoVaoActionPerformed(evt);
            }
        });

        rdoRa.setBackground(new java.awt.Color(255, 255, 255));
        rdoRa.setText("Điểm danh ra");
        rdoRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoRaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(btnDiemDanh))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoRa)
                            .addComponent(rdoVao))))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoVao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoRa)
                .addGap(131, 131, 131)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDiemDanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(197, 197, 197))
        );

        CTSuKien.setBackground(new java.awt.Color(255, 255, 255));
        CTSuKien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTenSK.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTenSK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSK.setText("<tên sự kiện>");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sự kiện");

        lbTG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTG.setText("Thời gian:");

        lbDD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDD.setText("Địa điểm:");

        javax.swing.GroupLayout CTSuKienLayout = new javax.swing.GroupLayout(CTSuKien);
        CTSuKien.setLayout(CTSuKienLayout);
        CTSuKienLayout.setHorizontalGroup(
            CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTSuKienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenSK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CTSuKienLayout.setVerticalGroup(
            CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTSuKienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTenSK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTG, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDD, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TTThe.setBackground(new java.awt.Color(255, 255, 255));
        TTThe.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbMa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMa.setText("Mã số SV/CB:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin thẻ");

        lbHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHoTen.setText("Họ Tên:");

        lbGiora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGiora.setText("Giờ ra:");

        lbGioVao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGioVao.setText("Giờ vào:");

        lbNganh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNganh.setText("Ngành:");

        javax.swing.GroupLayout TTTheLayout = new javax.swing.GroupLayout(TTThe);
        TTThe.setLayout(TTTheLayout);
        TTTheLayout.setHorizontalGroup(
            TTTheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTTheLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TTTheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGioVao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGiora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TTTheLayout.setVerticalGroup(
            TTTheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TTTheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMa, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbGioVao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbGiora, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TrangThai.setBackground(new java.awt.Color(255, 255, 255));
        TrangThai.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTT.setForeground(new java.awt.Color(0, 153, 153));
        lbTT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTT.setText("Trạng thái điểm danh");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Trạng thái");

        javax.swing.GroupLayout TrangThaiLayout = new javax.swing.GroupLayout(TrangThai);
        TrangThai.setLayout(TrangThaiLayout);
        TrangThaiLayout.setHorizontalGroup(
            TrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangThaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTT, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(TrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TrangThaiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TrangThaiLayout.setVerticalGroup(
            TrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrangThaiLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(TrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TrangThaiLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CTSuKien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TTThe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CTSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TTThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        txtID.setText("");
    }//GEN-LAST:event_txtIDMouseClicked

    private void btnDiemDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemDanhActionPerformed
        if(!txtID.getText().equals("")){
            kCo();
            txtID.requestFocusInWindow();
        }
//        this.setVisible(false);
//        dn.setVisible(true);
    }//GEN-LAST:event_btnDiemDanhActionPerformed

    private void rdoRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoRaActionPerformed
       rdoVao.setSelected(false);
       rdoRa.setSelected(true);
       txtID.requestFocusInWindow();
    }//GEN-LAST:event_rdoRaActionPerformed

    private void rdoVaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoVaoActionPerformed
        rdoRa.setSelected(false);
        rdoVao.setSelected(true);
        txtID.requestFocusInWindow();
    }//GEN-LAST:event_rdoVaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTSuKien;
    private javax.swing.JPanel TTThe;
    private javax.swing.JPanel TrangThai;
    private javax.swing.JButton btnDiemDanh;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lbDD;
    private javax.swing.JLabel lbGioVao;
    private javax.swing.JLabel lbGiora;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lbNganh;
    public javax.swing.JLabel lbTG;
    private javax.swing.JLabel lbTT;
    public javax.swing.JLabel lbTenSK;
    private javax.swing.JRadioButton rdoRa;
    private javax.swing.JRadioButton rdoVao;
    public javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables

}