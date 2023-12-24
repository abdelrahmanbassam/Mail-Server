<template>
    <div>
        <NavBar @navigatoTO="changeList"/>
        <v-toolbar>
      <v-text-field v-model="searchQuery" label="Search" class="mx-2"></v-text-field>
      <v-select
        v-model="sortKey"
        :items="['importance', 'date']"
        label="Sort by"
        class="mx-2"
        clearable
      ></v-select>
      <v-select
        v-model="filterKey"
        :items="['from', 'subject']"
        label="flter by"
        class="mx-2"
        clearable
      ></v-select>

    </v-toolbar>
        <v-toolbar v-if="selectedMails.length > 0">
        <v-btn color="error" @click="deleteSelectedMails">
            <v-icon>mdi-delete</v-icon>
            Delete
        </v-btn>
        <!-- <v-btn color="primary" @click="moveSelectedMails"> -->
            <v-icon>mdi-folder-move</v-icon>
        <v-select
            v-model="selectedFolders"
            :items="folders"
            label="Move to"
            class="mx-2"
            multiple
            clearable
        ></v-select>
            <!-- Move -->
        <!-- </v-btn> -->
            
        </v-toolbar>
        <v-list class="mail-list">
            <div v-for="mail in user?.folders.inbox.emails" :key="mail" class="mail">
                <v-checkbox
                v-model="selectedMails"
                :label="mail"
                :value="mail"
                ></v-checkbox> 
                <v-list-item :value="mail"  @click="df">
                <div  class="bs">
                    <p class="truncate">{{ mail.from }}</p>
                    <p class="truncate">{{ mail.subject }}</p>
                    <p class="truncate">{{ mail.date }}</p>
                </div>
            </v-list-item>
        </div>
    </v-list>
</div>
</template>

<script>
  import NavBar from '../../components/NavBar.vue';
  export default {
    components:{NavBar},
    data() {
        return {
            selectedFolders: [],
            sortKey: null,
            filterKey: null,
            selectedMails: [],
            user: null,
            currentList: [],
        }
    },
    // mounted() {
    //     this.fetchData();
    // },
    methods: {
        async fetchData(){
            try {
                
                fetch('http://localhost:3000/user')
                .then(response => response.json())
                .then(data => {
                    this.user = data;
                    console.log(this.user.name);
                });
                
            }catch(e) {
                console.error('Error fetching user data:', e.message);
            }
        },
        changeList(listName){
            this.currentList = listName;
            console.log(listName);
        },
        deleteSelectedMails() {
        // handle deletion of selected mails
      },
      moveSelectedMails() {
        // handle moving of selected mails
      },



    },
    updated(){
        console.log(this.selectedMails);
    }
}
</script>

<style scoped>
nav {
    z-index: 2;
}
p{
    max-width: 30vh;
}
.v-icon {
    display: flex;
    align-self: center;
    margin-right: 0.5%;
}
.mail{
    display: flex;
    margin: 0.25vh 0 0.5vh 0.5vh;
}
.bs {
    display: flex;
    justify-content: space-between;
}
.v-list-item {
    max-height: 10vh;
    width: 93%;
}
.mail-list{
    z-index: 1;
    /* margin-top: 2vh; */
    height: 87.5vh;
    overflow-y: auto;
}
.home-view {
    display: flex;
}
.mails-nav {
    display: flex;
    flex-direction: column;
    width: 100%;
}
</style>