/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemDanh;

import static DiemDanh.QuanLiSinhVien.tableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author trana
 */
public class QuanLiCanBo extends javax.swing.JPanel {

    /**
     * Creates new form QuanLiSuKien
     */
    public QuanLiCanBo() {
        initComponents();
<<<<<<< HEAD
        clearTable();
=======
        ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
        loadTable();
        txtMaT.setDocument(new LengthRestrictedDocument(10));
//        cbbNganh.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCB = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        TaoSVBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbKhoa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMaT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbNganh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEM = new javax.swing.JTextField();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(996, 496));

        tblCB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mscb", "Họ tên", "Khoa/Phòng", "Bộ Môn/Tổ", "Mã số thẻ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCB);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã số cán bộ:");
        jLabel1.setToolTipText("");

        txtMa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TaoSVBtn.setBackground(new java.awt.Color(51, 153, 255));
        TaoSVBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TaoSVBtn.setForeground(new java.awt.Color(255, 255, 255));
        TaoSVBtn.setText("Tạo Cán Bộ");
        TaoSVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoSVBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tạo Cán Bộ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Khoa:");

        cbbKhoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa Công nghệ", "Khoa Công nghệ TT-TT", "Khoa Khoa học Chính trị", "Khoa Khoa học Tự nhiên", "Khoa Khoa học Xã hội & Nhân văn", "Khoa Kinh tế", "Khoa Luật", "Khoa Môi trường & TNTN", "Khoa Nông nghiệp & SNƯD", "Khoa Ngoại ngữ", "Khoa Phát triển Nông thôn", "Khoa Sư phạm", "Khoa Thủy sản", "Viện NC&PTCNSH", "Viện NCPT ĐBSCL", "Bộ môn Giáo dục Thể chất" }));
        cbbKhoa.setToolTipText("");
        cbbKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhoaItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mã số thẻ:");

        txtMaT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Ngành:");
        jLabel9.setToolTipText("");

        cbbNganh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công nghệ kỹ thuật hóa học", "Công nghệ kỹ thuật hóa học (Chất lượng cao)", "Kỹ thuật điều khiển và tự động hóa", "Kỹ thuật điện tử, truyền thông", "Kỹ thuật điện, điện tử (Kỹ thuật điện)", "Kỹ thuật công trình thủy", "Kỹ thuật công trình xây dựng (XD Công trình thủy)", "Kỹ thuật công trình xây dựng (XD cầu đường)", "Kỹ thuật công trình xây dựng (XD dân dụng và CN)", "Kỹ thuật cơ - điện tử", "Kỹ thuật cơ khí (Cơ khí chế biến)", "Kỹ thuật cơ khí (Cơ khí chế tạo máy)", "Kỹ thuật cơ khí (Cơ khí giao thông)", "Kỹ thuật Máy tính", "Kỹ thuật vật liệu", "Kỹ thuật xây dựng công trình giao thông", "Quản lý công nghiệp" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        txtEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEM, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbNganh, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbbKhoa, 0, 303, Short.MAX_VALUE)))
                    .addComponent(txtMaT)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMa))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TaoSVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(282, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TaoSVBtn)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(355, Short.MAX_VALUE)))
        );

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimFocusGained(evt);
            }
        });

        btnTim.setBackground(new java.awt.Color(51, 153, 255));
        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 153, 255));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
<<<<<<< HEAD
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
=======
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921

        btnXoa.setBackground(new java.awt.Color(51, 153, 255));
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

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Import");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addGap(120, 120, 120)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim)
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nganhKhoa(){
        if(cbbKhoa.getSelectedItem().equals("Khoa Công nghệ")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Công nghệ kỹ thuật hóa học");
            cbbNganh.addItem("Công nghệ kỹ thuật hóa học (Chất lượng cao)");
            cbbNganh.addItem("Kỹ thuật điều khiển và tự động hóa");
            cbbNganh.addItem("Kỹ thuật điện tử, truyền thông");
            cbbNganh.addItem("Kỹ thuật điện, điện tử (Kỹ thuật điện)");
            cbbNganh.addItem("Kỹ thuật công trình thủy");
            cbbNganh.addItem("Kỹ thuật công trình xây dựng (XD Công trình thủy)");
            cbbNganh.addItem("Kỹ thuật công trình xây dựng (XD cầu đường)");
            cbbNganh.addItem("Kỹ thuật công trình xây dựng (XD dân dụng và CN)");
            cbbNganh.addItem("Kỹ thuật cơ - điện tử");
            cbbNganh.addItem("Kỹ thuật cơ khí (Cơ khí chế biến)");
            cbbNganh.addItem("Kỹ thuật cơ khí (Cơ khí chế tạo máy)");
            cbbNganh.addItem("Kỹ thuật cơ khí (Cơ khí giao thông)");
            cbbNganh.addItem(("Kỹ thuật Máy tính"));
            cbbNganh.addItem("Kỹ thuật vật liệu");
            cbbNganh.addItem("Kỹ thuật xây dựng công trình giao thông");
            cbbNganh.addItem("Quản lý công nghiệp");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Công nghệ TT-TT")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Công nghệ thông tin");
            cbbNganh.addItem("Công nghệ thông tin (Chât lượng cao)");
            cbbNganh.addItem("Công nghệ thông tin (Tin học ứng dụng)");
            cbbNganh.addItem("Hệ thống thông tin");
            cbbNganh.addItem("Kỹ thuật phần mềm");
            cbbNganh.addItem("Khoa học máy tính");
            cbbNganh.addItem("Truyền thông và Mạng máy tính");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Khoa học Chính trị")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Chính trị học");
            cbbNganh.addItem("Giáo dục công dân");
            cbbNganh.addItem("Triết học");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Khoa học Tự nhiên")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Hóa dược");
            cbbNganh.addItem("Hóa học");
            cbbNganh.addItem("Hóa học (Hóa dược)");
            cbbNganh.addItem("Sinh học");
            cbbNganh.addItem("Toán ứng dụng");
            cbbNganh.addItem("Vật lý kỹ thuật");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Khoa học Xã hội & Nhân văn")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Thông tin học");
            cbbNganh.addItem("Văn học");
            cbbNganh.addItem("Việt Nam học (Hướng dẫn viên du lịch)");
            cbbNganh.addItem("Xã hội học");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Kinh tế")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Kế toán");
            cbbNganh.addItem("Kiểm toán");
            cbbNganh.addItem("Kinh doanh quốc tế");
            cbbNganh.addItem("Kinh doanh quốc tế (Chất lượng cao)");
            cbbNganh.addItem("Kinh doanh thương mại");
            cbbNganh.addItem("Kinh tế");
            cbbNganh.addItem("Kinh tế nông nghiệp");
            cbbNganh.addItem("Kinh tế tài nguyên thiên nhiên");
            cbbNganh.addItem("Marketing");
            cbbNganh.addItem("Quản trị dịch vụ du lịch và lữ hành");
            cbbNganh.addItem("Quản trị kinh doanh");
            cbbNganh.addItem("Tài chính - Ngân hàng");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Luật")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Luật (Luật Hành chính)");
            cbbNganh.addItem("Luật (Luật Thương mại)");
            cbbNganh.addItem("Luật (Luật Tư pháp)");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Môi trường & TNTN")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Kỹ thuật môi trường");
            cbbNganh.addItem("Kỹ thuật tài nguyên nước");
            cbbNganh.addItem("Khoa học môi trường");
            cbbNganh.addItem("Lâm sinh"); 
            cbbNganh.addItem("Quản lý đất đai");
            cbbNganh.addItem("Quản lý tài nguyên và môi trường");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Nông nghiệp & SHƯD")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Bảo vệ thực vật");
            cbbNganh.addItem("Công nghệ rau hoa quả và cảnh quan");
            cbbNganh.addItem("Công nghệ sau thu hoạch");
            cbbNganh.addItem("Công nghệ thực phẩm");
            cbbNganh.addItem("Chăn nuôi");
            cbbNganh.addItem("Khoa học đất");
            cbbNganh.addItem("Khoa học cây trồng");
            cbbNganh.addItem("Khoa học cây trồng (Công nghệ giống cây trồng)");
            cbbNganh.addItem("Nông học");
            cbbNganh.addItem("Sinh học ứng dụng");
            cbbNganh.addItem("Thú y");
            cbbNganh.addItem("Thú y (Dược Thú y)");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Ngoại Ngữ")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Ngôn ngữ Anh");
            cbbNganh.addItem("Ngôn ngữ Anh (Phiên dịch - Biên dịch tiếng Anh)");
            cbbNganh.addItem("Ngôn ngữ Pháp");
            cbbNganh.addItem("Sư Phạm Tiếng Anh");
            cbbNganh.addItem("Sư phạm Tiếng Pháp");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Phát triển nông thôn")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Khuyến nông");
            cbbNganh.addItem("Kinh doanh nông nghiệp");
            cbbNganh.addItem("Nông học (Kỹ thuật nông nghiệp)");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Sư phạm")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Giáo dục Tiểu học");
            cbbNganh.addItem("Sư phạm Địa lý");
            cbbNganh.addItem("Sư phạm Hóa học");
            cbbNganh.addItem("Sư phạm Lịch sử");
            cbbNganh.addItem("Sư Phạm Ngữ Văn");
            cbbNganh.addItem("Sư phạm Sinh học");
            cbbNganh.addItem("Sư phạm Tin học");
            cbbNganh.addItem("Sư phạm Toán học");
            cbbNganh.addItem("Sư phạm Vật lý");
            cbbNganh.addItem("Sư phạm Vật lý (Vật lý - Tin học)");
        }else if(cbbKhoa.getSelectedItem().equals("Khoa Thủy sản")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Bệnh học thủy sản");
            cbbNganh.addItem("Công nghệ chế biến thủy sản");
            cbbNganh.addItem("Kinh tế nông nghiệp (Kinh tế thủy sản)");
            cbbNganh.addItem("Nuôi trồng thủy sản");
            cbbNganh.addItem("Nuôi trồng thủy sản (Chương trình tiên tiến)");
            cbbNganh.addItem("Quản lý nguồn lợi thủy sản");
        }else if(cbbKhoa.getSelectedItem().equals("Viện NC&PTCNSH")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Công nghệ Sinh học");
            cbbNganh.addItem("Công nghệ sinh học (Chương trình tiên tiến)");
            cbbNganh.addItem("Sinh học (Vi sinh vật học)");
        }else if(cbbKhoa.getSelectedItem().equals("Viện NCPT ĐBSCL")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Phát triển nông thôn");
        }else if(cbbKhoa.getSelectedItem().equals("Bộ môn Giáo dục Thể chất")){
            cbbNganh.removeAllItems();
            cbbNganh.addItem("Giáo dục thể chất");
        }
    }
    
    public static DefaultTableModel tableModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    
    private Connection con = null;
<<<<<<< HEAD
    public void loadTable(){
=======
    private void loadTable(){
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
         try {
            con = Connect.connect();
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM canbo");
            String []colsName = {"Mscb", "Họ tên","Email","Khoa","Ngành","Mã số thẻ"};
            tableModel.setColumnIdentifiers(colsName); 
            tblCB.setModel(tableModel);
            while(rs.next()){ 
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);  
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(6);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(4);
                tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    
<<<<<<< HEAD
    public void clearTable(){
=======
    private void ClearTable(){
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
        int dem = tblCB.getRowCount();
        try{
        while (dem > 0 ){
            tableModel.removeRow(0);
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
    private void Them(){
            try {
            con = Connect.connect();
            Statement st = con.createStatement();
            String Ma = txtMa.getText();
            String HoTen = txtHoTen.getText();
            String Em = txtEM.getText();
            String Khoa = (String) cbbKhoa.getSelectedItem();
            String Nganh = (String) cbbNganh.getSelectedItem();
            String MaT = txtMaT.getText();
            String SK = "insert into canbo  values('"+Ma+"','"+HoTen+"','"+Em+"','"+MaT+"','"+Nganh+"','"+Khoa+"')";
            st.executeUpdate(SK);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void textRong(){
        txtEM.setText("");
        txtHoTen.setText("");
        txtMa.setText("");
        txtMaT.setText("");
        cbbKhoa.setSelectedIndex(0);
        cbbNganh.setSelectedIndex(0);;
    }
    private void loadText(){
        int i = tblCB.getSelectedRow();
        Object Ma = tableModel.getValueAt(i, 0);
        Object HoTen = tableModel.getValueAt(i, 1);
        Object Em =  tableModel.getValueAt(i, 2);
        Object Khoa = tableModel.getValueAt(i, 3);
        Object Nganh = tableModel.getValueAt(i, 4);
        Object MaT = tableModel.getValueAt(i, 5);
        txtMa.setText((String) Ma);
        txtHoTen.setText((String) HoTen);
        txtEM.setText((String) Em);
        cbbKhoa.setSelectedItem(Khoa);
        cbbNganh.setSelectedItem(Nganh);
        txtMaT.setText((String) MaT);
    }
    
<<<<<<< HEAD
    private void Sua(){
        SuaTTCb s = new SuaTTCb();
        int i = tblCB.getSelectedRow();
        Object Ma = tableModel.getValueAt(i, 0);
        Object HoTen = tableModel.getValueAt(i, 1);
        Object Em =  tableModel.getValueAt(i, 2);
        Object Khoa = tableModel.getValueAt(i, 3);
        Object Nganh = tableModel.getValueAt(i, 4);
        Object MaT = tableModel.getValueAt(i, 5);
        s.txtMa.setText((String) Ma);
        s.txtHoTen.setText((String) HoTen);
        s.txtEM.setText((String) Em);
        s.cbbKhoa.setSelectedItem(Khoa);
        s.cbbNganh.setSelectedItem(Nganh);
        s.txtMaT.setText((String) MaT);
        s.setVisible(true);
    }
    
=======
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
    private void Tim(){
        try {
            
            con = Connect.connect();
            Statement s = con.createStatement();
            String Search = txtTim.getText();
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
                tableModel.addRow(rows);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void Xoa(){
          try {
            con = Connect.connect();
            Statement st = con.createStatement();
            int i = tblCB.getSelectedRow();
            String Ma = (String) tableModel.getValueAt(i, 0);
            
            String Em = "Delete from canbo where MSSV ='"+Ma+"'";
            st.executeUpdate(Em);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }
    
    private void cbbKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhoaItemStateChanged
        nganhKhoa();
//        cbbNganh.setEnabled(true);
    }//GEN-LAST:event_cbbKhoaItemStateChanged

    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private void TaoSVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoSVBtnActionPerformed
        if(txtMa.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mã cán bộ không được trống!");
        }else{
            if(txtHoTen.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Họ và tên cán bộ không được trống!");
            }else{
                if(txtEM.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Emal không được trống!");
                }else if(!txtEM.getText().matches(EMAIL_REGEX)){
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ!");
                }else{
                    if(txtMaT.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Mã số thẻ không được trống!");
                    }else{
                        String sql = "select * from canbo where MSCB = ?";
                try{
                   con = Connect.connect();
                   PreparedStatement pst = con.prepareStatement(sql);
                   pst.setString(1,txtMa.getText());

                   ResultSet rs = pst.executeQuery();
                   if(rs.next()){
                       JOptionPane.showMessageDialog(null, "Mã cán bộ đã tồn tại!!");
                   }else{
                      
                           Them();
<<<<<<< HEAD
                           clearTable();
=======
                           ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
                           loadTable();
                           JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                           textRong();
                        }
                       
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Kết nối cơ sở dũ liệu thất bại!! :(");
                }
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_TaoSVBtnActionPerformed

    private void tblCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCBMouseClicked
        loadText();
    }//GEN-LAST:event_tblCBMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if(txtTim.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Tìm kiếm không được trống");
        }else{
<<<<<<< HEAD
            clearTable();
=======
            ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
            Tim();
            int Count = tblCB.getRowCount();
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
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusGained
        txtTim.setText("");
<<<<<<< HEAD
        clearTable();
=======
        ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
        loadTable();
    }//GEN-LAST:event_txtTimFocusGained

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       int i = tblCB.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Chọn dữ liệu trước khi xóa!");
        }else{
            int n = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn xóa?","THÔNG BÁO",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                Xoa();
                JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
<<<<<<< HEAD
                clearTable();
=======
                ClearTable();
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
                loadTable();
                textRong();
            }else 
             return;
            } 
    }//GEN-LAST:event_btnXoaActionPerformed

<<<<<<< HEAD
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int i = tblCB.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Chọn dữ liệu trước khi sửa!");
        }else{
            Sua();
            clearTable();
            loadTable();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

=======
>>>>>>> ab4e7b332d57a209f87f5fefc0f2b040e2f8c921
    
    public final class LengthRestrictedDocument extends PlainDocument {

      private final int limit;

      public LengthRestrictedDocument(int limit) {
        this.limit = limit;
      }

      @Override
      public void insertString(int offs, String str, AttributeSet a)
          throws BadLocationException {
        if (str == null)
          return;

        if ((getLength() + str.length()) <= limit) {
          super.insertString(offs, str, a);
        }
      }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TaoSVBtn;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbKhoa;
    private javax.swing.JComboBox<String> cbbNganh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCB;
    private javax.swing.JTextField txtEM;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaT;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
