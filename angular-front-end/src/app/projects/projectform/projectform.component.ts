import { Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ProjectformService} from "./projectform.service";

@Component({
  selector: 'app-projectform',
  templateUrl: './projectform.component.html',
  styleUrl: './projectform.component.css'
})
export class ProjectformComponent implements OnInit{
  projectForm:any;
  constructor( private fb: FormBuilder, private pfs:ProjectformService) {
    this.projectForm=this.fb.group({
      projectID:[],
      nameproject:[],
      description:[],

    });
  }
  ngOnInit() {
  }
  fnAddProject(){
    console.log(this.projectForm.value);
    this.pfs.addProject(this.projectForm.value).subscribe((data)=>console.log(data));
    alert("project added");
  }
  fnUpdateProject() {
    const projectID = this.projectForm.get('projectID').value;
    this.pfs.updateProject(projectID, this.projectForm.value).subscribe(
      (data) => {
        console.log(data);
        alert("Project updated successfully");
      },
      (error) => {
        console.error('Error updating project:', error);
        alert("Error updating project");
      }
    );
  }

  fnDeleteProject(){
    var id=this.projectForm.controls.projectID.value;
    console.log(id);
    this.pfs.removeProject(id).subscribe((data)=>console.log(data));
    alert("project deleted");
  }
}
