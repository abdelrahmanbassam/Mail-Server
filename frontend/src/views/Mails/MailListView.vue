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
        <div class="refreshbutton">
      <v-btn icon @click="refreshPage">
        <v-icon size="50">mdi-refresh</v-icon>
        </v-btn>
    </div>

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
                <div v-for="(mail,index) in currentList" :key="mail" class="mail">
                    <v-checkbox
                    v-model="selectedMails"
                    :value="mail"
                    ></v-checkbox> 
                    <v-list-item :value="mail"  @click="EmailDialog = true">
                        <div  class="bs" v-on:click="showEmail(mail,index)">
                            <p class="truncate">{{ mail.from }}</p>
                            <p class="truncate">{{ mail.subject }}</p>
                            <p class="truncate">{{ mail.date }}</p>
                        </div>
                    </v-list-item>
                </div>
            </v-list>
        </div>


</div>
<div class="detail">
<v-dialog v-model="showEmailDialog" max-width="700px">
    {{ selectedindex }}
    {{ currentList.length }}
<v-card>
    <v-toolbar>
    <div class="text-center">
        <v-pagination
        v-model="previewindex"
        :length="currentList.length"
        :total-visible="3"
        @click="onjumping"
        prev-icon ="mdi-menu-left"
      next-icon="mdi-menu-right"
        >
        <template v-slot:prev>
        <v-icon @click="customPrevClick">mdi-menu-left</v-icon>
      </template>
      <template v-slot:next>
        <v-icon @click="customNextClick">mdi-menu-right</v-icon>
      </template>
    </v-pagination>
    </div>
</v-toolbar>
    <h3 style=" margin-left: 2%;">To:</h3>
    <v-card style="background-color: rgb(224, 224, 224); margin-left: 2%;">
     {{ selectedEmail?.to }}
    </v-card>
    <h3 style=" margin-left: 2%;">Subject:</h3>
    <v-card style="background-color: rgb(224, 224, 224); margin-left: 2%;">
    {{ selectedEmail?.subject }}
</v-card>
<h3 style=" margin-left: 2%;">Body:</h3>
<v-card style="background-color: rgb(224, 224, 224); margin-left: 2%;">
    {{ selectedEmail?.body }}
</v-card>
    <h3 style=" margin-left: 2%;">Attachment:</h3>
    <div>
           <ul>
            <li v-for="(attachment, index) in selectedEmail.attachments" :key="index">
               <span>
                 <a href="#" @click.prevent="openAttachment(attachment)">
                    <div style="margin-left: 2%;">
                   {{ attachment.name }}
                </div>
                
                 </a>
               </span>
             </li>
           </ul>
         </div>
    <h3 style=" margin-left: 2%;">importance:</h3>
    <v-card style="background-color: rgb(224, 224, 224); margin-left: 2%;">
    {{ selectedEmail?.importance }}
</v-card>

    <h3 style=" margin-left: 2%;">Date:</h3>
    <v-card style="background-color: rgb(224, 224, 224); margin-left: 2%;">
    {{ selectedEmail?.date }}
</v-card>
</v-card>

</v-dialog>
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
            user: '',
            selectedindex:'',
            previewindex:'',
            sortKey: '',
            searchKey:'',
            filterKeys: [],
            filterValue: '',
            currentFolder: '',
            selectedMails: [],
            currentList: [],
            showEmailDialog:false,
            selectedEmail:null,
            selectedFolder: null,
            showContacts: false,
            contacts:[],
            labels:[]
        }
    },
    
    // created() {
    //     this.currentFolder = this.$route.params.name; 
    // },
    
    mounted() {
        // this.user = JSON.parse(localStorage.getItem('user'));
        // console.log(this.user);
        this.changeList('inbox');
    },


    watch: {
        '$route'(to, from) {
            this.changeList(to.params.name);
            this.getLabels();
        }
    },


    methods: {
        refreshPage() {
      // Reload the current page
      window.location.reload();
    },
        openAttachment(file) {
            const pdfUrl = file.type === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'
              ? `https://docs.google.com/gview?url=${encodeURIComponent(file.url)}&embedded=true`
              : file.type === 'application/pdf'
                ? file.url
                : '';
      
            const newTabContent = `
              <html>
                <head>
                  <title>${file.name}</title>
                </head>
                <body style="margin: 0; display: flex; justify-content: center; align-items: center; height: 100vh;">
                  ${
                    file.type.startsWith('image')
                      ? `<img src="${file.url}" alt="${file.name}" style="max-width: 100%; max-height: 100%;">`
                      : file.type === 'application/pdf' || file.type === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'
                      ? `<iframe src="${pdfUrl}" style="width: 100%; height: 100%;" frameborder="0"></iframe>`
                      : file.type.startsWith('video')
                      ? `<video controls style="max-width: 100%; max-height: 100%;">
                          <source src="${file.url}" type="${file.type}">
                        </video>`
                      : ''
                  }
                </body>
              </html>
            `;
      
            const newTab = window.open('', '_blank');
            newTab.document.write(newTabContent);
            newTab.document.close();
          },
        showEmail(mail,index){
            this.showEmailDialog=true,
            this.selectedEmail=mail,
            this.selectedindex=index,
            this.previewindex=this.selectedindex+1
        },

        customPrevClick(){
            if(this.selectedindex>0){
            this.selectedindex=this.selectedindex-1,
            this.selectedEmail=this.currentList[this.selectedindex],
            this.previewindex=this.selectedindex+1
            }
        },

        customNextClick(){
            if(this.selectedindex<this.currentList.length-1){
            this.selectedindex=this.selectedindex+1,
            this.selectedEmail=this.currentList[this.selectedindex],
            this.previewindex=this.selectedindex+1
            }
        },
        onjumping(){
            this.selectedindex=this.previewindex-1,
            this.selectedEmail=this.currentList[this.selectedindex]
        },

        async getLabels(){
            await fetch('http://localhost:8085/labelsNames')
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
            this.currentFolder = folderName;
            this.selectedMails = [];
            this.selectedFolders = [];
            this.showContacts = false;
            
            await fetch('http://localhost:8085/getEmails'
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
            await fetch('http://localhost:8085/filterEmails', {
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
                await fetch('http://localhost:8085/deleteEmails', {
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
                await fetch('http://localhost:8085/moveEmails', {
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
                    console.log(data);
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
.detail{
    margin-left: 5%;
}
</style>