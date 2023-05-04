<script>
export default {
  name: 'Dashboard',
  data() {
    return {
      results: [
        { title: 'generallol' },
        { title: 'title' },
        { title: 'generallol' },
        { title: 'title' },
      ],
      searching: true,
    };
  },
  computed: {
    isLoggedIn() { return this.$store.getters.isAuthenticated},
  },
  methods: {
    search(e) {},
    async logout() {
      await this.$store.dispatch('Logout');
      this.$router.push('/');
    }
  },
  components: {},
};
</script>

<template>
  <header class="dashboard">
    <router-link to="/" class="generic-link home">
      <h1>LeChat</h1>
    </router-link>
    <div class="search">
      <ul class="result-list">
        <li class="search-item">
          <input
            class="text-input search-text-input"
            @keyup.enter.prevent="search"
            @focus="searching = false"
            @blur="searching = true"
            placeholder="Search for discussions"
          />
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
    <nav class="navigation">
      <a
        v-if="isLoggedIn"
        @click="logout"
        class="generic-link navigational-link"
        >Logout</a
      >
      <router-link v-else to="/login" class="generic-link navigational-link"
        >Login/Signup</router-link
      >
    </nav>
  </header>
</template>