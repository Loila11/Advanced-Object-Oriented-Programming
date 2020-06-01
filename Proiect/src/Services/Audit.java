package Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    public Audit(String actionName) {
        try {
            FileWriter file;
            file = new FileWriter(new File("audit.csv"), true);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss"));
            file.write(actionName + ',' + timestamp + ',' + Thread.currentThread().getName() + '\n');
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
