/*
 * Copyright [2022] [MaxKey of copyright http://www.maxkey.top]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SharedModule } from '@shared';
import { NzIconModule } from 'ng-zorro-antd/icon';

import { PermissionsEditerComponent } from './permissions/permissions-editer/permissions-editer.component';
import { PermissionsComponent } from './permissions/permissions.component';
import { MemberRolesEditerComponent } from './role-members/member-roles-editer/member-roles-editer.component';
import { RoleMembersEditerComponent } from './role-members/role-members-editer/role-members-editer.component';
import { RoleMembersComponent } from './role-members/role-members.component';
import { RoleEditerComponent } from './roles/role-editer/role-editer.component';
import { RolesComponent } from './roles/roles.component';
import { SelectRolesComponent } from './roles/select-roles/select-roles.component';
import { SessionsComponent } from './sessions/sessions.component';

const routes: Routes = [
  {
    path: 'sessions',
    component: SessionsComponent
  },
  {
    path: 'roles',
    component: RolesComponent
  },
  {
    path: 'rolemembers',
    component: RoleMembersComponent
  },
  {
    path: 'permissions',
    component: PermissionsComponent
  }
];

const COMPONENTS = [
  RolesComponent,
  RoleMembersComponent,
  PermissionsComponent,
  RoleEditerComponent,
  SessionsComponent,
  SelectRolesComponent,
  RoleMembersEditerComponent,
  PermissionsEditerComponent,
  MemberRolesEditerComponent
];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [NzIconModule, SharedModule, CommonModule, RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccessModule { }
