import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HarvestService } from '../../services/harvest/harvest.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';

@Component({
  selector: 'app-harvest',
  standalone: true,
  imports: [HttpClientModule, CommonModule, ReactiveFormsModule, ToastModule],
  templateUrl: './harvest.component.html',
  styleUrls: ['./harvest.component.css'],
  providers: [HarvestService, MessageService]
})
export class HarvestComponent implements OnInit {
  harvests: HarvestDTO[] = [];
  selectedHarvests: number[] = [];
  addHarvestForm: FormGroup;
  showForm: boolean = false;
  isEditMode: boolean = false;
  currentHarvestId: number | null = null;

  constructor(private harvestService: HarvestService, private fb: FormBuilder, private messageService: MessageService) {
    this.addHarvestForm = this.fb.group({
      title: ['', Validators.required],
      harvestDate: ['', Validators.required],
      quantity: ['', Validators.required],
      cropId: ['', Validators.required],
      farmId: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getAllHarvests();
  }

  getAllHarvests(): void {
    this.harvestService.getHarvests().subscribe(
      (data: HarvestDTO[]) => {
        console.log('Harvest data fetched successfully', data);
        this.harvests = data;
      },
      (error) => {
        console.error('Error fetching harvest data', error);
      }
    );
  }

  toggleHarvestSelection(harvestId: number, event: Event): void {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      this.selectedHarvests.push(harvestId);
    } else {
      const index = this.selectedHarvests.indexOf(harvestId);
      if (index > -1) {
        this.selectedHarvests.splice(index, 1);
      }
    }
    console.log('Selected harvests:', this.selectedHarvests);
  }

  showAddHarvestForm(): void {
    this.showForm = true;
    this.isEditMode = false;
    this.addHarvestForm.reset();
  }

  showEditHarvestForm(harvest: HarvestDTO): void {
    this.showForm = true;
    this.isEditMode = true;
    this.currentHarvestId = harvest.id;
    this.addHarvestForm.patchValue({
      title: harvest.title,
      harvestDate: harvest.harvestDate,
      quantity: harvest.quantity,
      cropId: harvest.crop.id,
      farmId: harvest.farmId
    });
  }

  hideAddHarvestForm(): void {
    this.showForm = false;
    this.isEditMode = false;
    this.currentHarvestId = null;
  }

  onSubmit(): void {
    if (this.addHarvestForm.valid) {
      if (this.isEditMode && this.currentHarvestId !== null) {
        this.harvestService.updateHarvest(this.currentHarvestId, this.addHarvestForm.value).subscribe(
          (data) => {
            this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Harvest data updated successfully' });
            console.log('Harvest data updated successfully', data);
            this.getAllHarvests();
            this.hideAddHarvestForm();
          },
          (error) => {
            console.error('Error updating harvest data', error);
            this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error updating harvest data: ' + error.message });
          }
        );
      } else {
        this.harvestService.addHarvest(this.addHarvestForm.value).subscribe(
          (data) => {
            this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Harvest data saved successfully' });
            console.log('Harvest data added successfully', data);
            this.getAllHarvests();
            this.hideAddHarvestForm();
          },
          (error) => {
            console.error('Error adding harvest data', error);
            this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error adding harvest data: ' + error.message });
          }
        );
      }
    }
  }

  deleteSelectedHarvests(): void { this.selectedHarvests.forEach((harvestId) => { this.harvestService.deleteHarvest(harvestId).subscribe( () => {
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Harvest deleted successfully' });
    this.getAllHarvests(); }, (error) => { console.error('Error deleting harvest', error);
       this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error deleting harvest: ' + error.message }); } ); });
       this.selectedHarvests = []; }

}

export interface HarvestDTO {
  id: number;
  title: string;
  harvestDate: string;
  quantity: number;
  crop: {
    id: number;
    cropName: string;
    cropDescription: string;
  };
  farmId: number;
}
