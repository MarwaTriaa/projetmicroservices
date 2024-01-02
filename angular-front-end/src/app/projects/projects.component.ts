import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-projects',

  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent implements OnInit{
  projects: any;
  constructor(private http : HttpClient, private router: Router) {}
  ngOnInit() {
    this.http.get("http://localhost:8888/PROJECT-SERVICE/api/projects")
      .subscribe({
        next : data => {
          this.projects = data;
        },
        error : err =>{
          console.log(err);
        }
      })
  }
  redirectToProjectForm() {
    // Rediriger vers le composant projectform
    this.router.navigate(['/projectform']);
  }
}
