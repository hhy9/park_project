import Vue from 'vue'
import Router from 'vue-router'
import Login from "../components/Login";
import Home from '../components/Home'
import Join from '../components/Join'
import list from '../components/list'
import Mypage from "../components/Mypage";
Vue.use(Router)

export default new Router({
    mode:'history',
    routes:[
        {path:'/',component:Home},
        {path:'/login',component: Login},
        {path: '/join',component: Join},
        {path:'/list',component: list},
        {path:'/mypage',component: Mypage}
    ]
})


