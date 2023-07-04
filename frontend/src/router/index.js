import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Index',
            component: () => import('@/views/user-facing/HomePageView.vue'),
            meta: {
                title: '天猫商城首页'
            }
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
                {
                    path: 'cart',
                    name: 'Cart',
                    component: () => import('@/views/user-facing/ShoppingCartView.vue'),
                },
                {
                    path: 'order',
                    name: 'Order',
                    component: () => import('@/views/user-facing/OrderListView.vue'),
                }
            ]
        },
        {
            path: '/manage',
            name: 'Manage',
            component: () => import('../views/manage/ManageView.vue'),
        },
        {
            path: '/product',
            name: 'Product',
            component: () => import('../components/manage/ProductComponents.vue'),
        },
        {
            path: '/property',
            name: 'Property',
            component: () => import('../components/manage/ProductSetProperty'),
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
        },
        {
            path: '/upload',
            name: 'Upload',
            component: () => import('../views/UploadImageTest.vue'),
        }
    ]
})

export default router
