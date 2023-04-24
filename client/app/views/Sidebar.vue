<script>
import axios from 'axios';

export default {
  name: 'Sidebar',
  props: {},
  data() {
    return {
      Discussions: [],
    };
  },
  methods: {
    async getAllDiscussions() {
      let results = await axios.get('/discussions');
      return results.data;
    }
  },
  components: {},
  async mounted() {
    this.Discussions = await this.getAllDiscussions();
  },
};
</script>

<template>
  <section class="sidebar">
    <h2 class="sidebar-title">Discussions</h2>
    <ul class="sidebar-list">
      <li class="sidebar-item" v-for="discussion in Discussions" :key="JSON.stringify(discussion)">
        {{ discussion.topic }} <input class="room-button" type="button" />
      </li>
    </ul>
  </section>
</template>
