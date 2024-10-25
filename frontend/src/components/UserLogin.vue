<template>
  <div class="login-container">
    <!-- ヘッダーの左側に「ログイン」、右側にロゴを表示 -->
    <header>
      <div class="left-header">ログイン</div>
      <img src="@/assets/company_logo.png" alt="Logo" class="logo" />
    </header>

    <!-- ログインフォームのメイン部分 -->
    <div class="login-form">
      <h2>会員機能用ログイン画面</h2>
      <!-- ログインメソッドの呼び出し（フォーム送信時ブラウザがページをリロードし
           送信した情報を表示することするのを防ぎ、loginメソッドを呼び出す） -->
      <form @submit.prevent="login">
        <!-- ログインIDテキストボックスの表示 -->
        <div class="input-group">
          <label for="loginId">ログインID：</label>
          <input type="text" v-model="loginId" id="loginId" required />
        </div>
        <!-- パスワードテキストボックスの表示（type属性をpasswordに設定し、入力内容を非表示） -->
        <div class="input-group">
          <label for="password">パスワード：</label>
          <input type="password" v-model="password" id="password" required />
        </div>
        <!-- フォーム送信ボタン -->
        <button type="submit" class="login-button">ログイン</button>
      </form>
      <!-- エラーメッセージの表示 -->
      <div v-if="error" class="error-message">{{ error }}</div>
    </div>

    <!-- フッター右下に著作権情報 -->
    <footer>
      <span>©株式会社BSS</span>
    </footer>
  </div>
</template>

<script>
// axiosをインポートしHTTPリクエストを簡単に行えるようにする
import axios from 'axios';

// ユーザーが入力した情報、エラーメッセージを保持する
export default {
  data() {
    return {
      loginId: '',
      password: '',
      error: ''
    };
  },
  methods: {
    // フォーム送信時に呼び出されるメソッド
    async login() {
      try {
        const response = await axios.post('http://localhost:8080/api/user/login', {
          loginId: this.loginId,
          password: this.password
        });
        if (response.data.success) {
          // ログイン成功、次のページへ進む
          this.$router.push('/next-page');
        } else {
          this.error = 'ログインIDまたはパスワードが間違っています。';
        }
      } catch (error) {
        //ログイン失敗、エラーメッセージを表示
        this.error = 'エラーが発生しました。';
      }
    }
  },
  mounted() {
    document.title = '会員ログイン';
  }
};
</script>

<!-- スタイルの定義 -->
 <!-- 全体のスタイルを設定 -->
<style scoped>
.login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  height: 100vh;
  padding: 20px;
  box-sizing: border-box;
}

/* ヘッダーのレイアウトを設定 */
header {
  display: flex;
  justify-content: space-between;
  width: 100%;
  align-items: center;
  margin-bottom: 20px;
}

/* ヘッダー左側のスタイルを設定 */
.left-header {
  font-size: 1.6em;
  font-weight: bold;
}

/* ロゴの高さを設定 */
.logo {
  height: 50px; 
}

/* ログインフォームのスタイルを設定 */
.login-form {
  text-align: center;
  width: 300px; /* フォームの幅を調整 */
  background-color: #f9f9f9; /* 背景色の追加 */
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* 入力フィールドのグループ化とスタイルを設定 */
.input-group {
  margin-bottom: 15px;
  display: flex;
  flex-direction: column;
  text-align: left;
}

/* ラベルのスタイルを設定 */
.input-group label {
  margin-bottom: 5px;
  font-weight: bold;
}

/* 入力フィールドのスタイルを設定 */
.input-group input {
  padding: 8px;
  font-size: 1em;
  border: 1px solid #ccc;
  border-radius: 4px;
}

/* ログインボタンのスタイルを設定 */
.login-button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  font-size: 1em;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* ログインボタンのマウスオーバー時のスタイルを設定 */
.login-button:hover {
  background-color: #0056b3;
}

/* エラーメッセージのスタイルを設定 */
.error-message {
  color: red;
  margin-top: 10px;
}

/* フッターのスタイルを設定 */
footer {
  display: flex;
  justify-content: flex-end;
  width: 100%;
  font-size: 0.8em;
  padding-right: 10px;
}
</style>