package nl.isential.training.calculator.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import nl.isential.training.calculator.dto.CalculationRequestDto;
import nl.isential.training.calculator.service.ICalculatorService;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ICalculatorService iCalculatorService;

	@Test
	public void when_adding_return_correctValue() throws Exception {
		CalculationRequestDto requestDto = new CalculationRequestDto();
		requestDto.setNumber1(1);
		requestDto.setNumber2(2);
		requestDto.setCalculationType("+");

		Mockito.when(this.iCalculatorService.add(1, 2)).thenReturn(3);

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String value = ow.writeValueAsString(requestDto);

		mockMvc.perform(post("/api/calculator/calculate").contentType("application/json").content(value)).andExpect(status().isOk())
				.andExpect(jsonPath("$.success", is(true)))
				.andExpect(jsonPath("$.amount", is(3)));
	}

}
