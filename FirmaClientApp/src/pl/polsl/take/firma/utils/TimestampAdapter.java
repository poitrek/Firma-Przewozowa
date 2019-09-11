package pl.polsl.take.firma.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter extends XmlAdapter<String, Date> {
	
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Override
    public String marshal(Date date) {
        synchronized (dateFormat) {
	        	try {
	            return dateFormat.format(date);
        	} catch (NullPointerException e) {
        		return null;
        	}
        }
    }

	@Override
    public Date unmarshal(String dateString) {
        synchronized (dateFormat) {
            try {
				return dateFormat.parse(dateString);
			} catch (ParseException e) {
				System.err.println("TimeStampAdapter unmarshal exception on parsing string: " + dateString);
				return null;
			}
        }
    }

}
