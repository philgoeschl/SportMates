export interface Event {
  id?: number;
  eventTitle: string;
  eventType: string;
  eventDescription?: string;
  eventTown: string;
  eventZIP?: number;
  eventStreet?: string;
  eventDateTime?: Date;
  eventOrganizer: string;

  sports?: Array<number>;
  users?: Array<string>;


}
