<script>
import Dashboard from './components/Dashboard.vue';

export default {
  name: 'App',
  data() {
    return {};
  },
  methods: {
  },
  components: {
    Dashboard,
  },
}
</script>

<template>
  <dashboard/>
  <router-view></router-view>
</template>
