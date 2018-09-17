import { Injectable } from '@angular/core';
import { CalculationRequestDto } from '../model/CalculationRequestDto';
import { CalculatorResponseDto } from '../model/CalculatorResponseDto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";
//import 'rxjs/Rx';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CalculatorService {

  constructor(private http: HttpClient ) { }

  calculate(dto: CalculationRequestDto): Observable<CalculatorResponseDto> {
    return this.http.post<CalculatorResponseDto>('http://localhost:8080/api/calculator/calculate', dto);
  }

}