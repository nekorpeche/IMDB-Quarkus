import {Component, OnInit} from '@angular/core';
import {MovieService} from "../../services/movie.service";
import {TitleBasics} from "../../models/title-basics";

@Component({
  selector: 'app-listing',
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.scss']
})
export class ListingComponent implements OnInit {
  criteria = 'movie';
  movies: TitleBasics[] | undefined;

  constructor(private movieService: MovieService) {
  }

  ngOnInit(): void {
    this.movieService.getAllMovies().subscribe((data: TitleBasics[]) => {
      console.log(data);
      this.movies = data;
    });
  }

  findMovies(value: string) {
    if (this.criteria == "movie") {
      this.movieService.getByPrimaryTitleOrOriginalTitle(value).subscribe((data: TitleBasics[]) => {
        this.movies = data;
      });
    }
    if (this.criteria == "genre") {
      this.movieService.getTopRatedMoviesByGenre(value).subscribe((data: TitleBasics[]) => {
        this.movies = data;
      });
    }
  }

  searchBy(value: string): void {
    this.criteria = value;
  }
}
