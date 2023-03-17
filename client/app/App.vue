<script>
import Dashboard from './views/Dashboard.vue'
import ChatRoom from './views/ChatRoom.vue'

export default {
   name: 'App',
   components: {
      Dashboard,
      ChatRoom
   },
}
</script>

<template>
   <chat-room Topic="General"/>
</template>