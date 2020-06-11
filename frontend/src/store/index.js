import Vue from 'vue'
import Vuex from 'vuex'
import park from './park'
import user from './user'

Vue.use(Vuex)

export const store = new Vuex.Store({
    modules:{
        park,user
    }
})