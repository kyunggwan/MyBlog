import axios from "axios";
import { SignInRequestDto, SignUpRequestDto } from "./requeset/auth";
import { SignInResponseDto, SignUpResponseDto } from "./response/auth";
import { ResponseDto } from "./response";
import { GetSignInUserReseponseDto } from "./response/user";

const DOMAIN = "http://localhost:4000";

const API_DOMAIN = `${DOMAIN}/api/v1`;

const authorization = (accessToken: string) => {
    return {
        headers: {
            Authorization: `Bearer ${accessToken}`
        }
    }
}

const SIGN_IN_URL = () => `${API_DOMAIN}/auth/sign-in`;
const SIGN_UP_URL = () => `${API_DOMAIN}/auth/sign-up`;

export const signInRequest = async (requestbody: SignInRequestDto) => {

    const result = await axios.post(SIGN_IN_URL(), requestbody)
        .then(response => {
            const responseBody: SignInResponseDto = response.data;
            return responseBody;
        })
        .catch((error => {
            if (!error.response.data) return null;
            const responseBody: ResponseDto = error.response.data;
            return responseBody;
        }))
    return result;
}

export const signUpRequest = async (requestbody: SignUpRequestDto) => {

    const result = await axios.post(SIGN_UP_URL(), requestbody)
        .then(response => {
            const responseBody: SignUpResponseDto = response.data;
            return responseBody;
        })
        .catch(error => {
            if (!error.response.data) return null;
            const responseBody: ResponseDto = error.response.data;
            return responseBody;
        });
    return result;
}

const GET_SIGN_IN_USER_URL = () => `${API_DOMAIN}/user`;

export const getSignInUserRequest = async (accessToken: string) => {
    const result = await axios.get(GET_SIGN_IN_USER_URL(), authorization(accessToken))
        .then(response => {
            const responseBody: GetSignInUserReseponseDto = response.data;
            return responseBody;
        })
        .catch(error => {
            if (!error.response) return null;
            const responseBody: ResponseDto = error.response.data;
            return responseBody;
        });
    return result;
}