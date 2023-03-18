<!-- The view where the user can see and send messages from -->

<script>
import TextInput from '../components/TextInput.vue'
import TextBox from '../components/TextBox.vue'

export default {
  name: 'Dashboard',
  data() {
    return {
      Chats: this.CurrentChats || []
    }
  },
  methods: {
    sendChat(e) {
      this.Chats.push(e.target.value)
      e.target.value = '';
    }
  },
  props: {
    Topic: {required: true, type: String},
    CurrentChats: {required: false, type: Array},
  },
  components: {
    TextInput,
    TextBox,
  }
};
</script>

<template>
  <section class="chat-room">
    <h2 class="room-title">{{ Topic }}</h2>
    <div class="chat-messages">
      <text-box v-for="Chat in Chats" :key="JSON.stringify(Chat)" :text="Chat"/>
    </div>
    <text-input class="chat-text-input" @keyup.enter.prevent="sendChat"/>
  </section>
</template>