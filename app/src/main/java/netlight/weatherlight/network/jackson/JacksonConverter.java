package netlight.weatherlight.network.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;


public class JacksonConverter implements Converter {

    private static final String TAG = JacksonConverter.class.getSimpleName() + " ";
    private ObjectMapper objectMapper;

    public JacksonConverter() {

        this.objectMapper = new ObjectMapper();
        //TODO Set different formats if wanted
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {

        JavaType javaType = this.objectMapper.getTypeFactory().constructType(type);
        try {
            return this.objectMapper.readValue(body.in(), javaType);
        }
        catch (IOException e) {
            throw new ConversionException(e);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public TypedOutput toBody(Object object) {

        try {
            String charset = "UTF-8";
            return new JsonTypedOutput(this.objectMapper.writeValueAsString(object).getBytes
                    (charset),
                    charset);
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
