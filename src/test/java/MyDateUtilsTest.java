import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

public class MyDateUtilsTest {

	@Test
	public void testParse() {

		String dateToParse = "21/04/2016";
		String format = "dd/MM/yyyy";
		Date parsedDate = MyDateUtils.parseDate(dateToParse, format);
		Instant expectedDate = LocalDate.of(2016, Month.APRIL, 21).atStartOfDay().atZone(ZoneId.systemDefault())
				.toInstant();

		assertEquals(Date.from(expectedDate), parsedDate);
	}

	@Test
	public void testFormat() {

		String format = "dd/MM/yyyy";
		Instant dateToParse = LocalDate.of(2016, Month.APRIL, 21).atStartOfDay().atZone(ZoneId.systemDefault())
				.toInstant();
		String parsedDate = MyDateUtils.formatDate(Date.from(dateToParse), format);
		String expectedDate = "21/04/2016";

		assertEquals(expectedDate, parsedDate);
	}

}
