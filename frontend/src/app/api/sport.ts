export interface Sport {
  id?: number;
  sportName: string;
  sportDescription: string;
  team?: boolean;
  teamSize?: number;
  sportPicture?: string;

  users?: Array<string>;
  events?: Array<string>;
}
