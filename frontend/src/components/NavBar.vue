<template>
  <div class="Search">
      <input v-model="searchQuery" type="text" placeholder="Search emails" @input="searchEmails" />
    </div>
    <div class="nav-bar">
      <!-- <v-card class="mx-auto" color="info">

      </v-card> -->
    <div class="Frombutton">
    <v-card
      class="mx-auto"
      color="info"
    >
      <v-list :opened="openfrom">
        <v-list-group value="Users">
          <template v-slot:activator="{ props }">
            <v-list-item v-bind="props" title="From"></v-list-item>
          </template>

            <v-list-item
              v-for="(title, i) in crudsfrom"
              :key="i"
              :value="title"
              :title="title"
            ></v-list-item>
          </v-list-group>
      </v-list>
    </v-card>
</div>
<div class="Tobutton">
    <v-card
      class="mx-auto"
      outlined
    >
      <v-list :opened="opento">  
        <v-list-group value="Users">
          <template v-slot:activator="{ props }">
            <v-list-item
              v-bind="props"
              title="To"
            ></v-list-item>
          </template>

            <v-list-item
              v-for="(title, i) in crudsto"
              :key="i"
              :value="title"
              :title="title"
            ></v-list-item>
          </v-list-group>
      </v-list>
    </v-card>
</div>
<div class="Anytimebutton">
    <v-card
      class="mx-auto"
      outlined
    >
      <v-list :opened="openanytime">  
        <v-list-group value="Users">
          <template v-slot:activator="{ props }">
            <v-list-item
              v-bind="props"
              title="Anytime"
            ></v-list-item>
          </template>
        
            <v-list-item
              v-for="(title, i) in crudsanytime"
              :key="i"
              :value="title"
              :title="title"
            ></v-list-item>
          </v-list-group>
      </v-list>
    </v-card>
</div>
<button id="hasattachmentbutton" @click="changeColorhasattachment">Has attachment</button>
<button id="isunreadbutton" @click="changeColorisunread">Is unread</button>
</div>
  </template>

<script>
  export default {
    data: () => ({
      openfrom: [],
      adminsfrom: [
        ['Management'],
        ['Settings'],
      ],
      crudsfrom: [
        ['Create'],
        ['Read'],
        ['Update'],
        ['Delete'],
      ],
      opento: [],
      adminsto: [
        ['Management'],
        ['Settings'],
      ],
      crudsto: [
        ['Create'],
        ['Read'],
        ['Update'],
        ['Delete'],
      ],
      openanytime: [],
      adminsanytime: [
        ['Management'],
        ['Settings'],
      ],
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
    background-color: white; 
    /* padding: 10px; */
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