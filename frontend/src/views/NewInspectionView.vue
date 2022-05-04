<template>
<div>
  <div  id="window">
    <div id="windowHeader">
      <h2>Vali inspekteeritav ehitusobjekt või loo uus.</h2>
    </div>
    <div id="siteTable">
      <button type="button" v-for="site in constructionSiteRespond" value="site.constructionSiteId" class="btn btn-light btn-lg">{{site.constructionSiteName}}</button>
      <button type="button" class="btn btn-primary" v-on:click="newConstructionSite()">Loo uus objekt +</button>
    </div>
  </div>


</div>
</template>
<script>
import router from "@/router";


export default {
  name: "NewInspectionView",
  data: function () {
    return {
      constructionSiteRespond: {},
      newConstructionSiteRequest:{}
    }
  },
  methods: {
    getConstructionSites: async function () {
      await this.$http.get("/inspection/sites", {
        params: {
          userId: sessionStorage.getItem("userId")
        }
      }).then(response => {
        this.constructionSiteRespond = response.data
      })
          .catch(error => console.log(error.response.data))
    },
    newConstructionSite:function(){
      router.push("/construction-site/new")
      }
  },
  mounted() {
    this.getConstructionSites();
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
#siteTable{
  width: 92%;
  height: 50%;
  margin:auto;
}
#siteTable button{
  width: 28%;
  height: 17vh;
  margin:2.6%;
  font-size: 1.7em;
}



</style>