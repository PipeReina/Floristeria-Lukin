
// package com.nomina.nomina1.util;

// import java.awt.Color;
// import java.util.List;
// import java.util.Map;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.view.document.AbstractPdfView;

// import com.lowagie.text.Document;
// import com.lowagie.text.Element;
// import com.lowagie.text.Font;
// import com.lowagie.text.FontFactory;
// import com.lowagie.text.PageSize;
// import com.lowagie.text.Phrase;
// import com.lowagie.text.pdf.PdfPCell;
// import com.lowagie.text.pdf.PdfPTable;
// import com.lowagie.text.pdf.PdfWriter;
// import com.nomina.nomina1.controller.NominaController;

// @Component("nomina/verNom")
// public class pdfnomina  extends AbstractPdfView{

//     @Override
//     protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
//             HttpServletRequest request, HttpServletResponse response) throws Exception {
//                 @SuppressWarnings("unchecked")
//                 List<NominaTotal> NominaTotal=(List<NominaTotal>) model.get("NominaTotal");

//                 Font fuentetitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
//                 Font fuentetitulocolumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,10,Color.BLACK);
//                 Font fuentedataceldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);

//                 document.setPageSize(PageSize.LETTER.rotate());
//                 document.setMargins(-50, -50,50,20);
//                 document.open();
//                 PdfPCell celda = null;

//                 PdfPTable tablatitulo= new PdfPTable(1);
                
//                 celda =new PdfPCell(new Phrase("Lista de Nomina",fuentetitulo));
//                 celda.setBorder(0);
//                 celda.setBackgroundColor(new Color(229,113,55));
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(10);

//                 tablatitulo.addCell(celda);
//                 tablatitulo.setSpacingAfter(20);
                
//                 PdfPTable tablanomina = new PdfPTable(9);
//                 tablanomina.setWidths(new float[]{3f,3f,3f,3f,3f,3f,3f,3f,3f});

//                 celda = new PdfPCell(new Phrase("Id",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Pago",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("ValorDev",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("ValorDeven",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("SalarioB",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Aux",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("HorasExtra",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Comision",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Pension",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Salud",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablanomina.addCell(celda);


//                 /*bucle for muestra todos los resultados */

//                 for(NominaTotal nominap: NominaTotal){
//                     celda= new PdfPCell(new Phrase(nominap.getIdIncapacidad().toString(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFechaInicio().toString(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFechaFinal().toString(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getSoporteIncapacidad().toString(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFKempleado().getNombreEmpleado(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFKempleado().getNombreEmpleado(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFKempleado().getNombreEmpleado(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFKempleado().getNombreEmpleado(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);

//                     celda= new PdfPCell(new Phrase(nominap.getFKempleado().getNombreEmpleado(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablanomina.addCell(celda);
                    
//                 }

//                 /*Anexar las tablas al documento */
//                 document.add(tablatitulo);
//                 document.add(tablanomina);
//     }
    
// }
