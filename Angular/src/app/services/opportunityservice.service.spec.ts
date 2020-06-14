import { TestBed } from '@angular/core/testing';
import { OpportunityserviceService } from './opportunityservice.service';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { Opportunity } from './opportunity';
import { environment } from '../environments/environment';



describe('OpportunityserviceService', () => {
  let service: OpportunityserviceService;
  let  httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[OpportunityserviceService]

    });
    service = TestBed.inject(OpportunityserviceService);
    httpMock = TestBed.get(HttpTestingController);
  });
  describe('getopportunitybyid', () => {

    it('should return an Opportunity', () => {
    
    const  opportunities = [
    
      {oid: 101, description: 'SoftwareEngineer', location:'Chennai',skills:'MongoDB',openingcount:15,projectduration:33,lastdate:'13-03-2019',experience:'3 years',managername:'vishnu',manageremail:'paul@gmail.com' }
    ];
    
    service.getbyid(1).subscribe((opp) => {
    expect(opp).toEqual(opportunities);
    
    });
    const  requestt = httpMock.expectOne(environment.baseUrl+"getopportunityid/1");
    
    expect(requestt.request.method).toBe("GET");
    
    requestt.flush(opportunities);
    
    httpMock.verify();
    
    });
    
    });

    describe('addOpportunity()', () => {
      let expectedOpps: Opportunity;

        beforeEach(() => {
         
          expectedOpps = 
           {oid: 10801, description: 'SoftwareEngineer', location:'Chennai',skills:'MongoDB',openingcount:15,projectduration:33,lastdate:'13-03-2019',experience:'3 years',managername:'vishnu',manageremail:'paul@gmail.com' } as Opportunity;
        });
      it('should add an Opportunity', () => {
        service. dosave(expectedOpps)
          .subscribe(data => {
            expect(data).toEqual('Opportunity created Successfully');
          });
 
      });
    });

    describe('updateOpportunity()', () => {
      let expectedOpps: Opportunity;
      beforeEach(() => {
         
        expectedOpps = 
         {oid: 3, description: 'SoftwareEngineer', location:'Chennai',skills:'Java',openingcount:15,projectduration:33,lastdate:'13-03-2019',experience:'3 years',managername:'vishnu',manageremail:'paul@gmail.com' } as Opportunity;
      });
     
      it('should update an Opportunity', () => {
       

       
    
        service. updatebyid(expectedOpps)
          .subscribe(data => {
            expect(data).toEqual('Opportunity redefined Successfully');
          });
    
       
      });
    });

   

    describe('deleteopportunity', () => {

    it('should delete an Opportunity', () => {
     
    service.deleteopportunity(102).subscribe((opp) => {
    expect(opp).toEqual('Opportunity Deleted Successfully');
    
    });
    
    
    
    const  requestt = httpMock.expectOne(environment.baseUrl+"deleteopportunity/102");
    
    expect(requestt.request.method).toBe("DELETE");

    
    httpMock.verify();
    
    });
    
    });

    describe('getopportunity', () => {

      it('should return all the Opportunities', () => {
      
        service.getopportunity().subscribe((data:any[])=>{
          expect(data.length).toEqual(7);
        })
     
      const  requestt = httpMock.expectOne(environment.baseUrl+"getoppurtunities");
      
      expect(requestt.request.method).toBe("GET");
    
      
      httpMock.verify();
      
      });
      
      });
  
 
    
});




  


