import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { FormBuilder, FormGroup } from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class PbformService {

  baseUrl = 'http://localhost:8888/PRODUCTBACKLOG-SERVICE/api/productbacklogs';

  constructor(private http: HttpClient, private fb: FormBuilder) { }

  // Get a product backlog item by ID
  getPBById(id: any) {
    return this.http.get(this.baseUrl + "/" + id);
  }

  // Add a new product backlog item
  addPB(pbItem: FormGroup) {
    return this.http.post(this.baseUrl, pbItem.value);
  }

  // Update a product backlog item
  updatePB(pbItem: FormGroup) {
    return this.http.put(this.baseUrl, pbItem.value);
  }

  // Remove a product backlog item by ID
  removePB(id: any) {
    return this.http.delete(this.baseUrl + "/" + id);
  }
}
