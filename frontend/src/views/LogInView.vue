<template>
  <div>
    <header>
      <h1>DigiTom</h1>
    </header>
    <body id="back">

    <div id="window">
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
          <button type="button" class="btn btn-primary btn-lg">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLogi sisse&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
          <button type="button" class="btn btn-secondary btn-lg">Registreeri kasutaja</button>
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
  name: "LogInView"
}
</script>

<style scoped>

#back {
  background-image: url("../assets/background.jpg");
  height: 100vh;
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

#window {
  position: absolute;
  width: 50vw;
  height: 55vh;
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
.col{
  width: 40%;
  margin-top: 2%;
  margin-left: 5%;
}
label{
  margin-top: 2%;
  margin-bottom: 2%;
}
button{
  margin-right: 5%;
  margin-top: 3%;
}

</style>