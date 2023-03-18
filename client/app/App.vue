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
   <h1>Enchant&eacute;e</h1>
   <chat-room Topic="General"/>
</template>