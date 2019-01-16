export interface User {
  id?: number;
  username: string;
  password?: string;
  admin?: boolean;
  firstName?: string;
  lastName?: string;
  eMail?: string;

  dayOfBirth?: Date;
  homeTown?: string;
  userLocation?: string;

  sports?: Array<string>;
  events?: Array<string>;
  managedEvents?: Array<string>;

}
