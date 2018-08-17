package fr.insee.bar.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import fr.insee.bar.beans.Client;

public class ClientsExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	Sheet sheet = workbook.createSheet("clients");
	@SuppressWarnings("rawtypes")
	List clients = (List) model.get("clients");
	for (int n = 0; n < clients.size(); n++) {
	    Client client = (Client) clients.get(n);
	    Row row = sheet.createRow(n);
	    row.createCell(0).setCellValue(client.getNom());
	    row.createCell(1).setCellValue(client.getEmail());
	}
    }
}
