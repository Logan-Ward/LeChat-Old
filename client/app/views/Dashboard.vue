<script>
import TextInput from '../components/TextInput.vue';

export default {
  name: 'Dashboard',
  data() {
    return {
      results: [{ title: 'generallol' }, { title: 'title' }, { title: 'generallol' }, { title: 'title' }],
      searching: true,
    };
  },
  methods: {
    search(e) {},
  },
  components: {
    TextInput,
  },
};
</script>

<template>
  <div class="dashboard">
    <h1>LeChat</h1>
    <div class="search">
      <ul class="result-list">
        <li class="search-item">
          <text-input class="search-text-input" @keyup.enter.prevent="search" @focus="searching = false" @blur="searching=true" />
        </li>
        <li
          class="result-item"
          v-for="result in results"
          :key="JSON.stringify(result)"
          :hidden="searching"
        >
          {{ result.title }}
        </li>
      </ul>
    </div>
  </div>
</template>
