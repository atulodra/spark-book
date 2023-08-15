<script setup>
// import { reactive, ref } from 'vue';
import { useRouter } from 'vue-router';
import fetcher from '../lib/fetcher';

const router = useRouter();

// const state = reactive({
//     posts: [],
//     error: null,
//     loading: true,
// });


// fetch('http://localhost:8221/api/books', {
//     method: 'GET',
//     credentials: 'include',
//     headers: {
//         'Content-Type': 'application/json',
//     },
// })
//     .then(response => response.json())
//     .then(data => state.posts = data);

const { data, error, loading } = fetcher('http://localhost:8221/api/books', 'GET');

const goToBook = (id) => {
    router.push(`/book/${id}`);
}

const addNewBook = () => {
    router.push('/books/addbook')
}
</script>


<template>
    <header>
        <div class="header-first-items">
            <h1>BOOK STORE</h1>
            <input type="text" placeholder="search..." />
        </div>
        <button class="add-book-button" @click="addNewBook">Add Book</button>
        <!-- <button @click="fetchData">Click Me</button> -->
    </header>
    <div v-if="!loading" class="books-container">
        <div v-for="post in data" class="book" :key="post.id" @click="goToBook(post.id)">
            <img class="book-image" :src="post.cover" alt="book-cover" />
            <p class="book-title">{{ post.title }}</p>
        </div>
    </div>
    <div v-else class="books-container">
        <p class="loading">Loading...</p>
    </div>
</template>

<style scoped>
header {
    display: flex;
    /* gap: 50px; */
    justify-content: space-between;
}

.header-first-items {
    width: 40%;
    display: flex;
    justify-content: space-around;
}

header input {
    /* height: 90%; */
    width: 50%;
    align-self: center;
}

.add-book-button {
    justify-self: flex-end;
}

.books-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    margin-top: 40px;
    gap: 20px 10px;
}

.book {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    /* align-content: center; */
    text-align: center;
    border: 1px solid grey;
    border-radius: 5%;
    /* padding: 40px; */
    width: 250px;
    height: 300px;
    overflow: hidden;
    text-overflow: clip;
    /* white-space: nowrap; */
    gap: 10px;
}

.book:hover {
    background-color: beige;
    transition: 0.6s ease-in-out;
    color: black;
    cursor: pointer;
}

.book-image {
    width: 200px;
    height: 200px;
    object-fit: cover;
}

.book-title {
    /* align-self: flex-start; */
    width: 80%;
    /* height: 20%; */
}
</style>