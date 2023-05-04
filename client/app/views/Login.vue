/* The page where the user can enter their username and password to gain access
to the rest of the website. */

<script>
import { mapActions } from "vuex";

export default {
  name: 'Login',
  props: {},
  computed: {},
  data() {
    return {
      show: true,
      signupError: false,
      vSignupError: false,
      loginError: false,
    };
  },
  methods: {
    ...mapActions(["Login", "Signup"]),
    
    async signup(e) {
      if(!e.target || Array.from(e.target).some(tg => !tg.value)) {
        this.vSignupError = false;
        this.signupError = true;
        return;
      }
      const [{value: username}, {value: password}, {value: vPassword}] = Array.from(e.target);
      console.log(username, password, vPassword);
      try {
        if (password === vPassword) {
          await this.Signup({
            username,
            password,
          });
          this.$router.push("/");
          this.signupError = false;
          this.vSignupError = false;
        }
        else {
          this.signupError = false;
          this.vSignupError = true;
        }
      } catch (err) {
        this.vSignupError = false;
        this.signupError = true;
      }
    },
    
    async login(e) {
      if(!e.target || Array.from(e.target).some(tg => !tg.value)) {
        this.loginError = true;
        return;
      }
      const [ {value: username}, {value: password} ] = Array.from(e.target);
      const User = new FormData();
      User.append("username", username);
      User.append("password", password);
      try {
        await this.Login(User);
        this.$router.push("/");
        this.loginError = false;
      } catch (err) {
        this.loginError = true;
        console.log('login error');
      }
    },
  },
  components: {},
};
</script>

<template>
  <main class="login-signup-view">
    <section class="login" :hidden="!show">
      <hgroup class="login-signup-hgroup">
        <h2 class="form-title">Login</h2>
        <button class="button login-signup-button" @click="show = !show">
          {{ show ? 'Signup' : 'Login' }}
        </button>
      </hgroup>
      <form class="form" @submit.prevent="login">
        <label for="username" class="form-label">Username:</label>
        <input
          type="text"
          name="username"
          placeholder="Username"
          id="username"
          class="text-input form-text-input"
        />
        <label for="password" class="form-label">Password:</label>
        <input
          type="password"
          name="password"
          placeholder="Password"
          id="password"
          class="text-input form-text-input"
        />
        <input type="submit" value="Submit" class="button form-button" />
      </form>
    </section>
    <section class="signup" :hidden="show">
      <hgroup class="login-signup-hgroup">
        <h2 class="form-title">Signup</h2>
        <button class="button login-signup-button" @click="show = !show">
          {{ show ? 'Signup' : 'Login' }}
        </button>
      </hgroup>
      <form class="form" @submit.prevent="signup">
        <label for="choose-username" class="form-label">Username:</label>
        <input
          type="text"
          name="username"
          placeholder="Username"
          id="choose-username"
          class="text-input form-text-input"
        />
        <label for="choose-password" class="form-label">Password:</label>
        <input
          type="password"
          name="password"
          placeholder="Password"
          id="choose-password"
          class="text-input form-text-input"
        />
        <label for="verify-password" class="form-label">Verify Password:</label>
        <input
          type="password"
          name="verify-password"
          placeholder="Password"
          id="verify-password"
          class="text-input form-text-input"
        />
        <input type="submit" value="Submit" class="button form-button" />
      </form>
    </section>
  </main>
</template>
