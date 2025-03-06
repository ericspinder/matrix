/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.management;

public class NotionDsNotification extends javax.management.Notification {

    public static String ROLLOVER = "com.notionds.notification.rollover";

    public NotionDsNotification(String type, Object source, long sequenceNumber) {
        super(type, source, sequenceNumber);
    }

    public NotionDsNotification(String type, Object source, long sequenceNumber, String message) {
        super(type, source, sequenceNumber, message);
    }

    public NotionDsNotification(String type, Object source, long sequenceNumber, long timeStamp) {
        super(type, source, sequenceNumber, timeStamp);
    }

    public NotionDsNotification(String type, Object source, long sequenceNumber, long timeStamp, String message) {
        super(type, source, sequenceNumber, timeStamp, message);
    }
}
