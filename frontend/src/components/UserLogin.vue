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

<style scoped>

</style>