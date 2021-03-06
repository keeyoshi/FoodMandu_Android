package com.keeyoshi.foodmandu.bll;

import com.keeyoshi.foodmandu.API.UserAPI;
import com.keeyoshi.foodmandu.URL.url;
import com.keeyoshi.foodmandu.serverresponse.SignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String email, String password) {

        UserAPI userAPI= url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> usersCall = userAPI.checkUser(email, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
