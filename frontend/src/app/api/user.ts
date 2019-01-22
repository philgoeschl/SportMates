export interface User {
  id?: number;
  encodeNumber?: number;
  username: string;
  password?: string;
  admin?: boolean;
  firstName?: string;
  lastName?: string;
  eMail?: string;

  dayOfBirth?: Date;
  homeTown?: string;
  userLocation?: string;

  sports?: Array<number>;
  events?: Array<string>;
  managedEvents?: Array<string>;

}
