<template>
    <div class="side-bar">
        
        <Compose />

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
import Compose from './Compose.vue'
export default {
    name: 'SideBar',
    props: ['user'], 
    components:{Compose},
    data(){
        return{
            
        }
    },
    methods: {
        navigateTo(listMails){
            this.$emit('navigateTo', listMails);
        }
    },
}
</script>

<style scoped>
.side-bar{
    display: flex;
    flex-direction: column;
    padding: 5vh 2vh  2vh 2vh;
    height: 91vh;
}
.compose{
    display: flex;
    justify-content: space-between;
}
.active{
    background: rgb(238, 159, 159);
}
</style>