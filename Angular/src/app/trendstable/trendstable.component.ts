import { Component, OnInit } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { ViewChild } from '@angular/core'
import {formatDate} from '@angular/common';
@Component({
  selector: 'app-trendstable',
  templateUrl: './trendstable.component.html',
  styleUrls: ['./trendstable.component.css']
})
export class TrendstableComponent implements OnInit {
  displayedColumns: string[] = ['Oid', 'ODes', 'Location', 'skill','Opencount','projectduration','LastDate','Experience','ManagerName','ManagerEmail'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(filterValue: string)
  {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}

export interface PeriodicElement {
  Oid: number;
  ODes: string;
  Location: string;
  skill: string;
  Opencount: number;
  projectduration: number;
  LastDate: Date;
  Experience: string;
  ManagerName: string;
  ManagerEmail: string;
  
}

const ELEMENT_DATA: PeriodicElement[] = [
  {Oid: 1, ODes: 'Software Engineer', Location:'chennai', skill: 'Msc',Opencount:3,projectduration:10,LastDate:new Date("08-12-2019"),Experience:'2years',ManagerName:'suresh',ManagerEmail:'sures@accolite.com'},
  {Oid: 2, ODes: 'Software Engineer', Location:'banglore', skill: 'b.tech',Opencount:4,projectduration:30,LastDate:new Date("01-03-2019"),Experience:'3years',ManagerName:'gokul',ManagerEmail:'gokul@accolite.com'},
  {Oid: 3, ODes: 'Software Engineer', Location:'chennai', skill: 'B.E.',Opencount:10,projectduration:25,LastDate:new Date("08-07-2019"),Experience:'5years',ManagerName:'rajesh',ManagerEmail:'rajesh@accolite.com'},
  {Oid: 4, ODes: 'Software Engineer', Location:'delhi', skill: 'b.tech',Opencount:4,projectduration:10,LastDate:new Date("01-03-2019"),Experience:'7years',ManagerName:'ram',ManagerEmail:'ram@accolite.com'},
  {Oid: 5, ODes: 'Software Engineer', Location:'chennai', skill: 'Msc',Opencount:15,projectduration:15,LastDate:new Date("12-01-2019"),Experience:'9years',ManagerName:'siva',ManagerEmail:'siva@accolite.com'},
  {Oid: 6, ODes: 'Software Engineer', Location:'hyderabad', skill: 'M.Tech',Opencount:17,projectduration:10,LastDate:new Date("01-09-2019"),Experience:'3years',ManagerName:'sakthi',ManagerEmail:'sakthi@accolite.com'},
  
  ];
