import axios from 'axios';

const state = {
  user: null,
  chats: null
};

const getters = {
  isAuthenticated: state => !!state.user,    
  StatePosts: state => state.posts,
  StateUser: state => state.user,
};

const actions = {
  async Signup({dispatch}, form) {
    await axios.post('/signup', form);
    let UserForm = new FormData();
    UserForm.append('username', form.username);
    UserForm.append('password', form.password);
    await dispatch('Login', UserForm);
  },
  
  async Login({commit}, User) {
    console.log(User)
    let x = await axios.post('/login', User);
    console.log(x)
    if (!x) {throw("error")}
    await commit('setUser', User.get('username'));
  },
  
  async Logout({commit}){
    let user = null;
    commit('Logout', user);
  },
  
  async CreateChat({dispatch}, chat) {
    await axios.post('/api/discussion', chat);
    await dispatch('GetChats');
  },
  
  async GetChats({ commit }){
    let response = await axios.get('/api/discussion');
    commit('setChats', response.data);
  },
  
};

const mutations = {
  setUser(state, username){
    state.user = username;
  },
  
  setPosts(state, chats){
      state.chats = chats;
  },
  
  Logout(state){
      state.user = null;
      state.chats = null;
  },
  
};

export default {
  state,
  getters,
  actions,
  mutations
};