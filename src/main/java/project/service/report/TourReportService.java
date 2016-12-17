package project.service.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.hotel.Hotel;
import project.model.tour.Tour;
import project.model.tourist.Tourist;
import project.service.TourService;
import project.service.TouristService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by slava23 on 12/16/2016.
 */

@Service
@Data
@AllArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
public class TourReportService {

    private TourService tourService;

    private static final String SALES_TEMPLATE_PATH = "D:\\java\\projects\\report\\template\\SalesReportTemplate.xls";
    private static final String MONTHLY_RESULT_PATH = "D:\\java\\projects\\report\\result\\MonthlySalesReport.xls";
    private static final String WEEKLY_RESULT_PATH = "D:\\java\\projects\\report\\result\\WeeklySalesReport.xls";
    private static final String DAILY_RESULT_PATH = "D:\\java\\projects\\report\\result\\DailySalesReport.xls";
    private static final String CUSTOM_RESULT_PATH = "D:\\java\\projects\\report\\result\\CustomSalesReport.xls";

    public void generateMonthlyReport() throws IOException {
        List<Tour> tours =
                tourService.filterToursByYearMonth(LocalDate.now().getYear(),
                                                   LocalDate.now().getMonthValue());
        try (InputStream inputStream = Files.newInputStream(Paths.get(SALES_TEMPLATE_PATH));
             OutputStream outputStream = Files.newOutputStream(Paths.get(MONTHLY_RESULT_PATH))) {
            generateSalesReport(tours,inputStream,outputStream);
        }
    }

    public void generateWeeklyReport() throws IOException {
        List<Tour> tours = tourService.findToursSoldCurrentWeek();
        try (InputStream inputStream = Files.newInputStream(Paths.get(SALES_TEMPLATE_PATH));
             OutputStream outputStream = Files.newOutputStream(Paths.get(WEEKLY_RESULT_PATH))) {
            generateSalesReport(tours,inputStream,outputStream);
        }
    }

    public void generateDailyReport() throws IOException {
        List<Tour> tours = tourService.findToursSoldToday();
        try (InputStream inputStream = Files.newInputStream(Paths.get(SALES_TEMPLATE_PATH));
             OutputStream outputStream = Files.newOutputStream(Paths.get(DAILY_RESULT_PATH))) {
            generateSalesReport(tours,inputStream,outputStream);
        }
    }

    public void generateCustomReport(List<Tour> tours) throws IOException {
        try (InputStream inputStream = Files.newInputStream(Paths.get(SALES_TEMPLATE_PATH));
             OutputStream outputStream = Files.newOutputStream(Paths.get(CUSTOM_RESULT_PATH))) {
            generateSalesReport(tours,inputStream,outputStream);
        }
    }

    private void generateSalesReport(List<Tour> tours, InputStream inputStream, OutputStream outputStream) throws IOException {
        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem, true);
        HSSFSheet monthlySheet = workbook.getSheet("Monthly");
        int row = 2;
        for (Tour tour : tours) {
            int column = 0;
            HSSFRow currentRow = monthlySheet.createRow(row++);
            currentRow.createCell(column++).setCellValue(tour.getId());
            currentRow.createCell(column++).setCellValue(String.valueOf(tour.getStartDate()));
            currentRow.createCell(column++).setCellValue(String.valueOf(tour.getEndDate()));

            int touristCol = column;
            List<Tourist> tourists = tour.getTouristList();
            Tourist firstTourist = tourists.get(0);
            currentRow.createCell(column++).setCellValue(firstTourist.getId());
            currentRow.createCell(column++).setCellValue(firstTourist.getFirstName());
            currentRow.createCell(column++).setCellValue(firstTourist.getLastName());
            currentRow.createCell(column++).setCellValue(firstTourist.getPhone());
            currentRow.createCell(column++).setCellValue(firstTourist.getEmail());
            currentRow.createCell(column++).setCellValue(String.valueOf(firstTourist.getBirthday()));
            currentRow.createCell(column++).setCellValue(String.valueOf(firstTourist.getSource()));

            tourists.remove(0);
            if (!tourists.isEmpty()) {
                int _row = row;
                for (Tourist tourist : tourists) {
                    int _column = touristCol;
                    HSSFRow _currentRow = monthlySheet.createRow(_row++);
                    _currentRow.createCell(_column++).setCellValue(tourist.getId());
                    _currentRow.createCell(_column++).setCellValue(tourist.getFirstName());
                    _currentRow.createCell(_column++).setCellValue(tourist.getLastName());
                    _currentRow.createCell(_column++).setCellValue(tourist.getPhone());
                    _currentRow.createCell(_column++).setCellValue(tourist.getEmail());
                    _currentRow.createCell(_column++).setCellValue(String.valueOf(tourist.getBirthday()));
                    _currentRow.createCell(_column++).setCellValue(String.valueOf(tourist.getSource()));
                    row++;
                }
            }

            Hotel hotel = tour.getHotel();
            currentRow.createCell(column++).setCellValue(hotel.getId());
            currentRow.createCell(column++).setCellValue(hotel.getName());
            currentRow.createCell(column++).setCellValue(hotel.getRate());
            currentRow.createCell(column++).setCellValue(hotel.getCountry());
            currentRow.createCell(column++).setCellValue(hotel.getRegion());

            currentRow.createCell(column++).setCellValue(String.valueOf(tour.getTourOperator()));
            currentRow.createCell(column++).setCellValue(tour.isVisaRequired());
            currentRow.createCell(column++).setCellValue(tour.isAvia());
            currentRow.createCell(column++).setCellValue(tour.getPriceBrutto());
            currentRow.createCell(column++).setCellValue(String.valueOf(tour.getClosureDate()));

            column = 0;
        }
        workbook.write(outputStream);
    }
}
