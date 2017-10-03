/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class QuanLiSuKien extends javax.swing.JPanel {

    
    public QuanLiSuKien() {
        initComponents();
<<<<<<< HEAD
        clearTable();
=======
        ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
        loadTable();
    }
    
    public static DefaultTableModel tableModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    
    private Connection con = null;
    public void loadTable(){
         try {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            con = Connect.connect();
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM sukien");
            String []colsName = {"Mã sự kiện", "Tên sự kiện","Ngày BĐ","Thời gian BĐ","Thời gian KT","Ngày KT"};
            tableModel.setColumnIdentifiers(colsName); 
            tblSuKien.setModel(tableModel);
            while(rs.next()){ 
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = formater.format(rs.getDate(5));
                rows[3] = format.format(rs.getTime(3));
                rows[4] = format.format(rs.getTime(4));
                rows[5] =formater.format(rs.getDate(6));
                tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void loadText() throws ParseException{
        
        int i = tblSuKien.getSelectedRow();
        Object maSK = tableModel.getValueAt(i, 0);
        Object tenSK = tableModel.getValueAt(i, 1);
        Object ngayBD =  tableModel.getValueAt(i, 2);
        Object gioBD = tableModel.getValueAt(i, 3);
        Object ngayKT = tableModel.getValueAt(i, 5);
        Object gioKT = tableModel.getValueAt(i, 4);
        
        SimpleDateFormat outtime = new SimpleDateFormat("HH:mm");

        
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        spnGioBD.setValue(outtime.parse((String) gioBD));
        spnGioKT.setValue(outtime.parse((String) gioKT));
        spnNgayBD.setValue(out.parse((String) ngayBD));
        spnNgayKT.setValue(out.parse((String) ngayKT));
        
        txtMaSuKien.setText((String) maSK);
        txtTenSuKien.setText((String) tenSK);
        
    } 
    
    private void Tim(){
        try {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtTimKiem.getText();
            String sql = "SELECT * FROM `sukien` where `MSK` Like '%"+Search+"%' or `TenSK` Like '%"+Search+"%' or `TGBatDau` Like '%"+Search+"%' or `TGKetThuc` Like '%"+Search+"%' or `NgayBD` Like '%"+Search+"%' or `NgayKT` Like '%"+Search+"%'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){ 
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = formater.format(rs.getDate(5));
                rows[3] = format.format(rs.getTime(3));
                rows[4] = format.format(rs.getTime(4));
                rows[5] =formater.format(rs.getDate(6));
                tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void Them(){
            try {
            con = Connect.connect();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Statement st = con.createStatement();
            String Ma = txtMaSuKien.getText();
            String Ten = txtTenSuKien.getText();
            String TGBD =  format.format(spnGioBD.getValue());
            String TGKT =  format.format(spnGioKT.getValue());
            String NgayBD =  formater.format(spnNgayBD.getValue());
            String NgayKT = formater.format(spnNgayKT.getValue());
//            System.out.println(Ma+ "  " +Ten + " " +TGBD+" "+TGKT+" "+ NgayBD+" "+NgayKT);
            String SK = "insert into sukien  values('"+Ma+"','"+Ten+"','"+TGBD+"','"+TGKT+"','"+NgayBD+"','"+NgayKT+"')";
            st.executeUpdate(SK);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
    private void Xoa(){
          try {
            con = Connect.connect();
            Statement st = con.createStatement();
            int i = tblSuKien.getSelectedRow();
            String MaSK = (String) tableModel.getValueAt(i, 0);
            
            String Em = "Delete from sukien where MSK ='"+MaSK+"'";
            st.executeUpdate(Em);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
    
    public void clearTable(){
        int dem = tblSuKien.getRowCount();
        try{
        while (dem > 0 ){
            tableModel.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuKien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSuKien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spnNgayBD = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spnNgayKT = new javax.swing.JSpinner();
        btnTaoSKBtn = new javax.swing.JButton();
        spnGioBD = new javax.swing.JSpinner();
        spnGioKT = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtMaSuKien = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnImport = new javax.swing.JButton();
        btnDSThamGia = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(996, 496));

        tblSuKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sự kiện", "Tên sự kiện", "Ngày BD", "TG Bắt đầu", "Ngày KT", "TG Kết thúc"
            }
        ));
        tblSuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuKienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuKien);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã sự kiện:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên sự kiện:");

        txtTenSuKien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        btnTaoSKBtn.setBackground(new java.awt.Color(51, 153, 255));
        btnTaoSKBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTaoSKBtn.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoSKBtn.setText("Tạo sự kiện");
        btnTaoSKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoSKBtnActionPerformed(evt);
            }
        });

        spnGioBD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnGioBD.setModel(new javax.swing.SpinnerDateModel());
        spnGioBD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnGioBD.setEditor(new javax.swing.JSpinner.DateEditor(spnGioBD, "HH:mm"));

        spnGioKT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnGioKT.setModel(new javax.swing.SpinnerDateModel());
        spnGioKT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnGioKT.setEditor(new javax.swing.JSpinner.DateEditor(spnGioKT, "HH:mm"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tạo sự kiện mới");

        txtMaSuKien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSuKien, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(spnGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(spnGioKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnTaoSKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(txtMaSuKien))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addContainerGap(204, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txtMaSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnGioKT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnTaoSKBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(294, 294, 294)))
        );

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(51, 153, 255));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 153, 255));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(51, 153, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Import từ file");

        btnImport.setBackground(new java.awt.Color(51, 153, 255));
        btnImport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btnImport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDSThamGia.setBackground(new java.awt.Color(51, 153, 255));
        btnDSThamGia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDSThamGia.setForeground(new java.awt.Color(255, 255, 255));
        btnDSThamGia.setText("DS Tham gia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
<<<<<<< HEAD
                        .addComponent(btnDSThamGia)
=======
                        .addComponent(SuaBtn1)
>>>>>>> parent of c363de5... update GUI
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addGap(103, 103, 103)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
<<<<<<< HEAD
                        .addComponent(btnTimKiem)
=======
                        .addComponent(TimKiemBtn)
>>>>>>> parent of c363de5... update GUI
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnDSThamGia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoSKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoSKBtnActionPerformed
        if(txtMaSuKien.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mã sự kiện không được trống!");
        }else if(txtTenSuKien.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tên sự kiện không được trống!");
        }else {
             String sql = "select * from sukien where MSK = ?";
                try{
                   con = Connect.connect();
                   PreparedStatement pst = con.prepareStatement(sql);
                   pst.setString(1,txtMaSuKien.getText());

                   ResultSet rs = pst.executeQuery();
                   if(rs.next()){
                       JOptionPane.showMessageDialog(null, "Mã sự kiện đã tồn tại!!");
                   }else{
<<<<<<< HEAD
                       if(kTraNgayHT() == true){
                            if(kTraNgay() == true){
                                Them();
                                clearTable();
                                loadTable();
                                txtMaSuKien.setText("");
                                txtTenSuKien.setText("");
                                JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                            }else{
                                JOptionPane.showMessageDialog(null, "Ngày không hợp lý vui lòng chọn lại!");
                            }
                        
                       }else{
                           JOptionPane.showMessageDialog(null, "Ngày không hợp lý vui lòng chọn lại!");
=======
                       if(kTraNgay() == true){
                           Them();
                           ClearTable();
                           loadTable();
                           txtMaSuKien.setText("");
                           txtTenSuKien.setText("");
                           JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                       }else{
                           JOptionPane.showMessageDialog(null, "Ngày không hợp lý vui lòng chọn lại!");
                       }
                        
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
                       }
                   }
                       
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Kết nối cơ sở dũ liệu thất bại!! :(");
                }
        }
    }//GEN-LAST:event_btnTaoSKBtnActionPerformed

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
    
    private void Sua() throws ParseException{
        int i = tblSuKien.getSelectedRow();
        Object maSK = tableModel.getValueAt(i, 0);
        Object tenSK = tableModel.getValueAt(i, 1);
        Object ngayBD =  tableModel.getValueAt(i, 2);
        Object gioBD = tableModel.getValueAt(i, 3);
        Object ngayKT = tableModel.getValueAt(i, 5);
        Object gioKT = tableModel.getValueAt(i, 4);
        SuaSK s = new SuaSK();
        SimpleDateFormat outtime = new SimpleDateFormat("HH:mm");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        s.spnGioBD.setValue(outtime.parse((String) gioBD));
        s.spnGioKT.setValue(outtime.parse((String) gioKT));
        s.spnNgayBD.setValue(out.parse((String) ngayBD));
        s.spnNgayKT.setValue(out.parse((String) ngayKT));
        
        s.txtMaSK.setText((String) maSK);
        s.txtTenSK.setText((String) tenSK);
        s.setVisible(true);
    }
    
    private void textRong() throws ParseException{
        txtMaSuKien.setText("");
        txtTenSuKien.setText("");
//        Date today=new Date();
//         SimpleDateFormat outtime = new SimpleDateFormat("HH:mm");
//
//        
//        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
//        Object gbd = today;
//        Object gkt = today;
//        Object nbd = today;
//        Object nkt = today;
//        String gioBD = String.valueOf(gbd);
//        String gioKT = String.valueOf(gkt);
//        String ngayBD = String.valueOf(nbd);
//        String ngayKT = String.valueOf(nkt);
//        spnGioBD.setValue(outtime.parse((String) gioBD));
//        spnGioKT.setValue(outtime.parse((String) gioKT));
//        spnNgayBD.setValue(out.parse((String) ngayBD));
//        spnNgayKT.setValue(out.parse((String) ngayKT));
    }
    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        
    }//GEN-LAST:event_btnImportActionPerformed

    private void tblSuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuKienMouseClicked
        try {
            loadText();
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiSuKien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblSuKienMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(txtTimKiem.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Tìm kiếm không được trống");
        }else{
<<<<<<< HEAD
            clearTable();
=======
            ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
            Tim();
            int Count = tblSuKien.getRowCount();
            if(Count == 0){
                JOptionPane.showMessageDialog(null, "Không tìm được dữ liệu này!");
<<<<<<< HEAD
                clearTable();
            }else{
                clearTable();
=======
                ClearTable();
            }else{
                ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
                Tim();
                JOptionPane.showMessageDialog(null, "Tìm kiếm dữ liệu thành công!");
           }
       }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
<<<<<<< HEAD
        clearTable();
=======
        ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
        loadTable();
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained
    
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int i = tblSuKien.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Chọn dữ liệu trước khi sửa!");
        }else{
            try {
                Sua();
<<<<<<< HEAD
                clearTable();
=======
                ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
                loadTable();
            } catch (ParseException ex) {
                Logger.getLogger(QuanLiSuKien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblSuKien.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Chọn dữ liệu trước khi xóa!");
        }else{
            int n = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn xóa?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                try {
                   Xoa();
                   JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
<<<<<<< HEAD
                   clearTable();
=======
                   ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
                   loadTable();
                   textRong();
               } catch (ParseException ex) {
                   Logger.getLogger(QuanLiSuKien.class.getName()).log(Level.SEVERE, null, ex);
               }
            }else 
                return;
        } 
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDSThamGia;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoSKBtn;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnGioBD;
    private javax.swing.JSpinner spnGioKT;
    private javax.swing.JSpinner spnNgayBD;
    private javax.swing.JSpinner spnNgayKT;
    public javax.swing.JTable tblSuKien;
    private javax.swing.JTextField txtMaSuKien;
    private javax.swing.JTextField txtTenSuKien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
