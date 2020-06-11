<template>
    <div id="wrapper">
        <header id="header">
            <div>
                <img style="margin-bottom:5px;margin-left:350px;width: 50px;float: left;" src="https://cdn.pixabay.com/photo/2016/12/20/16/02/tree-1920834_960_720.png" />
               <h1 @click="home" id="title">{{title}}</h1>
            </div>

        </header>
                <div v-if=auth>
                    <b-navbar toggleable="lg" type="dark" variant="info">
                        <b-navbar-brand @click="list">park</b-navbar-brand>
                        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
                        <b-collapse id="nav-collapse" is-nav>
                            <b-navbar-nav>
                                <b-nav-item @click="mypage">mypage</b-nav-item>
                                <b-nav-item @click="logout" >logout</b-nav-item>

                            </b-navbar-nav>

                            <!-- Right aligned nav items -->
                            <b-navbar-nav class="ml-auto">
                                <b-nav-form>
                                    <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
                                    <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
                                </b-nav-form>


                            </b-navbar-nav>
                        </b-collapse>
                    </b-navbar>
                </div>

        <div v-else>
            <b-navbar toggleable="lg" type="dark" variant="info">
                <b-navbar-brand @click="list">park</b-navbar-brand>
                <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
                <b-collapse id="nav-collapse" is-nav>
                    <b-navbar-nav>
                        <b-nav-item @click="login">login</b-nav-item>
                        <b-nav-item @click="join" >join</b-nav-item>

                    </b-navbar-nav>

                    <!-- Right aligned nav items -->
                    <b-navbar-nav class="ml-auto">
                        <b-nav-form>
                            <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
                            <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
                        </b-nav-form>


                    </b-navbar-nav>
                </b-collapse>
            </b-navbar>
        </div>

        <section id="content">
            <slot name="vue-content">

            </slot>
        </section>
        <v-footer>
            <v-spacer></v-spacer>
            <div>&copy; {{ new Date().getFullYear() }}</div>
        </v-footer>

    </div>
</template>

<script>
import {mapState} from 'vuex'


    export default {

        data: () => {
            return {
                title: 'Find Your Park',

                footer:'하단'
            }
        },
        computed:{
          ...mapState({
                auth:state=>state.user.auth
          })
        },
        methods:{
            login(){
                this.$router.push('/login')
            },
            home(){
              this.$router.push('/')
            },
            join(){
                this.$router.push('/join')
            },
            list(){
               this.$router.push('/list')
                //router.push('/list')
            },
            logout(){
                this.$store.dispatch('user/logout')
            },
            mypage(){
                this.$router.push('/mypage')
            }
        }
    }
</script>

<style scoped>
    #title {
        cursor: pointer;
    }
    #title:hover {
        color: green;
    }
    #wrapper{

        margin: 0 auto;
        width: 1300px;
        height: 100%;
        overflow: hidden;

    }


    footer {
        clear: both;
        padding: 0px 10px;
    }

    #content {
        width: 1300px;
        height:700px;
    }
    #header{
       text-align: left;
        margin-left: 130px;

    }
</style>
