<template>
  <div>
    <div id="errorMessage" class="alert alert-danger" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
    <h3 id="logOut" v-on:click="logOut" >Logi välja</h3>
    <div id="window">
      <div v-if="roleId===2">
        <div class="windowHeader">
          <h2><i class="fa-solid fa-user-shield"></i> Tere {{ logInName.userFirstName }} {{ logInName.userMiddleName }}
            {{ logInName.userLastName }}! </h2>
        </div>
        <div class="row">
          <div class="col">
            <button type="button" class="btn btn-dark btn-lg" v-on:click="newInspection">Alusta uut objekti
              läbivaatust
            </button>
          </div>
          <div class="col">
            <button type="button" class="btn btn-dark btn-lg" v-on:click="allReports">Kuva kõik raportid</button>
          </div>
          <div class="col">
            <button type="button" class="btn btn-dark btn-lg" v-on:click="allTasks">Kuva kinnitamata
              korrastusülesanded
            </button>
          </div>
        </div>
        <div class="tableTitle">
          <h3>Viimati koostatud raportid</h3>
        </div>
        <div class="table table-light table-bordered table-responsive" id="reportTable">
          <thead class="thead-dark">
          <tr>
            <th style="width: 30%">Kuupäev</th>
            <th style="width: 30%">Objekt</th>
            <th style="width: 30%">Peatöövõtja</th>
            <th style="width: 30%">TOM</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="report in reportList">
            <td>{{ report.date }}</td>
            <td>{{ report.constructionSiteName }}</td>
            <td>{{ report.mainContractorName }}</td>
            <td>{{ report.tom }} %</td>
          </tr>
          </tbody>
        </div>
      </div>
      <div v-if="roleId===3">
        <div class="windowHeader">
          <h2><i class="fa-solid fa-user-shield"></i> Tere {{ logInName.userFirstName }} {{ logInName.userMiddleName }}
            {{ logInName.userLastName }}! </h2>
        </div>
        <div class="tableTitle">
          <h3>Sinu kinnitamata korrastamisülesanded</h3>
        </div>
        <div class="table table-light table-bordered table-responsive" id="taskTable">
          <thead class="thead-dark">
          <tr>
            <th style="width: 15%">Objekt</th>
            <th style="width: 49%">Kirjeldus</th>
            <th style="width: 15%">Peatöövõtja</th>
            <th style="width: 15%">Tähtaeg</th>
            <th style="width: 15%"></th>
            <th style="width: 15%"></th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="task in userTaskList">
            <td>{{ task.constructionSiteName }}</td>
            <td style="word-break: break-word;">{{ task.description }}</td>
            <td>{{ task.mainContractorName }}</td>
            <td>{{ task.deadline }}</td>
            <td>
              <button v-on:click="getTaskPicture(task.taskId)" type="button" data-toggle="modal"
                      data-target="#exampleModal">
                <i class="fa-regular fa-image"></i></button>
            </td>
            <td><i class="fa-solid fa-arrow-right" v-on:click="newTaskResponse(task.taskId)"></i></td>
          </tr>
          </tbody>
        </div>

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
      </div>
    </div>
  </div>
</template>

<script>

import router from "@/router";

export default {
  name: "InspectorMainView",
  data: function () {
    return {
      userId: sessionStorage.getItem("userId"),
      logInName: {
        userFirstName: null,
        userMiddleName: null,
        userLastName: null,
      },
      logInRequest: {},
      roleId: Number(sessionStorage.getItem("roleId")),
      userTaskList: {},
      taskPicture: {},
      reportList: {},
      showError:false,
      errorMessage:""
    }
  },
  methods: {
    getLogInName: function () {
      this.$http.get("/account/login/name", {
        params: {
          userId: this.userId
        }
      })
          .then(response => {
            this.logInName = response.data
          })
          .catch(error => console.log(error.response.data))
    },
    newInspection: function () {
      router.push("/inspection/sites")
    },
    allTasks: function () {
      router.push("/inspector/alltasks")
    },
    allReports: function () {
      router.push("/inspector/allreports")
    },
    getAllUserTasks: function () {
      this.$http.get("/response/get/by/userid", {
        params: {
          userId: sessionStorage.getItem("userId")
        }
      })
          .then(response => {
            this.userTaskList = response.data;
          })
          .catch(error => {
            console.log(error.response.data)
          })
    },
    getTaskPicture: function (getTaskId) {
      this.$http.get("/image/task", {
        params: {
          taskId: getTaskId
        }
      })
          .then(response => {
            this.showError=false;
            this.taskPicture = response.data
          })
          .catch(error => {
            this.showError=false;
            console.log(error.response.data)
          })
    },
    getReportList: function () {
      this.$http.get("/response/report/last", {
        params: {
          userId: sessionStorage.getItem("userId")
        }
      })
          .then(response => {
            this.reportList = response.data
          })
          .catch(error => {
            console.log(error.response.data)
          })
    },
    newTaskResponse: function (id) {
      this.$http.get("/response/notexists",{
        params:{
          taskId:id
        }
      })
      .then(response=>{
        this.showError=false;
        sessionStorage.setItem("taskId", id)
        router.push("/taskresponse/new")
      })
      .catch(error=>{
        this.errorMessage = error.response.data.title + error.response.data.detail
        this.showError=true;
      })
    },
    logOut:function(){
      this.showError=false;
      router.push("/");
      sessionStorage.clear();
    }
  },
  mounted() {
    this.getLogInName();
    if (this.roleId === 3) {
      this.getAllUserTasks()
    }
    if (this.roleId === 2) {
      this.getReportList()
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

.col button {
  height: 20vh;
  width: 100%;
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 1.7em;
}

.row {
  width: 90%;
  margin-top: 5vh;
  margin-left: 5%;
}

h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 2.8em;
  margin-left: 6.2%;
  margin-top: 5%;
}

.tableTitle {
  border-bottom: black solid 4px;
  width: 80%;
  text-align: center;
  margin-top: 5vh;
  margin-left: 10%;
}

.tableTitle h3 {
  font-family: 'Akshar', sans-serif;
  color: black;
  font-size: 2.4em;
}

#taskTable {
  width: 750px;
  margin: auto;
  margin-top: 5%;
  border: 2px solid black;
  max-height: 500px;
  overflow-y: scroll;
}


#taskTable tbody {
  font-size: 0.75em;
}

#taskTable td {
  border: 1px solid grey;
}

#taskTable th {
  border: 1px solid grey;
}

h2 i {
  font-size: 1.2em;
}

i {
  font-size: 1.9em;
}

td button {
  border: 0;
  background-color: white;
}

#modalWindow {
  border: 4px solid black;
}

#reportTable {
  width: 600px;
  margin: 3% auto auto;
  border: 2px solid black;
  max-height: 500px;

}

#reportTable tbody {
  font-size: 0.7em;
}

#reportTable td {
  border: 1px solid grey;
}

#reportTable th {
  border: 1px solid grey;
}
#logOut{
  float: right;
  margin-top: 3vh;
  margin-right: 3vw;
  padding:5px;
  font-size: 1.2em;
  border: 2px solid black;
}
#errorMessage {
  text-align: center;
}

</style>