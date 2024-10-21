package com.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applications.model.Admin;
import com.applications.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

//HTTPリクエストを処理し、HTTPレスポンスを直接返す役割。戻り値はJSON形式。
@RestController
/* リクエストするURLを指定
   管理機能ログインのためのコントローラー */
@RequestMapping("/api/admins")
public class AdminController {

    //DBとのやり取りを行うためのadminServiceを自動的に注入
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<AdminResponse> getAdmins() {
        //DBとの接続エラーや取得時エラーの例外処理が必要

        /* サービスクラスからデータを取得し、
           Stream()で変換やフィルタリングが行いやすいようにして取得し返す処理 */
        return adminService.getAllAdmins().stream()
                //データ変換時の例外処理・nullや空文字の場合の例外処理が必要

                //必要な情報のみを取得しオブジェクトを生成
                .map(admin -> new AdminResponse(admin.getLoginId(), admin.getPassword()))
                //生成したオブジェクトをリストにまとめ格納
                .collect(Collectors.toList());
    }

    /*  管理者情報をくライアントに返すためのデータを保持するためのクラス
        取得した情報を格納するためのクラス */
    public static class AdminResponse {
        private String loginId;
        private String password;

        //コンストラクタを定義（オブジェクト生成時に値をセットする）
        public AdminResponse(String loginId, String password) {
            this.loginId = loginId;
            this.password = password;
        }

        public String getLoginId() {
            return loginId;
        }

        public String getPassword() {
            return password;
        }
    }
}
