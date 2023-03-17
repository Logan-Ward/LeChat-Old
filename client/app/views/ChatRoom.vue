<!-- The view where the user can see and send messages from -->

<script>
import TextInput from '../components/TextInput.vue'
import TextBox from '../components/TextBox.vue'

export default {
  name: 'Dashboard',
  props: {
    Topic: {required: true, type: String},
    Chats: {required: false, type: Array},
  },
  components: {
    TextInput,
    TextBox
  }
};
</script>

<template>
  <section class="chat-room">
    <h2>{{ Topic }}</h2>
    <text-box text="Enchanted"/>
    <text-input/>
  </section>
</template>