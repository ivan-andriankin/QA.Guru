package homeworks.workwithfiles;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UnzipAndCheckAllFilesTest {

    ClassLoader cl = UnzipAndCheckAllFilesTest.class.getClassLoader();

    @Test
    void zipParseTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("fileshomework/files.zip");
                ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).isIn("homework.csv", "homework.pdf", "homework.xlsx");
            }
        }
    }

    @Test
    void unzipFileAndReadCsv() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("fileshomework/files.zip");
                ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("homework.csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = reader.readAll();
                    AssertionsForClassTypes.assertThat(content.get(1)[0]).contains("hola");
                    AssertionsForClassTypes.assertThat(content.get(0)[2]).contains("AAA");
                    AssertionsForClassTypes.assertThat(content.get(2)[0]).contains("hola");
                }
            }
        }
    }

    @Test
    void unzipFileAndReadXlsx() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("fileshomework/files.zip");
                ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("homework.xlsx")) {
                    XLS content = new XLS(zis);
                    assertThat(content.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).contains("Number");
                    assertThat(content.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue()).contains("Izabella");
                }
            }
        }
    }

    @Test
    void unzipFileAndReadPdf() throws Exception {
        try (
            InputStream resource = cl.getResourceAsStream("fileshomework/files.zip");
            ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("homework.pdf")) {
                    PDF content = new PDF(zis);
                    assertThat(content.text).contains("Дзен и Искусство Стендап-Комедии");
                }
            }
        }
    }

}
