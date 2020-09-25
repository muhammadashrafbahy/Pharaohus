import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { DocumentViewGridComponent } from './components/document-view-grid/document-view-grid.component';

@NgModule({
  imports: [
    CommonModule,
    UsersRoutingModule
  ],
  declarations: [UsersComponent, DocumentViewGridComponent]
})
export class UsersModule { }
