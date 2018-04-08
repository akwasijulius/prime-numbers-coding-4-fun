/**
 * 
 */
package com.jog.apps.assignment.rbs.primes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jog.apps.assignment.rbs.primes.dto.PrimeDto;
import com.jog.apps.assignment.rbs.primes.service.PrimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.*;

/**
 * Prime REST Controller for prime resources
 * 
 * @author Julius Oduro
 */
@RestController
@RequestMapping("/primes")
@Api(value="Prime Numbers Resource")
public class PrimeController {
	
	@Autowired
	PrimeService primeService;
	
	@RequestMapping(value="/{number}", method=RequestMethod.GET, produces={"application/json", "application/xml"})
	@ApiOperation(value = "calculates and returns all the prime numbers up to an including a number provided", response = PrimeDto.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation performed successfully"),
            @ApiResponse(code = 500, message = "Unknown system error has occured, please contact systems admin or developer")
    	}
    )
	public PrimeDto getPrimeNumbers(@PathVariable int number){
		return primeService.calculatePrimeNumbers(number);		
	}

}
