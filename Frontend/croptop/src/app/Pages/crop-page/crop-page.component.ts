import { Component } from '@angular/core';
import { CropCardComponent } from "../../features/crop-card/crop-card.component";

@Component({
  selector: 'app-crop-page',
  standalone: true,
  imports: [CropCardComponent],
  templateUrl: './crop-page.component.html',
  styleUrl: './crop-page.component.css'
})
export class CropPageComponent {

}
