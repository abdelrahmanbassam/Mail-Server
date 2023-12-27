<template>
  <nav>      
    <v-app-bar flat app color="rgb(235, 235, 235)">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-app-bar-title class="text-uppercase">
        <span class="font-weight-light">Mail</span>
        <span>Server</span>
      </v-app-bar-title>
      <v-btn flat color="grey" @click="signOut">
        <span>Sign Out </span>
        <v-icon>mdi-logout-variant</v-icon>
      </v-btn>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app class="indigo">
      <SideBar />
    </v-navigation-drawer>
</nav>
</template>

<script>
  import SideBar from  './SideBar.vue';
  export default {
    components:{SideBar},
    data: () => ({
      drawer:true,
    }),
    methods:{
      signOut(){
        this.$router.push('/');
        localStorage.removeItem('user');
      }
    }
  }
</script>

<style scoped>
.nav-bar{
    margin-top: 40px;
    display: flex;
    flex-direction: row;
    /* padding: 2vh 2vh  2vh 2vh; */
}
.Search {
    margin-left: 10%;
    margin-top: 10px; /* Adjust the margin-top as needed */
    width: 50%;
  }

  .Search input {
    padding: 5px;
    width: 50%;
    border: 2px solid white;
    background-color: white;
  }
</style>