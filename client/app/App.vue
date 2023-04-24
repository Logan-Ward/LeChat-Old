<script>
import ChatBoard from './views/ChatBoard.vue';
import Dashboard from './views/Dashboard.vue';
import Sidebar from './views/Sidebar.vue';

export default {
  name: 'App',
  data() {
    return {};
  },
  methods: {
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
  <sidebar />
  <chat-board/>
</template>
