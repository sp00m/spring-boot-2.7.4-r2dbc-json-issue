package base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;

@ReadingConverter
public class JsonNodeReadingConverter implements Converter<byte[], JsonNode> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public JsonNode convert(byte[] source) {
        try {
            return OBJECT_MAPPER.readTree(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
