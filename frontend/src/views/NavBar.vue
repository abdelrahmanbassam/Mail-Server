<template>
    <div class="nav-bar">
    <div class="Frombutton">
    <v-card
      class="mx-auto"
    >
      <v-list v-model:opened="openfrom">
        <!-- <v-list-item prepend-icon="mdi-home" title="Home"></v-list-item> -->
  
        <v-list-group value="Users">
          <template v-slot:activator="{ props }">
            <!-- <v-list-item
              v-bind="props"
              prepend-icon="mdi-account-circle"
              title="From"
            ></v-list-item> -->
            <v-list-item v-bind="props" title="From"></v-list-item>
          </template>

            <v-list-item
              v-for="([title, icon], i) in crudsfrom"
              :key="i"
              :value="title"
              :title="title"
              :prepend-icon="icon"
            ></v-list-item>
          </v-list-group>
      </v-list>
    </v-card>
</div>
<div class="Tobutton">
    <v-card
      class="mx-auto"
    >
      <v-list v-model:opened="opento">
        <!-- <v-list-item prepend-icon="mdi-home" title="Home"></v-list-item> -->
  
        <v-list-group value="Users">
          <template v-slot:activator="{ props }">
            <v-list-item
              v-bind="props"
              prepend-icon="mdi-account-circle"
              title="To"
            ></v-list-item>
          </template>

            <v-list-item
              v-for="([title, icon], i) in crudsto"
              :key="i"
              :value="title"
              :title="title"
              :prepend-icon="icon"
            ></v-list-item>
          </v-list-group>
      </v-list>
    </v-card>
</div>
<div class="Anytimebutton">
    <v-card
      class="mx-auto"
    >
      <v-list v-model:opened="openanytime">
        <!-- <v-list-item prepend-icon="mdi-home" title="Home"></v-list-item> -->
  
        <v-list-group value="Users">
          <template v-slot:activator="{ props }">
            <v-list-item
              v-bind="props"
              prepend-icon="mdi-account-circle"
              title="Anytime"
            ></v-list-item>
          </template>
        
            <v-list-item
              v-for="([title, icon], i) in crudsanytime"
              :key="i"
              :value="title"
              :title="title"
              :prepend-icon="icon"
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
        ['Management', 'mdi-account-multiple-outline'],
        ['Settings', 'mdi-cog-outline'],
      ],
      crudsfrom: [
        ['Create', 'mdi-plus-outline'],
        ['Read', 'mdi-file-outline'],
        ['Update', 'mdi-update'],
        ['Delete', 'mdi-delete'],
      ],
      opento: [],
      adminsto: [
        ['Management', 'mdi-account-multiple-outline'],
        ['Settings', 'mdi-cog-outline'],
      ],
      crudsto: [
        ['Create', 'mdi-plus-outline'],
        ['Read', 'mdi-file-outline'],
        ['Update', 'mdi-update'],
        ['Delete', 'mdi-delete'],
      ],
      openanytime: [],
      adminsanytime: [
        ['Management', 'mdi-account-multiple-outline'],
        ['Settings', 'mdi-cog-outline'],
      ],
      crudsanytime: [
        ['Create', 'mdi-plus-outline'],
        ['Read', 'mdi-file-outline'],
        ['Update', 'mdi-update'],
        ['Delete', 'mdi-delete'],
      ],
    }),
    methods: {
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
    /* background: rgb(197, 102, 24); */
    /* margin-left: 150%; */
    border: 2px solid black;
    width: 300px; /* Set the desired width */
    height: 70px; /* Set the desired height */
}
.Tobutton{
    /* background: rgb(103, 8, 228); */
    margin-left: 30px;
    border: 2px solid black;
    width: 300px; /* Set the desired width */
    height: 70px; /* Set the desired height */
}
.Anytimebutton{
    /* background: rgb(197, 102, 24) ; */
    margin-left: 30px; 
    border: 2px solid black;
    width: 300px; /* Set the desired width */
    height: 70px; /* Set the desired height */
}

#hasattachmentbutton {
    margin-left: 30px; 
      background-color: white; /* Initial color */
      padding: 10px;
      border: none;
      border: 2px solid black;
      color: black;
      cursor: pointer;
      width: 300px; /* Set the desired width */
    height: 70px; /* Set the desired height */
    }

#hasattachmentbutton.blue {
      background-color: blue; /* Color when clicked */
    }
    #isunreadbutton {
    margin-left: 30px; 
      background-color: white; /* Initial color */
      padding: 10px;
      border: none;
      border: 2px solid black;
      color: black;
      cursor: pointer;
      width: 300px; /* Set the desired width */
    height: 70px; /* Set the desired height */
    }

#isunreadbutton.blue {
      background-color: blue; /* Color when clicked */
    }
.nav-bar{
    /* background: rgb(245, 228, 228); */
    display: flex;
    flex-direction: row;
    padding: 5vh 2vh  2vh 2vh;
    margin-left: 10%;
    /* height: 10vh;
    width: 40vh; */
}

</style>