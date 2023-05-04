<script>
import { mapGetters, mapActions } from 'vuex';
import ChatBoard from '../components/ChatBoard.vue';
import Sidebar from '../components/Sidebar.vue';

export default {
  name: 'Chat',
  computed: {
    ...mapGetters(({Chats: 'StateChats', User: 'StateUser'}))
  },
  data() {
    return {};
  },
  created() {
    this.User ? this.GetChats() : null;
  },
  methods: {
    ...mapActions(["GetChats"]),
  },
  components: {
    ChatBoard,
    Sidebar,
  },
};
</script>

<template>
  <main class="chat-view" v-if="User">
    <sidebar />
    <chat-board />
  </main>
  <main v-else class="unauthenticated-view">
    <section>
      <hgroup>
        <h2>
          Site Description
        </h2>
      </hgroup>
    </section>
  </main>
</template>
