<template>
  <card>
    <h4 slot="header" class="card-title">Login</h4>
    <form>
    <!--<form @submit="handleLogin">-->
      <div class="row">
        <div class="col-md-5">
          <base-input type="text"
                    label="Username"
                    placeholder="Username"
                    v-model="user.username"
                    required>
          </base-input>
        </div>
      </div>
      <div class="row">
        <div class="col-md-5">
          <base-input id="password"
            v-model="user.password"
            type="password"
            required
            placeholder="Password">
          </base-input>
        </div>
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-info btn-fill float-right" @click.prevent="handleLogin">
          Submit
        </button>
      </div>  
    </form>
  </card>
</template>

<script>
import User from '../models/user';

export default {
    name: 'Login',
    data() {
        return {
            user: new User('', '', ''),
            loading: false,
            message: ''
        }
    },
    computed: {
        loggedIn() {
            return this.$store.state.initialState.status.loggedIn;
        }
    },
    created() {
        if (this.loggedIn) {
            this.$router.push('/');
        }
    },
    methods: {
        handleLogin(evt) {
            evt.preventDefault();
            console.log(this.user.username);
            this.loading = true;
            if (this.user.username && this.user.password) {
                      this.$store.dispatch('login', this.user).then(
                        () => {
                            this.$router.push('/');
                            /*
                            this.$axios.post("/api/menu").then(res => {
                              let fmRouters = [];
      
                              res.data.menuList.forEach(menu => {
                                let { url = "/404", component = "Error", routerName} = menu;
                                console.log(menu);
                                let menuItem = {
                                  path: url,
                                  name: routerName,
                                  component: resolve => require([component], resolve)
                                };

                                //menuList.push(menuItem);
                                fmRouters.push(menuItem);
                              });
                              let {routes} = this.$router.options;
                              console.log({routes});
                              this.$router.addRoutes(fmRouters);
                              this.$router.push('/admin/overview');
                            
                            }).catch(err => {
                                console.log(err);
                            })
                            */
                        },
                        error => {
                            this.loading = false;
                            this.message = 
                            (error.response && error.response.data) || error.message || error.toString();
                        }
                    );
            }

        }

    }
}
</script>