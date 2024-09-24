# training_java

BSS 研修課題のリポジトリです。この課題はバックエンドは Java で構築します。

管理者インタフェース：
        1.登録インタフェース:
               1-1.基本情報
                 エンドポイント：/admin/register
　　　　　　　　　HTTPメソッド:POST
　　　　　　　　　メソッド名:register
　　　　　　　　　インターフェースの説明：このインターフェースは、管理者への登録に使用されます。

               1-2.リクエストパラメータ
                 リクエストパラメータ説明:
　　　　　　　　　パラメータ名　　　　説明　　　　種類
　　　　　　　　　 register　　　　登録者名　　　string
                  password        パスワード　　Integer
                    auth          権限　　　　　Integer

               1-3.レスポンスデータ
                 レスポンスデータの種類:json
                 レスポンスデータ説明:
                 レスポンスデータ名　　　　種類　　　　備考
                      code               number      0-成功　1-失敗
                     message             string      メッセージ
                      data               object      戻り値

　　　　2.ログインインタフェース：
               2-1.基本情報
　　　　　　　　　エンドポイント：/admin/login
　　　　　　　　　HTTPメソッド:POST
　　　　　　　　　メソッド名:login
　　　　　　　　　インターフェースの説明：このインターフェースは、管理者へのログインに使用されます。

　　　　　　　　2-2.リクエストパラメータ
                 リクエストパラメータ説明:
　　　　　　　　　パラメータ名　　　　説明　　　　種類
                     id          ログインid   Integer
                  password       パスワード   Integer

               2-3.レスポンスデータ
                 レスポンスデータの種類:json
                 レスポンスデータ説明:
                 レスポンスデータ名　　　　種類　　　　備考
                      code               number      0-成功　1-失敗
                     message             string      メッセージ
                      data               object      戻り値

        3.個人情報登録インタフェース:
               3-1.基本情報
　　　　　　　　　エンドポイント：/user
　　　　　　　　　HTTPメソッド:POST
　　　　　　　　　メソッド名:register
　　　　　　　　　インターフェースの説明：このインターフェースは、管理者へのログインに使用されます。
               3-2.リクエストパラメータ
                 リクエストパラメータ説明:
　　　　　　　　　エンティティクラス　user

               3-3.レスポンスデータ
                 レスポンスデータの種類:json
                 レスポンスデータ説明:
                 レスポンスデータ名　　　　種類　　　　備考
                      code               number      0-成功　1-失敗
                     message             string      メッセージ
                      data               object      戻り値

