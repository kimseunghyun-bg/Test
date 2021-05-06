import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import store from './store/index'

//alert, confirm component
import VueSimpleAlert from "vue-simple-alert"
//axios plugin
import axios from'axios'
// LightBootstrap plugin
import LightBootstrap from './light-bootstrap-main'

// router setup
//import routes from './routes/routes'
import DashboardLayout from './layout/DashboardLayout.vue'
import NotFound from './pages/NotFoundPage.vue'
import Login from 'src/pages/Login.vue'


import './registerServiceWorker'
// plugin setup
Vue.use(VueRouter)
Vue.use(LightBootstrap)
Vue.prototype.$axios = axios;
Vue.config.productionTip = false;
Vue.use(VueSimpleAlert, { title: "Vue Simple Alert", width: "420px" });


// configure router
const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'main',
      component: DashboardLayout
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    { path: '*', name:'404', component: NotFound }
  ],// short for routes: routes
  linkActiveClass: 'nav-item active',
  scrollBehavior: (to) => {
    if (to.hash) {
      return {selector: to.hash}
    } else {
      return { x: 0, y: 0 }
    }
  }
})

router.beforeEach((to, from, next) => {
  const publicPage = ['Login'];
  const authRequired = !publicPage.includes(to.name);
  const loggedIn = localStorage.getItem('user');

  if(authRequired && !loggedIn) {
    router.push({name: 'Login', query: {to: to.path}});
  }else{
    console.log(to);
    console.log(from);
    axios.post("/api/menu").then(res => {
      console.log(res);
      let resolved = router.resolve(to.path);
      console.log(resolved);
      if(resolved.route.name != '404'){
        next();
      }else{
        next({path: '/', query: {path: to.path}})
      }

      //next('/');
      //router.push({name: 'main', query: {to: to.path}});
      //next();
    }).catch(err => {
        console.log(err);
    })
    
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store
})
