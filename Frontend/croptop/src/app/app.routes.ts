import { Routes } from '@angular/router';
import { LoginComponent } from '../app/Pages/login/login.component';
import { SignupComponent } from '../app/Pages/signup/signup.component';
import { LandingpageComponent } from '../app/Pages/landingpage/landingpage.component';
// import { FarmsComponent } from './Pages/farms/farms.component';
import { LeftSidebarComponent } from './features/left-sidebar/left-sidebar.component';
import { TestComponent } from './Pages/test/test.component';
import { CropPageComponent } from './Pages/crop-page/crop-page.component';
import { InventoryComponent } from './Pages/inventory/inventory.component';
import { HarvestComponent } from './Pages/harvest/harvest.component';

export const routes: Routes = [
  // { path: '', component: InventoryComponent },
  { path: '', component: LandingpageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
<<<<<<< HEAD
  { path: 'sidebar', component: LeftSidebarComponent },
  {
    path: 'crop-page', 
    component: CropPageComponent
  },
  { 
    path: 'test', 
    component: TestComponent
  },

=======
  // { path: 'sidebar', component: LeftSidebarComponent },
>>>>>>> 7e8c89a81246a134b1b68f814de1a712bc07ce8e
  { path: 'inventory', component: InventoryComponent },
  { path: 'harvest', component: HarvestComponent },

  // { path: 'farm', component: FarmsComponent}

];
