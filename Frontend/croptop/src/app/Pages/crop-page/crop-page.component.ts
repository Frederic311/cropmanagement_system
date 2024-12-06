import { Component } from '@angular/core';
import { CropCardComponent } from "../../features/crop-card/crop-card.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-crop-page',
  standalone: true,
  imports: [CropCardComponent,CommonModule],
  templateUrl: './crop-page.component.html',
  styleUrl: './crop-page.component.css'
})
export class CropPageComponent {
  crops: any;

  
}
