import { TestBed } from '@angular/core/testing';
import { OpportunityserviceService } from './opportunityservice.service';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { Opportunity } from './opportunity';


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
  describe('getopportunity', () => {

    it('should return an Opportunity', () => {
    
    const  opportunities = [
    
      {oid: 101, description: 'SoftwareEngineer', location:'Chennai',skills:'MongoDB',openingcount:15,projectduration:33,lastdate:'13-03-2019',experience:'3 years',managername:'vishnu',manageremail:'paul@gmail.com' }
  
    
    ];
    
    
    
    service.getbyid(1).subscribe((opp) => {
    expect(opp).toEqual(opportunities);
    
    });
    
    
    
    const  requestt = httpMock.expectOne('http://localhost:8080/getopportunityid/1');
    
    expect(requestt.request.method).toBe("GET");
    
    requestt.flush(opportunities);
    
    httpMock.verify();
    
    });
    
    });
/*
    describe('addOpportunity()', () => {
      it('should add an Opportunity', () => {
        let expectedOpps: Opportunity;

        beforeEach(() => {
         
          expectedOpps = 
           {oid: 10801, description: 'SoftwareEngineer', location:'Chennai',skills:'MongoDB',openingcount:15,projectduration:33,lastdate:'13-03-2019',experience:'3 years',managername:'vishnu',manageremail:'paul@gmail.com' } as Opportunity;
        });
       
    
        service. dosave(expectedOpps)
          .subscribe(data => {
            expect(data).toEqual('Opportunity created Successfully');
          });
    
        const req = httpMock.expectOne("http://localhost:8080/addopp?expectedOpps");
    
        expect(req.request.method).toEqual('POST');
    
        req.flush(expectedOpps);
      });
    });

    describe('updateOpportunity()', () => {
      it('should update an Opportunity', () => {
        let expectedOpps: Opportunity;

        beforeEach(() => {
         
          expectedOpps = 
           {oid: 3, description: 'SoftwareEngineer', location:'Chennai',skills:'Java',openingcount:15,projectduration:33,lastdate:'13-03-2019',experience:'3 years',managername:'vishnu',manageremail:'paul@gmail.com' } as Opportunity;
        });
       
    
        service. updatebyid(expectedOpps)
          .subscribe(data => {
            expect(data).toEqual('Opportunity redefined Successfully');
          });
    
        const req = httpMock.expectOne("http://localhost:8080/updatebyid?expectedOpps");
    
        expect(req.request.method).toEqual('PUT');
    
        req.flush(expectedOpps);
      });
    });

   */ 

    describe('deleteopportunity', () => {

    it('should delete an Opportunity', () => {
     
    service.deleteopportunity(104).subscribe((opp) => {
    expect(opp).toEqual('Opportunity Deleted Successfully');
    
    });
    
    
    
    const  requestt = httpMock.expectOne('http://localhost:8080/deleteopportunity/104');
    
    expect(requestt.request.method).toBe("DELETE");

    
    httpMock.verify();
    
    });
    
    });
 
    
});




  


