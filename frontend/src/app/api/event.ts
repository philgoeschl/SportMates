export interface Event {
  id?: number;
  eventTitle: string;
  eventType: string;
  eventDescription: string;
  eventTown: string;
  eventZIP: number;
  eventStreet: string;
  eventDate: Date;
  eventOrganizer: string;
  eventImage?: string;

  users?: Array<string>;
  sports?: Array<string>;

}
