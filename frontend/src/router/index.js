import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Index',
            component: () => import('../components/HelloWorld.vue')
        },
        {
            path: '/user',
            name: 'User',
            component: () => import('../App.vue'),
            children: [
                {
                    path: 'login',
                    name: 'Login',
                    component: () => import('../views/user/LoginForm.vue')
                }
            ]
        }
    ]
})

export default router
