<template>
    <div>

        <NavBar/>
        
        <v-btn 
        v-if="searchKey || sortKey || filterFrom || filterSubject"
        @click="applyFilters"
        color="primary"
        block
        >
        Apply
        </v-btn>
    
    <v-toolbar>
        <v-row>
                <v-col cols="2">
                    <v-text-field 
                    v-model="searchKey"
                    label="Search" 
                    class="mx-2"
                    ></v-text-field>
                </v-col>
                
                <v-col cols="3">
                    <v-select
                    v-model="sortKey"
                    :items="showContacts? ['alphabetical'] : ['importance', 'date']"
                    label="Sort by"
                    class="mx-2"
                    clearable
                    ></v-select>
                </v-col>
                
                <v-col cols="3">
                    <v-select
                    v-show="!showContacts"
                    v-model="filterKeys"
                    :items="['from', 'subject']"
                    label="flter by"
                    class="mx-2"
                    multiple
                    ></v-select>
                </v-col>
                
                <v-col cols="2" v-show="!showContacts && filterKeys?.includes('from')">
                    <v-text-field
                    v-model="filterFrom"
                    placeholder="From"
                    ></v-text-field>
                </v-col>
                
                <v-col cols="2" v-show="!showContacts && filterKeys?.includes('subject')">
                    <v-text-field
                    v-model="filterSubject"
                    placeholder="Subject"
                    ></v-text-field>
                </v-col>
                
            </v-row>
            
        </v-toolbar>
        
        <!-- <v-toolbar v-if="selectedMails.length > 0"> -->
            <v-row v-show="selectedMails.length > 0">
                <v-col cols="3" >
                    <v-select
                    v-model="selectedFolder"
                    :items="labels"
                    label="Move to"
                    clearable
                    ></v-select>
                </v-col>

            <v-col cols="auto">
                <v-btn color="error" @click="deleteSelectedMails">
                    <v-icon>mdi-delete</v-icon>
                    Delete
                </v-btn>
            </v-col>
            <v-col cols="auto">
                <v-btn
                v-show="selectedFolder"
                color="primary"
                @click="moveSelectedMails" >
                <v-icon>mdi-folder-move</v-icon>
                        move
            </v-btn>
            </v-col>
            

        </v-row>

        
        
        <!-- </v-toolbar> -->

        <div v-show="showContacts">
            <ContactView />
        </div>
        <div v-show="!showContacts">
            {{ labels }}
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
    components:{NavBar, ContactView},
    data() {
        return {
            user: '',
            currentFolder: '',
            currentList: [],
            showContacts: false,
            contacts:[],
            labels:[],
            sortKey: '',
            searchKey:'',
            filterKeys: [],
            filterSubject: '',
            filterFrom: '',
            selectedMails: [],
            selectedFolder: null,
        }
    },
    
    // created() {
    //     this.currentFolder = this.$route.params.name; 
    // },
    
    mounted() {
        this.changeList('inbox');
    },


    watch: {
        '$route'(to, from) {
            this.changeList(to.params.name);
            this.getLabels();
        }
    },


    methods: {
        clear(){
            this.sortKey= '',
            this.searchKey='',
            this.filterKeys= [],
            this.filterSubject= '',
            this.filterFrom= '',
            this.selectedMails= [],
            this.selectedFolder= null
        },

        async getLabels(){
            await fetch('http://localhost:8081/labelsNames')
            .then(response => response.json())
            .then(data => {
                this.labels = data.labelsNames;
                console.log("labels :   " + data);
            })
            .catch(error => console.log(error));
        },
        async changeList(folderName){
            if(folderName === 'contacts'){
                this.showContacts = true;
                console.log(folderName);
                return;
            }
            this.clear();
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
            await fetch('http://localhost:8081/filterEmails', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    params:{
                        folderName: this.currentFolder,
                        senderFilter: this.filterFrom,
                        subjectFilter: this.filterSubject,
                        sort: this.sortKey,
                        search: this.searchKey,
                    }
                })
            })
            .then(response => response.json())
            .then(data => {
                this.currentList = data;
                console.log("sorted...........................");
            })
            .catch(error => console.error('Error applying filters:', error));
        },

        async deleteSelectedMails() {
                await fetch('http://localhost:8081/deleteEmails', {
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
        async moveSelectedMails() {
                await fetch('http://localhost:8081/moveEmails', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        params:{
                            emails: this.selectedMails,
                            from: this.currentFolder,
                            to: this.selectedFolder,
                        }
                    })
                })
                .then(response => response.json())
                .then(data => {
                    this.currentList = data;
                })
                .catch(error => console.error('Error moving selected mails:', error));
                this.$router.push('/list/' + this.selectedFolder);
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