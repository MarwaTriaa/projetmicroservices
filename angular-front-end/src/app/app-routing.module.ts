import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductbacklogsComponent} from "./productbacklogs/productbacklogs.component";
import {ProjectsComponent} from "./projects/projects.component";
import {ProjectformComponent} from "./projects/projectform/projectform.component";
import {PbformComponent} from "./productbacklogs/pbform/pbform.component";
const routes: Routes = [
  { path : "productbacklogs" , component : ProductbacklogsComponent},
  { path: "projects", component: ProjectsComponent},
  { path: 'projectform', component: ProjectformComponent},
  {path: 'pbform', component: PbformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
