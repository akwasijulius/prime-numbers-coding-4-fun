/**
 * 
 */
package com.jog.apps.assignment.rbs.primes.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

import org.assertj.core.util.Lists;
import org.junit.Test;

import com.jog.apps.assignment.rbs.primes.dto.PrimeDto;

/**
 * @author Julius Oduro
 *
 */

public class PrimeServiceTest {
	

	/**
	 * Test method for {@link com.jog.apps.assignment.rbs.primes.service.PrimeService#calculatePrimeNumbers(int)}.
	 */
	@Test
	public void testCalculatePrimeNumbers_shouldReturnEmptyPrimeList() {
		int number = 1;
		
		PrimeDto dto = new PrimeService().calculatePrimeNumbers(number);
		
		assertThat(dto, is(notNullValue()));
		assertThat(dto.getPrimes(), empty());
		assertThat(dto.getNumber(), is(number));
	}
	
	
	@Test
	public void testCalculatePrimeNumbers_shouldReturnOnePrimeNumberForNumberTwo() {
		int number = 2;
		
		PrimeDto dto = new PrimeService().calculatePrimeNumbers(number);
		
		assertThat(dto, is(notNullValue()));		
		assertThat(dto.getPrimes(), is(Lists.newArrayList(2)));
		assertThat(dto.getNumber(), is(number));
	}
	
	
	/**
	 * Test method for {@link com.jog.apps.assignment.rbs.primes.service.PrimeService#calculatePrimeNumbers(int)}.
	 */
	@Test
	public void testCalculatePrimeNumbers_shouldReturnFourPrimesForNumberTen() {
		int number = 10;
		
		PrimeDto dto = new PrimeService().calculatePrimeNumbers(number);
		
		assertThat(dto, is(notNullValue()));		
		assertThat(dto.getPrimes(), is(Lists.newArrayList(2, 3, 5, 7)));
		assertThat(dto.getNumber(), is(number));
	}
	
	/**
	 * Test method for {@link com.jog.apps.assignment.rbs.primes.service.PrimeService#calculatePrimeNumbers(int)}.
	 */
	@Test
	public void testCalculatePrimeNumbers_shouldReturnSevenPrimesForNumberSeventeen() {
		int number = 17;
		
		PrimeDto dto = new PrimeService().calculatePrimeNumbers(number);
		
		assertThat(dto, is(notNullValue()));		
		assertThat(dto.getPrimes(), is(Lists.newArrayList(2, 3, 5, 7, 11, 13, 17)));
		assertThat(dto.getNumber(), is(number));
	}

}
