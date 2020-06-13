<template>
    <div>
        <Layout>

            <template #vue-content>
                <b-navbar-nav class="ml-auto">
                    <b-nav-form>
                        <b-form-input id="search" size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
                        <b-button @click="searchclick" size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
                    </b-nav-form>


                </b-navbar-nav>

                <div class="overflow-auto">

                    <b-table
                            id="my-table"
                            :items="list"
                            :per-page="perPage"
                            :current-page="currentPage"
                            small
                    ></b-table>

                    <b-pagination
                            v-model="currentPage"
                            :total-rows="rows"
                            :per-page="perPage"
                            aria-controls="my-table"
                    ></b-pagination>

                    <p class="mt-3">Current Page: {{ currentPage }}</p>
                </div>
            </template>
        </Layout>


    </div>
</template>

<script>
    import {proxy} from '../components/mixins/proxy'
    import {mapState} from 'vuex'
    import Layout from "./common/Layout";
    import 'bootstrap/dist/css/bootstrap.css'
    import 'bootstrap-vue/dist/bootstrap-vue.css'

    export default {
        components: {Layout},
        mixins:[proxy],
        created() {
            let json=proxy.methods.paging(`${this.$store.state.park.context}/null/search`)
            this.$store.state.park.list=json.list
        },
        data(){
            return{
                perPage: 10,
                currentPage: 1,



            }
        },
        computed:{
            ...mapState({
            list:state=>state.park.list
            }),
            rows(){
                return this.list.length
            },
        },
        methods:{
            searchclick(){
                let search = document.getElementById('search').value
                if(search ==='') {search= "null"}
                this.$store.dispatch('park/search',search)
                alert('gg')
            }
        }

    }
</script>

<style scoped>
#th>div {
    text-decoration:green;
}
</style>