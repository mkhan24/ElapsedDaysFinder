package com.lorica.codingchallenge.mkhan.daysfinder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.lorica.codingchallenge.mkhan.daysfinder.FinderDateUtils;
import com.lorica.codingchallenge.mkhan.daysfinder.exception.InvalidFinderDateException;

public class FinderDateUtilsTest {

	FinderDateUtils dateValidator = new FinderDateUtils();

	@Test
	public void validateDateTest() {

		// Test invalid dates
		try {
			Assert.assertThat(dateValidator.isValidDate(190, 12, 1990), is(false));
			Assert.assertThat(dateValidator.isValidDate(29, 02, 2018), is(false));
			Assert.assertThat(dateValidator.isValidDate(28, -1, 2018), is(false));
			Assert.assertThat(dateValidator.isValidDate(28, 1, 1900), is(false));
			Assert.assertThat(dateValidator.isValidDate(28, 1, 3000), is(false));
		} catch (InvalidFinderDateException e) {
			Assert.assertNotNull(e);
		}

		// Test valid dates
		try {
			Assert.assertThat(dateValidator.isValidDate(19, 12, 1901), is(true));
			Assert.assertThat(dateValidator.isValidDate(29, 02, 2020), is(true));
			Assert.assertThat(dateValidator.isValidDate(29, 02, 2024), is(true));
			Assert.assertThat(dateValidator.isValidDate(28, 02, 2018), is(true));
			Assert.assertThat(dateValidator.isValidDate(31, 12, 2018), is(true));
			Assert.assertThat(dateValidator.isValidDate(28, 12, 2018), is(true));
			Assert.assertThat(dateValidator.isValidDate(28, 1, 2999), is(true));
		} catch (InvalidFinderDateException e) {
			Assert.fail();
		}

	}

}
