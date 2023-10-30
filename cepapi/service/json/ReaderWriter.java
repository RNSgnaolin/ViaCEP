package cepapi.service.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ReaderWriter {
    
    public ReaderWriter(String filename) throws IOException {
        Path dir = Path.of("");
        this.file = new File(dir.toAbsolutePath().toString(), filename);
        file.createNewFile();
        this.out = new FileWriter(file);
        this.in = new FileReader(file);
    }

    public final File file;
    public final FileWriter out;
    public final FileReader in;
    
}
