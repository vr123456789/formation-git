package fr.insee.bar.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import fr.insee.bar.model.Client;

public class ClientsPdfView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked") List<Client> clients = (List<Client>) model.get("clients");
        for (Client client : clients) {
			document.add(new Paragraph(String.format("%s — %s", client.getNom(), client.getEmail())));
        }
    }
}
