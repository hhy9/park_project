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
                    <b-button style="margin-left: 400px" @click="login" variant="primary">Login</b-button>
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
                console.log(this.$store.state.user)
                this.$cookies.set('value',this.$store.state.user,'1h')
                this.$store.dispatch('user/login',{userId:this.userId,password:this.password})

                console.log(this.$cookies.get('value'))

            },
            created () {
                console.log('created = ' + this.$cookies.get('value'))
                this.$store.state.user = this.$cookies.get('value')
            },
            updated () {
                console.log('updated = ' + this.$cookies.get('value'))
                this.$store.state.user = this.$cookies.get('value')
            },
            beforeMount () {
                console.log('updated = ' + this.$cookies.get('value'))
                this.$store.state.user = this.$cookies.get('value')
            },
            mounted () {
                console.log('updated = ' + this.$cookies.get('value'))
                this.$store.state.user = this.$cookies.get('value')
            },
            destroyed () {
                console.log('updated = ' + this.$cookies.get('value'))
                this.$store.state.user = this.$cookies.get('value')
            }
        },



    }
</script>

<style scoped>
#feedback-user,#text-password{
    width: 300px;
}
</style>