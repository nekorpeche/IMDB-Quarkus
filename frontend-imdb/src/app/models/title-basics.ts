import {TitlePrincipals} from "./title-principals";
import {TitleCrew} from "./title-crew";
import {TitleRatings} from "./title-ratings";

export interface TitleBasics {
  tconst: string;
  titleType?: string;
  primaryTitle?: string;
  originalTitle?: string;
  isAdult?: boolean;
  startYear: number;
  endYear: number;
  runtimeMinutes: number;
  genres: string;
  titlePrincipals: Array<TitlePrincipals>,
  titleCrew: TitleCrew,
  titleRatings: TitleRatings;
}

