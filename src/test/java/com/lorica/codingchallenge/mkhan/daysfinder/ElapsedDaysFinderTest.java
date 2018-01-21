package com.lorica.codingchallenge.mkhan.daysfinder;

import org.junit.Test;

import com.lorica.codingchallenge.mkhan.daysfinder.ElapsedDaysFinder;
import com.lorica.codingchallenge.mkhan.daysfinder.FinderDate;
import com.lorica.codingchallenge.mkhan.daysfinder.exception.InvalidFinderDateException;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

public class ElapsedDaysFinderTest {

	@Test
	public void getElapsedDaysTest() throws InvalidFinderDateException {

		ElapsedDaysFinder finder = new ElapsedDaysFinder();
		int elapsedDays = 0;

		/*
		 *  Proposed test cases as per coding challenge
		 */
		FinderDate startDate = new FinderDate(2, 6, 1983);
		FinderDate endDate = new FinderDate(22, 6, 1983);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(19));

		startDate = new FinderDate(4, 7, 1984);
		endDate = new FinderDate(25, 12, 1984);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(173));

		startDate = new FinderDate(3, 8, 1983);
		endDate = new FinderDate(3, 1, 1989);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(1979));
		
		startDate = new FinderDate(3, 1, 1989);
		endDate = new FinderDate(3, 8, 1983);
		elapsedDays = finder.findElapsedDays(endDate, startDate);
		Assert.assertThat(elapsedDays, is(1979));
		
		startDate = new FinderDate(1, 1, 1901);
		endDate = new FinderDate(31, 12, 2999);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(401400));

		/*
		 * Few more tests
		 */
		startDate = new FinderDate(1, 12, 2010);
		endDate = new FinderDate(10, 01, 2011);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(39));

		startDate = new FinderDate(1, 1, 2012);
		endDate = new FinderDate(10, 1, 2015);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(1104));

		startDate = new FinderDate(1, 1, 2012);
		endDate = new FinderDate(31, 12, 2012);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(364));

		startDate = new FinderDate(31, 12, 2011);
		endDate = new FinderDate(31, 12, 2012);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(365));

		startDate = new FinderDate(31, 12, 2011);
		endDate = new FinderDate(31, 12, 2028);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(6209));

		startDate = new FinderDate(1, 1, 2011);
		endDate = new FinderDate(1, 1, 2011);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(0));

		startDate = new FinderDate(1, 1, 2011);
		endDate = new FinderDate(2, 1, 2011);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(0));

		startDate = new FinderDate(31, 12, 2011);
		endDate = new FinderDate(1, 1, 2012);
		elapsedDays = finder.findElapsedDays(startDate, endDate);
		Assert.assertThat(elapsedDays, is(0));

	}

	/**
	 * Other unit tests
	 */
	@Test
	public void getNumOfDaysSameYearTest() {

		ElapsedDaysFinder finder = new ElapsedDaysFinder();
		FinderDate startDate = new FinderDate(10, 1, 2010);
		FinderDate endDate = new FinderDate(10, 2, 2010);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(31));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

		finder = new ElapsedDaysFinder();
		startDate = new FinderDate(10, 1, 2010);
		endDate = new FinderDate(10, 3, 2010);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(59));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

		finder = new ElapsedDaysFinder();
		startDate = new FinderDate(10, 1, 2012);
		endDate = new FinderDate(10, 3, 2012);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(60));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

		finder = new ElapsedDaysFinder();
		startDate = new FinderDate(10, 1, 2012);
		endDate = new FinderDate(10, 4, 2012);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(91));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

		finder = new ElapsedDaysFinder();
		startDate = new FinderDate(1, 12, 2010);
		endDate = new FinderDate(31, 12, 2010);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(30));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

		finder = new ElapsedDaysFinder();
		startDate = new FinderDate(1, 1, 2011);
		endDate = new FinderDate(10, 1, 2011);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(9));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}
	}

	/**
	 * Other unit tests
	 */
	@Test
	public void getNumOfDaysFirstAndLastYearTest() {

		ElapsedDaysFinder finder = new ElapsedDaysFinder();
		FinderDate startDate = new FinderDate(1, 12, 2010);
		FinderDate endDate = new FinderDate(10, 01, 2011);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(40));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

		finder = new ElapsedDaysFinder();
		startDate = new FinderDate(1, 1, 2012);
		endDate = new FinderDate(10, 1, 2015);

		try {
			int elapsedDays = finder.getNumOfDaysBetweenMonths(startDate, endDate);
			Assert.assertThat(elapsedDays, is(375));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

	}

}
