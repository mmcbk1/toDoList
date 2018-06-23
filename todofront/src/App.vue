<template>
  <div>
    <task-create @addedTask="addedTask($event)"></task-create>
    <task-list :item="item"></task-list>
  </div>
</template>

<script>
import Create from './components/task/Create';
import List from './components/task/List';

export default {
  name: 'app',
    data(){
      return{
          item:'',
      }
    },
    methods:{
      addedTask(val){
          this.item = val;
      }
    },
  components: {
    'task-create':Create,
      'task-list':List
  }
}
</script>
