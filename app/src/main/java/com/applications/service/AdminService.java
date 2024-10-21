package com.applications.service;

import com.applications.model.Admin;
import com.applications.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    //DBとのやり取りを行うためのadminRepositoryを自動的に注入
    @Autowired
    private AdminRepository adminRepository;

    //DBから全ての情報を取得するメソッド
    public List<Admin> getAllAdmins() {
        /* DBとの接続エラーや取得時エラーの例外処理、
           リストが空の場合の例外処理が必要*/

        //リスト形式で全ての情報を返す
        return adminRepository.findAll();
    }
}