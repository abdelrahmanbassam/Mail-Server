<template>
    <div class="show">
        <SideBar/>
        <NavBar/>
    </div>
</template>

<script>
import SideBar from '@/components/SideBar.vue';
import NavBar from '@/views/NavBar.vue';
export default {
    components: {SideBar, NavBar,}
}
</script>

<style>
.show{
    display: flex;
}

</style>