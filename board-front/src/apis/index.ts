import axios from "axios";
import { SignInRequestDto, SignUpRequestDto } from "./requeset/auth";
import { SignInResponseDto } from "./response/auth";
import { ResponseDto } from "./response";

const DOMAIN = "http://localhost:4000";

const API_DOMAIN = `${DOMAIN}/api/v1`;

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

export const signUpRequest = async (requsestbody: SignUpRequestDto) => {

}