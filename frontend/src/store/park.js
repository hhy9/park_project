
import axios from "axios";


const state={
    context:'http://localhost:5000',
    list:[]
}

const actions={

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