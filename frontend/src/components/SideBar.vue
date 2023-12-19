<template>
    <div class="side-bar">
        <v-btn class="compose" rounded="30" variant="tonal" stacked>
            <img src="@/assets/icons/compose.svg" alt="" />
            <h3>Compose</h3>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/inbox.svg" alt="" />
            <p>Inbox</p>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/sent.svg" alt="" />
            <p>Sent</p>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/star.svg" alt="" />
            <p>Stared</p>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/important.svg" alt="" />
            <p>Important</p>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/draft.svg" alt="" />
            <p>Draft</p>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/trash.svg" alt="" />
            <p>Trash</p>
        </v-btn>
        <v-btn variant="outlined" class="bt">
            <img src="@/assets/icons/folder.svg" alt="" />
            <p>My folder</p>
        </v-btn>
    </div>
</template>

<script>
export default {
    name: 'SideBar',
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
    width: 40vh;
}
.v-btn {
    color: black;
    font-weight: bold;
    font-size: 2vh;
    margin: 1vh 0 1vh 0;
}
</style>