import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {AddEmailComponent} from './add-email/add-email.component';
import {SitesRoutingModule} from './sites-routing.module';
import {SiteListComponent} from './site-list/site-list.component';
import {AddSiteComponent} from './add-site/add-site.component';
import {SiteDetailsComponent} from './site-details/site-details.component';
import {NgxDataTableModule} from 'angular-9-datatable';
import {ImportEmailListComponent} from './import-email-list/import-email-list.component';
@NgModule({
  declarations: [
    SiteListComponent,
    AddSiteComponent,
    SiteDetailsComponent,
    AddEmailComponent,
    ImportEmailListComponent,
  ],
  imports: [CommonModule, SitesRoutingModule, FormsModule, NgxDataTableModule],
})
export class SitesModule {}
