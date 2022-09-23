package base;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class JsonNodeWritingConverter implements Converter<JsonNode, String> {

    @Override
    public String convert(JsonNode source) {
        return source.toString();
    }

}
