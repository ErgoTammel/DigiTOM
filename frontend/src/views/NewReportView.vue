<template>
<div id="all">
  <div id="window">
    <h2 class="uppercase">Ülevaatus ehitusobjektil {{constructionSiteInfo.siteName}} </h2>
    <h3><strong>Kuupäev:</strong> {{constructionSiteInfo.reportDate}}</h3>
    <h3><strong>Aadress:</strong> {{constructionSiteInfo.siteAddress}}</h3>
    <h3><strong>Peatöövõtja:</strong> {{constructionSiteInfo.companyName}}</h3>
    <table class="table table-light table-bordered table-responsive" id="incidentTable" >
      <thead class="thead-dark">
      <tr>
        <th style="width: auto">KONTROLLKOHT</th>
        <th style="width: 25%">KORRAS</th>
        <th style="width: 25%">MITTE-KORRAS</th>
      </tr>
      </thead>
      <tbody>
      <tr>

<!--        toggleWindowBlur function-->
        <th scope="row"><h4 class="rowHeading">1. Kukkumisohu vältimine, varinguoht, uppumisoht</h4></th>
      <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field1.safe}}</h4></h4></td>
      <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field1.notsafe}}</h4></h4></td>
      </tr>
      <tr>
        <th scope="row"><h4 class="rowHeading">2. Tellingud, redelid, liikumisteed</h4></th>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field2.safe}}</h4></h4></td>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field2.notsafe}}</h4></h4></td>
      </tr>
      <tr>
        <th scope="row"><h4 class="rowHeading">3. Ehitusmasinad tõsteseadmed ja käsitööriistad</h4></th>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field3.safe}}</h4></h4></td>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field3.notsafe}}</h4></h4></td>
      </tr>
      <tr>
        <th scope="row"><h4 class="rowHeading">4. Elekter ja valgustus</h4></th>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field4.safe}}</h4></h4></td>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field4.notsafe}}</h4></h4></td>
      </tr>
      <tr>
        <th scope="row"><h4 class="rowHeading">5. Üldine kord, olme- ja jäätmekäitlus</h4></th>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field5.safe}}</h4></h4></td>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field5.notsafe}}</h4></h4></td>
      </tr>
      <tr>
        <th scope="row"><h4 class="rowHeading">6. Ehitustöölised</h4></th>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field6.safe}}</h4></h4></td>
        <td><h4><i class="fa-solid fa-plus"></i><i class="fa-solid fa-minus"></i><h4 class="counter">{{counter.field6.notsafe}}</h4></h4></td>
      </tr>
      </tbody>
    </table>
    <div class="submitRow">
    <button type="button" class="btn btn-danger btn-lg" >Tühista ülevaatus</button>
    <button type="button" class="btn btn-primary btn-lg">Vaata üle ja kinnita</button>
    </div>
  </div>
  <div id="newTaskWindow" v-if="newTaskWindow">
<h2 id="newTaskWindowHeading">Sisesta leitud vea kirjeldus</h2>
  </div>
</div>
</template>

<script>
export default {
  name: "NewReportView",
  data:function(){
    return{
      newTaskWindow:false,
      constructionSiteInfo:{},
      counter:{
        field1:{
          safe:0,
          notsafe:0
        },
        field2:{
          safe:0,
          notsafe:0
        },
        field3:{
          safe:0,
          notsafe:0
        },
        field4:{
          safe:0,
          notsafe:0
        },
        field5:{
          safe:0,
          notsafe:0
        },
        field6:{
          safe:0,
          notsafe:0
        }
      }
    }
  },
  methods:{
    newReport: async function(){
      await this.$http.post("/report/add",null,{
        params:{
          siteId:sessionStorage.getItem("constructionSiteId")
        }
      })
          .then(response=>{
              sessionStorage.setItem("reportId", response.data)
          })
    },
    getConstructionSiteName: function(){
      this.$http.get("/construction-site/name", {
        params:{
          constructionSiteId:sessionStorage.getItem("constructionSiteId"),
          reportId:sessionStorage.getItem("reportId")
        }
      })
      .then(response=>{
        this.constructionSiteInfo=response.data
      }).catch(error=>error.response.data)
    },
    toggleWindowBlur:function(){
      if(document.getElementById("all").classList.contains("blur")){
        document.getElementById("all").classList.remove("blur");
      }else{
        document.getElementById("all").classList.add("blur");

      }

    }
  },
  mounted(){
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

.uppercase{
  text-transform: uppercase;
}
h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 3.5em;
  margin-left: 10%;
  margin-top: 5%;
}
h3{
  margin-left: 10%;
  margin-top: 1vh;
}
h4{
  margin-top:1%;
  margin-bottom:1%;
  margin-left: 5%;
}
h4 i{
  font-size:1.8em;
  border: 3px solid gray;
  color: grey;
  border-radius: 10%;
  padding:3%;
  display: inline;
  margin-right: 5%;

}
.counter{
  display: inline;
  font-size: 2.2em;
  margin-left: 5%;
}

#incidentTable{
  margin:auto;
  width: 900px;
  margin-top: 3%;
  border: 4px solid black;
}
#incidentTable thead{
  font-size: 1.6em;
}
#incidentTable tbody{
  font-size: 1.2em;
}
#incidentTable td{
  border:1px solid grey;
}
#incidentTable th{
  border:1px solid grey;
}
.rowHeading{
  margin-top:2%;
  font-size: 1em;
  font-weight: bold;
}

.submitRow{
  width: 100%;
  margin-left: 46%;
}
button{
  width: 18%;
  margin-top: 3%;
  margin-right: 3%;
  height: 3em;
  font-size: 1.5em;
}
#newTaskWindow{
  position: absolute;
  left: 50%;
  top: 90%;
  background-color:#44b0ff;
  border: 4px solid black;
  transform: translate(-50%,-50%);
  width: 60vw;
  height: 70vh;
  z-index: 1000;
}


 .blur {
  filter: blur(3px);
}

</style>