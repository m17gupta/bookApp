import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './Admin/admin-dashboard/admin-dashboard.component';
import { AdminmainBoardComponent } from './Admin/adminmain-board/adminmain-board.component';
import { DashboardComponent } from './home/dashboard/dashboard.component';
import { LoginComponent } from './home/login/login.component';
import { MainBoardComponent } from './home/main-board/main-board.component';
import { SignUpComponent } from './home/sign-up/sign-up.component';

const routes: Routes = [
  {path:"dashboard",component:DashboardComponent,
   children:[
    {path:"mainboard",component:MainBoardComponent},
    {path:"login",component:LoginComponent},
    {path:"signup",component:SignUpComponent}
   ]
},
{path:"admin",component:AdminDashboardComponent,
  children:[
    {path:"adminboard",component:AdminmainBoardComponent}
  ]
},
{
  path:"",
  redirectTo:"dashboard/mainboard",
  pathMatch:'full'
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
