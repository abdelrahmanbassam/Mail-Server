<template>
    <div class="mail-list-view">
        <SideBar/>
        
        <v-scroll class="mail-list">
        <div v-for="i in 1000" :key="i" class="mail">
            <v-icon @click="toggleSelect" size="25" color="rgb(239, 99, 68)">{{isSelected ? 'mdi-checkbox-marked' : 'mdi-checkbox-blank-outline'}}</v-icon>
            <v-icon @click="toggleStar" size="27" color="rgb(239, 99, 68)">{{isStared ? 'mdi-star' : 'mdi-star-outline'}}</v-icon>
            <v-btn>mail</v-btn>
        </div>
        </v-scroll>

    </div>
</template>

<script>
import SideBar from '@/components/SideBar.vue';
import NavBar from '@/components/NavBar.vue';
export default {
    components: {SideBar, NavBar},
    data() {
        return {
            mailList:["bxbxbx", "djjd", "mdnnmd"],
            isSelected: false,
            isStared: false,
        }
    },
    methods: {
        toggleSelect() {
            this.isSelected = !this.isSelected;
        },
        toggleStar() {
            this.isStared = !this.isStared;
        },
    }
}
</script>

<style scoped>
.v-icon {
    display: flex;
    align-self: center;
    margin-right: 0.5%;
}
.mail{
    display: flex;
    margin: 0.5%;
    height: 5vh;
}
.v-btn {
    width: 98%;
    /* color: rgb(239, 99, 68); */
}
.mail-list{
    margin-top: 20vh;
    height: 80vh;
    width: 100%;
    overflow-y: auto;
}
.mail-list-view {
    display: flex;
}
.mailList-nav {
    display: flex;
    flex-direction: column;
}
</style>