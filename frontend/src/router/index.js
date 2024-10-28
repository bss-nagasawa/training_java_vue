import { createRouter, createWebHistory } from 'vue-router';
import UserLogin from '../components/UserLogin.vue';
import NextPage from '../components/NextPage.vue';

/* ルーティングの設定
   パスとコンポーネントの関連付け */
const routes = [
  { path: '/user/login', component: UserLogin }, 
  { path: '/next-page', component: NextPage }
];

//ページ遷移の設定
const router = createRouter({
  //Webブラウザの履歴を利用してページ遷移を行う
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;