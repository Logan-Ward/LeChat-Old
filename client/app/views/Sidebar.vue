<script>
export default {
  name: 'Sidebar',
  props: {
    PrevChatRooms: Array,
  },
  data() {
    return {
      ChatRooms: [],
    };
  },
  components: {},
  mounted() {
    console.log(this.PrevChatRooms)
    this.ChatRooms = this.PrevChatRooms || [];
  },
};
</script>

<template>
  <section class="sidebar">
    <h2 class="sidebar-title">Discussions</h2>
    <ul class="sidebar-list">
      <li class="sidebar-item" v-for="room in ChatRooms" :key="JSON.stringify(room)">
        {{ room.title }}
      </li>
    </ul>
  </section>
</template>
