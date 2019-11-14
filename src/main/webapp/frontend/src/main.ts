import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

Vue.config.productionTip = false;

import axios from 'axios';
import VueAxios from 'vue-axios';

import ElementUI from 'element-ui';
import {Table,TableColumn} from 'element-ui';

import 'element-ui/lib/theme-chalk/index.css';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import moment from 'moment'
import VueI18n from 'vue-i18n'

Vue.prototype.moment = moment

Vue.use(BootstrapVue)
Vue.use(VueAxios, axios);
Vue.use(ElementUI);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(require('vue-moment'));
Vue.use(VueI18n)

import {
  Select,
  Button
  // ...
} from 'element-ui'

Vue.component(Select.name, Select)
Vue.component(Button.name, Button)

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');