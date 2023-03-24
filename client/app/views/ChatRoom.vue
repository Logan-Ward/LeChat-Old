<!-- The view where the user can see and send messages from -->

<script>
import TextInput from '../components/TextInput.vue'
import ChatBox from '../components/ChatBox.vue'

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
    TextInput,
    ChatBox,
  },
};
</script>

<template>
  <section class="chat-room">
    <h2 class="room-title">{{ Topic }}</h2>
    <div class="chat-messages" :id="this.Topic">
      <chat-box v-for="Chat in Chats" :key="JSON.stringify(Chat)" :text="Chat.text"/>
    </div>
    <text-input class="chat-text-input" @keyup.enter.prevent="sendChat"/>
  </section>
</template>