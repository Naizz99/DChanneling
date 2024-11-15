package auroraskincare.view;

import dchanneling.controller.AppointmentController;
import auroraskincare.model.Appointment;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MainUI extends javax.swing.JFrame {

    AppointmentController appointmentController = new AppointmentController(); 
    
    public MainUI() {
        initComponents();
        refreshAppoinmentTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewAppoinment = new javax.swing.JButton();
        btnDermatologists = new javax.swing.JButton();
        btnTreatments = new javax.swing.JButton();
        btnTimeSessions = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        lblAppointmentId = new javax.swing.JLabel();
        txtAppointmentId = new javax.swing.JTextField();
        lblPatientName = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        lblAppoimentDate = new javax.swing.JLabel();
        txtAppoimentDate = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aurora Skin Care");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(350, 70, 2300, 1500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        btnNewAppoinment.setBackground(new java.awt.Color(0, 102, 102));
        btnNewAppoinment.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnNewAppoinment.setForeground(new java.awt.Color(255, 255, 255));
        btnNewAppoinment.setText("New Appoinment");
        btnNewAppoinment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewAppoinment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAppoinmentActionPerformed(evt);
            }
        });

        btnDermatologists.setBackground(new java.awt.Color(255, 153, 0));
        btnDermatologists.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnDermatologists.setForeground(new java.awt.Color(255, 255, 255));
        btnDermatologists.setText("Dermatologists");
        btnDermatologists.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDermatologists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDermatologistsActionPerformed(evt);
            }
        });

        btnTreatments.setBackground(new java.awt.Color(0, 102, 255));
        btnTreatments.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnTreatments.setForeground(new java.awt.Color(255, 255, 255));
        btnTreatments.setText("Treatments");
        btnTreatments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTreatments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreatmentsActionPerformed(evt);
            }
        });

        btnTimeSessions.setBackground(new java.awt.Color(153, 0, 51));
        btnTimeSessions.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnTimeSessions.setForeground(new java.awt.Color(255, 255, 255));
        btnTimeSessions.setText("Time Sessions");
        btnTimeSessions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimeSessions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeSessionsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Aurora Skin Care ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("On-Going Appoinments");

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        panel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        lblAppointmentId.setText("Appointment ID");

        lblPatientName.setText("Patient Name");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblAppointments.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAppointments);

        lblAppoimentDate.setText("Appoiment Date");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnNewAppoinment, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnDermatologists, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnTreatments, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnTimeSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPatientName))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAppoimentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAppoimentDate)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewAppoinment, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDermatologists, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTreatments, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimeSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppoimentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAppoimentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnRefresh))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewAppoinmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAppoinmentActionPerformed
        javax.swing.SwingUtilities.invokeLater(() -> {
            this.dispose();
            AppointmentForm appoinmentForm = new AppointmentForm();
            appoinmentForm.setVisible(true);
        });
    }//GEN-LAST:event_btnNewAppoinmentActionPerformed

    private void btnDermatologistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDermatologistsActionPerformed
        Dermatologists dermatologists = new Dermatologists();
        dermatologists.setVisible(true);
    }//GEN-LAST:event_btnDermatologistsActionPerformed

    private void btnTreatmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatmentsActionPerformed
        Treatments treatments = new Treatments();
        treatments.setVisible(true);
    }//GEN-LAST:event_btnTreatmentsActionPerformed

    private void btnTimeSessionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeSessionsActionPerformed
        TimeSessions times = new TimeSessions();
        times.setVisible(true);
    }//GEN-LAST:event_btnTimeSessionsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
		Integer appointmentId = null;
		String patientName = null;
		LocalDate appointmentDate = null;

		try {
			String appointmentIdText = txtAppointmentId.getText();
			if (appointmentIdText != null && !appointmentIdText.trim().isEmpty()) {
				appointmentId = Integer.parseInt(appointmentIdText);
			}

			patientName = txtPatientName.getText();
			if (patientName != null && patientName.trim().isEmpty()) {
				patientName = null; 
			}

			String appointmentDateText = txtAppoimentDate.getText();
			if (appointmentDateText != null && !appointmentDateText.trim().isEmpty()) {
				appointmentDate = LocalDate.parse(appointmentDateText, DateTimeFormatter.ISO_LOCAL_DATE);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid Appointment ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(this, "Invalid appointment date. Please enter a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		if (appointmentId != null || patientName != null || appointmentDate != null) {
			List<Appointment> appointmentList = appointmentController.searchAppointments(appointmentId, patientName, appointmentDate);
			loadAppointments(appointmentList);
		} else {
			List<Appointment> appointmentList = appointmentController.getAllAppointments();
			loadAppointments(appointmentList);
		}

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        List<Appointment> appointmentList = appointmentController.getAllAppointments();
	loadAppointments(appointmentList);
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDermatologists;
    private javax.swing.JButton btnNewAppoinment;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTimeSessions;
    private javax.swing.JButton btnTreatments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAppoimentDate;
    private javax.swing.JLabel lblAppointmentId;
    private javax.swing.JLabel lblPatientName;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTextField txtAppoimentDate;
    private javax.swing.JTextField txtAppointmentId;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables

    private void refreshAppoinmentTable() {
        List<Appointment> appointmentList = appointmentController.getAllAppointments();
        loadAppointments(appointmentList);
    }
    
    private void loadAppointments(List<Appointment> appointmentList){
        String[] columnNames = {"Appointment ID", "Patient Name", "Dermatologist", "Appointment Date", "Appointment Time", "Manage"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try {
            if (appointmentList != null && !appointmentList.isEmpty()) {
                for (Appointment appointment : appointmentList) {
                    Object[] rowData = new Object[6];
                    rowData[0] = appointment.getId();
                    rowData[1] = appointment.getPatient().getName();
                    rowData[2] = appointment.getDermatologist().getName();
                    rowData[3] = appointment.getDate();
                    rowData[4] = appointment.getTime();
                    rowData[5] = "Manage";

                    model.addRow(rowData);
                }

                tblAppointments.setModel(model);
                tblAppointments.setRowHeight(30);

                tblAppointments.getColumn("Manage").setCellRenderer(new ButtonRenderer());
                tblAppointments.getColumn("Manage").setCellEditor(new ButtonEditor(new JCheckBox()));
            } else {
                clearTable(model);
                JOptionPane.showMessageDialog(this, "No appointments found.");
            }
        } catch (Exception e) {
            clearTable(model);
            JOptionPane.showMessageDialog(this, "Error loading appointments: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void clearTable(DefaultTableModel model) {
        model.setRowCount(0);
        tblAppointments.setModel(model);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setText("Manage");
            setBackground(Color.ORANGE);
            setPreferredSize(new Dimension(50, 15));
            setForeground(Color.BLACK);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;
        
        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            this.setClickCountToStart(1);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            JButton button = new JButton(label);
            button.setPreferredSize(new Dimension(100, 30));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleManageButtonClick(row);
                }
            });
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }

    private void handleManageButtonClick(int row) {
        int appointmentId = (int) tblAppointments.getValueAt(row, 0);
        Appointment selectedAppointment = appointmentController.getAppointmentById(appointmentId);
        
        manageAppointment(selectedAppointment);
    }

    private void manageAppointment(Appointment appointment) {
        this.dispose();
        AppointmentForm appointmentForm = new AppointmentForm(appointment);
        appointmentForm.setVisible(true);
    }

}

