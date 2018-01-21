package com.lorica.codingchallenge.mkhan.daysfinder;

import java.util.Scanner;

import com.lorica.codingchallenge.mkhan.daysfinder.exception.InvalidFinderDateException;

public class ElapsedDaysFinder {

	public static void main(String[] args) {
		ElapsedDaysFinder finder = new ElapsedDaysFinder();
		finder.run();
	}

	private void run() {
		do {
			String startDateStr = null;
			String endDateStr = null;
			FinderDate startDate = null;
			FinderDate endDate = null;
			FinderDateUtils dateValidator = new FinderDateUtils();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			// Read and parse start date
			do {

				System.out.print("Enter start date (DD/MM/YYYY) : ");
				startDateStr = scanner.next();
				try {
					startDate = dateValidator.parse(startDateStr);
				} catch (InvalidFinderDateException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} while (startDate == null);

			// Read and parse end date
			do {
				System.out.print("Enter end date (DD/MM/YYYY) : ");
				endDateStr = scanner.next();
				try {
					endDate = dateValidator.parse(endDateStr);
				} catch (InvalidFinderDateException e) {
					System.out.println(e.getMessage());
					continue;
				}

			} while (endDate == null);

			try {
				if (startDate.isLessThanEqual(endDate))
					System.out.println("Elapsed Days: " + findElapsedDays(startDate, endDate));
				else
					System.out.println("Elapsed Days: " + findElapsedDays(endDate, startDate));
			} catch (InvalidFinderDateException e) {
				System.out.println(e.getMessage());
			}

		} while (true);

	}

	public int findElapsedDays(FinderDate startDate, FinderDate endDate) throws InvalidFinderDateException {

		int elapsedDays = 0;

		if (startDate.intValue() != endDate.intValue()) {

			// Add up number of days for all years except the first and last
			for (int i = startDate.getYear() + 1; i < endDate.getYear(); i++) {
				elapsedDays += FinderDateUtils.getDaysInYear(i);
			}

			// Get number of days in first and last year (including the same
			// start and end year)
			elapsedDays += getNumOfDaysBetweenMonths(startDate, endDate);

			// Exclude start date in calculation
			elapsedDays -= 1;
		}

		return elapsedDays;
	}

	public int getNumOfDaysBetweenMonths(FinderDate startDate, FinderDate endDate) throws InvalidFinderDateException {

		int elapsedDays = 0;

		int startDay = startDate.getDay();
		int startMonth = startDate.getMonth();
		int startYear = startDate.getYear();
		int endDay = endDate.getDay();
		int endMonth = endDate.getMonth();
		int endYear = endDate.getYear();

		if (startYear == endYear) {

			for (int month = startMonth; month <= endMonth; month++) {

				int daysInThisMonth = FinderDateUtils.getDaysInMonth(month, startYear);

				if (month == startMonth && month == endMonth) {
					elapsedDays += endDay - startDay;
				} else if (month == startMonth) {
					elapsedDays += daysInThisMonth - startDay;
				} else if (month == endMonth) {
					elapsedDays += endDay;
				} else {
					elapsedDays += daysInThisMonth;
				}
			}

		} else {

			elapsedDays += getNumOfDaysBetweenMonths(new FinderDate(startDay, startMonth, startYear),
					new FinderDate(31, 12, startYear));

			elapsedDays += getNumOfDaysBetweenMonths(new FinderDate(1, 1, endYear),
					new FinderDate(endDay, endMonth, endYear));

			elapsedDays += 1; // Adjust offset since the dates were inclusive in
								// the function calls above.

		}

		return elapsedDays;
	}

}
