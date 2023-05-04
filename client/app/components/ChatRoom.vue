<!-- The view where the user can see and send messages from -->

<script>

export default {
  name: 'ChatRoom',
  data() {
    return {
      Chats: [],
    }
  },
  methods: {
    sendChat(e) {
      this.Chats.push({text: e.target.value});
      this.Chats = this.Chats.slice();
      e.target.value = '';
    },
  },
  props: {
    Topic: {required: true, type: String},
  },
  watch: {
    Chats(newChats, oldChats) {
      setTimeout(() => {
        let messages = document.getElementById(this.Topic);
        messages.scrollTop = messages.scrollHeight;
      })
    }
  },
  components: {
  },
};
</script>

<template>
  <section class="chat-room">
    <h2 class="room-title">{{ Topic }}</h2>
    <div class="chat-messages" :id="this.Topic">
      <p v-for="Chat in Chats" class="chat-box">{{ Chat.text }}</p>
    </div>
    <input class="text-input chat-text-input" @keyup.enter.prevent="sendChat" placeholder="Type message here"/>
  </section>
</template>