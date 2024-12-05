import { Component } from '@angular/core';
import { Product } from '../../domain/product';
import { ProductService } from '../../services/product.service';
import { TableModule } from 'primeng/table';
import { TagModule } from 'primeng/tag';
import { RatingModule } from 'primeng/rating';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-farm',
  standalone: true,
  imports: [TableModule, TagModule, RatingModule, CommonModule, FormsModule],
  providers: [ProductService],
  templateUrl: './farm.component.html',
  styleUrl: './farm.component.css'
})
export class FarmComponent {

    
  

 }
