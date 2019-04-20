import {DomainEntity} from '../../shared/model/domain-entity.model';

export interface Product extends DomainEntity {
  name: string;
  price?: number;
}
