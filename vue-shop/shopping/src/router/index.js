import Vue from 'vue'
import VueRouter from 'vue-router'
import Shopping from '../views/Shopping.vue'
Vue.use(VueRouter)

  const routes = [
  {
      path: '/',
      redirect: '/shopping'
  },
  {
    path: '/shopping',
    name: 'Shopping',
    component: Shopping
  },
  {
    path: '/add',
    name: 'Add',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Add.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
