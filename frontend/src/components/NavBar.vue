<template>
  <nav>      
    <v-app-bar flat app color="rgb(235, 235, 235)">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-app-bar-title class="text-uppercase">
        <span class="font-weight-light">Mail</span>
        <span>Server</span>
      </v-app-bar-title>
      <v-spacer></v-spacer>
      <v-btn flat color="grey">
        <span>Sign Out </span>
        <v-icon>mdi-logout-variant</v-icon>
      </v-btn>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" app class="indigo">
      <SideBar/>
    </v-navigation-drawer>
</nav>
</template>

<script>
  import SideBar from  './SideBar.vue';
  export default {
    components:{SideBar},
    data: () => ({
      drawer:true,
      openfrom: [],
      crudsfrom: [
        ['Create'],
        ['Read'],
        ['Update'],
        ['Delete'],
      ],
      opento: [],
      crudsto: [
        ['Create'],
        ['Read'],
        ['Update'],
        ['Delete'],
      ],
      openanytime: [],
      crudsanytime: [
        ['Create'],
        ['Read'],
        ['Update'],
        ['Delete'],
      ],
    }),
    methods: {
      searchEmails() {
      // Implement your logic to filter emails based on the search query
      // You may want to filter the emails in openfrom, opento, or openanytime arrays
      // For example, if you have an 'emails' array, you can filter it like this:
      this.openfrom = this.filterEmails(this.openfrom);
      this.opento = this.filterEmails(this.opento);
      this.openanytime = this.filterEmails(this.openanytime);
    },
    filterEmails(emailArray) {
      // Use the Array.filter method to filter emails based on the search query
      return emailArray.filter(email => {
        // Modify this condition based on your email structure and search criteria
        return email.title.toLowerCase().includes(this.searchQuery.toLowerCase());
      });
    },
    changeColorhasattachment() {
      var button = document.getElementById("hasattachmentbutton");
      button.classList.toggle("blue");
    },
    changeColorisunread() {
      var button = document.getElementById("isunreadbutton");
      button.classList.toggle("blue");
    },
  },
  }
</script>

<style scoped>
.Frombutton{
    /* border: 2px solid black; */
    width: 17%; 
    height: 10vh; 
}
.Tobutton{
    margin-left: 30px;
    /* border: 2px solid black; */
    width: 17%;     
    height: 10vh; 
}
.Anytimebutton{
    margin-left: 30px; 
    /* border: 2px solid black; */
    width: 17%; 
    height: 10vh; 
}

#hasattachmentbutton {
    margin-left: 30px; 
    background-color: rgb(178, 178, 178); 
    border: none;
    border: 2px solid black;
    color: black;
    cursor: pointer;
    width: 17%; 
    height: 10vh; 
}

#hasattachmentbutton.blue {
      background-color: blue; 
}
#isunreadbutton {
margin-left: 30px; 
  background-color: white; 
  /* padding: 10px; */
  border: none;
  border: 2px solid black;
  color: black;
  cursor: pointer;
  width: 17%; 
height: 10vh; 
}

#isunreadbutton.blue {
      background-color: blue; 
    }
.nav-bar{
    margin-top: 40px;
    display: flex;
    flex-direction: row;
    /* padding: 2vh 2vh  2vh 2vh; */
}
.Search {
  margin-left: 25%;
}
.Search input {
  padding: 5px;
  width: 50%;
  border: 2px solid aqua;
}

</style>