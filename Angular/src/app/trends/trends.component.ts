import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})
export class TrendsComponent implements OnInit {
 

  constructor() { }

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels = ['id', 'description', 'location', 'skills', 'openingcount', 'projectduration', 'lastdate', 'experience', 'managername', 'manageremail'];
  public barChartType = 'bar';
  public barChartLegend = true;
  public barChartData = [
    {data: [65, 59, 80, 81, 56, 55, 40, 22, 55, 67], label: 'Opportunity A'},
    {data: [28, 48, 40, 19, 86, 27, 90, 43, 44, 56], label: 'Opportunity B'}
  ];

  ngOnInit(): void {
  }
  
}
