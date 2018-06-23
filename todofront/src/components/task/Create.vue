<template>
    <div class="form-control">
        <div>
            <p>{{communicate}}</p>
            <label for="name">Podaj nazwe</label>
        </div>
        <input type="text" id="name" @keyup.enter="saveTask" v-model="name" placeholder="podaj nazwę"/>
        <div>
            <button type="submit"  @click="saveTask">Zapisz</button>
        </div>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                name:'',
                communicate:''
            }
        },
        methods: {
            saveTask() {
                let data = {'name': this.name},
                vm = this;
                vm.communicate = '';
                Axios.post('http://localhost:8000/task/create', data)
                    .then(function (response) {
                            vm.communicate = 'dodano nowy wpis';
                            vm.name = '';
                            vm.$emit('addedTask', response.data);
                        },
                        function () {

                        });
            }
        }
    }
</script>