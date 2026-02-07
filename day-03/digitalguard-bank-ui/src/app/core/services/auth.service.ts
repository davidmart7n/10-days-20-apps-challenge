import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal } from "@angular/core";
import { AuthResponse, LoginRequest, MfaRequest, RegisterRequest } from "../../shared/models/auth.model";
import { Observable, tap } from "rxjs";

@Injectable({providedIn:'root'})
export class AuthService{

    private readonly http = inject(HttpClient);
    private readonly apiUrl = 'http://localhost8084/api/auth';

    currentUserToken = signal<string | null>(localStorage.getItem('jwt_token'));
    isMfaRequired = signal<boolean>(false);

    register(data: RegisterRequest):Observable<AuthResponse>{
        return this.http.post<AuthResponse>(this.apiUrl+'/register',data);
    }

    login(credentials:LoginRequest):Observable<AuthResponse>{
        return this.http.post<AuthResponse>(this.apiUrl+'/login', credentials).pipe(
            tap(res=>{
                if(res.mfaRequired) this.isMfaRequired.set(true);
            })
        );
    }

    verifyPin(credentials: MfaRequest):Observable<AuthResponse>{
        return this.http.post<AuthResponse>(`${this.apiUrl}/verify-pin`, credentials).pipe(
            tap(res => {
                if(res.token){
                    localStorage.setItem('jwt_token', res.token);
                    this.currentUserToken.set(res.token);
                    this.isMfaRequired.set(false);
                }
            })
        );
    }

    logout():void { 
        localStorage.removeItem('jwt_token');
        this.currentUserToken.set(null);
    }
}
