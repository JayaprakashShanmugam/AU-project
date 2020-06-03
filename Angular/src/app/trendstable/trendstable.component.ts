import { Component, OnInit } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { ViewChild } from '@angular/core'
import {MatTable} from '@angular/material/table';
import { OpportunityserviceService } from '../opportunityservice.service';
import { Opportunity } from '../opportunity';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialogModule,MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { SampleComponent } from '../sample/sample.component';
import { UserhomeComponent } from '../userhome/userhome.component';

@Component({
  selector: 'app-trendstable',
  templateUrl: './trendstable.component.html',
  styleUrls: ['./trendstable.component.css']
})
export class TrendstableComponent implements OnInit {
  
  constructor(private OpportunityserviceService:OpportunityserviceService,private _snackBar: MatSnackBar,private dialog:MatDialog)
  {}
  message:any;
  displayedColumns: any[] = ['oid', 'description', 'location', 'skills','openingcount','projectduration','lastdate','experience','managername','manageremail', 'action'];
  dataSource = new MatTableDataSource<Opportunity>();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  public deleteOpportunity(oid:number)
  {
   let resp=this.OpportunityserviceService.deleteopportunity(oid);
   resp.subscribe((data)=>this.message=data);
   console.log(resp);
   this._snackBar.open("Response:", "Opportunity Deleted Successfully", {
     duration: 2000,
   });
   window.location.reload();
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.OpportunityserviceService.getopportunity().subscribe((data:any[])=>{
      this.dataSource.data=data;
      this.dataSource.paginator=this.paginator;
    })
  }

  applyFilter(filterValue: string)
  {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onedit()
  {
    const dialogconfig= new MatDialogConfig();
    dialogconfig.disableClose=true;
    dialogconfig.autoFocus=true;
    dialogconfig.width="50%"; 
    this.dialog.open(SampleComponent)
  }

}



