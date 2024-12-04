import { Component,HostListener, OnInit, signal } from '@angular/core';
import { RouterOutlet,ActivatedRoute, Router } from '@angular/router';
import { LeftSidebarComponent } from './features/left-sidebar/left-sidebar.component';
import { MainComponent } from './features/main/main.component';
import { CommonModule } from '@angular/common';
import { trigger, state, style, transition, animate } from '@angular/animations';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,LeftSidebarComponent,MainComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  animations: [ trigger('state', [ state('done', style({ opacity: 1 })), transition('* => done', [ animate('1s') ]) ]) ]
})
export class AppComponent implements OnInit {
  constructor(private router: Router, private route: ActivatedRoute) {}
  title = 'croptop';
  isLeftSidebarCollapsed = signal<boolean>(false);
  screenWidth = signal<number>(window.innerWidth);

  @HostListener('window:resize')
  onResize() {
    this.screenWidth.set(window.innerWidth);
    if (this.screenWidth() < 768) {
      this.isLeftSidebarCollapsed.set(true);
    }
  }

  ngOnInit(): void {
    this.isLeftSidebarCollapsed.set(this.screenWidth() < 768);
  }

  changeIsLeftSidebarCollapsed(isLeftSidebarCollapsed: boolean): void {
    this.isLeftSidebarCollapsed.set(isLeftSidebarCollapsed);
  }
  shouldShowSidebar(): boolean { const currentRoute = this.router.url;
     return !(currentRoute === '/login' || currentRoute === '/signup' || currentRoute === '/'); }

}
