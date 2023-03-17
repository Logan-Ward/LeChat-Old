<script>
  export default {
    props: {
      text: {required: true, type: String}
    }
  }
</script>

<template>
  <p class="text-box">{{ text }}</p>
</template>
