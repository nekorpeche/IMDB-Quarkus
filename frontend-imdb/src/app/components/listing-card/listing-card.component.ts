import {Component, Input, OnInit} from '@angular/core';
import {TitleBasics} from "../../models/title-basics";

@Component({
  selector: 'app-listing-card',
  templateUrl: './listing-card.component.html',
  styleUrls: ['./listing-card.component.scss']
})
export class ListingCardComponent implements OnInit {
  @Input()
  titleBasic: TitleBasics | undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

}
