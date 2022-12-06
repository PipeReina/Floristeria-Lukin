
 package com.nomina.nomina1.util;

 import java.awt.Color;
 import java.util.List;
 import java.util.Map;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 import org.springframework.stereotype.Component;
 import org.springframework.web.servlet.view.document.AbstractPdfView;

 import com.lowagie.text.Document;
 import com.lowagie.text.Element;
 import com.lowagie.text.Font;
 import com.lowagie.text.FontFactory;
 import com.lowagie.text.PageSize;
 import com.lowagie.text.Phrase;
 import com.lowagie.text.pdf.PdfPCell;
 import com.lowagie.text.pdf.PdfPTable;
 import com.lowagie.text.pdf.PdfWriter;
 import com.nomina.nomina1.model.Empleado;


 @Component("empleado/empleado")
 public class pdfempleado extends AbstractPdfView{

     @Override
     protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
             HttpServletRequest request, HttpServletResponse response) throws Exception {
                 @SuppressWarnings("unchecked")
                 List<Empleado> empleado=(List<Empleado>) model.get("empleado");

                 Font fuentetitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
                 Font fuentetitulocolumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,10,Color.BLACK);
                 Font fuentedataceldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);

                 document.setPageSize(PageSize.LETTER.rotate());
                 document.setMargins(-50, -50,50,20);
                 document.open();
                 PdfPCell celda = null;

                 PdfPTable tablatitulo= new PdfPTable(1);
                
                 celda =new PdfPCell(new Phrase("Lista de Empleados",fuentetitulo));
                 celda.setBorder(0);
                 celda.setBackgroundColor(new Color(229,113,55));
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(10);

                 tablatitulo.addCell(celda);
                 tablatitulo.setSpacingAfter(20);
                
                 PdfPTable tablaempleado = new PdfPTable(13);
                 tablaempleado.setWidths(new float[]{2f,4f,4f,5f,5f,5f,6f,4f,4f,3f,6f,4f,5f});

                 celda = new PdfPCell(new Phrase("Id",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Nombre",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Apellido",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Documento",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Eps",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Direccion",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Genero",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Telefono",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Email",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Rh",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Especialidad",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Foto",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 celda = new PdfPCell(new Phrase("Cargo",fuentetitulocolumnas));
                 celda.setBackgroundColor(Color.white);
                 celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                 celda.setVerticalAlignment(Element.ALIGN_CENTER);
                 celda.setPadding(3);
                 tablaempleado.addCell(celda);

                 /*bucle for muestra todos los empleados */

                 for(Empleado empleadosp: empleado){
                     celda= new PdfPCell(new Phrase(empleadosp.getIdEmpleado().toString(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getNombreEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getApellidoEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);
                    
                     celda= new PdfPCell(new Phrase(empleadosp.getDocEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);
                    
                     celda= new PdfPCell(new Phrase(empleadosp.getEpsEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);
                    
                     celda= new PdfPCell(new Phrase(empleadosp.getDireccEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getGeneroEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getTelEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getEmailEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getRhEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getEspecialidadEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getFotoEmpleado(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                     celda= new PdfPCell(new Phrase(empleadosp.getFKcargo().getNombreCargo(),fuentedataceldas));
                     celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                     celda.setVerticalAlignment(Element.ALIGN_CENTER);
                     celda.setPadding(3);
                     tablaempleado.addCell(celda);

                 }

                 /*Anexar las tablas al documento */
                 document.add(tablatitulo);
                 document.add(tablaempleado);
     }
    
 }
