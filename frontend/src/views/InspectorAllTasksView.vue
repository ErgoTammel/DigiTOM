<template>
<div>
<div id="window">
<h2>Kõik kinnitamata korrastusülesanded</h2>

  <div class="table table-light table-bordered table-responsive" id="taskTable">
    <thead class="thead-dark">
    <tr>
      <th style="width: 20%">Objekt</th>
      <th style="width: 49%">Kirjeldus</th>
      <th style="width: 20%">Vastutaja</th>
      <th style="width: 120px">Tähtaeg</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="task in taskList">
      <td>{{ task.description }}</td>
      <td>{{ task.companyName }}</td>
      <td>{{ task.deadline }}</td>
      <td>{{ task.deadline }}</td>
    </tr>
    </tbody>
  </div>
</div>
</div>
</template>

<script>
export default {
  name: "InspectorAllTasksView",
  data:function(){
    return {
      taskList:{}
    }
  },
  methods:{
    getAllTasks: function(){
      this.$http.get("/get/list", {
        params:{

        }
      })
    }
  }
}
</script>

<style scoped>
#window {
  position: absolute;
  width: 70vw;
  height: 120vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}
h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 2.8em;
  margin-left: 6.2%;
  margin-top: 5%;
}
#taskTable{
  width: 1000px;
  margin-left: 6.2%;
  margin-top: 5%;
}
</style>