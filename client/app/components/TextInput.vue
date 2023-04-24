<script>
export default {
  props: {
    placeholder: { required: true, type: String },
  },
};
</script>

<template>
  <input class="text-input" :placeholder="placeholder" />
</template>
