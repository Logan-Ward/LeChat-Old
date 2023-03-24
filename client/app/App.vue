<script>
import ChatBoard from './views/ChatBoard.vue';
import Dashboard from './views/Dashboard.vue';
import Sidebar from './views/Sidebar.vue';

export default {
  name: 'App',
  data() {
    return {};
  },
  components: {
    ChatBoard,
    Dashboard,
    Sidebar
  },
}
</script>

<template>
  <sidebar/>
  <dashboard/>
  <chat-board/>
</template>
