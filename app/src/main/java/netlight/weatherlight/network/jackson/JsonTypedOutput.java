package netlight.weatherlight.network.jackson;

import java.io.IOException;
import java.io.OutputStream;

import retrofit.mime.TypedOutput;

/**
 * Created by amgh on 18/02/15.
 */
public class JsonTypedOutput implements TypedOutput {

    private static final String TAG = JsonTypedOutput.class.getSimpleName();

    private final byte[] jsonBytes;
    private final String mimeType;

    public JsonTypedOutput(byte[] jsonBytes, String charset) {
        this.jsonBytes = jsonBytes;
        this.mimeType = "application/json; charset=" + charset;
    }

    @Override
    public String fileName() {
        return null;
    }

    @Override
    public String mimeType() {
        return this.mimeType;
    }

    @Override
    public long length() {
        return this.jsonBytes.length;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
        out.write(this.jsonBytes);
    }
}
