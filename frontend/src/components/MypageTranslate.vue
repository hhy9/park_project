<template>
    <div>
        <Layout>

            <template #vue-content v-if="auth">
                <b-form id="mypage-form" @submit="onSubmit" @reset="onReset">

                    <b-form-group id="input-name" label="Your Name:" label-for="input-1">
                        <b-form-input
                                id="input-name"
                                v-model="userName"
                                required
                                placeholder="Enter name"
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-2" label="userId:" label-for="input-2">
                        <b-form-input
                                id="input-2"
                                v-model="userId"
                                required
                                placeholder="Enter userId"
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-3" label="Password:" label-for="input-3">
                        <b-form-input
                                id="input-3"
                                v-model="password"
                                required
                                placeholder="Enter password"
                        ></b-form-input>
                    </b-form-group>



                    <b-button type="submit" variant="primary" >Join</b-button>


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

            }
        },
        computed:{
            ...mapState({
                auth:state=>state.user.auth,
            })
        },

    }
</script>

<style scoped>

</style>