import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {PbformService} from "./pbform.service";

@Component({
  selector: 'app-pbform',
  templateUrl: './pbform.component.html',
  styleUrl: './pbform.component.css'
})
export class PbformComponent implements OnInit{
  pbForm: any;

  constructor(private fb: FormBuilder, private pbService: PbformService) {
    this.pbForm = this.fb.group({
    id: ['', Validators.required],
    name: ['', Validators.required],
    description: ['', Validators.required],
    priority: ['', Validators.required],
    assignedTo: ['', Validators.required],
    status: ['', Validators.required],
    creationDate: [''],
    dueDate: ['']
    // Add other form fields as needed
  });
  }

  ngOnInit() {
  }

  fnAddPB() {
    // Logic for adding a new product backlog item
    this.pbService.addPB(this.pbForm).subscribe(
      data => {
        console.log('Product Backlog Item added successfully:', data);
      },
      error => {
        console.error('Error adding Product Backlog Item:', error);
      }
    );
  }

  fnUpdatePB() {
    // Logic for updating a product backlog item
    this.pbService.updatePB(this.pbForm).subscribe(
      data => {
        console.log('Product Backlog Item updated successfully:', data);
      },
      error => {
        console.error('Error updating Product Backlog Item:', error);
      }
    );
  }

  fnRemovePB() {
    // Logic for removing a product backlog item
    const pbId = this.pbForm.get('id').value;
    this.pbService.removePB(pbId).subscribe(
      data => {
        console.log('Product Backlog Item removed successfully:', data);
      },
      error => {
        console.error('Error removing Product Backlog Item:', error);
      }
    );
  }
}
