/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class Dangkythamgia extends javax.swing.JPanel {

    /**
     * Creates new form Dangkythamgia
     */
    public Dangkythamgia() {
        initComponents();
        clearTableCB();
        loadTableCB();
        ClearTableSV();
        loadTableSV();
//        ClearTableDSTG();
//        loadTableDSTG();
    }
    QuanLiSuKien_user qlu;
    public void DangKy (int mask, String tenSK){
        
    }
    
    private String MaSK;
    public void getMaSK(String MaSK){
        this.MaSK = MaSK;
    }
    
    public static DefaultTableModel tableModelCB = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    private Connection con = null;
    public void loadTableCB(){
         try {
            con = Connect.connect();
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM canbo");
            String []colsName = {"Mscb", "Họ tên","Email","Khoa","Ngành","Mã số thẻ"};
            tableModelCB.setColumnIdentifiers(colsName); 
            tblCB.setModel(tableModelCB);
            while(rs.next()){ 
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(6);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(4);
                tableModelCB.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    
    public void clearTableCB(){
        int dem = tblCB.getRowCount();
        try{
        while (dem > 0 ){
            tableModelCB.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }

    ///Sinh Vien
    public static DefaultTableModel tableModelSV = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };

    public void loadTableSV(){
         try {
            con = Connect.connect();
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM sinhvien");
            String []colsName = {"Mssv", "Họ tên","Email","Khoa","Ngành","Khóa","Mã số thẻ"};
            tableModelSV.setColumnIdentifiers(colsName); 
            tblSV.setModel(tableModelSV);
            while(rs.next()){ 
                Object rows[] = new Object[7];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(6);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(7);
                rows[6] = rs.getString(4);
                tableModelSV.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    
    private void ClearTableSV(){
        int dem = tblSV.getRowCount();
        try{
        while (dem > 0 ){
            tableModelSV.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
   
    ///Sinh Vien
    public static DefaultTableModel tableModelDSTG = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };

    public void loadTableDSTGSV(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM dangky JOIN sinhvien ON sinhvien.MSSV = dangky.MS  where dangky.MaSK = '"+MaSK+"'");
            String []colsName = {"Mã đăng ký", "Mã số","Họ tên"};
            tableModelDSTG.setColumnIdentifiers(colsName); 
            tblDSThamGia.setModel(tableModelDSTG);
            while(rs.next()){ 
                Object rows[] = new Object[3];
                rows[0] = rs.getString("dangky.MaDK");
                rows[1] = rs.getString("dangky.MS"); 
                rows[2] = rs.getString("sinhvien.HoTenSV");
                tableModelDSTG.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadTableDSTGCB(String MaSK){
         try {
            con = Connect.connect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM dangky JOIN canbo ON canbo.MSCB = dangky.MS  where dangky.MaSK = '"+MaSK+"'");
            tblDSThamGia.setModel(tableModelDSTG);
            while(rs.next()){ 
                Object rows[] = new Object[3];
                rows[0] = rs.getString("dangky.MaDK");
                rows[1] = rs.getString("dangky.MS"); 
                rows[2] = rs.getString("canbo.HoTen");
                tableModelDSTG.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
   
    
    public void ClearTableDSTG(){
        int dem = tblDSThamGia.getRowCount();
        try{
        while (dem > 0 ){
            tableModelDSTG.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
    private void Xoa(){
        int i = tblDSThamGia.getSelectedRow();
        String MaDK = (String) tableModelDSTG.getValueAt(i, 0);
          try {
            con = Connect.connect();
            Statement st = con.createStatement();            
            String Em = "Delete from dangky where MaDK ='"+MaDK+"'";
            st.executeUpdate(Em);
            con.close();
//            System.out.println(MaDK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
    
    private String MaDKCB(){
        int i = tblCB.getSelectedRow();
        String MSCB = (String) tableModelCB.getValueAt(i, 0);
        return MaSK + MSCB;
    }
    
    private String MaDKSV(){
        int i = tblSV.getSelectedRow();
        String MSSV = (String) tableModelSV.getValueAt(i, 0);
        return MaSK + MSSV;
    }
    
    private void ThemCB(){
        int i = tblCB.getSelectedRow();
        String MSCB = (String) tableModelCB.getValueAt(i, 0);
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String SK = "insert into dangky  values('"+MaDKCB()+"','"+MaSK+"','"+MSCB+"')";
            st.executeUpdate(SK);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
    
    private void ThemSV(){
        int i = tblSV.getSelectedRow();
        String MSSV = (String) tableModelSV.getValueAt(i, 0);
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String SK = "insert into dangky  values('"+MaDKSV()+"','"+MaSK+"','"+MSSV+"')";
            st.executeUpdate(SK);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
    
    private void TimSV(){
        try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtTimKiemSV.getText();
            String sql = "SELECT * FROM `sinhvien` where `MSSV` Like '%"+Search+"%' or `HoTenSV` Like '%"+Search+"%' or `Email` Like '%"+Search+"%' or `MaRFID` Like '%"+Search+"%' or `NganhHoc` Like '%"+Search+"%' or `Khoa` Like '%"+Search+"%' or `K` Like '%"+Search+"%'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){ 
                Object rows[] = new Object[7];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(6);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(7);
                rows[6] = rs.getString(4);
                tableModelSV.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void TimCB(){
        try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtTimKiemCB.getText();
            String sql = "SELECT * FROM `canbo` where `MSCB` Like '%"+Search+"%' or `HoTen` Like '%"+Search+"%' or `Email` Like '%"+Search+"%' or `MaRFID` Like '%"+Search+"%' or `BoMon_To` Like '%"+Search+"%' or `Khoa_Phong` Like '%"+Search+"%'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){ 
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(6);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(4);
                tableModelCB.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSThamGia = new javax.swing.JTable();
        CTSuKien = new javax.swing.JPanel();
        lbTenSK = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNgaySK = new javax.swing.JLabel();
        lbDiaDiem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnThemCB = new javax.swing.JButton();
        txtTimKiemCB = new javax.swing.JTextField();
        btnTimKiemCB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCB = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiemSV = new javax.swing.JTextField();
        btnTimKiemSV = new javax.swing.JButton();
        btnThemSV = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        TimKiemBtn5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 511));
        setMinimumSize(new java.awt.Dimension(1000, 511));
        setPreferredSize(new java.awt.Dimension(1000, 511));

        tblDSThamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Stt", "Mã số", "Họ tên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDSThamGia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tblDSThamGia);
        if (tblDSThamGia.getColumnModel().getColumnCount() > 0) {
            tblDSThamGia.getColumnModel().getColumn(0).setMinWidth(30);
            tblDSThamGia.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        CTSuKien.setBackground(new java.awt.Color(255, 255, 255));
        CTSuKien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTenSK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTenSK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSK.setText("<tên sự kiện>");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sự kiện");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa điểm:");

        lbNgaySK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgaySK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNgaySK.setText("<thời gian>");

        lbDiaDiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDiaDiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiaDiem.setText("<địa điểm>");

        javax.swing.GroupLayout CTSuKienLayout = new javax.swing.GroupLayout(CTSuKien);
        CTSuKien.setLayout(CTSuKienLayout);
        CTSuKienLayout.setHorizontalGroup(
            CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTSuKienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CTSuKienLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTenSK, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CTSuKienLayout.createSequentialGroup()
                        .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDiaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgaySK, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );
        CTSuKienLayout.setVerticalGroup(
            CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTSuKienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenSK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgaySK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CTSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiaDiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách tham gia");

        btnXoa.setBackground(new java.awt.Color(51, 153, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThemCB.setBackground(new java.awt.Color(51, 153, 255));
        btnThemCB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemCB.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCB.setText("Thêm");
        btnThemCB.setToolTipText("");
        btnThemCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCBActionPerformed(evt);
            }
        });

        txtTimKiemCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemCBFocusGained(evt);
            }
        });

        btnTimKiemCB.setBackground(new java.awt.Color(51, 153, 255));
        btnTimKiemCB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiemCB.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemCB.setText("Tìm kiếm");
        btnTimKiemCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemCBActionPerformed(evt);
            }
        });

        tblCB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Mscb", "Họ tên", "Khoa/Phòng", "Bộ Môn/Tổ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCB.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblCB);
        if (tblCB.getColumnModel().getColumnCount() > 0) {
            tblCB.getColumnModel().getColumn(0).setMinWidth(30);
            tblCB.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiemCB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemCB)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemCB)
                    .addComponent(btnThemCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Cán bộ  ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiemSV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemSV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemSVFocusGained(evt);
            }
        });

        btnTimKiemSV.setBackground(new java.awt.Color(51, 153, 255));
        btnTimKiemSV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiemSV.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemSV.setText("Tìm kiếm");
        btnTimKiemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSVActionPerformed(evt);
            }
        });

        btnThemSV.setBackground(new java.awt.Color(51, 153, 255));
        btnThemSV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemSV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSV.setText("Thêm");
        btnThemSV.setToolTipText("");
        btnThemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSVActionPerformed(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mssv", "Họ tên", "Khoa", "Ngành", "Khóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblSV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThemSV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemSV)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemSV)
                    .addComponent(btnThemSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Sinh viên  ", jPanel2);

        TimKiemBtn5.setBackground(new java.awt.Color(51, 153, 255));
        TimKiemBtn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimKiemBtn5.setForeground(new java.awt.Color(255, 255, 255));
        TimKiemBtn5.setText("Import...");
        TimKiemBtn5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CTSuKien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(105, 105, 105)
                        .addComponent(TimKiemBtn5)
                        .addGap(15, 15, 15)
                        .addComponent(btnXoa))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CTSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(TimKiemBtn5)
                            .addComponent(btnXoa))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblDSThamGia.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 người");
        }else{
            Xoa();
            ClearTableDSTG();
            loadTableDSTGSV(MaSK);
            loadTableDSTGCB(MaSK);
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCBActionPerformed
        int i = tblCB.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn cán bộ");
        }else{
            String sql = "select * from dangky where MaDK = ?";
                try{
                   con = Connect.connect();
                   PreparedStatement pst = con.prepareStatement(sql);
                   pst.setString(1,MaDKCB());

                   ResultSet rs = pst.executeQuery();
                   if(rs.next()){
                       JOptionPane.showMessageDialog(null, "Cán bộ này đã đăng ký sự kiện này");
                   }else{
                        ThemCB();
                        ClearTableDSTG();
                        loadTableDSTGSV(MaSK);
                        loadTableDSTGCB(MaSK);
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                    }
                       
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Kết nối cơ sở dũ liệu thất bại!! :(");
                }
        }
    }//GEN-LAST:event_btnThemCBActionPerformed

    private void btnThemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSVActionPerformed
        int i = tblSV.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên");
        }else{
            String sql = "select * from dangky where MaDK = ?";
                try{
                   con = Connect.connect();
                   PreparedStatement pst = con.prepareStatement(sql);
                   pst.setString(1,MaDKSV());

                   ResultSet rs = pst.executeQuery();
                   if(rs.next()){
                       JOptionPane.showMessageDialog(null, "sinh viên này đã đăng ký sự kiện này");
                   }else{
                        ThemSV();
                        ClearTableDSTG();
                        loadTableDSTGSV(MaSK);
                        loadTableDSTGCB(MaSK);
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                    }
                       
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Kết nối cơ sở dũ liệu thất bại!! :(");
                }
        }
    }//GEN-LAST:event_btnThemSVActionPerformed

    private void btnTimKiemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSVActionPerformed
        if(txtTimKiemSV.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Tìm kiếm không được trống");
        }else{
            ClearTableSV();
            TimSV();
            int Count = tblSV.getRowCount();
            if(Count == 0){
                JOptionPane.showMessageDialog(null, "Không tìm được dữ liệu này!");
                ClearTableSV();
            }else{
                ClearTableSV();
                TimSV();
                JOptionPane.showMessageDialog(null, "Tìm kiếm dữ liệu thành công!");
           }
       }
    }//GEN-LAST:event_btnTimKiemSVActionPerformed

    private void txtTimKiemSVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemSVFocusGained
        txtTimKiemSV.setText("");
        ClearTableSV();
        loadTableSV();
    }//GEN-LAST:event_txtTimKiemSVFocusGained

    private void btnTimKiemCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemCBActionPerformed
        if(txtTimKiemCB.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Tìm kiếm không được trống");
        }else{
            clearTableCB();
            TimCB();
            int Count = tblCB.getRowCount();
            if(Count == 0){
                JOptionPane.showMessageDialog(null, "Không tìm được dữ liệu này!");
                clearTableCB();
            }else{
                clearTableCB();
                TimCB();
                JOptionPane.showMessageDialog(null, "Tìm kiếm dữ liệu thành công!");
           }
       }
    }//GEN-LAST:event_btnTimKiemCBActionPerformed

    private void txtTimKiemCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemCBFocusGained
        txtTimKiemCB.setText("");
        clearTableCB();
        loadTableCB();
    }//GEN-LAST:event_txtTimKiemCBFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTSuKien;
    private javax.swing.JButton TimKiemBtn5;
    private javax.swing.JButton btnThemCB;
    private javax.swing.JButton btnThemSV;
    private javax.swing.JButton btnTimKiemCB;
    private javax.swing.JButton btnTimKiemSV;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel lbDiaDiem;
    public javax.swing.JLabel lbNgaySK;
    public javax.swing.JLabel lbTenSK;
    private javax.swing.JTable tblCB;
    private javax.swing.JTable tblDSThamGia;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField txtTimKiemCB;
    private javax.swing.JTextField txtTimKiemSV;
    // End of variables declaration//GEN-END:variables
}
