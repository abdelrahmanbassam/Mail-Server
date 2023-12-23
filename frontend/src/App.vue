<template>
  <v-app>
    <NavBar/>
    <!-- <MailListView/> -->
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>


<script>
  import NavBar from './components/NavBar.vue';
  // import MailListView from './views/mails/MailListView.vue';
  export default {
    components:{NavBar},
  }
</script>

<style>
</style>
