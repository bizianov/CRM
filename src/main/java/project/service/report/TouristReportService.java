package project.service.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.tourist.Tourist;
import project.service.TouristService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by slava23 on 12/17/2016.
 */

@Service
@Data
@AllArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
public class TouristReportService {

    private TouristService touristService;

    private static final String CONTACTS_TEMPLATE_PATH = "D:\\java\\projects\\report\\template\\ContactsTemplate.xls";
    private static final String CONTACTS_RESULT_PATH = "D:\\java\\projects\\report\\result\\ContactsReport.xls";

    public void exportContacts() throws IOException {
        try(InputStream inputStream = Files.newInputStream(Paths.get(CONTACTS_TEMPLATE_PATH));
            OutputStream outputStream = Files.newOutputStream(Paths.get(CONTACTS_RESULT_PATH))){
            generateTouristReport(touristService.findAll(), inputStream, outputStream);
        }
    }

    private void generateTouristReport(List<Tourist> tourists, InputStream inputStream, OutputStream outputStream) throws IOException {
        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem, true);
        HSSFSheet contactsSheet = workbook.getSheet("Contacts");
        int row = 1;
        for (Tourist tourist : tourists){
            int column = 0;
            HSSFRow currentRow = contactsSheet.createRow(row++);
            currentRow.createCell(column++).setCellValue(tourist.getId());
            currentRow.createCell(column++).setCellValue(tourist.getFirstName());
            currentRow.createCell(column++).setCellValue(tourist.getLastName());
            currentRow.createCell(column++).setCellValue(tourist.getPhone());
            currentRow.createCell(column++).setCellValue(tourist.getEmail());
            currentRow.createCell(column++).setCellValue(String.valueOf(tourist.getBirthday()));
            currentRow.createCell(column++).setCellValue(String.valueOf(tourist.getSource()));
        }
        workbook.write(outputStream);
    }
}
