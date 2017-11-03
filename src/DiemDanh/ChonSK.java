/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import static DiemDanh.QuanLiSinhVien.tableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author trana
 */
public class ChonSK extends javax.swing.JPanel {

    /**
     * Creates new form ChonSK
     */
    DiemDanh dd;
    private Connection con = null;
    java.util.Date date = new java.util.Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm ");
    public ChonSK() {
        initComponents();
        System.out.println("Chọn SK");
    }
    public void setPanel(DiemDanh dd){
            this.dd = dd;
            loadData();
    }
    
    public void loadData(){
        //load db
        try {
            con = Connect.connect();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM `sukien`";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){ 
                String dh = String.valueOf(f.format(date));
                String d = String.valueOf(fd.format(rs.getDate("NgayBD")));
                String t = String.valueOf(ft.format(rs.getTime("TGBatDau")));
                String ds = d+" "+t;
                if(kTraNgay(ds, dh) == true){
                     add_btn_sk(rs.getString("MSK"),rs.getString("TenSK"),String.valueOf(ft.format(rs.getTime("TGBatDau"))),String.valueOf(ft.format(rs.getTime("TGKetThuc"))));
                }
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    public void add_btn_sk(String id, String name, String startTime, String endTime){
//        id : mã sự kiện
//        name : tên sự kiện
//        startTime : thời gian bắt đầu
//        endTime: thời gian kết thúc
        
        javax.swing.JButton sk = new javax.swing.JButton();
        
        //set properties
        sk.setBackground(new Color(51,153,255));
        sk.setForeground(Color.white);
        
        //set text         
        sk.setText("<html> <center><b style='font-size:25'>"+name+"</b><br> <p>từ "+startTime+" đến "+endTime+"</p></center> </html>");
        
        //add listener
        
        sk.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dd.getMaSK(id);
                dd.loadSK(id);
                setVisible(false);
                dd.setVisible(true);
                dd.txtID.requestFocusInWindow();
                
//                System.out.println(id);
            }
        });

        jPanel2.add(sk);        
    } 
    
    private boolean kTraNgay(String NgaySK, String NgayHT) {
        boolean ktra = false;
//        System.out.println(NgayHT);
        int ngaySK = Integer.parseInt(NgaySK.substring(0, 2));
        int ngayHT = Integer.parseInt(NgayHT.substring(0, 2));
        int thangSK = Integer.parseInt(NgaySK.substring(3, 5));
        int thangHT = Integer.parseInt(NgayHT.substring(3, 5));
        int namSK = Integer.parseInt(NgaySK.substring(6, 10));
        int namHT = Integer.parseInt(NgayHT.substring(6, 10));
        int gioSK = Integer.parseInt(NgaySK.substring(11, 13));
        int gioHT = Integer.parseInt(NgayHT.substring(11, 13));
        int phutSK = Integer.parseInt(NgaySK.substring(14, 16));
        int phutHT = Integer.parseInt(NgayHT.substring(14, 16));
        
        if(namHT == namSK){
            if(thangHT == thangSK){
                if(ngayHT == ngaySK){
                    if(gioHT == gioSK){
                        if(phutSK - phutHT > 30 ){
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 511));
        setMinimumSize(new java.awt.Dimension(1000, 511));
        setPreferredSize(new java.awt.Dimension(1000, 511));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách sự kiện đang diễn ra");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(5, 5));
        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
