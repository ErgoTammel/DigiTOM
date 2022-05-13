<template>
<div id="window">
  <h2>Korrastusülesanne</h2>

  <h4 style="word-break: break-word; margin-right: 6.2%;">{{taskDescription}}</h4>
  <button class="pictureButton" v-on:click="getTaskPicture()" type="button" data-toggle="modal"
          data-target="#exampleModal">
    <i class="fa-regular fa-image"></i></button>

  <div data-backdrop="false" class="modal fade" data-focus="true" id="exampleModal" tabindex="-1" role="dialog"
       aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
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
  <h2>Korrastusülesande vastus</h2>
  <h4 style="word-break: break-word; margin-right: 6.2%;">{{responseDescription}}</h4>
  <button class="pictureButton" v-on:click="getTaskResponsePicture()" type="button" data-toggle="modal"
          data-target="#exampleModal2">
    <i class="fa-regular fa-image"></i></button>
  <div data-backdrop="false" class="modal fade" data-focus="true" id="exampleModal2" tabindex="-1" role="dialog"
       aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
      <div class="modal-content" id="modalWindow2">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <img :src="taskResponsePicture" class="img-fluid">
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: "InspectorTaskResponseView",
  data:function (){
    return{
      taskPicture:{},
      taskResponsePicture:{},
      taskDescription:"",
      responseDescription:""
    }
  },
  methods:{
    getTaskDescription: function () {
      this.$http.get("/response/show/description", {
        params: {
          taskId: sessionStorage.getItem("taskId")
        }
      })
          .then(response => this.taskDescription = response.data)
          .catch(error => console.log(error.response.data))
    },
    getTaskPicture: function () {
      this.$http.get("/image/task", {
        params: {
          taskId: sessionStorage.getItem("taskId")
        }
      })
          .then(response => {
            this.taskPicture = response.data
          })
          .catch(error => console.log(error.response.data))
    },
    getTaskResponse:function (){
      this.$http.get("response/task/response", {
        params:{
          taskId:sessionStorage.getItem("taskId")
        }
      })
      .then(response=>{
        this.responseDescription=response.data;
      })
      .catch(error=>console.log(error.response.data))
    },
    getTaskResponsePicture:function (){
      this.$http.get("/response/taskresponse/image", {
        params:{
          taskId:sessionStorage.getItem("taskId")
        }
      })
      .then(response=>{
        this.taskResponsePicture = response.data;
      })
      .catch(error=>console.log(error.response.data))
    }
  },
  mounted() {
    this.getTaskDescription();
    this.getTaskResponse();
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

h3 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 2.2em;
  margin-left: 6.2%;
  margin-top: 3%;
}

h4 {
  font-family: 'Akshar', sans-serif;
  color: black;
  font-size: 1.3em;
  margin-left: 6.2%;
  margin-top: 2%;
}
i{
  font-size: 2em;
  margin-left: 7vh;
}

.pictureButton {
  border: 0;
  background-color: transparent;
  font-size: 2.5em;
  display: inline;
  margin-left: 10px;
}

.col {
  width: 40%;
  margin-left: 6.2%;
}

.row textarea {
  height: 10vh;
}

label {
  font-family: 'Akshar', sans-serif;
  color: black;
  font-size: 1.5em;
  margin-top: 2vh;
  margin-bottom: 1vh;
}

.submitRow {
  padding-left: 30vw;
}

.submitRow button {
  width: 35%;
  margin-top: 5%;
  margin-right: 3%;
  height: 3em;
  font-size: 1em;
}
</style>