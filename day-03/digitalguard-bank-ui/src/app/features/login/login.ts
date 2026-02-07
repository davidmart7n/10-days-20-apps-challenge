import { Component, inject, signal } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';
import { StepperModule } from 'primeng/stepper';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { MessageModule } from 'primeng/message';
import { TabsModule } from 'primeng/tabs'; // <--- OJO: Ahora suele ser Tabs en lugar de TabViewimport { CardModule } from 'primeng/card';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CardModule } from 'primeng/card';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, StepperModule, ButtonModule, 
          InputTextModule, MessageModule, TabsModule, CardModule],  
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
private fb = inject(FormBuilder);
  private authService = inject(AuthService);
  private router = inject(Router);

  errorMessage = signal<string | null>(null);
  successMessage = signal<string | null>(null);
  activeStep = signal<number>(0);

  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
    pin: ['']
  });

registerForm = this.fb.group({
  name: ['', Validators.required],
  secondName: ['', Validators.required],
  username: ['', [Validators.required, Validators.minLength(3)]],
  password: ['', [Validators.required, Validators.minLength(6)]],
  secretPin: ['', [Validators.required, Validators.pattern('^[0-9]{4,6}$')]] 
});

  onLogin() {
    const { username, password } = this.loginForm.value;
    this.authService.login({ username: username!, password: password! }).subscribe({
      next: (res) => {
        if (res.mfaRequired) this.activeStep.set(1);
        else this.router.navigate(['/dashboard']);
      },
      error: () => this.errorMessage.set('Error en el login')
    });
  }

  onVerifyPin() {
    const { username, pin } = this.loginForm.value;
    this.authService.verifyPin({ username: username!, secretPin: pin! }).subscribe({
      next: () => this.router.navigate(['/dashboard']),
      error: () => this.errorMessage.set('PIN incorrecto')
    });
  }

  onRegister() {
    this.authService.register(this.registerForm.value as any).subscribe({
      next: () => {
        this.successMessage.set('Registro con éxito. ¡Ya puedes loguearte!');
        this.registerForm.reset();
      },
      error: () => this.errorMessage.set('Error al registrar usuario')
    });
  }
}