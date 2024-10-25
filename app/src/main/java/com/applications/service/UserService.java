package com.applications.service;

import com.applications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applications.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //ログインIDとパスワードが一致するかを確認するメソッド
    public boolean authenticate(String loginId, String password) {
        //ログインIDが一致するユーザーを取得
        //UserRepositoryでUserエンティティにアクセスし、loginIdを検索
        User user = userRepository.findByLoginId(loginId);
        //ユーザーが存在し、パスワードが一致する場合はtrueを返す
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        //上記以外はfalseを返す
        return false;
    }

    //データベースに接続できるかを確認するメソッド
    public boolean isDatabaseConnected() {
        try {
            //レコード数を取得し、接続できる場合はtrueを返す
            userRepository.count();
            return true;
        //接続できない場合はfalseを返す
        } catch (Exception e) {
            return false;
        }
    }
}