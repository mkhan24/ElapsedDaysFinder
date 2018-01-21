package com.lorica.codingchallenge.mkhan.daysfinder;

public class FinderDate {

	private int day;
	private int month;
	private int year;

	public FinderDate() {
		super();
	}

	public FinderDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public FinderDate setDay(int day) {
		this.day = day;
		return this;
	}

	public int getMonth() {
		return month;
	}

	public FinderDate setMonth(int month) {
		this.month = month;
		return this;
	}

	public int getYear() {
		return year;
	}

	public FinderDate setYear(int year) {
		this.year = year;
		return this;
	}

	public int intValue() {
		return Integer.parseInt(String.format("%04d",year) + String.format("%02d", month) + String.format("%02d", day));
	}

	public boolean isGreaterThanEqual(FinderDate otherDate) {
		if(this.intValue() >= otherDate.intValue())
			return true;
		return false;

	}

	public boolean isLessThanEqual(FinderDate otherDate) {
		if(this.intValue() <= otherDate.intValue())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "FinderDate [day=" + day + ", month=" + month + ", year=" + year + ", intValue()="
				+ intValue() + "]";
	}
}
