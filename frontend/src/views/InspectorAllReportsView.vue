<template>
  <div>
    <div id="window">
      <h2>Kõik loodud raportid</h2>

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
          <td>{{ report.tom }}</td>
        </tr>
        </tbody>
      </div>
      <div class="row" id="taskSubmitRow">
        <button type="button" class="btn btn-dark btn-lg" v-on:click="returnMain">Tagasi</button>
        <button type="button" class="btn btn-primary btn-lg"v-on:click="newReport">Uus ülevaatus</button>
      </div>
    </div>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "InspectorAllReportsView",
  data:function(){
    return {
      reportList:{}
    }
  },
  methods:{
    returnMain:function(){
      router.push("/main")
    },
    newReport: function(){
      router.push("/inspection/sites")
    },
    allReports: function (){
      this.$http.get("/response/report/search/userid", {
        params:{
          userId:sessionStorage.getItem("userId")
        }
      })
      .then(response=>{
        this.reportList=response.data
      })
      .catch(error=>console.log(error.response.data))
    }

  },
  mounted() {
    this.allReports()
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
#reportTable{
  width:600px;
  margin: 5% auto auto;
  border: 2px solid black;
  max-height: 500px;
  overflow-y: scroll;

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
#taskSubmitRow {
  width: 54%;
  margin-left: 35%;
}
button {
  width: 35%;
  margin-top: 5%;
  margin-right: 3%;
  height: 3em;
  font-size: 1em;
}




</style>