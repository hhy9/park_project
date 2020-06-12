<template>
    <div>
        <Layout>
            <template #vue-content v-if="auth">
                <h1>h1{{user.userId}},{{user.password}},{{user.userName}}</h1>

                    <dl>
                        <dt>userName</dt>
                    <dd>{{user.userName}}</dd>
                    </dl>



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

    }
</script>


<style scoped>

</style>