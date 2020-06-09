import { Component, OnInit } from '@angular/core';
import { OpportunityserviceService } from '../opportunityservice.service';

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})
export class TrendsComponent implements OnInit {
 

  constructor(private service : OpportunityserviceService) { }

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
  barChartDataLive:any = [
    { 
        data: []
    }
];
  ngOnInit(): void {
    this.service.getopportunity().subscribe((data)=>{
      this.barChartDataLive = data as any [];
    })
  }
  
}
