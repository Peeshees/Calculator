package nl.isential.training.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

	@Override
	public int add(int number1, int number2) {
		return number1 + number2;
	}

	@Override
	public int minus(int number1, int number2) {
		return number1 - number2;
	}

	@Override
	public int devide(int number1, int number2) {
		return number1 / number2;
	}

	@Override
	public int multiply(int number1, int number2) {
		return number1 * number2;
	}

}
