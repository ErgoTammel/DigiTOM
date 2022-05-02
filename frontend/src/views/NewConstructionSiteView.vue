<template>
<div>
  <div id="firstNewConstructionSiteWindow" v-if="secondConstructionSite" >
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
          <select v-model="newConstructionSiteRequest.mainContractorCompanyId" class="custom-select" id="mainContractorSelect">
            <option selected>Peatöövõtja</option>
            <option v-for="company in allCompanyNames"  :value="company.companyId">{{company.companyName}}</option>
          </select>
        </div>
        <div class="row" id="submitRow">
          <button type="button" class="btn btn-dark btn-lg" v-on:click="routeNewInspection()">Tagasi</button>
          <button type="button" class="btn btn-primary btn-lg" v-on:click="addNewConstructionSite" >Edasi</button>
        </div>
    </div>
  </div>
        <div id="secondNewConstructionSiteWindow" v-if="!secondConstructionSite" >
          <h2>Lisa objektiga seotud alltöövõtjad</h2>
          <div class="col" id="subContractorCol">
            <div class="row">
            <select v-model="selectedSubContractorId" class="custom-select" id="subContractorSelect">
              <option selected>Alltöövõtja</option>
              <option v-for="company in allCompanyNames"  :value="company.companyId">{{company.companyName}}</option>
            </select>
              <button type="button" class="btn btn-dark btn-lg" v-on:click="addNewCompanyToList" >Lisa nimekirja</button>
            </div>
            <h1 v-for="subCompany in subContractorsList" >{{subCompany.name}}</h1>
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
      subContractorsList:{}

    }
  },
  methods: {
    toggleSecondConstructionSite: function () {
      this.secondConstructionSite = !this.secondConstructionSite;
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
      this.secondConstructionSite = !this.secondConstructionSite;
      this.$http.post("construction-site/new", this.newConstructionSiteRequest)
      .then(response=>{
        sessionStorage.setItem("constructionSiteId", response.data)
      })
      .catch(error=>{
        console.log(error.response.data)
      })
    },
    addNewCompanyToList:function(){
      this.$http.post("/construction-site/new/subcontractor", {
        params:{
          companyId:this.selectedSubContractorId,
          constructionSiteId:sessionStorage.getItem("constructionSiteId")
        }
      }).then(response=>{}).catch(error =>{
        console.log(error.response.data)
      })
      this.$http.get("/construction-site/all/companies", {
        params:{
          constructionSiteId:sessionStorage.getItem("constructionSiteId")
        }
      }).then(response=>{
        this.subContractorsList=response.data;
      }).catch(error=> console.log(error.response.data))
    }

    },
    mounted() {
      this.getAllCompanyNames();
    }
  }

</script>

<style scoped>
#firstNewConstructionSiteWindow{
  position: absolute;
  width: 70vw;
  height: 75vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}
#secondNewConstructionSiteWindow{
  position: absolute;
  width: 70vw;
  height: 75vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}
.col{
  width: 40%;
  margin-left: 6.2%;
}
.row{
  margin-top:5%;
}

h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 2.8em;
  margin-left: 6.2%;
  margin-top: 5%;
}
.row button{
  width: 40%;
  height: 8vh;
  margin-top: 5%;
  margin-right: 10%;
}
#submitRow{
  width: 40vw;
}
#subContractorSelect{
  width: 45%;
  margin-top: 3vh;
}
#subContractorCol{
  width: 70%;
}
#subContractorCol .row{
 margin-top: 2%;
}
#subContractorCol button{
  width: 40%;
  height: 7vh;
  margin-top: 2%;
  margin-left: 2vw;
}
</style>