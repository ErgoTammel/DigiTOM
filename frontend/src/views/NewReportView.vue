<template>
  <div id="all">
    <div id="window" v-if="!newTaskWindow">
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
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(1)"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">2. Tellingud, redelid, liikumisteed</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(2)"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">3. Ehitusmasinad tõsteseadmed ja käsitööriistad</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(3)"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">4. Elekter ja valgustus</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(4)"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">5. Üldine kord, olme- ja jäätmekäitlus</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(5)"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
        </tr>
        <tr>
          <th scope="row"><h4 class="rowHeading">6. Ehitustöölised</h4></th>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newPositiveIncident"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
          <td>
            <h4><i class="fa-solid fa-plus" v-on:click="newNegativeIncident(6)"></i><i class="fa-solid fa-minus"></i><h4
                class="counter">0</h4></h4>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="submitRow">
        <button type="button" class="btn btn-danger btn-lg">Tühista ülevaatus</button>
        <button type="button" class="btn btn-primary btn-lg">Vaata üle ja kinnita</button>
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
        <button type="button" class="btn btn-dark btn-lg">Tühista</button>
        <button type="button" class="btn btn-primary btn-lg" v-on:click="addNewTask">Salvesta</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NewReportView",
  data: function () {
    return {
      newTaskWindow: false,
      safetyField: 0,
      constructionSiteInfo: {},
      allConstructionSiteCompanies: {},
      taskRequest: {
        selectedCompanyId: null,
        description: "",
        taskDate: null
      },
      pictureData: ""
    }
  },
  methods: {
    newReport: async function () {
      await this.$http.post("/report/add", null, {
        params: {
          siteId: sessionStorage.getItem("constructionSiteId")
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
    newPositiveIncident: function (safetyField) {
      this.$http.post("/inspection/incident/new", {
        safe: true,
        safetyFieldId: safetyField,
        reportId: sessionStorage.getItem("reportId")
      }).then().catch(error => {
        console.log(error.response.data)
      })
    },
    toggleNewTaskWindow: function () {
      this.newTaskWindow = !this.newTaskWindow;
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
    addNewTask: function () {
      this.$http.post("/inspection/task/new", {
        reportId: sessionStorage.getItem("reportId"),
        incidentId: sessionStorage.getItem("incidentId"),
        companyId: this.taskRequest.selectedCompanyId,
        description: this.taskRequest.description,
        deadline: this.taskRequest.taskDate
      })
          .then()
          .catch(error => console.log(error.response.data))
    },
    // addNewReportPicture: function () {
    //   this.$http
    // },
    handleImage: function (event) {
      const selectedImage = event.target.files[0];
      this.createBase64Image(selectedImage);
    },
    createBase64Image: function (fileObject) {
      const reader = new FileReader();
      reader.onload = () => {
        this.pictureData = reader.result;
      };
      reader.onerror = function(error){
        console.log(error);
      }
      reader.readAsDataURL(fileObject);
    }
  },
  mounted() {
    this.getConstructionSiteName();
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
  font-size: 3.5em;
  margin-left: 10%;
  margin-top: 5%;
}

h3 {
  margin-left: 10%;
  margin-top: 1vh;
}

h4 {
  margin-top: 1%;
  margin-bottom: 1%;
  margin-left: 5%;
}

h4 i {
  font-size: 1.8em;
  border: 3px solid gray;
  color: grey;
  border-radius: 10%;
  padding: 3%;
  display: inline;
  margin-right: 5%;

}

.counter {
  display: inline;
  font-size: 2.2em;
  margin-left: 5%;
}

#incidentTable {
  margin: auto;
  width: 900px;
  margin-top: 3%;
  border: 4px solid black;
}

#incidentTable thead {
  font-size: 1.6em;
}

#incidentTable tbody {
  font-size: 1.2em;
}

#incidentTable td {
  border: 1px solid grey;
}

#incidentTable th {
  border: 1px solid grey;
}

.rowHeading {
  margin-top: 2%;
  font-size: 1em;
  font-weight: bold;
}

.submitRow {
  width: 100%;
  margin-left: 46%;
}

#taskSubmitRow {
  width: 100%;
  margin-left: 46%;
}

button {
  width: 18%;
  margin-top: 3%;
  margin-right: 3%;
  height: 3em;
  font-size: 1.5em;
}

#newTaskWindow {
  position: absolute;
  left: 50%;
  top: 70%;
  background-color: #44b0ff;
  border: 4px solid black;
  transform: translate(-50%, -50%);
  width: 60vw;
  height: 85vh;
  z-index: 1000;
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
  font-size: 1.8em;
  height: 30%;
  margin-top: 2%;
  margin-bottom: 2%;
}

select {
  width: 40%;
}


</style>