<template>
<div>
<div id="window">
  <div id="windowHeader">
    <h2>Tere {{logInName.userFirstName}} {{logInName.userMiddleName}} {{logInName.userLastName}}! </h2>
  </div>
  <div class="row">
    <div class="col">
      <button type="button" class="btn btn-dark btn-lg">Alusta uut objekti läbivaatust</button>
    </div>
    <div class="col">
      <button type="button" class="btn btn-dark btn-lg">Kuva raportite otsing</button>
    </div>
    <div class="col">
      <button type="button" class="btn btn-dark btn-lg">Kuva kinnitamata korrastusülesanded</button>
    </div>
  </div>
  <div id="tableTitle">
    <h3>Viimati koostatud raportid</h3>
  </div>
</div>
</div>
</template>

<script>

export default {
  name: "InspectorMainView",
  data:function(){
    return {
      userId:sessionStorage.getItem("userId"),
      logInName:{
      userFirstName:null,
      userMiddleName:null,
      userLastName:null,
      },
      logInRequest:{}
    }
  },
  methods:{
    getLogInName:function(){
      this.$http.get("/account/login/name",{
        params:{
          userId:this.userId
        }
      })
      .then(response =>{
        this.logInName=response.data
      })
      .catch(error => console.log(error.response.data))
    }
  },
  mounted(){
    this.getLogInName();
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

.col button{
  height: 20vh;
  width: 100%;
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 1.7em;
}
.row{
  width: 90%;
  margin-top:5vh;
  margin-left:5%;
}
h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 2.8em;
  margin-left: 6.2%;
  margin-top: 5%;
}
#tableTitle{
  border-bottom: black solid 4px;
  width: 80%;
  text-align: center;
  margin-top: 5vh;
  margin-left: 10%;
}
#tableTitle h3{
  font-family: 'Akshar', sans-serif;
  color: black;
  font-size: 2.4em;
}




</style>