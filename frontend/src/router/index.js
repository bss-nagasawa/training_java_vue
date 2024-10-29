import { createRouter, createWebHistory } from 'vue-router';
import UserLogin from '../components/UserLogin.vue';
import MyPage from '../components/MyPage.vue';

/* ルーティングの設定
   パスとコンポーネントの関連付け */
const routes = [
  { path: '/user/login', component: UserLogin }, 
  { path: '/myPage', component: MyPage }
];

//ページ遷移の設定
const router = createRouter({
  //Webブラウザの履歴を利用してページ遷移を行う
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;