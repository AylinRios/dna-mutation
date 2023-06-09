import { environment } from '../../environments/environment.prod'

const apiBaseUrl = `${environment.firebaseConfig.apiBaseUrl}`

// LOGIN
export const LOGIN_URL = `${apiBaseUrl}/user/login`

//GET RECORDS
export const GET_RECORDS = `${apiBaseUrl}/dna/records`

//GET ADN WITH MUTATION
export const GET_RECORDS_WITH_MUTATION = `${apiBaseUrl}/dna/records-mutated-onmutated/{hasMutation}`

