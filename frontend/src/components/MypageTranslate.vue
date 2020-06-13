<template>
    <div>
        <Layout>

            <template #vue-content v-if="auth">
                <h2 style="text-align: center;margin-top: 80px" >회원정보 수정 <b-badge>User</b-badge></h2>
                <b-form id="mypage-form" @submit="onSubmit">

                    <b-form-group id="input-name" label="Your Name:" label-for="input-1">
                        <b-form-input
                                id="input-name"
                                v-model="userName"
                                required
                                placeholder="Enter name"
                        ></b-form-input>
                    </b-form-group>

                    <dt>userId</dt>
                    <dd>{{user.userId}}</dd>

                    <b-form-group id="input-group-3" label="Password:" label-for="input-3">
                        <b-form-input
                                id="input-3"
                                v-model="password"
                                required
                                placeholder="Enter password"
                        ></b-form-input>
                    </b-form-group>



                    <b-button type="submit" variant="primary" >수정하기</b-button>


                </b-form>
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
                password:''
            }
        },
        computed:{
            ...mapState({
                auth:state=>state.user.auth,
                user:state=>state.user.user
            })
        },
        methods:{
            onSubmit(){
                this.$store.dispatch('user/update',{userName:this.userName,userId:this.user.userId,password:this.password})
            }
        }

    }
</script>

<style scoped>
    #mypage-form{
        width: 600px;
        margin: 0 auto;
    }

</style>