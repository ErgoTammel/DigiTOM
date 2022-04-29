import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInView from "@/views/LogInView";
import MainView from "@/views/MainView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'logInRoute',
    component: LogInView
  },
  {
    path: '/main',
    name: 'mainRoute',
    component: MainView
  }

]

const router = new VueRouter({
  routes
})

export default router
