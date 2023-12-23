<template>
    <div class="side-bar">

    <v-dialog v-model="dialog" persistent width="500">
    <template v-slot:activator="{ props }">
        <v-btn
        color="primary"
        v-bind="props"
        prepend-icon="mdi-pen"
        >
        Compose
        </v-btn>
    </template>

    <v-card class="mx-auto" width="600">
    <v-divider></v-divider>
    <div class="pa-3">
      <v-text-field
        label="To"
        single-line
        variant="underlined"
      ></v-text-field>
      <v-text-field
        label="Subject"
        single-line
        variant="underlined"
      ></v-text-field>
      <v-textarea label="Message" single-line variant="underlined"></v-textarea>
    </div>
    <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue-darken-2"
            variant="text"
            @click="dialog = false"
          >
            close
          </v-btn>
          <v-btn
            class="text-none ms-4 text-white"
            color="blue-darken-2"
            rounded="3"
            variant="flat"
            @click="dialog = false"
        >
            Send
        </v-btn>
        </v-card-actions>
  </v-card>

    </v-dialog>

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
        @click="navigateTo('sent')"
        ></v-list-item>
        <v-list-item 
        prepend-icon="mdi-star" 
        title="Stared" 
        value="stared"  
        @click="navigateTo('stared')"
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
        <v-list-group value="Labels" >
            <template v-slot:activator="{ props }">
                <v-list-item
                v-bind="props"
                prepend-icon="mdi-folder"
                title="Labels"
                ></v-list-item>
            </template>
            <v-list-item v-for="label in user?.folders.labels" :key="label.name" :title="label.name" 
            :value="label.name"  
            @click="navigateTo(label.name)"
            ></v-list-item>
        </v-list-group>
    </v-list>
    </div>
</template>

<script>
export default {
    name: 'SideBar',
    props: ['user'],   
    data(){
        return{
            dialog: false
        }
    },
    methods: {
        navigateTo(listMails){
            this.$emit('navigatTo', listMails);
        }
    },
}
</script>

<style scoped>
.compose {
    background: rgb(249, 212, 212);
}
.side-bar{
    background: rgb(245, 228, 228);
    display: flex;
    flex-direction: column;
    padding: 5vh 2vh  2vh 2vh;
    height: 100vh;
    /* width: 40vh; */
}
.compose{
    display: flex;
    justify-content: space-between;
}
.active{
    background: rgb(238, 159, 159);
}
</style>