<script setup>
import { reactive } from 'vue';
import fetcher from '../lib/fetcher';

const newBook = reactive({
    title: '',
    author: '',
    ISBN: '',
    publisher: '',
    publicationDate: '',
    cover: ''
});

const addBook = () => {
    fetcher('http://localhost:8221/api/books', 'POST', newBook);
    // console.log(JSON.stringify(newBook));
}

console.log(newBook);

</script>

<template>
    <div class="book-inputs">
        <div class="book-input">
            <p class="label">Title:</p>
            <input v-model="newBook.title" type="text" placeholder="Title of the Book" />
        </div>
        <div class="book-input">
            <p class="label">Author:</p>
            <input v-model="newBook.author" type="text" placeholder="Author of the book">
        </div>
        <div class="book-input">
            <p class="label">ISBN:</p>
            <input v-model="newBook.ISBN" type="text" placeholder="13 digit ISBN Number">
        </div>
        <div class="book-input">
            <p class="label">Publisher:</p>
            <input v-model="newBook.publisher" type="text" placeholder="Name of Publisher">
        </div>
        <div class="book-input">
            <p class="label">Date:</p>
            <input v-model="newBook.publicationDate" type="text" placeholder="Date of Publication of book">
        </div>
        <div class="book-input">
            <p class="label">Cover:</p>
            <input v-model="newBook.cover" type="text" placeholder="URL for the cover of Book">
        </div>
        <button @click="addBook">Add Book</button>
    </div>
</template>

<style scoped>
.book-inputs {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 30px;
}

.book-input {
    /* width: 100%; */
    display: flex;
    gap: 30px;
}

.label {
    color: wheat;
    font-weight: bold;
}

.book-input input {
    width: 400px;
}

.book-input input[placeholder] {
    /* color: rgba(0, 0, 0, 0.1); */
    font-style: italic;
}
</style>