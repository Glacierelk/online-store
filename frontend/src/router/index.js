import {createRouter, createWebHistory} from 'vue-router'

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
                },
                {
                    path: 'register',
                    name: 'Register',
                    component: () => import('../views/user/RegisterForm.vue')
                },
            ]
        },
        {
            path: '/manage',
            name: 'Manage',
            component: () => import('../views/manage/ManageView.vue'),
        }
    ]
})

export default router
