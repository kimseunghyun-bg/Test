<template>
  <div class="wrapper">
    <side-bar>
      <mobile-menu slot="content"></mobile-menu>
      <sidebar-link v-for='menu in menuList' :key="menu.menuId" :to='menu.url'>
        <i class="nc-icon" :class="menu.icon"></i>
        <p>{{menu.menuName}}</p>
      </sidebar-link>
      <!--
      <sidebar-link to="/admin/user">
        <i class="nc-icon nc-circle-09"></i>
        <p>User Profile</p>
      </sidebar-link>
      <sidebar-link to="/admin/table-list">
        <i class="nc-icon nc-notes"></i>
        <p>Table list</p>
      </sidebar-link>
      <sidebar-link to="/admin/typography">
        <i class="nc-icon nc-paper-2"></i>
        <p>Typography</p>
      </sidebar-link>
      <sidebar-link to="/admin/icons">
        <i class="nc-icon nc-atom"></i>
        <p>Icons</p>
      </sidebar-link>
      <sidebar-link to="/admin/maps">
        <i class="nc-icon nc-pin-3"></i>
        <p>Maps</p>
      </sidebar-link>
      <sidebar-link to="/admin/notifications">
        <i class="nc-icon nc-bell-55"></i>
        <p>Notifications</p>
      </sidebar-link>
      <sidebar-link to="/admin/notifications">
        <i class="nc-icon nc-bell-55"></i>
        <p>Message</p>
      </sidebar-link>
-->
      <!-- <template slot="bottom-links">
        <sidebar-link class="active"
                      to="/admin/upgrade">
          <i class="nc-icon nc-alien-33"></i>
          <p>Upgrade to PRO</p>
        </sidebar-link>
      </template> -->
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>

      <dashboard-content @click="toggleSidebar">

      </dashboard-content>

      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss">

</style>
<script>
  import TopNavbar from './TopNavbar.vue'
  import ContentFooter from './ContentFooter.vue'
  import DashboardContent from './Content.vue'
  import MobileMenu from './MobileMenu.vue'
  export default {
    data(){
      return {
        menuList: [
          {menuId: '1', menuName: 'Dashboard', url: '/admin/overview', icon : 'nc-chart-pie-35'},
          {menuId: '2', menuName: 'User Profile', url: '/admin/user', icon : 'nc-circle-09'},
          {menuId: '3', menuName: 'Table list', url: '/admin/table-list', icon : 'nc-notes'},
          {menuId: '4', menuName: 'Typography', url: '/admin/typography', icon : 'nc-paper-2'},
          {menuId: '5', menuName: 'Icons', url: '/admin/icons', icon : 'nc-atom'},
          {menuId: '6', menuName: 'Maps', url: '/admin/maps', icon : 'nc-pin-3'},
          {menuId: '7', menuName: 'Notifications', url: '/admin/notifications', icon : 'nc-bell-55'},
          {menuId: '8', menuName: 'Message', url: '/admin/message', icon : 'nc-email-83'}
        ],
        routesData: [
          {
            path: '/admin',
            component: resolve => require(['../layout/DashboardLayout.vue'], resolve),
            redirect: '/admin/overview',
            children: [
              {
                path: '/admin/overview',
                name: 'Overview',
                component: resolve => require(['../pages/Overview.vue'], resolve)
              },
              {
                path: '/admin/user',
                name: 'User',
                component: resolve => require(['../pages/UserProfile.vue'], resolve)
              },
              {
                path: '/admin/table-list',
                name: 'Table List',
                component: resolve => require(['../pages/TableList.vue'], resolve)
              },
              {
                path: '/admin/typography',
                name: 'Typography',
                component: resolve => require(['../pages/Typography.vue'], resolve)
              },
              {
                path: '/admin/icons',
                name: 'Icons',
                component: resolve => require(['..//pages/Icons.vue'], resolve)
              },
              {
                path: '/admin/maps',
                name: 'Maps',
                component: resolve => require(['../pages/Maps.vue'], resolve)
              },
              {
                path: '/admin/notifications',
                name: 'Notifications',
                component: resolve => require(['../pages/Notifications.vue'], resolve)
              },
              {
                path: '/admin/message',
                name: 'Message',
                component: resolve => require(['../pages/Message.vue'], resolve)
              }
            ]
          }
        ]
      }
    },
    components: {
      TopNavbar,
      ContentFooter,
      DashboardContent,
      MobileMenu
    },
    created() {
      const routes = this.routerFormat(this.routesData);
      this.$router.addRoutes(routes);
      if(this.$route.query.path){
        this.$router.push(this.$route.query.path);
      }else{
        this.$router.push('/admin/overview');
      }
    },
    methods: {
      toggleSidebar () {
        if (this.$sidebar.showSidebar) {
          this.$sidebar.displaySidebar(false)
        }
      },
      routerFormat: function rFormat(routers) {
        //console.log("inside routerFormat");
        if (!(routers instanceof Array)) {
          return false;
        }
        let fmRouters = [];
        //this.$axios.post("/api/menu").then(res => {
          routers.forEach(router => {
            let { path = "/404", component = "Error", name, children } = router;
            path = path || "";
            component = component || "Error";
            if (children && children instanceof Array) {
              children = rFormat(children);
            }
            //console.log("component", component);
            let fmRouter = {
              path: path,
              component: component, // Import about page in the top
              //component: () => import(`./${name}.vue`).then(m => m),
              name: name,
              children: children
            };
            console.log(fmRouter);
            fmRouters.push(fmRouter);
          });
          /*
        }).catch(err => {
          console.log(err);
        })
        */
        //console.log("fmRouters", fmRouters);
        return fmRouters;
      },
      addRoutes() {}
    }
  }

</script>
