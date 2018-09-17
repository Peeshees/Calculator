package nl.isential.training.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.isential.training.calculator.dto.CalculationRequestDto;
import nl.isential.training.calculator.dto.CalculatorResponseDto;
import nl.isential.training.calculator.service.ICalculatorService;

@RestController
public class CalculatorController {

	@Autowired
	private ICalculatorService service;

	@PostMapping("/api/calculator/calculate")
	public CalculatorResponseDto doCalculation( @RequestBody CalculationRequestDto dto ) {
		CalculatorResponseDto responseDto = new CalculatorResponseDto();
		
		switch (dto.getCalculationType()) {
		case "+":
			responseDto.setAmount( this.service.add(dto.getNumber1(), dto.getNumber2()) );
			responseDto.setSuccess(true);
			break;

		case "-":
			responseDto.setAmount( this.service.minus(dto.getNumber1(), dto.getNumber2()));
			responseDto.setSuccess(true);
			break;

		case "/":
			responseDto.setAmount(this.service.devide(dto.getNumber1(), dto.getNumber2()));
			responseDto.setSuccess(true);
			break;

		case "*":
			responseDto.setAmount(this.service.multiply(dto.getNumber1(), dto.getNumber2()));
			responseDto.setSuccess(true);
			break;
		}
		
		return responseDto;
	}

}
