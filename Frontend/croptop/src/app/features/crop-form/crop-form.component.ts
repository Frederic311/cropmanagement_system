import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CropService } from '../../services/crop/crop.service';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-crop-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './crop-form.component.html',
  styleUrl: './crop-form.component.css'
})
export class CropFormComponent {
  @Input() crop: any = { cropName: '', 
    cropDescription: '', 
    farmId: null 
  };
  cropForm!: FormGroup;
  farms: any[] = [];
  user: any = null;
  
  constructor(private cropService: CropService, private router: Router, private route: ActivatedRoute,  private fb: FormBuilder,) {}

  isEditMode = false;

  ngOnInit(): void {
    this.initializeForm();
    this.loadFarms();
  }


  initializeForm() {
    this.cropForm = this.fb.group({
      cropName: [this.crop.cropName, Validators.required],
      cropDescription: [this.crop.cropDescription],
      farm_id: [this.crop.farm_id, Validators.required]
    });
  }

  loadFarms() {
    this.cropService.getUserFromToken().subscribe({
      next: (user) => {
        this.user = user;
        this.cropService.getAllFarms().subscribe({
          next: (farms) => {
            this.farms = farms;
          },
          error: (err) => console.error('Error loading farms:', err)
        });
      },
      error: (err) => console.error('Error fetching user:', err)
    });
  }

  onSubmit() {
    if (this.cropForm.invalid) {
      return;
    }

    const cropData = this.cropForm.value;

    if (this.crop.id) {
      // Update crop
      this.cropService.updateCrop(this.crop.id, cropData).subscribe({
        next: (response) => {
          console.log('Crop updated successfully:', response);
          alert('Crop updated successfully!');
        },
        error: (err) => {
          console.error('Error updating crop:', err);
          alert('Error updating crop!');
        }
      });
    } else {
      // Add a new crop
      this.cropService.addCrop(cropData).subscribe({
        next: (response) => {
          console.log('Crop created successfully:', response);
          alert('Crop created successfully!');
          this.cropForm.reset(); // Reset the form after successful creation
        },
        error: (err) => {
          console.error('Error creating crop:', err);
          alert('Error creating crop!');
        }
      });
    }
  }
}
