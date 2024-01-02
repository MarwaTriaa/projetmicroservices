import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProjectformService {
  baseUrl='http://localhost:8888/PROJECT-SERVICE/api/projects';
  constructor(private http:HttpClient) { }
  projectById(id:any){
    return this.http.get(this.baseUrl+"/"+id)
  }
  addProject(project:any){
    return this.http.post(this.baseUrl, project);
  }

  updateProject(projectID: number, updatedProject: any) {
    const url = `${this.baseUrl}/${projectID}`;
    return this.http.put(url, updatedProject);
  }

  removeProject(id: any){
    return this.http.delete(this.baseUrl+"/"+id);
  }
}
