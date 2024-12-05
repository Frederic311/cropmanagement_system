import { Component, CUSTOM_ELEMENTS_SCHEMA, ViewEncapsulation } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { DialogModule } from 'primeng/dialog';
import { FormsModule } from '@angular/forms';

interface Farm {
  id: number;
  name: string;
  location: string;
  dateEstablished: string;
  size: string;
  owner: string;
  picture: string;
  showMenu?: boolean;
}

@Component({
  selector: 'app-farm',
  standalone: true,
  imports: [CommonModule, RouterModule, DialogModule, FormsModule],
  templateUrl: './farm.component.html',
  styleUrls: ['./farm.component.css'],
  encapsulation: ViewEncapsulation.ShadowDom,
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FarmComponent {
  farms: Farm[] = [];
  newFarm: Farm = { id: 0, name: '', location: '', dateEstablished: '', size: '', owner: '', picture: '' };
  selectedFarm: Farm = { id: 0, name: '', location: '', dateEstablished: '', size: '', owner: '', picture: '' };

  isAddFarmModalOpen = false;
  isEditFarmModalOpen = false;

  openAddFarmModal() {
    this.newFarm = { id: Date.now(), name: '', location: '', dateEstablished: '', size: '', owner: '', picture: '' };
    this.isAddFarmModalOpen = true;
  }

  addFarm() {
    this.farms.push(this.newFarm);
    this.closeModal();
  }

  openEditFarmModal(farm: Farm) {
    this.selectedFarm = { ...farm };
    this.isEditFarmModalOpen = true;
  }

  updateFarm() {
    const index = this.farms.findIndex(farm => farm.id === this.selectedFarm.id);
    if (index !== -1) {
      this.farms[index] = { ...this.selectedFarm };
    }
    this.closeModal();
  }

  deleteFarm(farm: Farm) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you really want to delete this farm?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it',
      width: '450', // Adjust the size as per your requirement
      customClass: {
        container: 'custom-swal',
        title: 'custom-swal-title',
        htmlContainer: 'custom-swal-text',
        actions: 'custom-swal-buttons',
        confirmButton: 'swal2-confirm',
        cancelButton: 'swal2-cancel'
      }
    }).then((result: { isConfirmed: any; }) => {
      if (result.isConfirmed) {
        this.farms = this.farms.filter(f => f.id !== farm.id);
        Swal.fire(
          'Deleted!',
          'Farm has been deleted.',
          'success'
        );
      }
    });
  }

  closeModal() {
    this.isAddFarmModalOpen = false;
    this.isEditFarmModalOpen = false;
  }

  base64Image: string | null = null;
  onFileChange(event: any) {
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.newFarm.picture = e.target.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  }

  toggleMenu(farm: Farm) {
    farm.showMenu = !farm.showMenu;
  }
}
