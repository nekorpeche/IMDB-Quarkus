import {NameBasics} from "./name-basics";

export interface TitlePrincipals {
  ordering: number;
  tconst: string;
  nconst: string;
  category?: string;
  job?: string;
  characters?: string;
  nameBasics?: NameBasics;
}
