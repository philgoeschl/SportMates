export interface User {
  id?: number;
  username: string;
  password: string;
  isAdmin: boolean;
  firstName?: string;
  lastName?: string;
  eMail?: string;

  dayOfBirth?: Date;
  homeTown?: boolean;
  userLocation?: string;

  sports?: Array<string>;
  events?: Array<string>;
  managedEvents?: Array<string>;

}
