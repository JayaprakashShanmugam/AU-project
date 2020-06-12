import { TestBed } from '@angular/core/testing';
import { LoginUserService } from './login-user.service';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { environment } from '../environments/environment';

describe('LoginUserService', () => {
  let service: LoginUserService;
  let  httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule]
    });
    service = TestBed.inject(LoginUserService);
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  describe('getusers', () => {

    it('should add an google user', () => {
    
    service.dosaveuser('Jayaprakash','shanmugam','jayaprakash.shanmugam@accoliteindia.com').subscribe((opp) => {
    expect(opp).toEqual('User Synced');
    
    });
    

    const  requestt = httpMock.expectOne(environment.baseUrl+"validateuser/Jayaprakash/shanmugam/jayaprakash.shanmugam@accoliteindia.com");
    
    expect(requestt.request.method).toBe("GET");
    
    httpMock.verify();
    });
    
    });

});
