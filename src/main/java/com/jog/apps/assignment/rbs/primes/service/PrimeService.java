/**
 * 
 */
package com.jog.apps.assignment.rbs.primes.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.jog.apps.assignment.rbs.primes.dto.PrimeDto;

/**
 * PrimeService class for handling all service requests
 * 
 * @author Julius Oduro
 */
@Service
public class PrimeService {
	
	/**
	 * Calculates and returns a dto containing all the prime numbers up to and including the number provided
	 * 
	 * @param number the integer number to use 
	 * @return the dto containing the result.
	 */
	public PrimeDto calculatePrimeNumbers(int number){		
		List<Integer> primes = IntStream.rangeClosed(2, number)
			      .filter(x -> isPrime(x)).boxed()
			      .collect(Collectors.toList());
		
		return new PrimeDto(number, primes);
	}
	

	
	private boolean isPrime(int number){
		if(number == 2) return true;
		
		if(number % 2 == 0) return false;
			
		for (int i = 3; i * i <= number; i +=2) {
			if(number % i == 0){
				return false;
			}
		}
		return true;				
	}

}
