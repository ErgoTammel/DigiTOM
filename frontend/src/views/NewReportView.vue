<template>
  <div id="all">
    <div id="errorMessage" class="alert alert-danger" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
    <div id="window" v-if="!newTaskWindow && !deleteTaskWindow">
      <h2 class="uppercase">Ülevaatus ehitusobjektil {{ constructionSiteInfo.siteName }} </h2>
      <h3><strong>Kuupäev:</strong> {{ constructionSiteInfo.reportDate }}</h3>
      <h3><strong>Aadress:</strong> {{ constructionSiteInfo.siteAddress }}</h3>
      <h3><strong>Peatöövõtja:</strong> {{ constructionSiteInfo.companyName }}</h3>
      <table class="table table-light table-bordered table-responsive" id="incidentTable">
        <thead class="thead-dark">
        <tr>
          <th style="width: auto">KONTROLLKOHT</th>
          <th style="width: 25%">KORRAS</th>
          <th style="width: 25%">MITTE-KORRAS</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th scope="row"><h4 class="rowHeading">1. Kukkumisohu vältimine, varinguoht, uppumisoht</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident(1)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="removeTrueIncident(1)"></i>
              <h4
                  class="counter">{{ counter.field1.safe }}</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(1)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="openDeleteTaskWindow(1)"></i>
              <h4
                  class="counter">{{ counter.field1.notSafe }}</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">2. Tellingud, redelid, liikumisteed</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident(2)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="removeTrueIncident(2)"></i>
              <h4
                  class="counter">{{ counter.field2.safe }}</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(2)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="openDeleteTaskWindow(2)"></i>
              <h4
                  class="counter">{{ counter.field2.notSafe }}</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">3. Ehitusmasinad tõsteseadmed ja käsitööriistad</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident(3)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="removeTrueIncident(3)"></i>
              <h4
                  class="counter">{{ counter.field3.safe }}</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(3)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="openDeleteTaskWindow(3)"></i>
              <h4
                  class="counter">{{ counter.field3.notSafe }}</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">4. Elekter ja valgustus</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident(4)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="removeTrueIncident(4)"></i>
              <h4
                  class="counter">{{ counter.field4.safe }}</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(4)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="openDeleteTaskWindow(4)"></i>
              <h4
                  class="counter">{{ counter.field4.notSafe }}</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">5. Üldine kord, olme- ja jäätmekäitlus</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident(5)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="removeTrueIncident(5)"></i>
              <h4
                  class="counter">{{ counter.field5.safe }}</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(5)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="openDeleteTaskWindow(5)"></i>
              <h4
                  class="counter">{{ counter.field5.notSafe }}</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">6. Ehitustöölised</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident(6)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="removeTrueIncident(6)"></i>
              <h4
                  class="counter">{{ counter.field6.safe }}</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(6)"></i><i class="fa-solid fa-minus"
                                                                                       v-on:click="openDeleteTaskWindow(6)"></i>
              <h4
                  class="counter">{{ counter.field6.notSafe }}</h4></h4>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="submitRow">
        <button type="button" class="btn btn-danger btn-lg" v-on:click="discardReport">Tühista ülevaatus</button>
        <button type="button" class="btn btn-primary btn-lg" v-on:click="pushReportOverview">Vaata üle ja kinnita
        </button>
      </div>
    </div>
    <div id="newTaskWindow" v-if="newTaskWindow">
      <h2 id="newTaskWindowHeading">Lisa uus korrastamisülesanne </h2>
      <div class="col">
        <div id="descriptionInputRow" class="row">
          <label for="descriptionInput">Sisesta leitud puuduse kirjeldus</label>
          <textarea id="descriptionInput" v-model="taskRequest.description"
                    placeholder="Leitud puuduse kirjeldus."></textarea>
        </div>
        <div class="row">
          <label for="descriptionInput">Sisesta vastutav ettevõte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
          <select class="custom-select" v-model="taskRequest.selectedCompanyId" id="companyInput">
            <option v-for="company in allConstructionSiteCompanies" :value="company.companyId">
              {{ company.companyName }}
            </option>
          </select>
        </div>
        <div class="row">
          <label for="dateInput">Sisesta korrastamisülesande tähtaeg</label>
          <select class="custom-select" v-model="taskRequest.taskDate" id="dateInput">
            <option value=0>Täna</option>
            <option value=1>Homme</option>
            <option value=2>Ülehomme</option>
            <option value=3>3 päeva pärast</option>
            <option value=4>4 päeva pärast</option>
            <option value=5>5 päeva pärast</option>
            <option value=6>6 päeva pärast</option>
            <option value=7>7 päeva pärast</option>
            <option value=14>14 päeva pärast</option>
          </select>
        </div>
        <div class="row">
          <label for="dateInput">Sisesta puudusest pilt&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
          <input type="file" @change="handleImage" accept="image/x-png,image/jpeg">
        </div>
      </div>
      <div class="row" id="taskSubmitRow">
        <button type="button" class="btn btn-dark btn-lg" v-on:click="toggleNewTaskWindow" n id="cancelButton">Tühista</button>
        <button type="button" class="btn btn-primary btn-lg" v-on:click="addNewTask" id="saveButton">Salvesta</button>
      </div>
    </div>
    <div id="deleteTaskWindow" v-if="deleteTaskWindow">
      <h2>Tee valikud kustutamiseks</h2>
      <div class="table table-light table-bordered table-responsive" id="taskTable">
        <thead class="thead-dark">
        <tr>
          <th style="width: 50%">Kirjeldus</th>
          <th style="width: 25%">Vastutaja</th>
          <th style="width: 15%">Tähtaeg</th>
          <th style="width: 10%">Kustuta</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="task in removeTaskListResponse">
          <td>{{ task.description }}</td>
          <td>{{ task.companyName }}</td>
          <td>{{ task.deadline }}</td>
          <td><i id="deleteButton" class="fa-solid fa-xmark" v-on:click="deleteIncident(task.taskId)"></i></td>
        </tr>
        </tbody>
      </div>
      <div id="deleteTaskSubmit">
        <button type="button" class="btn btn-primary btn-lg" v-on:click="updateCounterAfterIncidentDelete"
                id="saveTaskDeleteButton">Jätka
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "NewReportView",
  data: function () {
    return {
      newTaskWindow: false,
      deleteTaskWindow: false,
      constructionSiteInfo: {},
      allConstructionSiteCompanies: {},
      taskRequest: {
        selectedCompanyId: null,
        description: "",
        taskDate: null
      },
      pictureData: "",
      counter: {
        field1: {
          safe: 0,
          notSafe: 0
        },
        field2: {
          safe: 0,
          notSafe: 0
        },
        field3: {
          safe: 0,
          notSafe: 0
        },
        field4: {
          safe: 0,
          notSafe: 0
        },
        field5: {
          safe: 0,
          notSafe: 0
        },
        field6: {
          safe: 0,
          notSafe: 0
        }
      },
      newTaskSafetyField: 0,
      removeTaskListResponse: {},
      errorMessage: "",
      showError: false
    }
  },
  methods: {
    newReport: async function () {
      await this.$http.post("/report/add", null, {
        params: {
          siteId: sessionStorage.getItem("constructionSiteId"),
          userId: sessionStorage.getItem("userId")
        }
      })
          .then(response => {
            sessionStorage.setItem("reportId", response.data)
          })
    },
    getConstructionSiteName: function () {
      this.$http.get("/construction-site/name", {
        params: {
          constructionSiteId: sessionStorage.getItem("constructionSiteId"),
          reportId: sessionStorage.getItem("reportId")
        }
      })
          .then(response => {
            this.constructionSiteInfo = response.data
          }).catch(error => error.response.data)
    },
    newNegativeIncident: async function (safetyField) {
      this.newTaskSafetyField = safetyField;
      await this.getAllSiteCompanies();
      this.$http.post("/inspection/incident/new", {
        safe: false,
        safetyFieldId: safetyField,
        reportId: sessionStorage.getItem("reportId")
      }).then(response => {
        sessionStorage.setItem("incidentId", response.data)
      }).catch(error => {
        console.log(error.response.data)
      })
      this.toggleNewTaskWindow()


    },
    newPositiveIncident: async function (safetyField) {
      await this.$http.post("/inspection/incident/new", {
        safe: true,
        safetyFieldId: safetyField,
        reportId: sessionStorage.getItem("reportId")
      }).then().catch(error => {
        console.log(error.response.data)
      })
      this.updateCounter(safetyField, true);
    },
    toggleNewTaskWindow: function () {
      this.newTaskWindow = !this.newTaskWindow;
      this.showError = false;
    },
    getAllSiteCompanies: function () {
      this.$http.get("/construction-site/all/company", {
        params: {
          constructionSiteId: sessionStorage.getItem("constructionSiteId")
        }
      })
          .then(response => {
            this.allConstructionSiteCompanies = response.data
          }).catch(error => console.log(error.response.data))
    },
    addNewTask: async function () {
      await this.$http.post("/inspection/task/new", {
        reportId: sessionStorage.getItem("reportId"),
        incidentId: sessionStorage.getItem("incidentId"),
        companyId: this.taskRequest.selectedCompanyId,
        description: this.taskRequest.description,
        deadline: this.taskRequest.taskDate
      })
          .then(response => {
            sessionStorage.setItem("taskId", response.data)
            this.updateCounter(this.newTaskSafetyField, false);
            this.addNewReportPicture();
            this.toggleNewTaskWindow();
          })
          .catch(error => {
            this.errorMessage = error.response.data.title + error.response.data.detail;
            this.showError = true;
          })


    },
    addNewReportPicture: function () {
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
    updateCounter: function (safetyField, isSafe) {
      this.$http.post("/inspection/counter/incident", {
        reportId: sessionStorage.getItem("reportId"),
        safetyFieldId: safetyField,
        safe: isSafe
      })
          .then(response => {
            switch (Number(safetyField)) {
              case 1:
                if (isSafe) {
                  this.counter.field1.safe = response.data;
                } else {
                  this.counter.field1.notSafe = response.data;
                }
                break;
              case 2:
                if (isSafe) {
                  this.counter.field2.safe = response.data;
                } else {
                  this.counter.field2.notSafe = response.data;
                }
                break;
              case 3:
                if (isSafe) {
                  this.counter.field3.safe = response.data;
                } else {
                  this.counter.field3.notSafe = response.data;
                }
                break;
              case 4:
                if (isSafe) {
                  this.counter.field4.safe = response.data;
                } else {
                  this.counter.field4.notSafe = response.data;
                }
                break;
              case 5:
                if (isSafe) {
                  this.counter.field5.safe = response.data;
                } else {
                  this.counter.field5.notSafe = response.data;
                }
                break;
              case 6:
                if (isSafe) {
                  this.counter.field6.safe = response.data;
                } else {
                  this.counter.field6.notSafe = response.data;
                }
                break;
              default:
                alert("ERROR ")
            }
          })
          .catch(error => console.log(error.response.data))
    },
    toggleDeleteTaskWindow: function () {
      this.deleteTaskWindow = !this.deleteTaskWindow;
      this.errorMessage = false;
    },
    updateDeleteTaskWindow: function (safetyField) {
      this.$http.post("/inspection/incident/false", {
        reportId: sessionStorage.getItem("reportId"),
        safetyFieldId: safetyField,
        safe: false
      }).then(response => {
        this.removeTaskListResponse = response.data;
      }).catch(error => console.log(error.response.data))
    },
    deleteIncident: async function (taskIdParam) {
      await this.$http.delete("/inspection/incident", {
        params: {
          taskId: taskIdParam
        }
      }).then()
          .catch(error => error.response.data)
      this.updateDeleteTaskWindow(sessionStorage.getItem("safetyField"));

    },
    openDeleteTaskWindow: async function (safetyField) {
      sessionStorage.setItem("safetyField", safetyField);
      this.updateDeleteTaskWindow(safetyField);
      this.toggleDeleteTaskWindow();
    },
    updateCounterAfterIncidentDelete: function () {
      this.updateCounter(sessionStorage.getItem("safetyField"), false);
      this.toggleDeleteTaskWindow();


    },
    discardReport: async function () {
     await this.$http.delete("/inspection/report", {
        params: {
          reportId: sessionStorage.getItem("reportId")
        }
      })
          .then()
          .catch(error => error.response.data)
      sessionStorage.removeItem("taskId");
      sessionStorage.removeItem("reportId");
      sessionStorage.removeItem("safetyField");
      sessionStorage.removeItem("constructionSiteId");
      sessionStorage.removeItem("incidentId");
      router.push('/main');
    },
    removeTrueIncident: async function (safetyField) {
      await this.$http.post("/inspection/counter/incident/delete", {
        reportId: sessionStorage.getItem("reportId"),
        safetyFieldId: safetyField,
        safe: true
      })
          .then()
          .catch(error => {
            console.log(error.response.data)
          })
      this.updateCounter(safetyField, true);

    },
    pushReportOverview: function () {
      this.$http.get("/inspection/checkifvalid", {
        params: {
          reportId: sessionStorage.getItem("reportId")
        }
      })
      .then(response=>{
        router.push('/report/overview')
      }).catch(error=>{
        this.errorMessage=error.response.data.title + error.response.data.detail;
        this.showError=true;
      })
    }
  },
  async mounted() {
   await this.getConstructionSiteName();
    this.newReport();
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

.uppercase {
  text-transform: uppercase;
}

h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 3em;
  margin-left: 10%;
  margin-top: 5%;
}

h3 {
  font-size: 1.2em;
  margin-left: 10%;
  margin-top: 1vh;
}

h4 {
  margin-top: 1%;
  margin-bottom: 1%;
  margin-left: 5%;
}

h4 i {
  font-size: 1.5em;
  border: 3px solid gray;
  color: grey;
  border-radius: 10%;
  padding: 2%;
  display: inline;
  margin-right: 5%;

}

.counter {
  display: inline;
  font-size: 1.5em;
  margin-left: 5%;
}

#incidentTable {
  width: 700px;
  margin: 3% auto auto;
  border: 4px solid black;
}

#incidentTable thead {
  font-size: 1.2em;
}

#incidentTable tbody {
  font-size: 0.9em;
}

#incidentTable td {
  border: 1px solid grey;
}

#incidentTable th {
  border: 1px solid grey;
}

#taskTable {
  width: 700px;
  margin: 3% auto auto;
  border: 4px solid black;
}

#taskTable thead {
  font-size: 1.2em;
}

#taskTable tbody {
  font-size: 0.9em;
}

#taskTable td {
  border: 1px solid grey;
}

#taskTable th {
  border: 1px solid grey;
}


.rowHeading {
  margin-top: 2%;
  font-size: 1em;
  font-weight: bold;
}

.submitRow {
  padding-left: 30vw;
}

#taskSubmitRow {
  width: 54%;
  margin-left: 46%;
}

#deleteTaskSubmit {
  width: 54%;
  margin-left: 58%;
}

button {
  width: 35%;
  margin-top: 5%;
  margin-right: 3%;
  height: 3em;
  font-size: 1em;
}

#newTaskWindow {
  position: absolute;
  left: 50%;
  top: 70%;
  background-color: #44b0ff;
  border: 4px solid black;
  transform: translate(-50%, -50%);
  width: 60vw;
  height: 88vh;
  z-index: 1000;
}

#deleteTaskWindow {
  position: absolute;
  left: 50%;
  top: 70%;
  background-color: #44b0ff;
  border: 4px solid black;
  transform: translate(-50%, -50%);
  width: 60vw;
  height: 88vh;
  z-index: 1000;
}

#deleteButton {
  margin-left: 23%;
  font-size: 2.1em;
  border: 2px solid black;
  border-radius: 10%;
  padding: 3% 13% 3% 10%;
}

.col {
  margin-left: 10%;
  width: 40%;

}

.col #descriptionInputRow {
  width: 100%;
  height: 20vh;
  margin-top: 1%;

}

#descriptionInput {
  width: 100%;
  margin-top: 1%;
  height: 60%;
}

label {
  font-family: 'Akshar', sans-serif;
  font-weight: bold;
  font-size: 1.5em;
  height: 30%;
  margin-top: 2%;
  margin-bottom: 2%;
}

select {
  width: 40%;
}

#errorMessage {
  text-align: center;
}

</style>