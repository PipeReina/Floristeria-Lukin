
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
// import com.nomina.nomina1.model.Devengado;


// @Component("Devengado/listar")
// public class pdfdevengado  extends AbstractPdfView{

//     @Override
//     protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
//             HttpServletRequest request, HttpServletResponse response) throws Exception {
//                 @SuppressWarnings("unchecked")
//                 List<Devengado> Devengados=(List<Devengado>) model.get("Devengados");

//                 Font fuentetitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
//                 Font fuentetitulocolumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,10,Color.BLACK);
//                 Font fuentedataceldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);

//                 document.setPageSize(PageSize.LETTER.rotate());
//                 document.setMargins(-50, -50,50,20);
//                 document.open();
//                 PdfPCell celda = null;

//                 PdfPTable tablatitulo= new PdfPTable(1);
                
//                 celda =new PdfPCell(new Phrase("Lista de Devengados",fuentetitulo));
//                 celda.setBorder(0);
//                 celda.setBackgroundColor(new Color(229,113,55));
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(10);

//                 tablatitulo.addCell(celda);
//                 tablatitulo.setSpacingAfter(20);
                
//                 PdfPTable tablaDevengado = new PdfPTable(4);
//                 tablaDevengado.setWidths(new float[]{3f,5f,5f,5f});

//                 celda = new PdfPCell(new Phrase("Id",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablaDevengado.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Total Devengado",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablaDevengado.addCell(celda);

//                 celda = new PdfPCell(new Phrase("Fecha Devengado",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablaDevengado.addCell(celda);

                
//                 celda = new PdfPCell(new Phrase("Empleado",fuentetitulocolumnas));
//                 celda.setBackgroundColor(Color.white);
//                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                 celda.setPadding(3);
//                 tablaDevengado.addCell(celda);

//                 /*bucle for muestra todos los Devengados */

//                 for(Devengado Devengadosp: Devengados){
//                     celda= new PdfPCell(new Phrase(Devengadosp.getIdDev().toString(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablaDevengado.addCell(celda);

//                     celda= new PdfPCell(new Phrase(Devengadosp.getTotalDev().toString(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablaDevengado.addCell(celda);

//                     celda= new PdfPCell(new Phrase(Devengadosp.getFechaDev(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablaDevengado.addCell(celda);

//                     celda= new PdfPCell(new Phrase(Devengadosp.getFKempleado().getNombreEmpleado(),fuentedataceldas));
//                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
//                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
//                     celda.setPadding(3);
//                     tablaDevengado.addCell(celda);
                    
//                 }

//                 /*Anexar las tablas al documento */
//                 document.add(tablatitulo);
//                 document.add(tablaDevengado);
//     }
    
// }
