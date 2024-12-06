import { Component, CUSTOM_ELEMENTS_SCHEMA, ViewEncapsulation, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { DialogModule } from 'primeng/dialog';
import { FormsModule } from '@angular/forms';
import {Farm} from '../../models/farm.model'
import { FarmService } from '../../services/farm/farm.service';



interface Farms {
  id: number;
  name: string;
  description: string;
  deadline: string;
  picture: string;
  showMenu?: boolean;
}



@Component({
  selector: 'app-farm',
  standalone: true,
  imports: [DialogModule, FormsModule, CommonModule],
  templateUrl: './farm.component.html',
  styleUrls: ['./farm.component.css']
})
export class FarmComponent implements OnInit {
  farms: Farms[] = [];
  newFarm: Farms = { id: 0, name: '', description: '', deadline: '', picture: '' };
  selectedFarm: Farms = { id: 0, name: '', description: '', deadline: '', picture: '' };

  isAddFarmModalOpen = false;
  isEditFarmModalOpen = false;

  constructor(private farmService: FarmService) {}

  ngOnInit(): void {
    this.getAllFarms();
  }

  getAllFarms(): void {
    this.farmService.getAllFarms().subscribe(farms => {
      this.farms = farms;
    });
  }

  openAddFarmModal(): void {
    this.newFarm = { id: Date.now(), name: '', description: '', deadline: '', picture: '' };
    this.isAddFarmModalOpen = true;
  }

  addFarm(): void {
    this.farmService.addFarm(this.newFarm).subscribe(() => {
      this.getAllFarms();
      this.closeModal();
    });
  }

  openEditFarmModal(farm: Farms): void {
    this.selectedFarm = { ...farm };
    this.isEditFarmModalOpen = true;
  }

  updateFarm(): void {
    this.farmService.updateFarm(this.selectedFarm.id, this.selectedFarm).subscribe(() => {
      this.getAllFarms();
      this.closeModal();
    });
  }

  deleteFarm(farm: Farms): void {
    this.farmService.deleteFarm(farm.id).subscribe(() => {
      this.getAllFarms();
    });
  }

  closeModal(): void {
    this.isAddFarmModalOpen = false;
    this.isEditFarmModalOpen = false;
  }

  onFileChange(event: any): void {
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.newFarm.picture = e.target.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  }

  toggleMenu(farm: Farms): void {
    farm.showMenu = !farm.showMenu;
  }
}
  

