import Vue from 'vue'
import Router from 'vue-router'
import VulnerabilityRemover from '@/components/VulnerabilityRemover'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'VulnerabilityRemover',
      component: VulnerabilityRemover
    }
  ]
})
