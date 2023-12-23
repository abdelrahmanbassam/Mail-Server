<template>
    <v-list class="mail-list">
        <div v-for="mail in user?.folders.inbox.emails" :key="mail" class="mail">
            <v-icon @click="toggleSelect" size="25" color="rgb(239, 99, 68)">{{isSelected ? 'mdi-checkbox-marked' : 'mdi-checkbox-blank-outline'}}</v-icon>
            <v-icon @click="toggleStar" size="27" color="rgb(239, 99, 68)">{{isStared ? 'mdi-star' : 'mdi-star-outline'}}</v-icon>
            <v-list-item value="">
                <div  class="bs">
                    <p class="truncate">from: {{ mail.from }}</p>
                    <p class="truncate">subject: {{ mail.subject }}</p>
                    <p class="truncate">date: {{ mail.date }}</p>
                </div>
                </v-list-item>
        </div>
    </v-list>
</template>

<script>
export default {
    data() {
        return {
            user: null,
            currentList: null,
            isSelected: false,
            isStared: false,
        }
    },
    mounted() {
        this.fetchData();
    },
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
.truncate {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>