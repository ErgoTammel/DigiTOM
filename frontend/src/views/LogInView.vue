<template>
  <div>
    <header>
      <h1>DigiTom</h1>
    </header>
    <body id="back">

    <div id="logInWindow" v-if="loginScreen">
      <h2>Palun logige sisse või registreerige kasutaja!</h2>
      <div class="col">
        <div class="row">
          <label for="email">Email:</label>
          <input type="text" class="form-control" placeholder="E-mail" id="email">
        </div>
        <div class="row">
          <label for="Password">Password:</label>
          <input type="password" class="form-control" placeholder="Password" id="Password">
        </div>
      </div>
      <div class="row">
        <div class="col" id="loginButton">
          <button type="button" class="btn btn-primary btn-lg">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLogi
            sisse&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          </button>
          <button type="button" class="btn btn-secondary btn-lg" v-on:click="toggleLogInWindow">Registreeri kasutaja
          </button>
        </div>
      </div>
    </div>
    <div id="registrationWindow" v-if="!loginScreen">
      <h2>Registreerimiseks sisestage enda andmed.</h2>
      <div class="col">
        <div class="row">
          <label for="eesnimi">Eesnimi:</label>
          <input type="text" class="form-control" placeholder="Eesnimi" id="eesnimi"
                 v-model="registerRequest.firstName">
        </div>
        <div class="row">
          <label for="keskmineNimi"> Keskmine nimi:</label>
          <input type="text" class="form-control" placeholder="Keskmine nimi" id="keskmineNimi"
                 v-model="registerRequest.middleName">
        </div>
        <div class="row">
          <label for="perekonnanimi">Perekonnanimi:</label>
          <input type="text" class="form-control" placeholder="Perekonnanimi" id="perekonnanimi"
                 v-model="registerRequest.lastName">
        </div>
        <div class="row">
          <label for="ettevõtteNimi">Ettevõtte nimi:</label>
          <input type="text" class="form-control" placeholder="Ettevõtte nimi" id="ettevõtteNimi"
                 v-model="registerRequest.companyName">
        </div>
        <div class="row">
          <label for="ettevõtteReg">Ettevõtte registreerimisnumber:</label>
          <input type="text" class="form-control" placeholder="Ettevõtte registreerimisnumber" id="ettevõtteReg"
                 v-model="registerRequest.companyNumber">
        </div>
        <div class="row">
          <label for="telnr">Telefoninumber:</label>
          <input type="text" class="form-control" placeholder="Telefoninumber" id="telnr"
                 v-model="registerRequest.phoneNumber">
        </div>
        <div class="row">
          <label for="emailReg">Email:</label>
          <input type="text" class="form-control" placeholder="Email" id="emailReg"
                 v-model="registerRequest.email">
        </div>
        <div class="row">
          <label for="passwordReg">Password:</label>
          <input type="password" class="form-control" placeholder="Password" id="passwordReg"
                 v-model="registerRequest.password">
        </div>
        <div class="row" id="formRadio">
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input"
                   value="User" v-model="registerRequest.roleName" checked>
            <label class="custom-control-label" for="customRadioInline1">Tavakasutaja</label>
          </div>
          <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" id="customRadioInline2" name="customRadioInline1" class="custom-control-input"
                   value="Inspector" v-model="registerRequest.roleName">
            <label class="custom-control-label" for="customRadioInline2">Inspektor</label>
          </div>
        </div>
      </div>
      <div class="col" id="registrationButtonRow">
        <div class="row">
          <button id="registrationButton" type="button" class="btn btn-primary btn-lg" v-on:click="addNewAccount">
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspRegistreeru&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          </button>
          <button type="button" class="btn btn-secondary btn-lg" v-on:click="toggleLogInWindow">
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspTagasi&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          </button>
        </div>
      </div>
    </div>
    </body>
    <footer>
    </footer>
  </div>
</template>

<script>
export default {
  name: "LogInView",
  data: function () {
    return {
      loginScreen: true,
      registerRequest: {}
    }
  },
  methods: {
    toggleLogInWindow: function () {
      if (this.loginScreen) {
        this.loginScreen = false;
      } else {
        this.loginScreen = true;
        window.scrollTo(0, 0);
      }
    },
    addNewAccount: function () {
      this.$http.post("/registration/add",this.registerRequest)
          .then(response => {
            console.log(response.status);
            this.toggleLogInWindow();
          })
          .catch(error => console.log(error.response.data))
    }
  }
}
</script>

<style scoped>

#back {
  background-image: url("../assets/background.jpg");
  height: 150vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

header {
  height: 15vh;
  width: 100%;
  background-color: #44b0ff;
}

header h1 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 7vh;
  width: auto;
  text-align: left;
  padding-left: 3vw;
  padding-top: 3.5vh;
  letter-spacing: 3.5px;
}

h2 {
  font-family: 'Akshar', sans-serif;
  color: white;
  font-size: 5vh;
  margin-left: 5%;
  margin-top: 5%;
}

#logInWindow {
  position: absolute;
  width: 50vw;
  height: 55vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}

#registrationWindow {
  position: absolute;
  width: 50vw;
  height: 120vh;
  margin-top: 13vh;
  background-color: #44b0ff;
  left: 50%;
  transform: translate(-50%, 0);
  border: 2px solid black;
}

footer {
  height: 10vh;
  width: 100%;
  background-color: #44b0ff;
}

.col {
  width: 40%;
  margin-top: 2%;
  margin-left: 5%;
}

label {
  margin-top: 2%;
  margin-bottom: 2%;
}

button {
  margin-right: 5%;
  margin-top: 3%;
}

#formRadio {
  margin-top: 2.5vh;
}

#registrationButtonRow {
  width: 70%;
}


</style>