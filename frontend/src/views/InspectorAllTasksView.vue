<template>
  <div>
    <div id="errorMessage" class="alert alert-danger" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
  <h3 id="logOut" v-on:click="logOut" >Logi välja</h3>
<div id="window">
<h2>Kõik kinnitamata korrastusülesanded</h2>

  <div class="table table-light table-bordered table-responsive" id="taskTable">
    <thead class="thead-dark">
    <tr>
      <th style="width: 15%">Objekt</th>
      <th style="width: 15%">Vastutaja</th>
      <th style="width: 49%">Kirjeldus</th>
      <th style="width: 15%">Tähtaeg</th>
      <th style="width: 120px"></th>
      <th style="width: 120px"></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="task in taskList">
      <td>{{ task.constructionSiteName }}</td>
      <td>{{ task.companyName }}</td>
      <td style="word-break: break-word;">{{ task.description }}</td>
      <td>{{ task.deadline }}</td>
      <td><button v-on:click="getTaskPicture(task.taskId)"  type="button" data-toggle="modal" data-target="#exampleModal">
        <i class="fa-regular fa-image"></i></button></td>
      <td><i id="arrow" class="fa-solid fa-arrow-right" v-on:click="viewTaskResponse(task.taskId)"></i></td>
    </tr>
    </tbody>
  </div>
  <div  data-backdrop="false" class="modal fade" data-focus="true" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document" >
      <div class="modal-content" id="modalWindow">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <img :src="taskPicture" class="img-fluid">
        </div>
      </div>
    </div>
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
      taskList:{},
      taskPicture:{},
      errorMessage:"",
      showError:false
    }
  },
  methods:{
    getAllTasks: function(){
      this.$http.get("/inspection/inspector/tasks", {
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
      this.showError = false;
    },
    getTaskPicture:function(getTaskId){
      this.$http.get("/image/task", {
        params:{
          taskId:getTaskId
        }
      })
          .then(response=>{
            this.taskPicture=response.data
          })
          .catch(error=>console.log(error.response.data))
      this.showError = false;
    },
    viewTaskResponse:function(id){
      this.$http.get("/response/task/exists",{
        params:{
          taskId:id
        }
      }).then(response=>{
        sessionStorage.setItem("taskId", id)
        router.push("/inspector/alltasks/view")
        this.showError = false;
      })
      .catch(error=>{
        this.errorMessage = error.response.data.title + error.response.data.detail
        this.showError = true;
      })
    },
    logOut:function(){
      this.showError = false;
      router.push("/");
      sessionStorage.clear();
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
  margin: 5% auto auto;
  border: 2px solid black;
  max-height: 500px;
  overflow-y: scroll;
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
  width: 40%;
  margin-left: 70%;
}
button {
  width: 35%;
  margin-top: 5%;
  margin-right: 3%;
  height: 3em;
  font-size: 1em;
}
i{
  font-size: 1.5em;
}
td button{
  border: 0;
  background-color: white;
}
#arrow{
  margin-top: 1.5vh;
}
#logOut{

  float: right !important;
  margin-top: 3vh !important;
  margin-right: 3vw !important;
  padding:5px !important;
  font-size: 1.2em !important;
  border: 2px solid black !important;
}
#errorMessage {
  text-align: center;
}

</style>