import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductbacklogsComponent } from './productbacklogs/productbacklogs.component';
import { ProjectsComponent } from './projects/projects.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ProjectformComponent } from './projects/projectform/projectform.component';
import { PbformComponent } from './productbacklogs/pbform/pbform.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from "@angular/material/input";

@NgModule({
  declarations: [
    AppComponent,
    ProductbacklogsComponent,
    ProjectsComponent,
    ProjectformComponent,
    PbformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
