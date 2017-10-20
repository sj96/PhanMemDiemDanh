/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import static DiemDanh.QuanLiSinhVien.tableModel;
import java.sql.Connection;
import java.sql.Date;
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
public class QuanLiSuKien_user extends javax.swing.JPanel {
    Dangkythamgia dk = new Dangkythamgia();
    
    
    
    public QuanLiSuKien_user() {
        initComponents();
        ThongTin.setVisible(false);
        clearTable();
        btnDangKy.setEnabled(false);
        btnHuyDangKy.setEnabled(false);
        txtTimKiem.setEnabled(false);
        btnTimKiem.setEnabled(false);
    }
      
    private static DefaultTableModel tableModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    private boolean TimSV(){
        try {
            
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtKiemTra.getText();
            String sql = "SELECT * FROM `sinhvien` where `MSSV` = '"+Search+"'";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                txtHoTen.setText(rs.getString("HoTenSV"));
                txtMa.setText(rs.getString("MSSV"));
                txtNganh.setText(rs.getString("NganhHoc"));
                return true;
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    private boolean TimCB(){
        try {
            
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtKiemTra.getText();
            String sql = "SELECT * FROM `canbo` where `MSCB` = '"+Search+"'";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                txtHoTen.setText(rs.getString("HoTen"));
                txtMa.setText(rs.getString("MSCB"));
                txtNganh.setText(rs.getString("BoMon_To"));
                return true;
            }
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean kTraNgay(java.util.Date NgaySK, java.util.Date GioSK, java.util.Date NgayHT) {
        boolean ktra = false;
        SimpleDateFormat ngay = new SimpleDateFormat("dd");
        SimpleDateFormat thang = new SimpleDateFormat("MM");
        SimpleDateFormat nam = new SimpleDateFormat("yyyy");
        SimpleDateFormat gio = new SimpleDateFormat("HH");
        SimpleDateFormat phut = new SimpleDateFormat("mm");
        
        int ngaySK = Integer.parseInt(ngay.format(NgaySK));
        int ngayHT = Integer.parseInt(ngay.format(NgayHT));
        int thangSK = Integer.parseInt(thang.format(NgaySK));
        int thangHT = Integer.parseInt(thang.format(NgayHT));
        int namSK = Integer.parseInt(nam.format(NgaySK));
        int namHT = Integer.parseInt(nam.format(NgayHT));
        int gioSK = Integer.parseInt(gio.format(GioSK));
        int gioHT = Integer.parseInt(gio.format(NgayHT));
        int phutSK = Integer.parseInt(phut.format(GioSK));
        int phutHT = Integer.parseInt(phut.format(NgayHT));
        
        if(namHT == namSK){
            if(thangHT == thangSK){
                if(ngayHT == ngaySK){
                    if(gioHT == gioSK){
                        if(phutHT < phutSK ){
                            ktra = true;
                        }else if (phutHT >= phutSK){
                            ktra = false;
                        }
                    }else if(gioSK > gioHT){
                        ktra = true;
                    }else{
                        ktra = false;
                    }
                }else if(ngaySK > ngayHT){
                    ktra = true;
                }else{
                    ktra = false;
                }
            }else if(thangSK > thangHT){
                ktra = true;
            }else{
                ktra = false;
            }
        }else if(namSK > namHT){
            ktra = true;
        }else{
            ktra = false;
        }
        return ktra;
    }
    
    private Connection con = null;
    public void loadTable(){
         try {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            con = Connect.connect();
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM sukien");
            String []colsName = {"Mã sự kiện", "Tên sự kiện","Ngày BĐ","Thời gian BĐ","Thời gian KT","Ngày KT","Địa điểm"};
            tableModel.setColumnIdentifiers(colsName); 
            tblSuKien.setModel(tableModel);
            while(rs.next()){ 
                Object rows[] = new Object[7];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = formater.format(rs.getDate(5));
                rows[3] = format.format(rs.getTime(3));
                rows[4] = format.format(rs.getTime(4));
                rows[5] =formater.format(rs.getDate(6));
                rows[6] = rs.getString(7);
                tableModel.addRow(rows);
            }
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
     
    public void loadTableDate() throws ParseException{
        java.util.Date NgayHT = new java.util.Date();
        SimpleDateFormat outtime = new SimpleDateFormat("HH:mm");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        int a = 0;
        int i = tblSuKien.getRowCount() - a;
        
//          System.out.println(NgayHT);
        for(int j = i -1; j >= 0; j--){
            Object ngayBD =  tableModel.getValueAt(j, 2);
            Object gioBD = tableModel.getValueAt(j, 3);
            java.util.Date NgaySK = out.parse((String) ngayBD);
            java.util.Date GioSK = outtime.parse((String) gioBD);
            if(kTraNgay(NgaySK, GioSK, NgayHT) == false){
                tableModel.removeRow(j);
            }
        }  
        
        
    } 
      
    private String MaDK(){
        int i = tblSuKien.getSelectedRow();
        String MSK = (String) tableModel.getValueAt(i, 0);
        String MSSV = txtMa.getText();
        return MSK+MSSV; 
     }
      
     private void DangKy(){
        int i = tblSuKien.getSelectedRow();
        String MSK = (String) tableModel.getValueAt(i, 0);
        String MS = txtMa.getText();
        try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String SK = "insert into dangky  values('"+MaDK()+"','"+MSK+"','"+MS+"')";
            st.executeUpdate(SK);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
     }
     
     private void HuySK(){
          try {
            con = Connect.connect();
            Statement st = con.createStatement();            
            String Em = "Delete from dangky where MaDK ='"+MaDK()+"'";
            st.executeUpdate(Em);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
     
     private void Tim(){
        try {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtTimKiem.getText();
            String sql = "SELECT * FROM `sukien` where `MSK` Like '%"+Search+"%' or `TenSK` Like '%"+Search+"%' or `TGBatDau` Like '%"+Search+"%' or `TGKetThuc` Like '%"+Search+"%' or `NgayBD` Like '%"+Search+"%' or `NgayKT` Like '%"+Search+"%' or `DiaDiem` Like '%"+Search+"%'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){ 
                Object rows[] = new Object[7];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = formater.format(rs.getDate(5));
                rows[3] = format.format(rs.getTime(3));
                rows[4] = format.format(rs.getTime(4));
                rows[5] =formater.format(rs.getDate(6));
                rows[6] = rs.getString(7);
                tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuKien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKiemTra = new javax.swing.JTextField();
        btnKiemTra = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnHuyDangKy = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        ThongTin = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        txtNganh = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 511));
        setMinimumSize(new java.awt.Dimension(1000, 511));
        setPreferredSize(new java.awt.Dimension(1000, 511));

        tblSuKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sự kiện", "Tên sự kiện", "Ngày BD", "TG Bắt đầu", "Ngày KT", "TG Kết thúc"
            }
        ));
        tblSuKien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuKienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuKien);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MSSV/MSCB");

        txtKiemTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnKiemTra.setBackground(new java.awt.Color(51, 153, 255));
        btnKiemTra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKiemTra.setForeground(new java.awt.Color(255, 255, 255));
        btnKiemTra.setText("Kiểm tra");
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKiemTra, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnKiemTra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKiemTra)
                .addContainerGap(14, Short.MAX_VALUE))
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

        btnHuyDangKy.setBackground(new java.awt.Color(51, 153, 255));
        btnHuyDangKy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuyDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyDangKy.setText("Hủy Đăng ký");
        btnHuyDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDangKyActionPerformed(evt);
            }
        });

        btnDangKy.setBackground(new java.awt.Color(51, 153, 255));
        btnDangKy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        ThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Mã số SV/CB:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Họ Tên:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Ngành/Đơn vị:");

        btnCapNhat.setBackground(new java.awt.Color(51, 153, 255));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật thông tin");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHoTen.setEnabled(false);

        txtMa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMa.setEnabled(false);

        txtNganh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNganh.setEnabled(false);

        javax.swing.GroupLayout ThongTinLayout = new javax.swing.GroupLayout(ThongTin);
        ThongTin.setLayout(ThongTinLayout);
        ThongTinLayout.setHorizontalGroup(
            ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHoTen)
                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNganh))
                .addContainerGap())
        );
        ThongTinLayout.setVerticalGroup(
            ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDangKy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHuyDangKy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnTimKiem))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem)
                            .addComponent(btnHuyDangKy)
                            .addComponent(btnDangKy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
       int i = tblSuKien.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sự kiện");
        }else{
            String sql = "select * from dangky where MaDK = ?";
                try{
                   con = Connect.connect();
                   PreparedStatement pst = con.prepareStatement(sql);
                   pst.setString(1,MaDK());

                   ResultSet rs = pst.executeQuery();
                   if(rs.next()){
                       JOptionPane.showMessageDialog(null, "Bạn đã đăng ký sự kiện này");
                   }else{
                        DangKy();
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                    }
                       
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Kết nối cơ sở dũ liệu thất bại!! :(");
                }
        }
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
       if(TimCB() == true || TimSV() == true){
           ThongTin.setVisible(true);
           clearTable();
           loadTable();
           try {
                loadTableDate();
                btnDangKy.setEnabled(true);
                btnHuyDangKy.setEnabled(true);
                txtTimKiem.setEnabled(true);
                btnTimKiem.setEnabled(true);
                txtTimKiem.setText("");
           } catch (ParseException ex) {
               Logger.getLogger(QuanLiSuKien_user.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{
            ThongTin.setVisible(false);
            clearTable();
            btnDangKy.setEnabled(false);
            btnHuyDangKy.setEnabled(false);
            txtTimKiem.setEnabled(false);
            btnTimKiem.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Mã số không tồn tại");
           
       }
       
    }//GEN-LAST:event_btnKiemTraActionPerformed

    private void tblSuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuKienMouseClicked
        
    }//GEN-LAST:event_tblSuKienMouseClicked

    private void btnHuyDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDangKyActionPerformed
        int i = tblSuKien.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sự kiện");
        }else{
            String sql = "select * from dangky where MaDK = ?";
                try{
                   con = Connect.connect();
                   PreparedStatement pst = con.prepareStatement(sql);
                   pst.setString(1,MaDK());

                   ResultSet rs = pst.executeQuery();
                   if(!rs.next()){
                       JOptionPane.showMessageDialog(null, "Bạn chưa đăng ký sự kiện này");
                   }else{
                        HuySK();
                        JOptionPane.showMessageDialog(null, "Hủy đăng ký thành công");
                    }
                       
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Kết nối cơ sở dũ liệu thất bại!! :(");
                }
        }
    }//GEN-LAST:event_btnHuyDangKyActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(txtTimKiem.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Tìm kiếm không được trống");
        }else{
            clearTable();
            Tim();
            try {
                loadTableDate();
            } catch (ParseException ex) {
                Logger.getLogger(QuanLiSuKien_user.class.getName()).log(Level.SEVERE, null, ex);
            }
            int Count = tblSuKien.getRowCount();
            if(Count == 0){
                JOptionPane.showMessageDialog(null, "Không tìm được dữ liệu này!");
                clearTable();
            }else{
                clearTable();
                Tim();
                try {
                    loadTableDate();
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLiSuKien_user.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Tìm kiếm dữ liệu thành công!");
           }
       }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        clearTable();
        loadTable();
        try {
            loadTableDate();
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiSuKien_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ThongTin;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnHuyDangKy;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSuKien;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtKiemTra;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNganh;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    
}
