<template>
    <div class="side-bar">
      <h1>{{  }}</h1>
        <Compose />
        <v-btn
        prepend-icon="mdi-account"
        color="teal" 
        @click="navigateTo('contacts')"
        class="mt-3"
        >Contacts</v-btn>
        
        <v-list :value="activeButton">
        <v-list-item 
        prepend-icon="mdi-inbox" 
        title="Inbox" 
        value="inbox"
        @click="navigateTo('inbox')"
        ></v-list-item>
        <v-list-item 
        prepend-icon="mdi-send" 
        title="Send" 
        value="send" 
        @click="navigateTo('send')"
        ></v-list-item>
        <v-list-item 
        prepend-icon="mdi-label-variant-outline" 
        title="Important" 
        value="important"  
        @click="navigateTo('important')"
        ></v-list-item>
        <v-list-item 
        prepend-icon="mdi-file" 
        title="Draft" 
        value="draft" 
        @click="navigateTo('draft')"
        ></v-list-item>
        <v-list-item 
        prepend-icon="mdi-trash-can-outline" 
        title="Trash" 
        value="trash" 
        @click="navigateTo('trash')"
        ></v-list-item>
        <v-list-group value="Labels">
      <template v-slot:activator="{ props }">
        <v-list-item v-bind="props"  title="Labels">
          <!-- Add input for adding new label -->
          <v-text-field v-model="newLabel" @input="onNewLabelInput" placeholder="New Label"></v-text-field>
          <v-btn @click="addNewLabel" icon>
            <v-icon>mdi-plus</v-icon>
          </v-btn>
        </v-list-item>
      </template>

      <!-- Display existing labels -->
      <v-span v-for="label in labels" :key="label" :value="label">
        <div class="label">

          <v-btn @click="navigateTo(label)">
            {{ label }}
          </v-btn>
          
          <!-- <v-list-item-action> -->
            <v-btn icon @click="deleteLabel(label)">
              <v-icon>mdi-delete</v-icon>
            </v-btn>
          <!-- </v-list-item-action> -->
        </div>

      </v-span>
        
    </v-list-group>
  </v-list>
  </div>
</template>

<script>
import Compose from './Compose.vue'
export default {
    name: 'SideBar',
    components:{Compose},
    data(){
        return{
             labels: null,
             newLabel: '',

        }
    },
    methods: {
        navigateTo(folderName){
          this.$router.push({ name:  'mail-list-view', params: { name: folderName } });
        },
        async fetchLabels(){
            fetch('http://localhost:8081/labelsNames')
            .then(response => response.json())
            .then(data => {
                this.labels = data.labelsNames;
            })
            .catch(error => console.log(error));
        },
        async addNewLabel() {
            if (this.newLabel.trim() !== '') {
              // this.labels.push(this.newLabel.trim());
              await fetch('http://localhost:8081/addLabel', {
                method: 'POST',
                headers: {
                  'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                  params:{
                    labelName: this.newLabel.trim(),
                  }
                }),
              })
              .then(response => response.json())
              .then(data => {
                this.labels = data.labelsNames;
              })
              .catch((error) => {
                console.error('Error:', error);
              });
            }
            this.newLabel = ''; // Clear the input field
          },
          
    // Delete a label
    deleteLabel(label) {
      // this.labels.splice(this.labels.indexOf(label), 1);
      fetch('http://localhost:8081/deleteLabel', {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          params:{
            labelName: label,
          }
        }),
      })
      .then(response => response.json())
      .then(data => {
        this.labels = data.labelsNames;
      })
      .catch((error) => {
        console.error('Error:', error);
      });
    },

    },
    mounted(){
        this.fetchLabels();
    }
}
</script>

<style scoped>
.label{
    display: flex;
    justify-content: space-between;

}
.side-bar{
    display: flex;
    flex-direction: column;
    padding: 5vh 2vh  2vh 2vh;
}
.compose{
    display: flex;
    justify-content: space-between;
}
.active{
    background: rgb(238, 159, 159);
}
</style>