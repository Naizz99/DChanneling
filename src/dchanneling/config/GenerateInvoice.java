package dchanneling.config;

import dchanneling.controller.CompanyController;
import auroraskincare.model.Appointment;
import auroraskincare.model.Company;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.font.FontSet;
import com.itextpdf.layout.properties.TextAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class GenerateInvoice {
    
    private static CompanyController companyController = new CompanyController();
    
    public static void generateInvoicePDF(Appointment appointment, char type) {
        PageSize pageSize = new PageSize(400, 450);
        String filePath = "invoices/invoice_" + appointment.getId() + ".pdf";

        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, pageSize);

            String title = (type == 'A')? "Appointment Confirmation" : "INVOICE";
            document.add(new Paragraph(title)
                    .setBold()
                    .setFontSize(24)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20));

            if(type == 'A'){
                document.add(new Paragraph("Appointment ID: " + appointment.getId())
                    .setFontSize(12)
                    .setMarginBottom(10));
                document.add(new Paragraph("Patient Name: " + appointment.getPatient().getName())
                        .setFontSize(12)
                        .setMarginBottom(10));
                document.add(new Paragraph("Appointment Date: " + appointment.getDate())
                        .setFontSize(12)
                        .setMarginBottom(10));
                document.add(new Paragraph("Appointment Time: " + appointment.getTime())
                        .setFontSize(12)
                        .setMarginBottom(20));
            }else{
                document.add(new Paragraph("Date: " + LocalDate.now() + " " + LocalTime.now())
                    .setFontSize(12)
                    .setMarginBottom(10));
            }
            

            Table table = new Table(2);
//            table.setWidthPercent(100);
            table.setMarginBottom(20);
            table.setWidth(350);
            
            table.addCell(new Cell().add(new Paragraph("Dermatologist").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
            table.addCell(new Cell().add(new Paragraph(appointment.getDermatologist().getName())).setTextAlignment(TextAlignment.CENTER));

            table.addCell(new Cell().add(new Paragraph("Treatment").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
            table.addCell(new Cell().add(new Paragraph(appointment.getTreatment().getType())).setTextAlignment(TextAlignment.CENTER));

            if(type == 'A'){
                table.addCell(new Cell().add(new Paragraph("Registration Fee(PAID)").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(500.00) + " /=")).setTextAlignment(TextAlignment.CENTER)); 
            }else if(type == 'B'){
                double treatmentCost = appointment.getTreatment().getPrice();
                double taxRate = 2.5;
                double tax = (treatmentCost * taxRate)/ 100;
                double total = treatmentCost + tax;
                
                table.addCell(new Cell().add(new Paragraph("Treatment Cost").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(treatmentCost) + " /=")).setTextAlignment(TextAlignment.RIGHT));
                
                table.addCell(new Cell().add(new Paragraph("Tax Rate").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(taxRate) + "%")).setTextAlignment(TextAlignment.RIGHT));
                
                table.addCell(new Cell().add(new Paragraph("Tax").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(tax) + " /=")).setTextAlignment(TextAlignment.RIGHT));
                
                table.addCell(new Cell().add(new Paragraph("Total").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY).setTextAlignment(TextAlignment.LEFT));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(total) + " /=")).setTextAlignment(TextAlignment.RIGHT));
            }
            

            document.add(table);

            document.add(new Paragraph("Thank you for choosing our service!")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setMarginTop(2));
            
            Company company = companyController.showCompanyDetails();
            
            document.add(new Paragraph(company.getName())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setMarginTop(2));
            document.add(new Paragraph(company.getEmail() + " | " + company.getMobile())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setMarginTop(1));
            document.add(new Paragraph(company.getAddress())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setMarginTop(1));
            
            document.close();
            System.out.println("Invoice saved as " + filePath);

            openPDF(filePath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } 
    
    // Optional: Automatically open the generated PDF using the default system viewer
    private static void openPDF(String filePath) {
        File pdfFile = new File(filePath);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(pdfFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Initialize components (for example)
    private void initComponents() {
        // Code to initialize your GUI components here
    }

    // Load data into fields (for example)
    private void dataLoad() {
        // Code to load existing data into fields if necessary
    }
}
