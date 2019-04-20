import {Entity} from './entity.model';

export interface DomainEntity extends Entity {
  businessKey: number;
}
