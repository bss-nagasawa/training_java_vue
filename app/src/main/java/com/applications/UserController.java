package com.applications;

import com.applications.service.UserService;
import com.applications.dto.UserLoginRequest;
import com.applications.dto.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    //UserServiceクラスを呼び出しログイン認証を行う
    private UserService userService;

    @PostMapping("/login")
    //クライアントから送られたJSONデータをLoginRequestクラスに変換し、ログイン認証を行う
    public ResponseEntity<?> login(@RequestBody UserLoginRequest loginRequest) {
        //UserServiceクラスのauthenticateメソッドにオブジェクトを渡し、認証結果を取得
        boolean isAuthenticated = userService.authenticate(loginRequest.getLoginId(), loginRequest.getPassword());
        //認証結果をクライアントに返す
        if (isAuthenticated) {
            return ResponseEntity.ok(new UserLoginResponse(true));
        } else {
            return ResponseEntity.ok(new UserLoginResponse(false));
        }
    }
}