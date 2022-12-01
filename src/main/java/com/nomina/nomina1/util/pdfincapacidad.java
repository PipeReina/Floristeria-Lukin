
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
import com.nomina.nomina1.model.Incapacidad;


@Component("Incapacidad/listar")
public class pdfincapacidad  extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
                @SuppressWarnings("unchecked")
                List<Incapacidad> Incapacidads=(List<Incapacidad>) model.get("Incapacidads");

                Font fuentetitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
                Font fuentetitulocolumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,10,Color.BLACK);
                Font fuentedataceldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);

                document.setPageSize(PageSize.LETTER.rotate());
                document.setMargins(-50, -50,50,20);
                document.open();
                PdfPCell celda = null;

                PdfPTable tablatitulo= new PdfPTable(1);
                
                celda =new PdfPCell(new Phrase("Lista de Incapacidades",fuentetitulo));
                celda.setBorder(0);
                celda.setBackgroundColor(new Color(229,113,55));
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(10);

                tablatitulo.addCell(celda);
                tablatitulo.setSpacingAfter(20);
                
                PdfPTable tablaIncapacidad = new PdfPTable(5);
                tablaIncapacidad.setWidths(new float[]{3f,5f,5f,5f,5f});

                celda = new PdfPCell(new Phrase("Id",fuentetitulocolumnas));
                celda.setBackgroundColor(Color.white);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(3);
                tablaIncapacidad.addCell(celda);

                celda = new PdfPCell(new Phrase("Fecha Inicio",fuentetitulocolumnas));
                celda.setBackgroundColor(Color.white);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(3);
                tablaIncapacidad.addCell(celda);

                celda = new PdfPCell(new Phrase("Fecha Final",fuentetitulocolumnas));
                celda.setBackgroundColor(Color.white);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(3);
                tablaIncapacidad.addCell(celda);

                celda = new PdfPCell(new Phrase("Soporte",fuentetitulocolumnas));
                celda.setBackgroundColor(Color.white);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(3);
                tablaIncapacidad.addCell(celda);

                celda = new PdfPCell(new Phrase("Empleado",fuentetitulocolumnas));
                celda.setBackgroundColor(Color.white);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(3);
                tablaIncapacidad.addCell(celda);


                /*bucle for muestra todos los Incapacidads */

                for(Incapacidad Incapacidadp: Incapacidads){
                    celda= new PdfPCell(new Phrase(Incapacidadp.getIdIncapacidad().toString(),fuentedataceldas));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.setPadding(3);
                    tablaIncapacidad.addCell(celda);

                    celda= new PdfPCell(new Phrase(Incapacidadp.getFechaInicio().toString(),fuentedataceldas));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.setPadding(3);
                    tablaIncapacidad.addCell(celda);

                    celda= new PdfPCell(new Phrase(Incapacidadp.getFechaFinal().toString(),fuentedataceldas));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.setPadding(3);
                    tablaIncapacidad.addCell(celda);

                    celda= new PdfPCell(new Phrase(Incapacidadp.getSoporteIncapacidad().toString(),fuentedataceldas));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.setPadding(3);
                    tablaIncapacidad.addCell(celda);

                    celda= new PdfPCell(new Phrase(Incapacidadp.getFKempleado().getNombreEmpleado(),fuentedataceldas));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.setPadding(3);
                    tablaIncapacidad.addCell(celda);
                    
                }

                /*Anexar las tablas al documento */
                document.add(tablatitulo);
                document.add(tablaIncapacidad);
    }
    
}
