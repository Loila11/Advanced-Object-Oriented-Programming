package Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    static boolean seen = false;

    public Audit(String actionName) {
        try {
            FileWriter file;
            if (!seen) {
                file = new FileWriter(new File("audit.csv"));
                seen = true;
            } else {
                file = new FileWriter(new File("audit.csv"), true);
            }
            file.write(actionName + ',' +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss\n")));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
