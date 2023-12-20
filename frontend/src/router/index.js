import { createRouter, createWebHistory } from 'vue-router'
import MailListView from '@/views/Mails/MailListView.vue'
import MailView from '@/views/Mails/MailView.vue'
import LandingPage from '@/views/LandingPage/LandingPageView.vue'
import NavBar from '@/views/NavBar.vue'

const routes = [
  {
    path: '/',
    name: 'mail-list-view',
    component: MailListView
  },
  // {
  //   path: '/',
  //   name: 'mail-navbar-view',
  //   component: NavBar
  // },
  {
    path: '/mail/:id',
    name: 'mail-view',
    component: MailView
  },
  {
    path: '/home',
    name: 'landing-page',
    component: LandingPage
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
