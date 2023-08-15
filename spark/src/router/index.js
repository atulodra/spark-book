import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import BookView from '../views/BookView.vue';
import AddBookView from '../views/AddBookView.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'books',
            component: HomeView,
        },
        {
            path: '/books',
            redirect: '/',
        },
        {
            path: '/book/:id',
            name: 'book',
            component: BookView,
        },
        {
            path: '/books/addbook',
            name: 'Add Book',
            component: AddBookView,
        },
    ],
});

export default router;
