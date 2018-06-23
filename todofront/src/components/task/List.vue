<template>
    <div class="wrapper">
        <div>lista</div>
        <ul>
            <li v-for="task in tasks">{{task.name}}</li>
        </ul>
    </div>
</template>
<script>
    export default {
        props:['item'],
        data(){
            return{
                tasks:[],
            }
        },
        watch:{
          item(val){
              this.tasks.unshift(val);
          }
        },
        methods:{
            fetchTasks(){
                let vm = this;
                Axios.get('http://localhost:8000/tasks')
                    .then(function(response){
                        vm.tasks = response.data;
                    },
                    function(error){

                    })
            }
        },
        created(){
            this.fetchTasks();
        }
    }
</script>