import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtils {

	public static Date parseDate(String date, String format) {

		DateFormat formatter = new SimpleDateFormat(format);
		Date parsedDate = null;
		try {
			parsedDate = formatter.parse(date);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return parsedDate;
	}

	public static String formatDate(Date date, String format) {
		DateFormat formatter = new SimpleDateFormat(format);
		String parsedDate = null;
		try {
			parsedDate = formatter.format(date);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return parsedDate;
	}

}
