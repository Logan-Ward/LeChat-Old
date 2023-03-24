<script>

  export default {
    props: {
      text: {required: true, type: String},
    },
  }
</script>

<template>
  <p class="chat-box" :id="text">{{ text }}</p>
</template>
