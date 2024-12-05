import { Routes } from '@angular/router';
import { LoginComponent } from '../app/Pages/login/login.component';
import { SignupComponent } from '../app/Pages/signup/signup.component';
import { LandingpageComponent } from '../app/Pages/landingpage/landingpage.component';
import { LeftSidebarComponent } from './features/left-sidebar/left-sidebar.component';
import { MainComponent } from './features/main/main.component';
import { FarmComponent } from './Pages/farm/farm.component';
// import { MainComponent } from './features/main/main.component';
// import { FarmsComponent } from './Pages/farms/farms.component';

export const routes: Routes = [
  { path: '', component: LandingpageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'main', component: MainComponent},
  { path: 'farm', component: FarmComponent},
 

  // { path: 'farm', component: FarmsComponent}

];
