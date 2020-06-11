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
                                img-src="https://picsum.photos/1024/480/?image=10"
                        ></b-carousel-slide>
                        <b-carousel-slide
                                caption="Second Slide"
                                img-src="https://picsum.photos/1024/480/?image=12"
                        ></b-carousel-slide>
                        <b-carousel-slide
                                caption="Third Slide"
                                img-src="https://picsum.photos/1024/480/?image=22"
                        ></b-carousel-slide>
                        <b-carousel-slide
                                caption="Fourth Slide"
                                img-src="https://picsum.photos/1024/480/?image=23"
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
