import Vuex from 'vuex';
import createPersistedState from "vuex-persistedstate";
import auth from './modules/auth.js';

export default new Vuex.Store({
  modules: {
    auth
  },
  
  plugins: [createPersistedState()]
});
