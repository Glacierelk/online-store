import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Index',
            component: () => import('@/views/user-facing/HomePage.vue')
        },
        {
            path: '/user',
            name: 'User',
            component: () => import('../App.vue'),
            children: [
                {
                    path: 'login',
                    name: 'Login',
                    component: () => import('@/views/user-facing/account/LoginForm.vue')
                },
                {
                    path: 'register',
                    name: 'Register',
                    component: () => import('@/views/user-facing/account/RegisterForm.vue')
                },
            ]
        },
        {
            path: '/manage',
            name: 'Manage',
            component: () => import('../views/manage/ManageView.vue'),
        },
        {
            path: '/search',
            name: 'Search',
            component: () => import('../views/user-facing/SearchResultView.vue'),
        },
        {
            path: '/details',
            name: 'Details',
            component: () => import('../views/user-facing/ProductDetailsView.vue'),
        }
    ]
})

export default router
