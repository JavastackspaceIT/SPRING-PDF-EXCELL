package com.spring.pdf.format;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.spring.pdf.gen.model.User;

@SuppressWarnings("deprecation")
@Component
public class ExcelBuilder extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<User> users = (List<User>) model.get("users");

		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Java Books");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("UserId");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("Name");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Mobile");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("Email");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Age");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("Address");
		header.getCell(5).setCellStyle(style);

		// create data rows
		int rowCount = 1;

		for (User user : users) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(String.valueOf(user.getId()));
			aRow.createCell(1).setCellValue(user.getName());
			aRow.createCell(2).setCellValue(user.getMobileNo());
			aRow.createCell(3).setCellValue(user.getEmail());
			aRow.createCell(4).setCellValue(user.getAge());
			aRow.createCell(5).setCellValue(user.getAddress());
		}
	}

}
