package com.applications.dto;

public class LoginResponse {
    private boolean success;

    //認証結果を格納し、クライアントにレスポンスを返す
    public LoginResponse(boolean success) {
        this.success = success;
    }

    //getter
    public boolean isSuccess() {
        return success;
    }
}