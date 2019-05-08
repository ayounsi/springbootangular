import {BusinessEntity} from '../../shared/model/business-entity.model';

export interface Product extends BusinessEntity {
  name: string;
  price?: number;
}
