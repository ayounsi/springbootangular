import {BusinessEntity} from '../../shared/model/business-entity.model';

export interface Book extends BusinessEntity {
  title: string;
  isbn?: number;
}
