import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  dataForm!: FormGroup;
  namePage: String = '';
  roles: string[] = [];
  token: string = '';
  IsLogin = false;

  constructor(private fb: FormBuilder, private authService: AuthService, private tokenStorage: TokenStorageService, private router:Router) { }

  ngOnInit(): void {
    this.infoForm();
  }

  infoForm(){
    /*Create Form group*/
    this.dataForm = this.fb.group({
      email: ['', [Validators.required]],   
      password: ['', [Validators.required]]
    })
  }

  onSubmit(): void {
    this.authService.login(this.dataForm.value).subscribe(
      data => {
        this.tokenStorage.saveUser(data);        
        this.token =  this.tokenStorage.getUser().token;
        this.tokenStorage.saveToken(this.token);
        this.roles = this.tokenStorage.getUser().roles;
        if(this.roles[0] == "ROLE_USER")
        {
          this.router.navigate([`${this.namePage}`]);
        }    
        else {
          this.router.navigate(['admin']);
        }
      },
      err => {  
        this.IsLogin = true;
      }
    );
  }
  
}
