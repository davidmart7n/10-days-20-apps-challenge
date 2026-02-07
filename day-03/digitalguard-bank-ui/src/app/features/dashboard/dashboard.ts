import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { ToolbarModule } from 'primeng/toolbar';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [ButtonModule, TableModule, CardModule, ToolbarModule, DecimalPipe],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {

  authService = inject(AuthService);
  private router = inject(Router);

  // Datos mock de movimientos bancarios
  transactions = [
    { id: 1, date: '2026-02-01', description: 'Nómina Enero', amount: 2500.00, type: 'Ingreso' },
    { id: 2, date: '2026-02-02', description: 'Alquiler', amount: -850.00, type: 'Gasto' },
    { id: 3, date: '2026-02-03', description: 'Supermercado', amount: -120.50, type: 'Gasto' },
    { id: 4, date: '2026-02-05', description: 'Transferencia Bizum', amount: 50.00, type: 'Ingreso' }
  ];

  onLogout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}