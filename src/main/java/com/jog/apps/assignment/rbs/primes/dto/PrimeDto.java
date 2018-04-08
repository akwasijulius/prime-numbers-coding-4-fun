package com.jog.apps.assignment.rbs.primes.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PrimeDto, dto containing the number and primes values
 * 
 * @author Julius Oduro
 */
public class PrimeDto {
	
	@JsonProperty("Initial")
	@ApiModelProperty(notes = "The up to number for the primes")
	private int number;
	
	@JsonProperty("Primes")
	@ApiModelProperty(notes = "The List containing the prime numbers")
	private List<Integer> primes;
	
	
	/**
	 * @param number the number
	 * @param primes the prime numbers 
	 */
	public PrimeDto(int number, List<Integer> primes) {
		this.number = number;
		this.primes = primes;
	}
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the primes
	 */
	public List<Integer> getPrimes() {
		return primes;
	}

	/**
	 * @param primes the primes to set
	 */
	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}

	
	

}
