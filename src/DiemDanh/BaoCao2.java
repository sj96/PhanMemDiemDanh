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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class BaoCao2 extends javax.swing.JPanel {
    
    BaoCao1 bcpanel;
     /**
     * Creates new form BaoCao2
     */
    public BaoCao2() {
        initComponents();
    }
    private int DaDD=1;
    private int ChuaDD=1;
    private int ChiVao =1;
    private int ChiRa =1;
    public void ChiTietBaoCao(String maSuKien, BaoCao1 bcPanel){
        bcpanel = bcPanel;
        loadSK(maSuKien);
        //xử lý load thông tin
        loadTable(maSuKien);
        
        
    }
    private void loadTable(String maSuKien){
        //load da DD
        clearDaDD();
        DaDDSVdk(maSuKien);
        DaDDSVkdk(maSuKien);
        DaDDCBkdk(maSuKien);
        DaDDCBdk(maSuKien);
        //load Chua DD
        clearChuaDD();
        loadTableChuaDDSV(maSuKien);
        loadTableChuaDDCB(maSuKien);
        
        //load CHi vao
        clearChiVao();
        loadTableChiVaoSV(maSuKien);
        loadTableChiVaoCB(maSuKien);
        loadTableChiVaoSVk(maSuKien);
        loadTableChiVaoCBk(maSuKien);
        //load chi ra
        clearChiRa();
        loadTableChiRaSV(maSuKien);
        loadTableChiRaCB(maSuKien);
        loadTableChiRaSVk(maSuKien);
        loadTableChiRaCBk(maSuKien);
    }
    private Connection con = null;
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
                lbTG.setText(ds);
                lbDD.setText(rs.getString("DiaDiem"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static DefaultTableModel tableModelDaDD = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    private static DefaultTableModel tableModelChuaDD = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    private static DefaultTableModel tableModelChiVao = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    private static DefaultTableModel tableModelChiRa = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    
    public void clearDaDD(){
        int dem = tblDaDD.getRowCount();
        try{
        while (dem > 0 ){
            tableModelDaDD.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
    public void clearChuaDD(){
        int dem = tblChuaDD.getRowCount();
        try{
        while (dem > 0 ){
            tableModelChuaDD.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
    public void clearChiVao(){
        int dem = tblCV.getRowCount();
        try{
        while (dem > 0 ){
            tableModelChiVao.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
    public void clearChiRa(){
        int dem = tblCR.getRowCount();
        try{
        while (dem > 0 ){
            tableModelChiRa.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    public void DaDDSVdk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select s.MSSV, s.HoTenSV, dk.MaSK from sinhvien s join dangky dk on s.MSSV = dk.MS join diemdanh dd on dk.MaDK = dd.MaDK where dk.MaSk = '"+MaSK+"'");
            String []colsName = {"STT", "MS","Họ và Tên"};
            tableModelDaDD.setColumnIdentifiers(colsName); 
            tblDaDD.setModel(tableModelDaDD);
            while(rs.next()){ 
                Object rows[] = new Object[3];
                rows[0] = DaDD;
                rows[1] = rs.getString("s.MSSV");
                rows[2] = rs.getString("s.HoTenSV");
                tableModelDaDD.addRow(rows);
                DaDD++;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void DaDDSVkdk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select s.MSSV, s.HoTenSV, dk.MaSK from sinhvien s join kdangky dk on s.MSSV = dk.MS join diemdanh dd on dk.MaDK = dd.MaDK where dk.MaSk = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                rows[0] = DaDD;
                rows[1] = rs.getString("s.MSSV");
                rows[2] = rs.getString("s.HoTenSV");
                tableModelDaDD.addRow(rows);
                DaDD++;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void DaDDCBkdk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select s.MSCB, s.HoTen, dk.MaSK from canbo s join kdangky dk on s.MSCB = dk.MS join diemdanh dd on dk.MaDK = dd.MaDK where dk.MaSk = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                rows[0] = DaDD;
                rows[1] = rs.getString("s.MSCB");
                rows[2] = rs.getString("s.HoTen");
                tableModelDaDD.addRow(rows);
                DaDD++;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void DaDDCBdk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select s.MSCB, s.HoTen, dk.MaSK from canbo s join dangky dk on s.MSCB = dk.MS join diemdanh dd on dk.MaDK = dd.MaDK where dk.MaSk = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                rows[0] = DaDD;
                rows[1] = rs.getString("s.MSCB");
                rows[2] = rs.getString("s.HoTen");
                tableModelDaDD.addRow(rows);
                DaDD++;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //chua ĐD
    public void loadTableChuaDDSV(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from dangky dk join sinhvien s on dk.MS = s.MSSV where dk.MaSK = '"+MaSK+"'");
            String []colsName = {"STT", "MS","Họ và Tên"};
            tableModelChuaDD.setColumnIdentifiers(colsName); 
            tblChuaDD.setModel(tableModelChuaDD);
            while(rs.next()){ 
                Object rows[] = new Object[3];
                Statement s1 = con.createStatement();
                ResultSet rs1 = s1.executeQuery("select * from diemdanh where MaDK = '"+rs.getString("dk.MaDK")+"'");
                if(!rs1.next()){
                    rows[0] = ChuaDD;
                    rows[1] = rs.getString("s.MSSV");
                    rows[2] = rs.getString("s.HoTenSV");
                    ChuaDD++;
                    tableModelChuaDD.addRow(rows);
                }
                
                
                
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChuaDDCB(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from dangky dk join canbo s on dk.MS = s.MSCB where dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                Statement s1 = con.createStatement();
                ResultSet rs1 = s1.executeQuery("select * from diemdanh where MaDK = '"+rs.getString("dk.MaDK")+"'");
                if(!rs1.next()){
                    rows[0] = ChuaDD;
                    rows[1] = rs.getString("s.MSCB");
                    rows[2] = rs.getString("s.HoTen");
                    ChuaDD++;
                    tableModelChuaDD.addRow(rows);
                }
                
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //chi  vao
    public void loadTableChiVaoSV(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSSV,s.HoTenSV FROM sinhvien s join dangky dk on s.MSSV = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhRa is null and dk.MaSK = '"+MaSK+"'");
            String []colsName = {"STT", "MS","Họ và Tên"};
            tableModelChiVao.setColumnIdentifiers(colsName); 
            tblCV.setModel(tableModelChiVao);
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiVao;
                    rows[1] = rs.getString("s.MSSV");
                    rows[2] = rs.getString("s.HoTenSV");
                    ChiVao++;
                tableModelChiVao.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChiVaoCB(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSCB,s.HoTen FROM canbo s join dangky dk on s.MSCB = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhRa is null and dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiVao;
                    rows[1] = rs.getString("s.MSCB");
                    rows[2] = rs.getString("s.HoTen");
                    ChiVao++;
                tableModelChiVao.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChiVaoSVk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSSV,s.HoTenSV FROM sinhvien s join kdangky dk on s.MSSV = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhRa is null and dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiVao;
                    rows[1] = rs.getString("s.MSSV");
                    rows[2] = rs.getString("s.HoTenSV");
                    ChiVao++;
                tableModelChiVao.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChiVaoCBk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSCB,s.HoTen FROM canbo s join kdangky dk on s.MSCB = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhRa is null and dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiVao;
                    rows[1] = rs.getString("s.MSCB");
                    rows[2] = rs.getString("s.HoTen");
                    ChiVao++;
                tableModelChiVao.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //Chi ra
    public void loadTableChiRaSV(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSSV,s.HoTenSV FROM sinhvien s join dangky dk on s.MSSV = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhVao is null and dk.MaSK = '"+MaSK+"'");
            String []colsName = {"STT", "MS","Họ và Tên"};
            tableModelChiRa.setColumnIdentifiers(colsName); 
            tblCR.setModel(tableModelChiRa);
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiRa;
                    rows[1] = rs.getString("s.MSSV");
                    rows[2] = rs.getString("s.HoTenSV");
                    ChiRa++;
                tableModelChiRa.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChiRaCB(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSCB,s.HoTen FROM canbo s join dangky dk on s.MSCB = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhVao is null and dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiRa;
                    rows[1] = rs.getString("s.MSCB");
                    rows[2] = rs.getString("s.HoTen");
                    ChiRa++;
                tableModelChiRa.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChiRaSVk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSSV,s.HoTenSV FROM sinhvien s join kdangky dk on s.MSSV = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhVao is null and dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiRa;
                    rows[1] = rs.getString("s.MSSV");
                    rows[2] = rs.getString("s.HoTenSV");
                    ChiRa++;
                tableModelChiRa.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableChiRaCBk(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT s.MSCB,s.HoTen FROM canbo s join kdangky dk on s.MSCB = dk.MS join diemdanh dd on dd.MaDK = dk.MaDK WHERE dd.DiemDanhVao is null and dk.MaSK = '"+MaSK+"'");
            while(rs.next()){ 
                Object rows[] = new Object[3];
                    rows[0] = ChiRa;
                    rows[1] = rs.getString("s.MSCB");
                    rows[2] = rs.getString("s.HoTen");
                    ChiRa++;
                tableModelChiRa.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CTSuKien = new javax.swing.JPanel();
        lbTenSK = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTG = new javax.swing.JLabel();
        lbDD = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCV = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaDD = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCR = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChuaDD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        Btn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 511));
        setMinimumSize(new java.awt.Dimension(1000, 511));
        setPreferredSize(new java.awt.Dimension(1000, 511));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CTSuKien.setBackground(new java.awt.Color(255, 255, 255));
        CTSuKien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTenSK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTenSK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSK.setText("<tên sự kiện>");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sự kiện:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa điểm:");

        lbTG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTG.setText("<Thời Gian>");

        lbDD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDD.setText("<Địa Điểm>");

        javax.swing.GroupLayout CTSuKienLayout = new javax.swing.GroupLayout(CTSuKien);
        CTSuKien.setLayout(CTSuKienLayout);
        CTSuKienLayout.setHorizontalGroup(
            CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTSuKienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTenSK, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTG, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CTSuKienLayout.setVerticalGroup(
            CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTSuKienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenSK)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTG)
                    .addComponent(lbDD))
                .addContainerGap())
        );

        add(CTSuKien, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 10, 920, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblCV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Stt", "Họ tên", "Mã số"
            }
        ));
        jScrollPane2.setViewportView(tblCV);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chỉ vào");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 490, 220));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblDaDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Stt", "Họ tên", "Mã số"
            }
        ));
        jScrollPane1.setViewportView(tblDaDD);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đã điểm danh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 480, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblCR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Stt", "Họ tên", "Mã số"
            }
        ));
        jScrollPane3.setViewportView(tblCR);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Chỉ ra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(0, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 490, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblChuaDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Stt", "Họ tên", "Mã số"
            }
        ));
        jScrollPane4.setViewportView(tblChuaDD);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Chưa điểm danh");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 480, -1));

        Btn1.setBackground(new java.awt.Color(51, 153, 255));
        Btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn1.setForeground(new java.awt.Color(255, 255, 255));
        Btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DiemDanh/back-arrow.png"))); // NOI18N
        Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1ActionPerformed(evt);
            }
        });
        add(Btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1ActionPerformed
        this.setVisible(false);
        bcpanel.setVisible(true);
        DaDD = 1;
        ChuaDD = 1;
        ChiRa = 1;
        ChiVao = 1;
    }//GEN-LAST:event_Btn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn1;
    private javax.swing.JPanel CTSuKien;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbDD;
    private javax.swing.JLabel lbTG;
    private javax.swing.JLabel lbTenSK;
    private javax.swing.JTable tblCR;
    private javax.swing.JTable tblCV;
    private javax.swing.JTable tblChuaDD;
    private javax.swing.JTable tblDaDD;
    // End of variables declaration//GEN-END:variables
}
