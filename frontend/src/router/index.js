import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInView from "@/views/LogInView";
import MainView from "@/views/MainView";
import NewInspectionView from "@/views/NewInspectionView";

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
  },
  {
    path:'/inspection/sites',
    name:'newInspectionRoute',
    component: NewInspectionView
  }

]

const router = new VueRouter({
  routes
})

export default router
