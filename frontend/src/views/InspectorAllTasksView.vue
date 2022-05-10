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
      <td>{{ task.constructionSiteName }}</td>
      <td>{{ task.description }}</td>
      <td>{{ task.companyName }}</td>
      <td>{{ task.deadline }}</td>
    </tr>
    </tbody>
  </div>
  <div class="row" id="taskSubmitRow">
    <button type="button" class="btn btn-dark btn-lg" v-on:click="returnMain">Tagasi</button>
  </div>
</div>
</div>
</template>

<script>
import router from "@/router";

export default {
  name: "InspectorAllTasksView",
  data:function(){
    return {
      taskList:{}
    }
  },
  methods:{
    getAllTasks: function(){
      this.$http.get("/response/get/by/userid", {
        params:{
          userId: sessionStorage.getItem("userId")
        }
      })
      .then(response=>{
        this.taskList=response.data;
      })
      .catch(error=>{
        console.log(error.response.data)
      })
    },
    returnMain:function(){
      router.push("/main")
    }
  },
  mounted() {
    this.getAllTasks();

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
  width: 800px;
  margin-left: 6.2%;
  margin-top: 5%;
  border: 2px solid black;
}


#taskTable tbody {
  font-size: 0.7em;
}

#taskTable td {
  border: 1px solid grey;
}

#taskTable th {
  border: 1px solid grey;
}
#taskSubmitRow {
  width: 54%;
  margin-left: 70%;
}
button {
  width: 35%;
  margin-top: 5%;
  margin-right: 3%;
  height: 3em;
  font-size: 1em;
}
</style>