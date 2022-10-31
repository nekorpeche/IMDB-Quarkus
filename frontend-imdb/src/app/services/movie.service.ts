import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TitleBasics} from "../models/title-basics";

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private apiUrl = '/api/title-basics/';

  constructor(private http: HttpClient) {
  }

  getAllMovies() {
    return this.http.get<TitleBasics[]>(this.apiUrl);
  }

  getByPrimaryTitleOrOriginalTitle(keyword: string) {
    return this.http.get<TitleBasics[]>(this.apiUrl + keyword);
  }

  getTopRatedMoviesByGenre(keyword: string) {
    return this.http.get<TitleBasics[]>(this.apiUrl + "topratedmovies/" + keyword);
  }
}
