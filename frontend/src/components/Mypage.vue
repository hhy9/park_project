<template>
    <div>
        <Layout>
            <template #vue-content v-if="auth">
                <h2 style="text-align: center;margin-top: 80px" >MyPage <b-badge>User</b-badge></h2>
                    <dl id="mypage_dl">
                        <dt>userName</dt>
                        <dd>{{user.userName}}</dd>
                        <dt>userId</dt>
                        <dd>{{user.userId}}</dd>
                        <dt>userId</dt>
                        <dd>{{user.password}}</dd>
                    </dl>

                <div style="text-align: center;margin-top: 80px">
                    <b-button @click="translate" variant="success">수정하기</b-button>
                    <b-button style="margin-left: 20px" @click="withdraw" variant="danger">탈퇴하기</b-button>
                </div>



            </template>

        </Layout>
    </div>
</template>

<script>
    import Layout from "./common/Layout";
    import {mapState} from 'vuex'
    export default {
        components: {Layout},
        data(){
            return{
                userName:'',
                userId:'',
                password:'',

            }
        },
        computed:{
            ...mapState({
                auth:state=>state.user.auth,
                user:state=>state.user.user
            })
        },
        methods:{
            translate(){
                this.$router.push('/mypagetranslate')
            },
            withdraw(){
                this.$store.dispatch('user/withdraw',{userName:this.user.userName,userId:this.user.userId,password:this.user.password})
            }
        }

    }
</script>


<style scoped>
#mypage_dl{
    margin-top: 80px;
    text-align: center;
}
</style>