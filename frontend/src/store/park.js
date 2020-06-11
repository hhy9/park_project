import router from '@/router'


const state={
    context:'http://localhost:5000',
    list:[]
}

const actions={
    async park({commit}){
            commit('PARK')
        router.push('/list')


    }
}
const mutations= {
    PARK(state,data){
        state.list=data
    }
}

const getters={

}


export default {
    name:'park',
    namespaced:true,
    state,
    actions,
    mutations,
    getters
}