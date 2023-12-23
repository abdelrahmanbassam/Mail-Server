<template>
  <v-app>
    <!-- <SideBar/> -->
    <v-toolbar-side-icon class="grey--text"  @click="drawer = !drawer"></v-toolbar-side-icon>

    <NavBar/>

    <v-content>
      <router-view/>
    </v-content>
  </v-app>
</template>


<script>
  import NavBar from './components/NavBar.vue';
  export default {
    components:{NavBar},
  }
</script>

<style>
</style>
