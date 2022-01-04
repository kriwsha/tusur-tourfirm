import { createAction, props } from '@ngrx/store';
import { Client } from '../model';

export const CREATE_CLIENT = '[CREATE CLIENT] Create CLIENT API ';
export const CREATE_CLIENT_SUCCESS = '[CREATE CLIENT] Create CLIENT API Success';
export const CREATE_CLIENT_FAILURE = '[CREATE CLIENT] Create CLIENT API Failure';

export const createCLIENT = createAction(
  CREATE_CLIENT,
  props<Client>()
);

export const createCLIENTSuccess = createAction(
  CREATE_CLIENT,
  props<Client>()
);

export const createCLIENTFailure = createAction(
  CREATE_CLIENT,
  props<Client>()
);
