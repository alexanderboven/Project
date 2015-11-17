package gui;

import java.util.Comparator;
import java.util.Date;

class DateComparator implements Comparator<Date> {
	
	public int compare(Date date1, Date date2) {

		if (date1.after(date2)) {
			return 1;
		} else if (date1.equals(date2)) {
			return 0;

		} else {
			return -1;
		}
	}
}
