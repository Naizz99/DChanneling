package auroraskincare.view;

import dchanneling.config.AppointmentValidator;
import dchanneling.config.GenerateInvoice;
import dchanneling.controller.AppointmentController;
import dchanneling.controller.CompanyController;
import dchanneling.controller.DermatologistController;
import dchanneling.controller.PatientController;
import dchanneling.controller.TreatmentController;
import auroraskincare.model.Appointment;
import auroraskincare.model.Dermatologist;
import auroraskincare.model.Patient;
import auroraskincare.model.Treatment;
import java.awt.Color;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class AppointmentForm extends javax.swing.JFrame {

    CompanyController companyController = new CompanyController();
    AppointmentController appointmentController = new AppointmentController();
    PatientController patientController = new PatientController();
    DermatologistController dermatologistController = new DermatologistController();
    TreatmentController treatmentController = new TreatmentController();

    public AppointmentForm() {
        initComponents();
        dataLoad();
    }
    
    public AppointmentForm(Appointment appointment) {
        initComponents();
        dataLoad();
        btnSaveAppoinment.setEnabled(true);
        btnCancelAppoinment.setEnabled(true);
        btnSaveAppoinment1.setEnabled(true);
        btnSaveAppoinment2.setEnabled(true);
                
        txtAppointmentId.setText(String.valueOf(appointment.getId()));
        txtDate.setText(String.valueOf(appointment.getDate()));
        txtStartTime.setText(String.valueOf(appointment.getTime()));
        txtNic.setText(appointment.getPatient().getNic());
        txtName.setText(appointment.getPatient().getName());
        txtEmail.setText(appointment.getPatient().getEmail());
        txtPhoneNumber.setText(appointment.getPatient().getPhone());
        txtStatus.setText(appointment.getStatus());
        if((appointment.getStatus() != null) && (appointment.getStatus().equals("REGISTERED"))){
            chRegFee.setSelected(true);
            txtStatus.setBackground(Color.ORANGE);
            btnSaveAppoinment2.setText("Complete");
        }else if((appointment.getStatus() != null) && (appointment.getStatus().equals("COMPLETED"))){
            chRegFee.setSelected(true);
            txtStatus.setBackground(Color.GREEN);
            btnCancelAppoinment.setEnabled(false);
        }else{
            txtStatus.setBackground(Color.RED);
        }
                
        int dermatologistId = appointment.getDermatologist().getId();
        for (int i = 0; i < cmbDermatologistList.getItemCount(); i++) {
            String item = (String) cmbDermatologistList.getItemAt(i);
            if (item.startsWith(dermatologistId + ". ")) {
                cmbDermatologistList.setSelectedIndex(i);
                break;
            }
        }

        // Set the selected Treatment in cmbTreatmentList
        int treatmentId = appointment.getTreatment().getId();
        for (int i = 0; i < cmbTreatmentList.getItemCount(); i++) {
            String item = (String) cmbTreatmentList.getItemAt(i);
            if (item.startsWith(treatmentId + ". ")) {
                cmbTreatmentList.setSelectedIndex(i);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        panel3 = new java.awt.Panel();
        lblAppointmentId = new javax.swing.JLabel();
        txtAppointmentId = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        lblPatientDetails = new javax.swing.JLabel();
        lblNIC = new javax.swing.JLabel();
        txtNic = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSaveAppoinment = new javax.swing.JButton();
        lblTreatment = new javax.swing.JLabel();
        lblDermatologistAndTreatment = new javax.swing.JLabel();
        lblDermatologist = new javax.swing.JLabel();
        btnCancelAppoinment = new javax.swing.JButton();
        lblPatientDetails1 = new javax.swing.JLabel();
        btnSaveAppoinment1 = new javax.swing.JButton();
        btnSaveAppoinment2 = new javax.swing.JButton();
        txtPhoneNumber = new javax.swing.JTextField();
        lbPhoneNumber = new javax.swing.JLabel();
        lblError1 = new javax.swing.JLabel();
        lblError2 = new javax.swing.JLabel();
        lblError3 = new javax.swing.JLabel();
        lblError4 = new javax.swing.JLabel();
        lblError5 = new javax.swing.JLabel();
        lblError6 = new javax.swing.JLabel();
        cmbDermatologistList = new javax.swing.JComboBox<>();
        cmbTreatmentList = new javax.swing.JComboBox<>();
        chRegFee = new javax.swing.JCheckBox();
        txtStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aurora Skin Care");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(450, 80, 2300, 1500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Aurora Skin Care ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Appoinment Form");

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

        panel3.setBackground(new java.awt.Color(204, 204, 204));

        lblAppointmentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAppointmentId.setText("Appointment ID");

        txtAppointmentId.setEditable(false);
        txtAppointmentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAppointmentId.setText("0");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDate.setText("Date");

        txtDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtDateInputMethodTextChanged(evt);
            }
        });
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        txtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDateKeyPressed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTime.setText("Time");

        txtStartTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStartTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStartTimeKeyTyped(evt);
            }
        });

        lblPatientDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPatientDetails.setText("Patient Details");

        lblNIC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNIC.setText("NIC");

        txtNic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicActionPerformed(evt);
            }
        });
        txtNic.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNicPropertyChange(evt);
            }
        });
        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNicKeyTyped(evt);
            }
        });

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        btnSaveAppoinment.setBackground(new java.awt.Color(0, 102, 102));
        btnSaveAppoinment.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSaveAppoinment.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveAppoinment.setText("Save Appoinment");
        btnSaveAppoinment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveAppoinment.setEnabled(false);
        btnSaveAppoinment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAppoinmentActionPerformed(evt);
            }
        });

        lblTreatment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTreatment.setText("Treatment");

        lblDermatologistAndTreatment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDermatologistAndTreatment.setText("Dermatologist & Treatment");

        lblDermatologist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDermatologist.setText("Dermatologist");

        btnCancelAppoinment.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelAppoinment.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnCancelAppoinment.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelAppoinment.setText("Cancel Appoinment");
        btnCancelAppoinment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelAppoinment.setEnabled(false);
        btnCancelAppoinment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAppoinmentActionPerformed(evt);
            }
        });

        lblPatientDetails1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPatientDetails1.setText("Appoinment Details");

        btnSaveAppoinment1.setBackground(new java.awt.Color(0, 102, 102));
        btnSaveAppoinment1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSaveAppoinment1.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveAppoinment1.setText("Print Confirmation");
        btnSaveAppoinment1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveAppoinment1.setEnabled(false);
        btnSaveAppoinment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAppoinment1ActionPerformed(evt);
            }
        });

        btnSaveAppoinment2.setBackground(new java.awt.Color(0, 102, 102));
        btnSaveAppoinment2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSaveAppoinment2.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveAppoinment2.setText("Print Invoice");
        btnSaveAppoinment2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveAppoinment2.setEnabled(false);
        btnSaveAppoinment2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAppoinment2ActionPerformed(evt);
            }
        });

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });

        lbPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPhoneNumber.setText("Phone Number");

        lblError1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblError1.setForeground(new java.awt.Color(204, 0, 0));
        lblError1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError1.setText("Invalid Date");
        lblError1.setVisible(false);

        lblError2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblError2.setForeground(new java.awt.Color(204, 0, 0));
        lblError2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError2.setText("Invalid Time");
        lblError2.setVisible(false);

        lblError3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblError3.setForeground(new java.awt.Color(204, 0, 0));
        lblError3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError3.setText("Invalid NIC");
        lblError3.setVisible(false);

        lblError4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblError4.setForeground(new java.awt.Color(204, 0, 0));
        lblError4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError4.setText("Name should be more that 3 characters");
        lblError4.setVisible(false);

        lblError5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblError5.setForeground(new java.awt.Color(204, 0, 0));
        lblError5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError5.setText("Invalid Email");
        lblError5.setVisible(false);

        lblError6.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblError6.setForeground(new java.awt.Color(204, 0, 0));
        lblError6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError6.setText("Invalid Phone Number");
        lblError6.setVisible(false);

        chRegFee.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        chRegFee.setText("Paid Registration Fee");
        chRegFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chRegFeeActionPerformed(evt);
            }
        });

        txtStatus.setEditable(false);
        txtStatus.setBackground(new java.awt.Color(51, 102, 255));
        txtStatus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(255, 255, 255));
        txtStatus.setText("PENDING");
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        txtStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStatusKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPatientDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDermatologist, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbDermatologistList, 0, 196, Short.MAX_VALUE)
                                    .addComponent(cmbTreatmentList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(lblAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDate)))
                            .addComponent(lblDermatologistAndTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStartTime))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(lblNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblError4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(lbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chRegFee, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCancelAppoinment, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(btnSaveAppoinment)
                        .addGap(27, 27, 27)
                        .addComponent(btnSaveAppoinment1)
                        .addGap(29, 29, 29)
                        .addComponent(btnSaveAppoinment2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPatientDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lblError3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(lblDermatologistAndTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDermatologist, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cmbDermatologistList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTreatmentList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chRegFee)))
                .addGap(29, 29, 29)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAppoinment, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveAppoinment1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveAppoinment2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnCancelAppoinment, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveAppoinmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAppoinmentActionPerformed
        try {
            Integer appointmentId = Integer.valueOf(txtAppointmentId.getText());
            LocalDate date = LocalDate.parse(txtDate.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalTime time = LocalTime.parse(txtStartTime.getText(), DateTimeFormatter.ofPattern("HH:mm"));
               
            String nic = txtNic.getText();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String phoneNumber = txtPhoneNumber.getText();
            boolean isRegFeePaid = chRegFee.isSelected();
            
            Integer dermatologistId = Integer.valueOf(((String) cmbDermatologistList.getSelectedItem()).split("\\. ", 2)[0].trim());
            Integer treatmentId = Integer.valueOf(((String) cmbTreatmentList.getSelectedItem()).split("\\. ", 2)[0].trim());

            Dermatologist dermatologist = dermatologistController.getDermatologistById(dermatologistId);
            Treatment treatment = treatmentController.getTreatmentById(treatmentId);

            List<Appointment> existingAppointments1 = appointmentController.getAppointmentsForDermatologist(dermatologistId, date);

            AppointmentValidator validator = new AppointmentValidator(this, existingAppointments1);

            boolean isValid = validator.validateAppointment(date, time, dermatologist);

            if (isRegFeePaid && isValid) {
                Patient patient = patientController.savePatient(new Patient(nic, name, email, phoneNumber));

                appointmentController.saveAppointment(new Appointment(appointmentId, date, time, patient, dermatologist, treatment, Appointment.STATUS.REGISTERED.name()));

                JOptionPane.showMessageDialog(this, "Appointment Added Successfully!");

                this.dispose(); 
            } else if(isValid && !isRegFeePaid){
                JOptionPane.showMessageDialog(this, "Please Collect the Registration Fee to Enable Appointment.");
            }else if(!isValid && isRegFeePaid){
                JOptionPane.showMessageDialog(this, "Invalid Appointment Time or Conflict with Existing Appointments.");
            }
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Record failed to save: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveAppoinmentActionPerformed

    private void btnCancelAppoinmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAppoinmentActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this, 
                "Are you sure you want to delete this appointment?", 
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE
        );

        Integer appointmentId = Integer.parseInt(txtAppointmentId.getText());
        if (response == JOptionPane.YES_OPTION) {
            try {
                appointmentController.deleteAppointment(appointmentId);

                JOptionPane.showMessageDialog(
                        this, 
                        "Appointment deleted successfully!", 
                        "Deletion Successful", 
                        JOptionPane.INFORMATION_MESSAGE
                );

                this.dispose();
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        this, 
                        "Failed to delete appointment: " + e.getMessage(), 
                        "Deletion Failed", 
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btnCancelAppoinmentActionPerformed

    private void btnSaveAppoinment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAppoinment1ActionPerformed
        Integer appointmentId = Integer.parseInt(txtAppointmentId.getText());
        GenerateInvoice.generateInvoicePDF(appointmentController.getAppointmentById(appointmentId),'A');
    }//GEN-LAST:event_btnSaveAppoinment1ActionPerformed

    private void btnSaveAppoinment2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAppoinment2ActionPerformed
        Integer appointmentId = Integer.parseInt(txtAppointmentId.getText());
        Appointment appointment = appointmentController.getAppointmentById(appointmentId);
        appointment.setStatus(Appointment.STATUS.COMPLETED.name());
        appointmentController.saveAppointment(appointment);
        
        txtStatus.setText(appointment.getStatus());
        txtStatus.setBackground(Color.GREEN);
        GenerateInvoice.generateInvoicePDF(appointmentController.getAppointmentById(appointmentId),'B');
    }//GEN-LAST:event_btnSaveAppoinment2ActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtDateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtDateInputMethodTextChanged
        System.out.println(txtDate.getText());
    }//GEN-LAST:event_txtDateInputMethodTextChanged

    private void txtDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyPressed
        int year, month, date;
        lblError1.setVisible(false);
        
        try{
            year = Integer.parseInt(txtDate.getText().substring(0, 4));
            month = Integer.parseInt(txtDate.getText().substring(5, 7));
            date = Integer.parseInt(txtDate.getText().substring(8, 10));
            
            if(month > 12){
                lblError1.setVisible(true);
                btnSaveAppoinment.setEnabled(false);
            }else{
                lblError1.setVisible(false);
                btnSaveAppoinment.setEnabled(true);
            }
            
            if(date > 31){
                lblError1.setVisible(true);
                btnSaveAppoinment.setEnabled(false);
            }else{
                lblError1.setVisible(false);
                btnSaveAppoinment.setEnabled(true);
            }
        }catch(Exception e){
            lblError1.setVisible(true);
            btnSaveAppoinment.setEnabled(false);
        }
        
        if(txtDate.getText().length() == 4){
            txtDate.setText(txtDate.getText() + "-");
        }else if(txtDate.getText().length() == 7){
            txtDate.setText(txtDate.getText() + "-");
        }else if(txtDate.getText().length() > 10){
            lblError1.setVisible(true);
            btnSaveAppoinment.setEnabled(false);
        }else{
            lblError1.setVisible(false);
            btnSaveAppoinment.setEnabled(true);
        }
    }//GEN-LAST:event_txtDateKeyPressed

    private void txtStartTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStartTimeKeyTyped
        int hours, minutes;
        lblError2.setVisible(false);
        
        try{
            hours = Integer.parseInt(txtStartTime.getText().substring(0, 4));
            minutes = Integer.parseInt(txtStartTime.getText().substring(5, 7));
            
            if(hours > 24){
                lblError2.setVisible(true);
                btnSaveAppoinment.setEnabled(false);
            }else{
                lblError2.setVisible(false);
                btnSaveAppoinment.setEnabled(true);
            }
            
            if(minutes > 60){
                lblError2.setVisible(true);
                btnSaveAppoinment.setEnabled(false);
            }else{
                lblError2.setVisible(false);
                btnSaveAppoinment.setEnabled(true);
            }
        }catch(Exception e){
            lblError2.setVisible(true);
            btnSaveAppoinment.setEnabled(false);
        }
        
        if(txtStartTime.getText().length() == 2){
            txtStartTime.setText(txtStartTime.getText() + ":");
        }else if(txtStartTime.getText().length() > 5){
            lblError2.setVisible(true);
            btnSaveAppoinment.setEnabled(false);
        }else{
            lblError2.setVisible(false);
            btnSaveAppoinment.setEnabled(true);
        }
    }//GEN-LAST:event_txtStartTimeKeyTyped

    private void txtNicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyTyped
        
        
    }//GEN-LAST:event_txtNicKeyTyped

    private void txtNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyPressed
        
    }//GEN-LAST:event_txtNicKeyPressed

    private void txtNicPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNicPropertyChange
    }//GEN-LAST:event_txtNicPropertyChange

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        String oldFormat = "^[0-9]{9}[Vv]$";
        String newFormat = "^[0-9]{12}$";
        boolean isValid = false;
        
        String nic = txtNic.getText();
        
        if (nic == null || nic.isEmpty()) {
            isValid = false;
        }

        isValid = Pattern.matches(oldFormat, nic) || Pattern.matches(newFormat, nic);
        
        lblError3.setVisible(!isValid);
        btnSaveAppoinment.setEnabled(isValid);
    }//GEN-LAST:event_txtNicKeyReleased

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String name = txtName.getText();
        if(name.length() < 4){
            lblError4.setVisible(true);
            btnSaveAppoinment.setEnabled(false);
        }else{
            lblError4.setVisible(false);
            btnSaveAppoinment.setEnabled(true);
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String email = txtEmail.getText();
        boolean isValid = false;
        
        if (email == null || email.isEmpty()) {
            isValid = false;
        }

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        isValid = matcher.matches();
        lblError5.setVisible(!isValid);
        btnSaveAppoinment.setEnabled(isValid);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtPhoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyReleased
        // txtPhoneNumber
        String phoneNumberRegex = "^(?:\\+94|0)(7[0-9]{8})$";
        String phoneNumber = txtPhoneNumber.getText();
        boolean isValid = false;
        
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            isValid = false;
        }

        Pattern pattern = Pattern.compile(phoneNumberRegex);
        Matcher matcher = pattern.matcher(phoneNumber);

        isValid = matcher.matches();
        lblError6.setVisible(!isValid);
        btnSaveAppoinment.setEnabled(isValid);
    }//GEN-LAST:event_txtPhoneNumberKeyReleased

    private void chRegFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chRegFeeActionPerformed
        if(chRegFee.isSelected()){
            btnSaveAppoinment.setEnabled(true);
        }else{
            btnSaveAppoinment.setEnabled(false);
        }
    }//GEN-LAST:event_chRegFeeActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtStatusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStatusKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusKeyReleased

    private void txtNicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentForm().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelAppoinment;
    private javax.swing.JButton btnSaveAppoinment;
    private javax.swing.JButton btnSaveAppoinment1;
    private javax.swing.JButton btnSaveAppoinment2;
    private javax.swing.JCheckBox chRegFee;
    private javax.swing.JComboBox<String> cmbDermatologistList;
    private javax.swing.JComboBox<String> cmbTreatmentList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbPhoneNumber;
    private javax.swing.JLabel lblAppointmentId;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDermatologist;
    private javax.swing.JLabel lblDermatologistAndTreatment;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblError2;
    private javax.swing.JLabel lblError3;
    private javax.swing.JLabel lblError4;
    private javax.swing.JLabel lblError5;
    private javax.swing.JLabel lblError6;
    private javax.swing.JLabel lblNIC;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPatientDetails1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTreatment;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private javax.swing.JTextField txtAppointmentId;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtStartTime;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    private void dataLoad() {
        List<Dermatologist> dermatologistList = dermatologistController.getAllDermatologists();
        for (Dermatologist dermatologist : dermatologistList) {
            cmbDermatologistList.addItem(dermatologist.getId() + ". " + dermatologist.getName());
        }
        
        List<Treatment> treatmentList = treatmentController.getAllTreatments();
        for (Treatment treatment : treatmentList) {
            cmbTreatmentList.addItem(treatment.getId() + ". " + treatment.getType());
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
    }
}
