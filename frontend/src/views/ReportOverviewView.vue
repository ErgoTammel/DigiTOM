<template>
  <div>
    <div class="window">
      <h2 class="uppercase">Ülevaatus ehitusobjektil {{ constructionSiteInfo.siteName }} </h2>
      <h3><strong>Kuupäev:</strong> {{ constructionSiteInfo.reportDate }}</h3>
      <h3><strong>Aadress:</strong> {{ constructionSiteInfo.siteAddress }}</h3>
      <h3><strong>Peatöövõtja:</strong> {{ constructionSiteInfo.companyName }}</h3>
      <div class="table table-light table-bordered table-responsive" id="taskTable">
        <thead class="thead-dark">
        <tr>
          <th style="width: 50%">Kirjeldus</th>
          <th style="width: 25%">Vastutaja</th>
          <th style="width: 25%">Tähtaeg</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="task in taskList">
          <td>{{ task.description }}</td>
          <td>{{ task.companyName }}</td>
          <td>{{ task.deadline }}</td>
        </tr>
        </tbody>
      </div>
      <div id="tomWindow">
        <div>
          <h4 style="display: inline;">Korras: {{ tomData.safeSum }}</h4>
          <h4 style="display: inline; margin-left: 5%;">Mitte-korras: {{ tomData.notSafeSum }}</h4>
        </div>
        <h4 style="margin-top: 2%;">TOM = {{ tomData.safeSum }} / {{ tomData.safeSum }} + {{ tomData.notSafeSum }} * 100
          = <strong>{{ tomData.tom }} %</strong></h4>
      </div>
      <div class="submitRow">
        <button v-on:click="endReport" type="button" class="btn btn-primary btn-lg">Lõpeta ülevaatus</button>
      </div>
    </div>
  </div>
</template>

<script>
import router from "@/router";
import MainView from "@/views/MainView";

export default {
  name: "ReportOverviewView",
  data: function () {
    return {
      constructionSiteInfo: {},
      taskList: {},
      tomData: {}
    }
  },
  methods: {
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
    getAllTasks: function () {
      this.$http.post("/inspection/report/overview", null, {
        params: {
          reportId: sessionStorage.getItem("reportId")
        }
      })
          .then(response => {
            this.taskList = response.data;
          })
          .catch(error => error.response.data)
    },
    getTomData: function () {
      this.$http.get("/inspection/report/result", {
        params: {
          reportId: sessionStorage.getItem("reportId")
        }
      }).then(response => {

        this.tomData = response.data;
        this.tomData.tom = response.data.tom.toFixed(2);
      })
          .catch(error => console.log(error.response.data))
    },
    endReport:function (){
      sessionStorage.removeItem("taskId");
      sessionStorage.removeItem("reportId");
      sessionStorage.removeItem("safetyField");
      sessionStorage.removeItem("constructionSiteId");
      sessionStorage.removeItem("incidentId");
      router.push('/main')
    }
  },
  mounted() {
    this.getConstructionSiteName();
    this.getAllTasks();
    this.getTomData();
  }
}
</script>

<style scoped>
.window {
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

#taskTable {
  width: 520px;
  margin: 3% auto auto;
  border: 4px solid black;
}

#taskTable thead {
  font-size: 1.5em;
}

#taskTable tbody {
  font-size: 1.2em;
}

#taskTable td {
  border: 1px solid grey;
}

#taskTable th {
  border: 1px solid grey;
}
#tomWindow{
  margin:auto;
  margin-top: 2vh;
  border:4px solid black;
  width: 520px;
  padding:2% 1%;
  background-color: white;
}

#tomWindow div{
  width: 100%;
  margin: auto;
}
.submitRow {
  margin-top: 5vh;
  padding-left: 39vw;
}
</style>