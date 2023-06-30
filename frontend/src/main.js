import { createApp } from 'vue'
import App from './App.vue'
import 'element-plus/dist/index.css'
import router from './router'
import Antd from 'ant-design-vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'font-awesome/css/font-awesome.min.css';


const app = createApp(App)

app.use(router)
app.use(Antd)
app.use(ElementPlus)
app.mount('#app')
