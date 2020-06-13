import router from '@/router'
import axios from "axios";


const state={
    context:'http://localhost:5000',
    list:[]
}

const actions={
    async park({commit}){
            commit('PARK')
        router.push('/list')


    },
    async search({commit},search){
        axios.get(state.context+`/${search}/search`)
            .then(({data})=>{
                commit('SEARCH',data)

            })
            .catch(()=>{
                alert('오류')
            })
    }
}
const mutations= {
    PARK(state,data){
        state.list=data.list
    },
    SEARCH(state,data){
        state.list =data.list
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