import axios from 'axios'

export const proxy={
    methods:{
        paging(url){
            const list = []

               axios.get(url)
                .then(({data})=>{
                    data.forEach(
                        elem=>{
                            list.push(elem)
                        }
                    )
                })
                .catch((err)=>{
                    alert(`에러${err}`)
                })

            return {list}
        }
    }
}