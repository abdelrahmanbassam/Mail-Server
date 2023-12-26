<template>
    <div>
        <NavBar/>
        
        <v-toolbar>
            
            <div class="filter">
                <v-text-field 
                v-model="searchKey"
                label="Search" 
                class="mx-2"
                ></v-text-field>
            </div>
            
            <div class="filter">
            <v-select
            v-model="sortKey"
            :items="showContacts? ['alphabetical'] : ['importance', 'date']"
            label="Sort by"
            class="mx-2"
            clearable
            ></v-select>
        </div>
        
        <div class="filter">
            <v-select
            v-show="!showContacts"
            v-model="filterKeys"
            :items="['from', 'subject']"
            label="flter by"
            class="mx-2"
            multiple
            ></v-select>
        </div>
        <div class="filter">
            <v-text-field
            v-show="!showContacts && filterKeys?.length > 0"
            v-model="filterValue"
            class="mx-2"
            ></v-text-field>
        </div>
        
        <v-btn 
        v-if="searchKey || sortKey || (filterKeys?.length > 0 && filterValue)"
        @click="applyFilters"
        class="bt"
        >
        Apply
        </v-btn>

</v-toolbar>

        <v-toolbar v-if="selectedMails.length > 0">
        <v-btn color="error" @click="deleteSelectedMails">
            <v-icon>mdi-delete</v-icon>
            Delete
        </v-btn>
            <v-icon>mdi-folder-move</v-icon>
        <v-select
            v-model="selectedFolders"
            :items="folders"
            label="Move to"
            class="mx-2"
            multiple
            clearable
        ></v-select>
        </v-toolbar>

        <div v-show="showContacts">
            <ContactView />
        </div>
        <div v-show="!showContacts">
            {{ currentList }}
            <v-list class="mail-list">
                <div v-for="mail in currentList" :key="mail" class="mail">
                    <v-checkbox
                    v-model="selectedMails"
                    :value="mail"
                    ></v-checkbox> 
                    <v-list-item :value="mail"  @click="EmailDialog = true">
                        <div  class="bs">
                            <p class="truncate">{{ mail.from }}</p>
                            <p class="truncate">{{ mail.subject }}</p>
                            <p class="truncate">{{ mail.date }}</p>
                        </div>
                    </v-list-item>
                </div>
            </v-list>
        </div>


</div>
</template>

<script>
  import NavBar from '../../components/NavBar.vue';
  import ContactView from '../ContactView.vue';
  export default {
    // props: ['name'],
    components:{NavBar, ContactView},
    data() {
        return {
            // name: 'inbox',
            user: null,
            // mailsControll:{
                sortKey: null,
                searchKey:null,
                filterKeys: [],
                filterValue: null,
            // },
            currentFolder: '',
            selectedMails: [],
            currentList: null,
            selectedFolders: [],
            showContacts: false,
            contacts:[],
        }
    },
    
    created() {
        const listName = this.$route.params.name;
        console.log(listName);
    },
    
    mounted() {
        // this.changeList();
        this.changeList('inbox');
    },


    watch: {
        '$route'(to, from) {
            this.changeList(to.params.name);
            console.log("heloooooooo" + to.params.name);
            }
    },


    methods: {
        //send a post request to the server to change the current folder and recievve a new list to show
        async changeList(folderName){
            if(folderName === 'contacts'){
                this.showContacts = true;
                console.log(folderName);
                return;
            }
            this.currentFolder = folderName;
            this.selectedMails = [];
            this.selectedFolders = [];
            this.showContacts = false;
            
            await fetch('http://localhost:8081/getEmails'
            , {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    params:{
                        folderName: folderName,
                    }
                })
            }
            )
            .then(response => response.json())
            .then(data => {
                this.currentList = data;
            })
            .catch(error => console.error('Error changing list:', error));
        },

        async applyFilters(){
            await fetch('http://localhost:3000/filterEmails', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    params:{
                        folderName: this.currentFolder,
                        sort: this.sortKey,
                        search: this.searchKey,
                        filterKeys: this.filterKeys,
                        filterValue: this.filterValue,
                    }
                })
            })
            .then(response => response.json())
            .then(data => {
                this.currentList = data;
            })
            .catch(error => console.error('Error applying filters:', error));
        },

        async deleteSelectedMails() {
                await fetch('http://localhost:3000/user', {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        params: {
                            emails: this.selectedMails,
                            from: this.currentFolder
                        }
                    })
                })
                .then(response => response.json())
                .then(data => {
                    this.currentList = data;
                })
                .catch(error => console.error('Error deleting selected mails:', error));
        },
       //send a post request to the server to move the selected mails to the selected folders
        async moveSelectedMails() {
                await fetch('http://localhost:3000/user', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        params:{
                            emails: this.selectedMails,
                            from: this.currentFolder,
                            to: this.selectedFolders,
                        }
                    })
                })
                .then(response => response.json())
                .then(data => {
                    this.currentList = data;
                })
                .catch(error => console.error('Error moving selected mails:', error));
        },

    }
}
</script>

<style scoped>
.bt {
    background-color: rgb(27, 154, 185) !important;
    color: white !important;
}
.filter{
    width: 50vh;
}

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
    height: 85vh;
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