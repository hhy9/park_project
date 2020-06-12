<template>

    <div>
        <Layout>
            <template #vue-content>
                <h1 style="text-align: center">Join</h1>
                <b-form id="join-form" @submit="onSubmit" @reset="onReset">

            <b-form-group id="input-group-1" label="Your Name:" label-for="input-1">
                <b-form-input
                        id="input-1"
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
            <b-button type="reset" variant="danger" style="margin-left: 10px">Reset</b-button>

        </b-form>

            </template>
        </Layout>
    </div>
</template>

<script>
    import Layout from "./common/Layout";
    import axios from 'axios'
    export default {
        components: {Layout},
        data() {
            return {

                    userName: '',
                    userId: '',
                    password: '',

            }
        },
        methods: {

            onSubmit() {
                alert('서브밋')
               // this.$store.dispatch('user/join',{username:this.name,userid:this.userId,password:this.password})
                axios.post(`${this.$store.state.user.context}users/${this.userId}/join`,
                    {userName: this.userName,userId: this.userId,password: this.password},
                    {
                        authorization: 'JWT fefege..',
                        Accept: 'application/json',
                        'Content-Type': 'application/json'
                    })
                    .then(({data}) => {
                        alert(`조인${data}`)
                    })
                    .catch((err) => {
                        alert(`조인에러${err}`)
                    })
            }
        ,

        onReset(evt) {
            evt.preventDefault()
            // Reset our form values
            this.form.email = ''
            this.userName= ''
            this.form.food = null

            // Trick to reset/clear native browser form validation state
            this.show = false
            this.$nextTick(() => {
                this.show = true
            })
        }
    }
        }


</script>

<style scoped>
#join-form{
    width: 500px;
    margin:0 auto;
    margin-top: 100px;
}


</style>