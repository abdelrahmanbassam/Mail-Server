<template>
    <div class="home-view">
        <SideBar/>
        <div class="mails-nav">
            <NavBar/>
            <v-scroll class="mail-list">
                <div v-for="i in 100" :key="i" class="mail">
                    <v-icon @click="toggleSelect" size="25" color="rgb(239, 99, 68)">{{isSelected ? 'mdi-checkbox-marked' : 'mdi-checkbox-blank-outline'}}</v-icon>
                    <v-icon @click="toggleStar" size="27" color="rgb(239, 99, 68)">{{isStared ? 'mdi-star' : 'mdi-star-outline'}}</v-icon>
                    <v-btn>mail</v-btn>
                </div>
            </v-scroll>
        </div>
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
    width: 100%;
    /* color: rgb(239, 99, 68); */
}
.mail-list{
    margin-top: 2vh;
    height: 78vh;
    /* width: 100%; */
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