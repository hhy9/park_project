<template>
    <div>
        <Layout>

            <template #vue-content>
                    <b-carousel
                            id="carousel-no-animation"
                            style="text-shadow: 0px 0px 2px #000"
                            no-animation
                            indicators
                            img-width="1024"
                            img-height="480"
                    >
                        <b-carousel-slide
                                caption="First slide"
                                img-src="https://cdn.pixabay.com/photo/2018/08/10/03/19/lane-3596034_1280.jpg"
                        ></b-carousel-slide>
                        <b-carousel-slide
                                caption="Second Slide"
                                img-src="https://cdn.pixabay.com/photo/2018/03/15/21/10/tree-3229512_1280.jpg"
                        ></b-carousel-slide>
                        <b-carousel-slide
                                caption="Third Slide"
                                img-src="https://cdn.pixabay.com/photo/2017/12/11/21/17/bridge-3013297_1280.jpg"
                        ></b-carousel-slide>
                        <b-carousel-slide
                                caption="Fourth Slide"
                                img-src="https://cdn.pixabay.com/photo/2015/04/20/13/44/ferris-wheel-731511_1280.jpg"
                        ></b-carousel-slide>
                    </b-carousel>

            </template>

        </Layout>
    </div>

</template>

<script>
    import Layout from "../components/common/Layout.vue"

    export default {
        components : {Layout},
        data() {
            return {

            }
        },
        methods: {

        }

    }
</script>

<style scoped>
    ul.menu{
        list-style: none;

    }
    div>img {
        width: 50px;
        height: 50px;
    }
    div #title {
        display: inline;
    }
    div #parksearch{
        display: inline;
        margin-left: 600px;
    }

</style>
