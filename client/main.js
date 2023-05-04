import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import axios from 'axios';
import App from './app/App.vue';
import Chat from './app/views/Chat.vue';
import Login from './app/views/Login.vue';
import store from './store'

axios.defaults.withCredentials = true;

axios.interceptors.response.use(undefined, error => {
  if (error) {
    const originalRequest = error.config;
    
    if (error.response.status === 401 && !originalRequest._retry) {
        originalRequest._retry = true;
        store.dispatch('LogOut')
        return router.push('/login')
    }
  }
});

const routes = [
  { path: '/', component: Chat, },
  { path: '/login', component: Login, },
]; // add meta: { requiresAuth: true } to protected routes

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  if(to.matched.some(record => record.meta.requiresAuth)) {
    if (store.getters.isAuthenticated) {
      next();
      return;
    }
    next('/login');
  } else {
    next();
  }
});

const app = createApp(App);

app.use(router);
app.use(store);
app.mount('#app');