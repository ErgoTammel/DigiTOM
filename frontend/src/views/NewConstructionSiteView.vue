<template>
  <div>
    <div id="errorMessage" class="alert alert-danger" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
    <h3 id="logOut" v-on:click="logOut">Logi välja</h3>
    <div id="firstNewConstructionSiteWindow" v-if="secondConstructionSite">
      <h2>Sisesta uue objekti andmed.</h2>
      <div class="col">
        <div class="row">
          <label for="siteName">Objekti nimi</label>
          <input type="text" class="form-control" placeholder="Objekti nimi" id="siteName"
                 v-model="newConstructionSiteRequest.siteName">
        </div>
        <div class="row">
          <label for="siteAddress"> Objekti aadress</label>
          <input type="text" class="form-control" placeholder="Objekti aadress" id="siteAddress"
                 v-model="newConstructionSiteRequest.siteAddress">
        </div>
        <div class="row">
          <label for="mainContractorSelect"> Vali objekti peatöövõtja</label>
          <select v-model="newConstructionSiteRequest.mainContractorCompanyId" class="custom-select"
                  id="mainContractorSelect">
            <option selected>Peatöövõtja</option>
            <option v-for="company in allCompanyNames" :value="company.companyId">{{ company.companyName }}</option>
          </select>
        </div>
        <div class="row" id="submitRow">
          <button type="button" class="btn btn-dark btn-lg" v-on:click="routeNewInspection()">Tagasi</button>
          <button type="button" class="btn btn-primary btn-lg" v-on:click="addNewConstructionSite">Edasi</button>
        </div>
      </div>
    </div>
    <div id="secondNewConstructionSiteWindow" v-if="!secondConstructionSite">
      <h2>Lisa objektiga seotud alltöövõtjad</h2>
      <div class="col" id="subContractorCol">
        <div class="row">
          <select v-model="selectedSubContractorId" class="custom-select" id="subContractorSelect">
            <option selected>Alltöövõtja</option>
            <option v-for="company in allCompanyNames" :value="company.companyId">{{ company.companyName }}</option>

          </select>
          <button type="button" class="btn btn-dark btn-lg" v-on:click="addNewCompanyToList">Lisa nimekirja</button>
        </div>
      </div>
      <div id="listWindow">

        <h3 v-for="subCompany in subContractorsList">{{ subCompany.companyName }} <i class="fa-solid fa-square-xmark"
                                                                              v-on:click="deleteCompanyFromList(subCompany.companyId)"></i>
        </h3>
      </div>
      <div class="row" id="saveButtonRow">
        <button type="button" class="btn btn-dark btn-lg" v-on:click="toggleSecondConstructionSite">Tagasi</button>
        <button type="button" class="btn btn-primary btn-lg" v-on:click="routeNewInspection">Salvesta objekt</button>
      </div>

    </div>


  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "NewConstructionSiteView",
  data: function () {
    return {
      secondConstructionSite: true,
      allCompanyNames: {},
      newConstructionSiteRequest: {},
      selectedSubContractorId: 0,
      subContractorsList: {},
      errorMessage:"",
      showError:false
    }
  },
  methods: {
    toggleSecondConstructionSite: function () {
      this.secondConstructionSite = !this.secondConstructionSite;
      this.showError=false;
    },
    routeNewInspection: function () {
      router.push('/inspection/sites');
    },
    getAllCompanyNames: function () {
      this.$http.get("construction-site/all")
          .then(response => {
            this.allCompanyNames = response.data
          })
          .catch(error => {
            console.log(error.response.data)
          })
    },
    addNewConstructionSite: function () {
      this.$http.post("construction-site/new", this.newConstructionSiteRequest)
          .then(response => {
            sessionStorage.setItem("constructionSiteId", response.data)
          })
          .catch(error => {
            console.log(error.response.data)
          })
      this.secondConstructionSite = !this.secondConstructionSite;
    },
    addNewCompanyToList: async function () {
      await this.$http.post("/construction-site/new/subcontractor", null, {
        params: {
          companyId: this.selectedSubContractorId,
          constructionSiteId: sessionStorage.getItem("constructionSiteId")
        }
      }).then().catch(error => {
        this.errorMessage=error.response.data.title + error.response.data.detail;
        this.showError=true;
      })
       await this.$http.get("/construction-site/all/subcontractor", {
        params: {
          constructionSiteId: sessionStorage.getItem("constructionSiteId")
        }
      }).then(response => {
        this.subContractorsList = response.data;
      }).catch(error => console.log(error.response.data))
    },
    deleteCompanyFromList: async function (id) {
      await this.$http.delete("/construction-site/delete", {
        params: {
          companyId: id,
          siteId: sessionStorage.getItem("constructionSiteId")
        }
      }).then()
          .catch(error => console.log(error.response.data)
          )

      this.$http.get("/construction-site/all/subcontractor", {
        params: {
          constructionSiteId: sessionStorage.getItem("constructionSiteId")
        }
      }).then(response => {
        this.subContractorsList = response.data;
      }).catch(error => console.log(error.response.data))

    },
    logOut:function(){
      router.push("/");
      sessionStorage.clear();
    }
  },
  async mounted() {
    await this.getAllCompanyNames();
  }
}

</script>

<style scoped>
#firstNewConstructionSiteWindow {
  position: absolute;
  width: 70vw;
  height: 75vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}

#secondNewConstructionSiteWindow {
  position: absolute;
  width: 70vw;
  height: 80vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}

.col {
  width: 40%;
  margin-left: 6.2%;
}

.row {
  margin-top: 5%;
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
  color: black;
  font-size: 1.7em;
  margin-left: 3%;
  margin-top: 2%;
}

h3 i {
  margin-left: 1vw;

}

.row button {
  width: 40%;
  height: 6vh;
  margin-right: 10%;
}

#submitRow {
  width: 40vw;
}

#subContractorSelect {
  width: 45%;
  height: 6.2vh;
}

#subContractorCol {
  width: 70%;
}

#subContractorCol .row {
  margin-top: 4%;
}

#subContractorCol button {
  width: 40%;
  height: 6.2vh;
  margin-left: 2vw;
}

#listWindow {
  height: 40%;
  width: 60%;
  margin-left: 6.2%;
  margin-top: 4%;
  background-color: rgb(214, 214, 214);
  border: white 2px solid;
  overflow: scroll;
  overflow-x: hidden;
}

#saveButtonRow {
  margin-top: 5%;
  width: 70%;
  margin-left: 6.2%;
}

#saveButtonRow button {
  margin-right: 1vw;
  margin-top: 0%;
}
#errorMessage {
  text-align: center;
}
#logOut{
  float: right;
  margin-top: 3vh;
  margin-right: 3vw;
  padding:5px;
  font-size: 1.2em;
  border: 2px solid black;
}

</style>