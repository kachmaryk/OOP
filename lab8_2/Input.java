package lab8_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
	private Input () {}
	
	private final static SimpleDateFormat ISO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String startBuffer;
	
	public static Date dateIn(String dateRow) throws ParseException {
		Date date = ISO.parse(dateRow);
		startBuffer = dateRow;
		return date;
	}
	
	public static Date timeIn(String dateRow) throws ParseException {
		String[] start = startBuffer.split(" ");
		String[] startTime = start[1].split(":");
		String[] duration = dateRow.split(":");
		dateRow = start[0] + " ";
		for (int i = 0; i < 3; i++) {
			dateRow += Integer.parseInt(startTime[i]) + Integer.parseInt(duration[i]);
			if (i < 2) {
				dateRow += ":";
			}
		}
		Date date = ISO.parse(dateRow);
		startBuffer = "";
		return date;
	}
	
	public static boolean isNumber(String count) {
		Pattern onlyDigits = Pattern.compile("[0-9]+");
		Matcher matcher = onlyDigits.matcher(count);
		return matcher.find();
	}

	public static boolean isDateRight(String date) {
		Pattern isDateRight = Pattern.compile("20\\d\\d-((0[1-9]|1[0-2])-(0\\d|1\\d|2[0-8])|(0[469]|11)-(29|30)|(0[13578]|1[02])-(29|30|31)|(02-28))|20(([02468][048])|([13579][26]))-((0[1-9]|1[0-2])-(0\\d|1\\d|2[0-8])|(0[469]|11)-(29|30)|(0[13578]|1[02])-(29|30|31)|(02-29))");
		Matcher matcher = isDateRight.matcher(date);
		return matcher.find();
	}

	public static boolean isTimeRight(String date) {
		Pattern isTimeRight = Pattern.compile("((2[0-3])|([0-1]\\d)):([0-5]\\d):([0-5]\\d)");
		Matcher matcher = isTimeRight.matcher(date);
		return matcher.find();
	}
	
}
