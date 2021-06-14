import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/token-storage.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  dataForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private tokenStorage: TokenStorageService, private router:Router, private crudApi: UserService) { }

  ngOnInit(): void {
    this.infoForm();
  }

  infoForm(){
    /*Create Form group*/
    this.dataForm = this.fb.group({
      username: ['', [Validators.required]],   
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],   
      email: ['', [Validators.required]],
      phone: ['', [Validators.required]],   
      address: ['', [Validators.required]],
      password: ['', [Validators.required]],
      pwdd: ['', [Validators.required]]
    })
  }

  onSubmit() {
    const val = this.dataForm.value;
    this.addData();
  }

  addData() {
    this.authService.register(this.dataForm.value).
    subscribe( (data: any) => {
      console.log("Registion success");
      this.router.navigate(['/login']);
    });
  }
}
