import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../../service/calculator.service';
import { CalculationRequestDto } from '../../model/CalculationRequestDto';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  dto = new CalculationRequestDto();
  amount: number;

  constructor( private service: CalculatorService ) { }

  ngOnInit() {
  }

  calculate() {
    this.service.calculate(this.dto).subscribe( data => {
      this.amount = data.amount;
    })
  }

}
