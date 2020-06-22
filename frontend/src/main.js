import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import { BootstrapVue} from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import router from './router'
import {store} from './store'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

Vue.config.productionTip = false
Vue.use(BootstrapVue)




new Vue({
  vuetify,
  router,
  store,
  Vuex,
  axios,

  render: h => h(App)
}).$mount('#app')
