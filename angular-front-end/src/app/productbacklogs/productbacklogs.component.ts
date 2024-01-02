import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Router} from "@angular/router";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-productbacklogs',
  templateUrl: './productbacklogs.component.html',
  styleUrl: './productbacklogs.component.css'
})
export class ProductbacklogsComponent implements OnInit{
  productbacklogs: any;
  constructor(private http : HttpClient, private router: Router) {}
  ngOnInit() {
    this.http.get('http://localhost:8888/PRODUCTBACKLOG-SERVICE/api/productbacklogs')
      .subscribe({
        next: (data: any) => {
          this.productbacklogs = data;
        },
        error: (err: any) => {
          console.log(err);
        }
      });
  }
  redirectToPBForm() {
    // Rediriger vers le composant projectform
    this.router.navigate(['/pbform']);
  }
}
