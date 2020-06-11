1<template>
    <div>
        <Layout>
            <template #vue-content>
                <h1 style="text-align: center">login</h1>
                <div style="padding-left: 300px; padding-top: 100px">
        <b-form  @submit.stop.prevent>
            <label >User ID</label>
            <b-input type="text" v-model="userId"  id="feedback-user"></b-input>

        </b-form>
    </div>

    <div>
        <b-form @submit.stop.prevent>
            <div style="padding-left:300px; padding-top:30px" >
            <label >Password</label>
            <b-input type="password" v-model="password" id="text-password" aria-describedby="password-help-block"></b-input>
            </div>
            <b-form-text id="password-help-block">

            </b-form-text>
        </b-form>
    </div><br />
                <div >
                    <b-button @click="login" variant="primary">Login</b-button>
                </div>
</template>

        </Layout>
    </div>

</template>


<script>


    import Layout from "./common/Layout";
    export default {
        components: {Layout},
        data(){
            return{
                userId: '',
                password:''
            }
        },
        methods:{
            login(){

                this.$store.dispatch('user/login',{userId:this.userId,password:this.password})
            }
        }

    }
</script>

<style scoped>
#feedback-user,#text-password{
    width: 300px;
}
</style>