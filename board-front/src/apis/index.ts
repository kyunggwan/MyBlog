import { SignInRequestDto, SignUpRequestDto } from "./requeset/auth";

const DOMAIN = "http://localhost:4000";

const API_DOMAIN = `${DOMAIN}/api/v1`;

const SIGN_IN_URL = () => { `${API_DOMAIN}/auth/sign-in` };
const SIGN_UP_URL = () => { `${API_DOMAIN}/auth/sign-up` };

export const signInRequest = (requestbody: SignInRequestDto) => {

}

export const signUpRequest = (requestbody: SignUpRequestDto) => {

}