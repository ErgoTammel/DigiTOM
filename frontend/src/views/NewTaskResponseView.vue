<template>
<div id="window">
  <h2>Korrastusülesanne</h2>
  <h4>Sittus põrandale.</h4>
   <h4>Vaata lisatud pilti</h4><button id="pictureButton" v-on:click="getTaskPicture()"  type="button" data-toggle="modal" data-target="#exampleModal">
    <i class="fa-regular fa-image"></i></button>
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
  <h2>Sisesta korrastusülesande vastus</h2>
  <div class="col">
  <div class="row">
    <label for="responseDescription"> Vastuse kirjeldus</label>
    <textarea class="form-control" placeholder="Vastuse kirjeldus" id="responseDescription"
              v-model="newTaskResponseRequest.description"></textarea>
  </div>
    <div class="row">
      <label for="taskImage">Sisesta korrastusest pilt&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="file" @change="handleImage" accept="image/x-png,image/jpeg" id="taskImage">
    </div>
  </div>
  <div class="submitRow">
    <button type="button" class="btn btn-secondary btn-lg" v-on:click="pushMain">Tagasi</button>
    <button type="button" class="btn btn-primary btn-lg" v-on:click="addNewTaskResponse">Kinnita</button>
  </div>
</div>
</template>

<script>
import router from "@/router";

export default {
  name: "NewTaskResponseView",
  data:function(){
    return{
      taskPicture:{},
      newTaskResponseRequest:{}
    }
  },
  methods:{
    getTaskPicture:function(){
      this.$http.get("/image/task", {
        params:{
          taskId:sessionStorage.getItem("taskId")
        }
      })
          .then(response=>{
            this.taskPicture=response.data
          })
          .catch(error=>console.log(error.response.data))
    },
    addNewTaskResponsePicture: function () {
      this.$http.post("/inspection/new/picture", {
        reportId: sessionStorage.getItem("reportId"),
        taskId: sessionStorage.getItem("taskId"),
        base64: this.pictureData
      })
    },
    handleImage: function (event) {
      const selectedImage = event.target.files[0];
      this.createBase64Image(selectedImage);
    },
    createBase64Image: function (fileObject) {
      const reader = new FileReader();
      reader.onload = () => {
        this.pictureData = reader.result;
      };
      reader.onerror = function (error) {
        console.log(error);
      }
      reader.readAsDataURL(fileObject);
    },
    pushMain:function(){
      router.push("/main")
    },
    sendTaskResponse:function(){
      this.$http.post()
    },
    addNewTaskResponse:{

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
  display: inline;
}
#pictureButton{
  border:0;
  background-color: transparent;
  font-size: 2.5em;
  display: inline;
  margin-left: 10px;
}
.col{
  width: 40%;
  margin-left: 6.2%;
}
.row textarea{
  height: 10vh;
}
label{
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