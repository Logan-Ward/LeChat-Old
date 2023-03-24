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
  <dashboard/>
  <sidebar :PrevChatRooms="[{title: 'sad'}, {title: 'happy'}]"/>
  <chat-board/>
</template>
