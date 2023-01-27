package homeworks.workwithfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeworks.workwithfiles.model.JsonModel;
import org.junit.jupiter.api.Test;
import practice.workwithfiles.FilesParsingTest;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void jsonParseImprovedTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (
            InputStream resource = cl.getResourceAsStream("fileshomework/homework.json");
            InputStreamReader reader = new InputStreamReader(resource);
        ) {

            JsonModel jsonObject = objectMapper.readValue(reader, JsonModel.class);
            assertThat(jsonObject.menu.id).isEqualTo(1);
            assertThat(jsonObject.menu.value).isEqualTo("File");
            assertThat(jsonObject.menu.popup.menuitem).contains("Open", "Save");
        }
    }

}
