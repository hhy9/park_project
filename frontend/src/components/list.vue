<template>
    <div>
        <Layout>
            <template #vue-content>
                <b-navbar-nav>
                    <b-nav-form>
                        <b-form-input @keyup.native.enter="searchclick" id="search" size="sm" class="mr-sm-2" placeholder="주소를 검색해주세요"></b-form-input>
                        <b-button  @click="searchclick" size="sm" class="my-2 my-sm-0" >Search</b-button>
                    </b-nav-form>
                </b-navbar-nav>

                <div class="overflow-auto">
                    <b-table
                            id="my-table"
                            :items="list"
                            :per-page="perPage"
                            :current-page="currentPage"
                            :fields="fields"
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
                fields:[
                    {key:'parkName', label:'공원 이름'},
                    {key:'roadAddress', label:'도로명 주소'},
                    {key:'jibunAddress', label:'지번 주소'},
                    {key:'sportsFacilities', label:'체육 시설'},
                    {key:'playFacilities', label:'놀이 시설'},
                    {key:'culturalFacilities', label:'문화 시설'},
                ]
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

            }
        }

    }
</script>

<style scoped>
#th>div {
    text-decoration:green;
}
</style>