<template>
    <div class="wrapper">
        <div>lista</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>description</th>
                <th>status</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="task in tasks">
                <td>{{task.id}}</td>
                <td>{{task.description}}</td>
                <td>
                    <select @change="updateStatus()" v-model="task.status">
                        <option value="inprogress">in progress</option>
                        <option value="canceled">canceled</option>
                        <option value="completed">completed</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>


    </div>
</template>
<script>
    export default {
        props: ['item'],
        data() {
            return {
                tasks: [],
            }
        },
        watch: {
            item(val) {
                this.tasks.unshift(val);
            }
        },
        methods: {
            updateStatus(id) {
                let data = {
                    'status': this.tasks[id].status
                };
                Axios.put('http://localhost:8000/task/id', data)
                    .then(function (response) {
                        console.log(response);
                        },
                        function (error) {

                        });
            },
            fetchTasks() {
                let vm = this;
                Axios.get('http://localhost:8000/tasks')
                    .then(function (response) {
                            vm.tasks = response.data;
                        },
                        function (error) {

                        })
            }
        },
        created() {
            this.fetchTasks();
        }
    }
</script>