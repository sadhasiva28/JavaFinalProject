import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScrollBackDirective } from './directives/scroll-back.directive';
import { ScrollDirective } from './directives/scroll.directive';

@NgModule({
  declarations: [
    ScrollBackDirective,
    ScrollDirective,
  ],
  exports: [
    ScrollBackDirective,
    ScrollDirective
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
