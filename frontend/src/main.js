import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

//新規Vueインスタンスの作成
const app = createApp(App);
//アプリケーションにルーターを適用
app.use(router);
/* HTMLのid属性がappの要素にマウント（取付け）
   ブラウザに表示させる処理 */
app.mount('#app');