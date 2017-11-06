/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class BaoCao1 extends javax.swing.JPanel {
    BaoCao2 chitietPanel;
    private JFileChooser FileChooser=new JFileChooser(); 
    Vector columna = new Vector(); 
    Vector filas = new  Vector();  
    static int tabla_ancho = 0; 
    static int tabla_alto = 0; 
    /**
     * Creates new form BaoCao1
     */
    
    
    public BaoCao1() {
        initComponents();
        clearTable();
        loadTable();
    }
    
    //set main form
    public void setPanel(BaoCao2 chitietPanel){
        this.chitietPanel = chitietPanel;
    }
    
    private static DefaultTableModel tableModel = new DefaultTableModel(){
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
            String []colsName = {"Mã sự kiện", "Tên sự kiện","Ngày BĐ","Thời gian BĐ","Ngày KT","Thời gian KT","Địa điểm"};
            tableModel.setColumnIdentifiers(colsName); 
            tblSuKien.setModel(tableModel);
            while(rs.next()){ 
                Object rows[] = new Object[7];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = formater.format(rs.getDate(5));
                rows[3] = format.format(rs.getTime(3));
                rows[5] = format.format(rs.getTime(4));
                rows[4] =formater.format(rs.getDate(6));
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
                rows[5] = format.format(rs.getTime(4));
                rows[4] =formater.format(rs.getDate(6));
                rows[6] = rs.getString(7);
                tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    /*********************************************/
    public void llama_excel(){
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+txtLink.getText()+".xlsx");
            } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLink = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuKien = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnXemChitiet = new javax.swing.JButton();
        btnEx = new javax.swing.JButton();

        txtLink.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 511));
        setMinimumSize(new java.awt.Dimension(1000, 511));
        setPreferredSize(new java.awt.Dimension(1000, 511));

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
        tblSuKien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblSuKien);

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnTimKiem.setBackground(new java.awt.Color(51, 153, 255));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Báo cáo");

        BtnXemChitiet.setBackground(new java.awt.Color(51, 153, 255));
        BtnXemChitiet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnXemChitiet.setForeground(new java.awt.Color(255, 255, 255));
        BtnXemChitiet.setText("Xem chi tiết");
        BtnXemChitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnXemChitietActionPerformed(evt);
            }
        });

        btnEx.setBackground(new java.awt.Color(51, 153, 255));
        btnEx.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEx.setForeground(new java.awt.Color(255, 255, 255));
        btnEx.setText("Export to excel");
        btnEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)
                        .addGap(334, 334, 334)
                        .addComponent(BtnXemChitiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEx)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(BtnXemChitiet)
                    .addComponent(btnEx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnXemChitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnXemChitietActionPerformed
        //xu li bien truyen vao ma su kien
        int i = tblSuKien.getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Chọn dữ liệu trước xem!");
        }else{
            Object maSK = tableModel.getValueAt(i, 0);
            chitietPanel.ChiTietBaoCao((String) maSK, this);
            this.setVisible(false);
            chitietPanel.setVisible(true);
        }
        
    }//GEN-LAST:event_BtnXemChitietActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(txtTimKiem.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Tìm kiếm không được trống");
        }else{

            clearTable();

            Tim();
            int Count = tblSuKien.getRowCount();
            if(Count == 0){
                JOptionPane.showMessageDialog(null, "Không tìm được dữ liệu này!");
                clearTable();
            }else{
                clearTable();
                Tim();
                JOptionPane.showMessageDialog(null, "Tìm kiếm dữ liệu thành công!");
           }
       }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExActionPerformed
        JFileChooser dialog = new JFileChooser();
        int opcion = dialog.showSaveDialog(this);

        if(opcion == JFileChooser.APPROVE_OPTION){
            File dir = dialog.getSelectedFile();
            String fl = dir.toString();
            try {      	 
           List<JTable> tb = new ArrayList<JTable>();
           tb.add(tblSuKien);
           //-------------------
           export_excel excelExporter = new export_excel(tb, new File(fl+".xls"));
           if (excelExporter.export()) {
               JOptionPane.showMessageDialog(null, "Export thành công");
           }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//         llama_excel();
        }
    }//GEN-LAST:event_btnExActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnXemChitiet;
    private javax.swing.JButton btnEx;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSuKien;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
