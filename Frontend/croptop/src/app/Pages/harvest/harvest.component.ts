import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { HarvestService } from '../../services/harvest/harvest.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-harvest',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './harvest.component.html',
  styleUrls: ['./harvest.component.css'],
  providers: [HarvestService]
})
export class HarvestComponent implements OnInit {
  harvests: HarvestDTO[] = [];
  selectedHarvests: number[] = [];

  constructor(private harvestService: HarvestService) {}

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



  toggleHarvestSelection(harvestId: number, event: Event): void { const checkbox = event.target as HTMLInputElement; if (checkbox.checked) { this.selectedHarvests.push(harvestId); } else { const index = this.selectedHarvests.indexOf(harvestId); if (index > -1) { this.selectedHarvests.splice(index, 1); } } console.log('Selected harvests:', this.selectedHarvests); } }


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
}
