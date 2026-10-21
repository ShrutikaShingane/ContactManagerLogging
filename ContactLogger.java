
package contactmanager;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ContactLogger {

    private static final Logger logger =
            Logger.getLogger("ContactManagerLogger");

    static {
        logger.setLevel(Level.INFO);

        try {
            FileHandler fileHandler =
                    new FileHandler("contacts.log", true);

            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Unable to create contacts.log", e);
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }
}
