# 会員情報取得API/IF仕様書
### エンドポイント
- URL: /api/users
- HTTPメソッド: GET

### 説明
このエンドポイントは会員情報を取得し、login_idとpasswordのみを含むレスポンスを返却します。

### リクエスト
- パラメータ: なし

### レスポンス
- HTTPステータスコード: 200 OK
- レスポンス形式: application/json
- レスポンスボディ:
    - 型: 配列
    - 要素: オブジェクト
        - プロパティ:
            - login_id (文字列): 会員のログインID
            - password (文字列): 会員のパスワード

### レスポンス例
```json
[
  {
    "login_id": "Userkcv5vs",
    "password": "Qrgvy9Ts4PZvyNSr6NzL"
  },
  {
    "login_id": "Userfsb5dg",
    "password": "XxzfnDiNMj7j4f6VC3RT"
  }
]