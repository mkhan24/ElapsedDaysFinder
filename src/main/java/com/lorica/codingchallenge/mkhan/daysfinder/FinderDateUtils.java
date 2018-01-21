package com.lorica.codingchallenge.mkhan.daysfinder;

import com.lorica.codingchallenge.mkhan.daysfinder.exception.InvalidFinderDateException;

public class FinderDateUtils {

	public FinderDate parse(String dateStr) throws InvalidFinderDateException {

		FinderDate date = new FinderDate();

		int day, month, year;
		String[] dateTokens = dateStr.split("/");
		if (dateTokens.length == 3) {
			try {
				day = Integer.parseInt(dateTokens[0]);
				month = Integer.parseInt(dateTokens[1]);
				year = Integer.parseInt(dateTokens[2]);

				isValidDate(day, month, year);

				date.setDay(day).setMonth(month).setYear(year);

			} catch (NumberFormatException ex) {
				throw new InvalidFinderDateException(ex.getMessage(), ex);
			}
		}else {
			throw new InvalidFinderDateException("Invalid date format. Correct format is dd/mm/yyyy.", null);
		}

		return date;
	}

	public boolean isValidDate(int day, int month, int year) throws InvalidFinderDateException {

		return isValidYear(year) && isValidMonth(month) && isValidDay(day, month, year); 

	}

	public boolean isValidYear(int year) throws InvalidFinderDateException {
		if (year >= 1901 && year <= 2999)
			return true;
		else
			throw new InvalidFinderDateException("Year must be between 1901 and 2999", null);
	}

	public boolean isValidMonth(int month) throws InvalidFinderDateException {
		if (month >= 1 && month <= 12)
			return true;
		else
			throw new InvalidFinderDateException("Month must be between 01 and 12", null);
	}

	public boolean isValidDay(int day, int month, int year) throws InvalidFinderDateException {
		int daysInMonth = getDaysInMonth(month, year);
		if (day >= 1 && day <= daysInMonth)
			return true;
		else
			throw new InvalidFinderDateException("Invalid day for month: " + month + " and year: " + year, null);
		
	}

	public static int getDaysInMonth(int month, int year) throws InvalidFinderDateException {

		int daysInMonth;

		switch (month) {
		case 1:
			daysInMonth = 31;
			break;
		case 2:
			daysInMonth = ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) ? 29 : 28;
			break;
		case 3:
			daysInMonth = 31;
			break;
		case 4:
			daysInMonth = 30;
			break;
		case 5:
			daysInMonth = 31;
			break;
		case 6:
			daysInMonth = 30;
			break;
		case 7:
			daysInMonth = 31;
			break;
		case 8:
			daysInMonth = 31;
			break;
		case 9:
			daysInMonth = 30;
			break;
		case 10:
			daysInMonth = 31;
			break;
		case 11:
			daysInMonth = 30;
			break;
		case 12:
			daysInMonth = 31;
			break;
		default:
			throw new InvalidFinderDateException("Invalid month: " + month + ". Month must be between 01 and 12", null);
		}

		return daysInMonth;
	}
	
	public static int getDaysInYear(int year){
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
			return 366;
		return 365;
	}

}
