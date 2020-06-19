import axios from "axios";
import router from '@/router'

const state={
    context:'http://localhost:5000/',
    user:{},
    fail:false,
    auth:false
}

const actions= {
    async join({commit},payload) {
        const url = state.context + `users/join`
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url,payload,headers)
            .then(({data}) => {
                commit('JOIN',data)
               console.log(data)
            })
            .catch((err) => {
                alert(`조인에러${err}`)
            })
    },

    async login({commit},payload){
        return new Promise((resolve,reject)=>{
            const url = state.context + `users/${payload.userId}/access`
            const headers = {
                authorization: 'JWT fefege..',
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
            axios.post(url,payload,headers)
                .then(({data})=>{
                    if(data.result){
                        commit('LOGIN_COMMIT',data)
                        resolve(true);

                    }else{
                        commit('FAIL_COMMIT')
                    }
                })
                .catch((error)=>{
                    alert('서버 전송 실패')
                    state.fail=true
                    reject(error)
                })


        })

    },

    async logout({commit}){
        commit('LOGOUT_COMMIT')

    },
    async withdraw({commit},payload){
        const url=state.context+`users/delete`
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url,payload,headers)
            .then(({data})=>{
                commit('DROP_USER',data)
                router.push('/')
            })
            .catch((err)=>{
                alert(`에러${err}`)
            })

    },
    update({commit},payload){
        const url=state.context+`users/${payload.userId}/update`
        const headers={
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url,payload,headers)
            .then(({data})=>{
                commit('UPDATE_USER',data)
                router.push('/mypage')
            })
            .catch((err)=>{
                alert(`에러${err}`)
            })
    }

}

const mutations={
    LOGIN_COMMIT(state,data){
        state.auth=true
        state.user=data.user
        localStorage.setItem('token',data.token)
        localStorage.setItem('userId',data.user.userId)
        router.push('/')

    },
    FAIL_COMMIT(state){
        state.fail=true
        alert('아이디 또는 비밀번호가 맞지않습니다.')
    },

    JOIN(state,data){
        alert(data.popupResult)
    },
    LOGOUT_COMMIT(state){
        localStorage.clear()
        state.auth = false
        state.user ={}
        router.push('/')

    },
    DROP_USER(state,data){
        localStorage.clear()
        state.auth=false
        state.user=data.user
    },
    UPDATE_USER(state,data){
        state.auth=true,
            state.user=data.user

    }

}

const getters={

}

export default {
    name:'user',
    namespaced:true,
    state,
    actions,
    mutations,
    getters
}